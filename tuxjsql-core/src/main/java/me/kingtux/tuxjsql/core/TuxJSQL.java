package me.kingtux.tuxjsql.core;


import me.kingtux.tuxjsql.core.builders.SQLBuilder;
import me.kingtux.tuxjsql.core.connection.ConnectionProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;

/**
 * TuxJSQL core class.
 *
 * @author KingTux
 */
public final class TuxJSQL {
    private static Logger logger = LoggerFactory.getLogger(TuxJSQL.class);
    private ConnectionProvider provider;
    private SQLBuilder builder;


    public TuxJSQL(ConnectionProvider provider, SQLBuilder builder) {
        this.provider = provider;
        this.builder = builder;
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
}
