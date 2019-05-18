package me.kingtux.tuxjsql.core.sql;

import me.kingtux.tuxjsql.basic.sql.SimpleSQLTable;
import me.kingtux.tuxjsql.core.response.DBAction;
import me.kingtux.tuxjsql.core.sql.where.WhereStatement;

public interface DeleteStatement {

    WhereStatement where();

    DBAction execute();

    DeleteStatement setTable(SimpleSQLTable simpleSQLTable);
}
