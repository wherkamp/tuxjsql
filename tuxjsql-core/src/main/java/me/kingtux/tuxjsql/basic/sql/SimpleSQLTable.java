package me.kingtux.tuxjsql.basic.sql;
import me.kingtux.tuxjsql.core.TuxJSQL;
import me.kingtux.tuxjsql.core.sql.SQLTable;

public abstract class SimpleSQLTable implements SQLTable {
    private TuxJSQL tuxJSQL;

    public SimpleSQLTable(TuxJSQL tuxJSQL) {
        this.tuxJSQL = tuxJSQL;
    }


}
