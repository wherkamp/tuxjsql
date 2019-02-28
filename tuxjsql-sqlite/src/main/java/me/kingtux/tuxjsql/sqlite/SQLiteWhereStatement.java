package me.kingtux.tuxjsql.sqlite;

import me.kingtux.tuxjsql.core.SubWhereStatement;
import me.kingtux.tuxjsql.core.Where;
import me.kingtux.tuxjsql.core.WhereStatement;

import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("Duplicates")
public class SQLiteWhereStatement implements WhereStatement {
    private List<Object> objects = new ArrayList<>();
    private List<Object> items = new ArrayList<>();

    SQLiteWhereStatement() {

    }

    @Override
    public WhereStatement start(String s, Object value) {
        objects.add(value);
        items.add(new SQLITEWhere(s));
        return this;
    }

    @Override
    public WhereStatement start(SubWhereStatement s) {
        items.add(s);
        return this;
    }

    @Override
    public WhereStatement AND(String s, Object value) {
        objects.add(value);
        items.add("AND");
        items.add(new SQLITEWhere(s));
        return this;
    }

    @Override
    public WhereStatement AND(SubWhereStatement s) {
        items.add("AND");
        items.add(s);
        return this;
    }

    @Override
    public WhereStatement OR(String s, Object value) {
        objects.add(value);
        items.add("OR");

        items.add(new SQLITEWhere(s));
        return this;
    }

    @Override
    public WhereStatement OR(SubWhereStatement s) {
        items.add("OR");

        items.add(s);
        return this;
    }

    @Override
    public WhereStatement NOT(String s, Object value) {
        objects.add(value);
        items.add("NOT");

        items.add(new SQLITEWhere(s));
        return this;
    }

    @Override
    public WhereStatement NOT(SubWhereStatement s) {
        items.add("NOT");
        items.add(s);
        return this;
    }

    @Override
    public Object[] getValues() {
        return objects.toArray();
    }

    @Override
    public String build() {
        StringBuilder builder = new StringBuilder();
        for (Object object : items) {
            if (object instanceof SubWhereStatement) {
                builder.append(((SubWhereStatement) object).build());
            } else if (object instanceof Where) {
                builder.append(((Where) object).build());
            } else if (object instanceof String) {
                builder.append(object);
            }
        }

        return builder.toString();
    }
}