package me.kingtux.tuxjsql.core.builders;

import me.kingtux.tuxjsql.core.sql.DeleteStatement;
import me.kingtux.tuxjsql.core.sql.InsertStatement;
import me.kingtux.tuxjsql.core.sql.SQLDataType;
import me.kingtux.tuxjsql.core.sql.UpdateStatement;
import me.kingtux.tuxjsql.core.sql.select.JoinStatement;
import me.kingtux.tuxjsql.core.sql.select.SelectStatement;
import me.kingtux.tuxjsql.core.sql.where.SubWhereStatement;
import me.kingtux.tuxjsql.core.sql.where.WhereStatement;

import javax.swing.table.JTableHeader;

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
    
    
    /**
     * This will convert a public DataType to its local dielect version.
     * @param dataType
     * @return
     */
    SQLDataType convertDataType(SQLDataType dataType);

    InsertStatement createInsertStatement();
}
