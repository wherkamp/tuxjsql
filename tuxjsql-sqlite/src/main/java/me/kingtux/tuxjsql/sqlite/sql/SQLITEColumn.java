package me.kingtux.tuxjsql.sqlite.sql;

import me.kingtux.tuxjsql.basic.sql.BasicSQLColumn;
import me.kingtux.tuxjsql.core.sql.SQLColumn;

public class SQLITEColumn extends BasicSQLColumn {
    private final static String AUTOINCREMENT = "AUTOINCREMENT";
    @Override
    public String build() {
        StringBuilder builder = new StringBuilder();
        builder.append("`").append(name).append("`");
        builder.append(" ").append(buildDataType());
        builder.append(primaryKey() ? " PRIMARY KEY" : "");
        builder.append(autoIncrement() ? " AUTOINCREMENT" : "");
        if (!autoIncrement()) {
            builder.append(notNull() ? " NOT NULL" : "");
            builder.append(unique() ? " UNIQUE" : "");
        }
        if (defaultValue != null) {
            builder.append(" DEFAULT ");
            builder.append("'").append(defaultValue).append("'");
        }
        return builder.toString();
    }

    @Override
    public String foreignBuild(SQLColumn column) {
        return String.format(Queries.FOREIGN_VALUE.getString(), column.getName(), getName(), getTable().getName());
    }
}
