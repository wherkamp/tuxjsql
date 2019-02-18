package me.kingtux.tuxjsql.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;

/**
 * I know I know static is bad. But FUCK YOU
 */
public class TuxJSQL {
    private static Builder builder;
    private static Connection connection;

    private TuxJSQL() {
    }

    public static Builder getBuilder() {
        if (builder == null) {
            try {
                throw new IllegalAccessException("TuxJSQL has not been configured... Please set the Builder");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        }
        return builder;
    }

    public static void setBuilder(Builder builder) {
        TuxJSQL.builder = builder;
    }

    public static void setBuilder(Type type) {
        setBuilder(type.classPath);
    }

    public static void setBuilder(String clazzPath) {
        Class<?> clazz = null;
        try {
            clazz = Class.forName(clazzPath);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (clazz == null) {
            return;
        }
        Method method;

        try {
            method = clazz.getMethod("getInstance");
        } catch (NoSuchMethodException e) {
            method = null;
        }
        if (method != null) {
            try {
                builder = (Builder) method.invoke(null);
                return;
            } catch (IllegalAccessException | InvocationTargetException ignored) {

            }
        }
        try {
            builder = (Builder) clazz.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                throw new IllegalAccessException("TuxJSQL has not been configured... Please set the connection.");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        }
        return connection;
    }

    public static void setConnection(Connection connection) {
        if (connection == null) {
            throw new IllegalArgumentException("Connection is null.");
        }
        TuxJSQL.connection = connection;
    }

    public static enum Type {
        MYSQL("me.kingtux.tuxjsql.mysql.MySQLBuilder");
        private String classPath;

        Type(String classPath) {
            this.classPath = classPath;
        }

        public String getClassPath() {
            return classPath;
        }
    }
}