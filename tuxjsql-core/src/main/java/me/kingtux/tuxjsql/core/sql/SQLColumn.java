package me.kingtux.tuxjsql.core.sql;

import java.util.List;
import java.util.function.Predicate;

public interface SQLColumn {


    String getName();

    String defaultValue();


    boolean unique();

    boolean notNull();

    boolean autoIncrement();

    boolean primaryKey();

    boolean isForeignKey();

    SQLColumn foreignKey();

    SQLTable getTable();


    SQLDataType getDataType();

    List<String> dataTypeRules();

    /**
     * This takes all the rules. And makes a string for building the column
     * @return the column and its rules;
     */
    String build();

    String foreignBuild(SQLColumn column);
}
