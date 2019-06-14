package me.kingtux.tuxjsql.sqlite.sql;

import me.kingtux.tuxjsql.basic.sql.BasicSQLTable;
import me.kingtux.tuxjsql.core.TuxJSQL;
import me.kingtux.tuxjsql.core.sql.SQLColumn;
import me.kingtux.tuxjsql.core.sql.SQLTable;

import java.util.List;

public class SQLITETable extends BasicSQLTable {
    public SQLITETable(TuxJSQL tuxJSQL, String name, List<SQLColumn> sqlColumns) {
        super(tuxJSQL, name, sqlColumns);
    }
    public void prepareTable() {
        //This will do a create if not exists and add new columns if needed
    }
}
