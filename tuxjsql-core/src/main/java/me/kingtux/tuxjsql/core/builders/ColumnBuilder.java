package me.kingtux.tuxjsql.core.builders;

import me.kingtux.tuxjsql.core.sql.SQLColumn;
import me.kingtux.tuxjsql.core.sql.SQLDataType;
import me.kingtux.tuxjsql.core.sql.SQLTable;

public interface ColumnBuilder<T> {

    ColumnBuilder<T> setDataType(SQLDataType type);

    ColumnBuilder<T> addDataTypeRule(String s);

    ColumnBuilder<T> setTable(SQLTable table);
    SQLColumn build();

    T and();
}
