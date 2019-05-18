package me.kingtux.tuxjsql.core.sql.where;

public interface SubWhereStatement<T> {
    SubWhereStatement start(String s, Object value);

    SubWhereStatement start(SubWhereStatement s);

    SubWhereStatement<SubWhereStatement> start();

    SubWhereStatement AND(String s, Object value);

    SubWhereStatement AND(SubWhereStatement s);

    SubWhereStatement<SubWhereStatement> AND();

    SubWhereStatement OR(String s, Object value);

    SubWhereStatement OR(SubWhereStatement s);

    SubWhereStatement<SubWhereStatement> OR();

    SubWhereStatement NOT(String s, Object value);

    SubWhereStatement NOT(SubWhereStatement s);

    SubWhereStatement<SubWhereStatement> NOT();


    T and();

    String getQuery();

    Object[] getValues();
}
