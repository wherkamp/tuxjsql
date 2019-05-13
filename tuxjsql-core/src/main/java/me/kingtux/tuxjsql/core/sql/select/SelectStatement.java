package me.kingtux.tuxjsql.core.sql.select;

import me.kingtux.tuxjsql.core.response.DBAction;
import me.kingtux.tuxjsql.core.sql.where.WhereStatement;

public interface SelectStatement {

    WhereStatement<SelectStatement> where();

    SelectStatement limit(int i);

    SelectStatement column(String s);

    SelectStatement column(String... s);


    JoinStatement join();


    DBAction execute();
}
