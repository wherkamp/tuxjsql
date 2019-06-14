package me.kingtux.tuxjsql.basic.builders;

import me.kingtux.tuxjsql.core.TuxJSQL;
import me.kingtux.tuxjsql.core.builders.ColumnBuilder;
import me.kingtux.tuxjsql.core.builders.TableBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class BasicTableBuilder implements TableBuilder {
    private String name;
    private List<ColumnBuilder> columnBuilders = new ArrayList<>();
    private TuxJSQL jsql;

    public BasicTableBuilder(TuxJSQL jsql) {
        this.jsql = jsql;
    }

    @Override
    public TableBuilder addColumn(ColumnBuilder column) {
        columnBuilders.add(column);
        return this;
    }

    @Override
    public TableBuilder addColumn(Consumer<ColumnBuilder> column) {
        ColumnBuilder builder  = jsql.getBuilder().createColumn();
        column.accept(builder);
        columnBuilders.add(builder);
        return this;
    }

    @Override
    public ColumnBuilder<TableBuilder> addColumn() {
        ColumnBuilder<TableBuilder> builder  = jsql.getBuilder().createColumn(this);
        columnBuilders.add(builder);
        return builder;
    }


    @Override
    public TableBuilder setName(String name) {
        this.name = name;
    return this;
    }

    public List<ColumnBuilder> getColumnBuilders() {
        return columnBuilders;
    }

    public String getName() {
        return name;
    }

    public TuxJSQL getJsql() {
        return jsql;
    }
}
