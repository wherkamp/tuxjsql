package me.kingtux.tuxjsql.core.sql.where;

public interface WhereStatement<T> {

    WhereStatement start(String s, Object value);

    WhereStatement start(SubWhereStatement s);

    SubWhereStatement<WhereStatement> start();

    WhereStatement AND(String s, Object value);

    WhereStatement AND(SubWhereStatement s);

    SubWhereStatement<WhereStatement> AND();

    WhereStatement OR(String s, Object value);

    WhereStatement OR(SubWhereStatement s);

    SubWhereStatement<WhereStatement> OR();

    WhereStatement NOT(String s, Object value);

    WhereStatement NOT(SubWhereStatement s);

    SubWhereStatement<WhereStatement> NOT();


    T build();


    String getQuery();

    Object[] getValues();
}
