package me.kingtux.tuxjsql.sqlite.sql;

import me.kingtux.tuxjsql.basic.builders.BasicTableBuilder;
import me.kingtux.tuxjsql.core.TuxJSQL;
import me.kingtux.tuxjsql.core.builders.ColumnBuilder;
import me.kingtux.tuxjsql.core.sql.SQLColumn;
import me.kingtux.tuxjsql.core.sql.SQLTable;

import java.util.List;
import java.util.stream.Collectors;

public class SQLITETableBuilder extends BasicTableBuilder {
    public SQLITETableBuilder(TuxJSQL jsql) {
        super(jsql);
    }

    @Override
    public SQLTable createTable() {
        List<SQLColumn> builders = getColumnBuilders().stream().map(ColumnBuilder::build).collect(Collectors.toList());
        SQLITETable table = new SQLITETable(getJsql(), getName(),builders);
        table.prepareTable();
        return table;
    }
}
