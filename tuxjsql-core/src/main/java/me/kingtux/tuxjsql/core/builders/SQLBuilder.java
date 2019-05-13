package me.kingtux.tuxjsql.core.builders;

import me.kingtux.tuxjsql.core.sql.where.WhereStatement;

public interface SQLBuilder {
    TableBuilder createTable();

    ColumnBuilder createColumn();

    WhereStatement createWhere();


}
