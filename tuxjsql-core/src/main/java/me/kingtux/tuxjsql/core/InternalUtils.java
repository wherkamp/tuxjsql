package me.kingtux.tuxjsql.core;

import java.util.Properties;

public class InternalUtils {
    static Class<?> getImplementationClass(Properties properties) {

        String s = properties.getProperty("tuxjsql.implementation.type");
        if (s == null)
            s = properties.getProperty("tuxjsql.implemnetaion.class");
        else
            s = TuxJSQLBuilder.Implementation.valueOf(s.toUpperCase()).getImplementationClass();
        Class<?> iClazz = null;
        try {
            iClazz = Class.forName(s);
        } catch (ClassNotFoundException e) {
            TuxJSQL.LOGGER.error(String.format("Unable to locate implementation class: %s", s), e);
        }
        return iClazz;
    }
}
