package me.kingtux.tuxjsql.core;

import me.kingtux.tuxjsql.core.sql.SQLTable;

import java.util.List;

public interface TableCollection extends List<SQLTable> {

    SQLTable getTableByName(String name);
}
