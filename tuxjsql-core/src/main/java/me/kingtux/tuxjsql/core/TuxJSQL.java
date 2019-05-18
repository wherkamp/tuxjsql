package me.kingtux.tuxjsql.core;


import me.kingtux.tuxjsql.core.builders.ColumnBuilder;
import me.kingtux.tuxjsql.core.builders.SQLBuilder;
import me.kingtux.tuxjsql.core.builders.TableBuilder;
import me.kingtux.tuxjsql.core.connection.ConnectionProvider;
import me.kingtux.tuxjsql.core.sql.SQLDataType;
import me.kingtux.tuxjsql.core.sql.select.JoinStatement;
import me.kingtux.tuxjsql.core.sql.select.SelectStatement;
import me.kingtux.tuxjsql.core.sql.where.SubWhereStatement;
import me.kingtux.tuxjsql.core.sql.where.WhereStatement;
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

    /**
     * <b>REMEMBER to do Connection#close() to return it!</b>
     *
     * @return a connection!
     */
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

    public TableBuilder createTable() {
        return builder.createTable();
    }

    public ColumnBuilder createColumn() {
        return builder.createColumn();
    }

    public WhereStatement createWhere() {
        return builder.createWhere();
    }

    public SubWhereStatement createSubWhereStatement() {
        return builder.createSubWhereStatement();
    }

    public <T> WhereStatement<T> createWhere(T t) {
        return builder.createWhere(t);
    }

    public <T> SubWhereStatement<T> createSubWhereStatement(T t) {
        return builder.createSubWhereStatement(t);
    }

    public SelectStatement createSelectStatement() {
        return builder.createSelectStatement();
    }

    public JoinStatement createJoinStatement() {
        return builder.createJoinStatement();
    }

    public SQLDataType convertDataType(SQLDataType dataType) {
        return builder.convertDataType(dataType);
    }

    public ConnectionProvider getProvider() {
        return provider;
    }

    public SQLBuilder getBuilder() {
        return builder;
    }

    public ExecutorService getExecutor() {
        return executor;
    }
}
