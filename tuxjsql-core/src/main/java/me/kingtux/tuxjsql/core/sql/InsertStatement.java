package me.kingtux.tuxjsql.core.sql;

import me.kingtux.tuxjsql.basic.sql.BasicSQLTable;
import me.kingtux.tuxjsql.core.response.DBAction;

import java.util.Map;

public interface InsertStatement {

    InsertStatement values(Map<String, Object> map);

    InsertStatement value(String string, Object o);

    DBAction execute();

    InsertStatement setTable(BasicSQLTable basicSQLTable);
}
