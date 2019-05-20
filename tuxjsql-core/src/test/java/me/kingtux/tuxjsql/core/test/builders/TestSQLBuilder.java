package me.kingtux.tuxjsql.core.test.builders;

import me.kingtux.tuxjsql.core.builders.ColumnBuilder;
import me.kingtux.tuxjsql.core.builders.SQLBuilder;
import me.kingtux.tuxjsql.core.builders.TableBuilder;
import me.kingtux.tuxjsql.core.connection.ConnectionProvider;
import me.kingtux.tuxjsql.core.sql.DeleteStatement;
import me.kingtux.tuxjsql.core.sql.InsertStatement;
import me.kingtux.tuxjsql.core.sql.SQLDataType;
import me.kingtux.tuxjsql.core.sql.UpdateStatement;
import me.kingtux.tuxjsql.core.sql.select.JoinStatement;
import me.kingtux.tuxjsql.core.sql.select.SelectStatement;
import me.kingtux.tuxjsql.core.sql.where.SubWhereStatement;
import me.kingtux.tuxjsql.core.sql.where.WhereStatement;

import java.util.Properties;

public class TestSQLBuilder implements SQLBuilder {

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
        return "Test SQLBuilder";
    }

    @Override
    public String key() {
        return "TEST-SQLBUILDER";
    }

    @Override
    public String jbdcClass() {
        return "";
    }

    @Override
    public SQLDataType convertDataType(SQLDataType dataType) {
        return null;
    }

    @Override
    public InsertStatement createInsertStatement() {
        return null;
    }

    @Override
    public void configureConnectionProvider(ConnectionProvider provider, Properties userProperties) {

    }
}
