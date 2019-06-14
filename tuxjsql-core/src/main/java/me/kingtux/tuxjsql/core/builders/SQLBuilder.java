package me.kingtux.tuxjsql.core.builders;

import me.kingtux.tuxjsql.basic.builders.BasicTableBuilder;
import me.kingtux.tuxjsql.basic.sql.BasicDataTypes;
import me.kingtux.tuxjsql.core.connection.ConnectionProvider;
import me.kingtux.tuxjsql.core.sql.*;
import me.kingtux.tuxjsql.core.sql.select.JoinStatement;
import me.kingtux.tuxjsql.core.sql.select.SelectStatement;
import me.kingtux.tuxjsql.core.sql.where.SubWhereStatement;
import me.kingtux.tuxjsql.core.sql.where.WhereStatement;

import java.util.Properties;

public interface SQLBuilder {
    TableBuilder createTable();

    ColumnBuilder createColumn();

    WhereStatement createWhere();

    SubWhereStatement createSubWhereStatement();

    <T> WhereStatement<T> createWhere(T t);

    <T> SubWhereStatement<T> createSubWhereStatement(T t);

    SelectStatement createSelectStatement();

    JoinStatement createJoinStatement();

    UpdateStatement createUpdateStatement();
    
    DeleteStatement createDeleteStatement();


    String name();

    String key();

    String jdbcClass();

    SQLAction[] supportedActions();

    boolean supportsAction(SQLAction actions);
    /**
     * This will convert a public DataType to its local dialect version.
     * @param dataType
     * @return
     */
    SQLDataType convertDataType(BasicDataTypes dataType);

    InsertStatement createInsertStatement();

    void configureConnectionProvider(ConnectionProvider provider, Properties userProperties);

    <T> ColumnBuilder<T> createColumn(T t);
}
