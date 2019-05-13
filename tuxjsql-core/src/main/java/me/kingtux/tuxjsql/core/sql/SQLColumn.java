package me.kingtux.tuxjsql.core.sql;

import java.util.List;

public interface SQLColumn {


    String getName();


    List<SQLContraint> getContraints();

    SQLDataType getDataType();


    /**
     * This takes all the rules. And makes a string for building the column
     * @return the column and its rules;
     */
    String build();
}
