package me.kingtux.tuxjsql.core;

import com.esotericsoftware.reflectasm.ConstructorAccess;
import me.kingtux.tuxjsql.core.builders.SQLBuilder;
import me.kingtux.tuxjsql.core.connection.CPProvider;
import me.kingtux.tuxjsql.core.connection.ConnectionProvider;
import me.kingtux.tuxjsql.core.exceptions.NoSQLBuilderException;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TuxJSQLBuilder {
    private static List<Class<? extends SQLBuilder>> loadedBuilders = new ArrayList<>();

    public static void add(Class<? extends SQLBuilder> aClass) {
        loadedBuilders.add(aClass);
    }

    static {
        if (TuxJSQL.getLogger().isDebugEnabled()) {
            new Thread(() -> {
                for (Class<? extends SQLBuilder> clazz : InternalUtils.loadAllClasses()) {
                    loadedBuilders.add(clazz);
                    SQLBuilder builder = getBuildByClazz(clazz);
                    TuxJSQL.getLogger().debug(String.format("Found SQLBuilder: %s", builder.name()));
                }
            }).start();
        }
    }

    public static SQLBuilder getBuildByKey(String key) {
        for (Class<? extends SQLBuilder> clazz : loadedBuilders) {
            SQLBuilder builder1 = getBuildByClazz(clazz);
            if (builder1.key().equalsIgnoreCase(key)) {
                return builder1;
            }
        }
        throw new NoSQLBuilderException("Unable to find SQLBuilder for " + key);
    }

    public static SQLBuilder getBuildByClazz(String clazz) {
        Class<?> cla;
        try {
            cla = Class.forName(clazz);
        } catch (ClassNotFoundException e) {
            throw new NoSQLBuilderException("Unable to find SQLBuilder for " + clazz);
        }
        return getBuildByClazz(cla);
    }

    public static SQLBuilder getBuildByClazz(Class<?> clazz) {
        ConstructorAccess<?> access = ConstructorAccess.get(clazz);
        return (SQLBuilder) access.newInstance();
    }

    public static TuxJSQL create(Properties properties) {
        return create(properties, Executors.newSingleThreadExecutor());
    }

    public static TuxJSQL create(Properties properties, ExecutorService service) {
        SQLBuilder builder;
        if (properties.containsKey("db.type")) {
            builder = getBuildByKey(properties.getProperty("db.type"));
        } else if (properties.containsKey("db.type.class")) {
            builder = getBuildByClazz(properties.getProperty("db.type.class"));
        } else {
            throw new IllegalArgumentException("Must provide a DB type");
        }
        return create(properties, builder, service);
    }



    public static TuxJSQL create(Properties properties, SQLBuilder builder, ExecutorService service) {
        ConnectionProvider provider = CPProvider.getCP();
        builder.configureConnectionProvider(provider, properties);

        return new TuxJSQL(provider, builder, service);
    }
}
