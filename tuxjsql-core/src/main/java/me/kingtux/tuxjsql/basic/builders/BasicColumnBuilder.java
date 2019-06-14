package me.kingtux.tuxjsql.basic.builders;

import me.kingtux.tuxjsql.core.builders.ColumnBuilder;
import me.kingtux.tuxjsql.core.sql.SQLColumn;
import me.kingtux.tuxjsql.core.sql.SQLDataType;
import me.kingtux.tuxjsql.core.sql.SQLTable;

import java.util.ArrayList;
import java.util.List;

public abstract class BasicColumnBuilder<T> implements ColumnBuilder<T> {
    private String name;
    private SQLColumn foreignColumn;
    private boolean primaryKey = false, autoIncrement = false, notNull = false;
    private SQLDataType type;
    private List<String> dataTypeRules = new ArrayList<>();
    private Object defaultValue;
    private T andValue;
    private SQLTable table;

    public BasicColumnBuilder(T andValue) {
        this.andValue = andValue;
    }

    @Override
    public ColumnBuilder<T> setDataType(SQLDataType type) {
        this.type = type;
        return this;
    }

    @Override
    public ColumnBuilder<T> addDataTypeRule(String s) {
        dataTypeRules.add(s);
        return this;
    }

    @Override
    public ColumnBuilder<T> primaryKey() {
        primaryKey = true;
        return this;
    }

    @Override
    public ColumnBuilder<T> defaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    @Override
    public ColumnBuilder<T> notNull() {
        notNull = true;
        return this;
    }

    @Override
    public ColumnBuilder<T> autoIncrement() {
        autoIncrement = true;
        return this;
    }

    public ColumnBuilder<T> setTable(SQLTable table) {
        this.table = table;
        return this;
    }

    @Override
    public ColumnBuilder<T> foreignColumn(SQLColumn otherColumn) {
        this.foreignColumn = otherColumn;
        return this;
    }

    @Override
    public T and() {
        return andValue;
    }

    //Getters for internal use.
    public String getName() {
        return name;
    }

    public SQLColumn getForeignColumn() {
        return foreignColumn;
    }

    public boolean isPrimaryKey() {
        return primaryKey;
    }

    public boolean isAutoIncrement() {
        return autoIncrement;
    }

    public boolean isNotNull() {
        return notNull;
    }

    public SQLDataType getType() {
        return type;
    }

    public List<String> getDataTypeRules() {
        return dataTypeRules;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public T getAndValue() {
        return andValue;
    }

    public SQLTable getTable() {
        return table;
    }
}
