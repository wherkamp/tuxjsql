package me.kingtux.tuxjsql.core.builders;

import me.kingtux.tuxjsql.core.sql.SQLColumn;
import me.kingtux.tuxjsql.core.sql.SQLContraint;
import me.kingtux.tuxjsql.core.sql.SQLDataType;

public interface ColumnBuilder<T> {

    ColumnBuilder setDataType(SQLDataType type);

    ColumnBuilder addDataTypeRule(String s);

    ColumnBuilder addSQLContraint(SQLContraint contraint);

    SQLColumn build();

    T and();
}
