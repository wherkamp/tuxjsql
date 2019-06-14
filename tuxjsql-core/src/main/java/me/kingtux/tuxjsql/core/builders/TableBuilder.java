package me.kingtux.tuxjsql.core.builders;

import me.kingtux.tuxjsql.core.sql.SQLTable;

import java.util.function.Consumer;

public interface TableBuilder {


    TableBuilder addColumn(ColumnBuilder column);

    TableBuilder addColumn(Consumer<ColumnBuilder> column);

    ColumnBuilder<TableBuilder> addColumn();

    /**
     * This will create the table on the Java side and on the db side. If needed will update the table on the db side.
     *
     * @return The SQLTable object
     */
    SQLTable createTable();


    TableBuilder setName(String name);
}
