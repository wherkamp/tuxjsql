package me.kingtux.tuxjsql.core;

import me.kingtux.tuxjsql.core.builders.SQLBuilder;
import org.reflections.Reflections;

import java.util.Properties;
import java.util.Set;

public class InternalUtils {
    static Class<?> getImplementationClass(Properties properties) {

        String s = properties.getProperty("tuxjsql.implementation.type");
        if (s == null)
            s = properties.getProperty("tuxjsql.implemnetaion.class");
        Class<?> iClazz = null;
        try {
            iClazz = Class.forName(s);
        } catch (ClassNotFoundException e) {
            TuxJSQL.getLogger().error(String.format("Unable to locate implementation class: %s", s), e);
        }
        return iClazz;
    }

    static Set<Class<? extends SQLBuilder>> loadAllClasses() {
        Reflections reflections = new Reflections("me.kingtux.tuxjsql");
        return reflections.getSubTypesOf(SQLBuilder.class);

    }
}
