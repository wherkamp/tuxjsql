package me.kingtux.tuxjsql.sqlite.sql;

import me.kingtux.tuxjsql.basic.builders.BasicSQLBuilder;
import me.kingtux.tuxjsql.basic.sql.BasicDataTypes;
import me.kingtux.tuxjsql.core.builders.ColumnBuilder;
import me.kingtux.tuxjsql.core.builders.TableBuilder;
import me.kingtux.tuxjsql.core.connection.ConnectionProvider;
import me.kingtux.tuxjsql.core.connection.ConnectionSettings;
import me.kingtux.tuxjsql.core.sql.*;
import me.kingtux.tuxjsql.core.sql.select.JoinStatement;
import me.kingtux.tuxjsql.core.sql.select.SelectStatement;
import me.kingtux.tuxjsql.core.sql.where.SubWhereStatement;
import me.kingtux.tuxjsql.core.sql.where.WhereStatement;

import java.util.Properties;

public final class SQLITEBuilder extends BasicSQLBuilder {
    private static final String NAME = "SQLITE";
    private static final String KEY = "SQLITE";
    private static final String JDBC_CLASS = "SQLITE";
    private static final String DRIVER_URL = "SQLITE";
    private static final SQLAction[] ACTIONS = {SQLAction.DELETE, SQLAction.INSERT, SQLAction.ADD_COLUMN, SQLAction.SELECT};

    @Override
    public TableBuilder createTable() {
        return null;
    }

    @Override
    public ColumnBuilder createColumn() {
        return null;
    }

    @Override
    public WhereStatement createWhere() {
        return null;
    }

    @Override
    public SubWhereStatement createSubWhereStatement() {
        return null;
    }

    @Override
    public <T> WhereStatement<T> createWhere(T t) {
        return null;
    }

    @Override
    public <T> SubWhereStatement<T> createSubWhereStatement(T t) {
        return null;
    }

    @Override
    public SelectStatement createSelectStatement() {
        return null;
    }

    @Override
    public JoinStatement createJoinStatement() {
        return null;
    }

    @Override
    public UpdateStatement createUpdateStatement() {
        return null;
    }

    @Override
    public DeleteStatement createDeleteStatement() {
        return null;
    }

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public String key() {
        return KEY;
    }

    @Override
    public String jdbcClass() {
        return JDBC_CLASS;
    }

    @Override
    public SQLAction[] supportedActions() {
        return ACTIONS;
    }

    @Override
    public SQLDataType convertDataType(BasicDataTypes dataType) {
        return dataType;
    }

    @Override
    public InsertStatement createInsertStatement() {
        return null;
    }

    @Override
    public void configureConnectionProvider(ConnectionProvider provider, Properties userProperties) {
        provider.setup(new ConnectionSettings(JDBC_CLASS, DRIVER_URL), userProperties);
    }
}
