package me.kingtux.tuxjsql.core.sql.select;

import me.kingtux.tuxjsql.basic.sql.BasicSQLTable;
import me.kingtux.tuxjsql.core.response.DBAction;
import me.kingtux.tuxjsql.core.sql.where.WhereStatement;

import java.util.function.Consumer;

public interface SelectStatement {

    WhereStatement<SelectStatement> where();

    SelectStatement where(Consumer<WhereStatement> whereStatement);

    SelectStatement limit(int i);

    SelectStatement column(String s);

    SelectStatement column(String... s);


    JoinStatement join();

    SelectStatement join(Consumer<JoinStatement> consumer);


    DBAction execute();

    SelectStatement setTable(BasicSQLTable basicSQLTable);
}
