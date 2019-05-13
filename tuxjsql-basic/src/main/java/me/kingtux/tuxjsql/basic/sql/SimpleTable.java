package me.kingtux.tuxjsql.basic.sql;
import me.kingtux.tuxjsql.core.TuxJSQL;
import me.kingtux.tuxjsql.core.sql.Table;

public abstract class SimpleTable implements Table {
    private TuxJSQL tuxJSQL;

    public SimpleTable(TuxJSQL tuxJSQL) {
        this.tuxJSQL = tuxJSQL;
    }


}
