package me.kingtux.tuxjsql.core.sql.select;

public interface JoinStatement {

    JoinStatement on(String tableOneColumn, String tableTwo);

    SelectStatement column(String s);

    SelectStatement column(String... s);

    SelectStatement build();

    JoinStatement joinType(JoinType type);
}
