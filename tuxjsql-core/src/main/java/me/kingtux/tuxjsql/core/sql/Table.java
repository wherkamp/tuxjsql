package me.kingtux.tuxjsql.core.sql;

import me.kingtux.tuxjsql.core.sql.select.SelectStatement;

public interface Table {


    void executeStatement(String string);


    SelectStatement select();


}
