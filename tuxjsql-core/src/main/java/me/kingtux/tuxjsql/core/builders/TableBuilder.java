package me.kingtux.tuxjsql.core.builders;

import me.kingtux.tuxjsql.core.sql.SQLColumn;

import java.util.function.Consumer;

public interface TableBuilder {


    TableBuilder addColumn(ColumnBuilder column);

    TableBuilder addColumn(Consumer<ColumnBuilder> column);

    ColumnBuilder<TableBuilder> addColumn();


    TableBuilder setName(String name);
}
