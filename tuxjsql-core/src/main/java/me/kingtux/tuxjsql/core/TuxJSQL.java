package me.kingtux.tuxjsql.core;


import me.kingtux.tuxjsql.core.builders.SQLBuilder;
import me.kingtux.tuxjsql.core.connection.ConnectionProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.concurrent.ExecutorService;

/**
 * TuxJSQL core class.
 *
 * @author KingTux
 */
public final class TuxJSQL {
    private static Logger logger = LoggerFactory.getLogger(TuxJSQL.class);
    private ConnectionProvider provider;
    private SQLBuilder builder;
    private ExecutorService executor;
    public TuxJSQL(ConnectionProvider provider, SQLBuilder builder, ExecutorService executor) {
        this.provider = provider;
        this.builder = builder;
        this.executor = executor;
        Runtime.getRuntime().addShutdownHook(new Thread(provider::close));
    }

    public Connection getConnection(){
        return provider.getConnection();
    }

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        if (logger == null) return;
        TuxJSQL.logger = logger;
    }

    public ExecutorService getExecutor() {
        return executor;
    }
}
