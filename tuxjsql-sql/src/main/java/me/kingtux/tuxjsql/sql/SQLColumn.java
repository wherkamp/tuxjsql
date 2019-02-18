package me.kingtux.tuxjsql.sql;

import me.kingtux.tuxjsql.core.Column;
import me.kingtux.tuxjsql.core.ColumnType;

public class SQLColumn implements Column {
    private String name;
    private boolean unique, primary, nullable, autoIncrement;
    private ColumnType type;

    public SQLColumn(String name, boolean unique, boolean primary, boolean nullable, boolean autoIncrement, ColumnType type) {
        this.name = name;
        this.unique = unique;
        this.primary = primary;
        this.nullable = nullable;
        this.autoIncrement = autoIncrement;
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isUnique() {
        return unique;
    }

    @Override
    public boolean isPrimary() {
        return primary;
    }

    @Override
    public boolean isNullable() {
        return nullable;
    }

    @Override
    public boolean isAutoIncrement() {
        return autoIncrement;
    }

    @Override
    public String build() {
        StringBuilder builder = new StringBuilder();
        builder.append(name);
        builder.append(" " + getType().type());
        builder.append(isAutoIncrement() ? " AUTO_INCREMENT" : "");
        builder.append(isPrimary() ? " PRIMARY KEY" : "");
        if (!isAutoIncrement()) {
            builder.append(isNullable() ? "" : " NOT NULL");
            builder.append(isUnique() ? " UNIQUE" : "");
        }
        return builder.toString();
    }

    @Override
    public ColumnType getType() {
        return type;
    }
}