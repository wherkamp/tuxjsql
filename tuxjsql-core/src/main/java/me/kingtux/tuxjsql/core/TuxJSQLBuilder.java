package me.kingtux.tuxjsql.core;

import pw.rayz.vessel.objects.Database;

import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import static me.kingtux.tuxjsql.core.InternalUtils.getImplementationClass;

public interface TuxJSQLBuilder {


    public static TuxJSQL build(Database db, SQLBuilder builder) {
        return new TuxJSQL(db, builder);
    }

    public static TuxJSQLBuilder create(Properties properties) {
        return create(getImplementationClass(properties));
    }

    public static TuxJSQLBuilder create(Implementation implementation) {
        Properties properties = new Properties();
        properties.setProperty("tuxjsql.implementation.class", implementation.getImplementationClass());
        return create(properties);
    }

    public static TuxJSQLBuilder create(Class<?> iClazz) {
        if (iClazz == null) {
            //TODO throw exception saying unable to find TuxJSQLBuilder
        }
        try {
            return (TuxJSQLBuilder) iClazz.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            TuxJSQL.LOGGER.error("Unable to create TuxJSQLBuilder", e);
        }
        return null;
    }

    TuxJSQL build();

    public enum Implementation {
        ;


        private String implementationClass;

        Implementation(String implementationClass) {
            this.implementationClass = implementationClass;
        }

        public String getImplementationClass() {
            return implementationClass;
        }
    }

}
