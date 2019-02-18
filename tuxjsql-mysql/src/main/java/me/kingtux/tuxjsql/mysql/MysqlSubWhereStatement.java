package me.kingtux.tuxjsql.mysql;

import me.kingtux.tuxjsql.core.SubWhereStatement;
import me.kingtux.tuxjsql.core.Where;
import me.kingtux.tuxjsql.core.WhereStatement;

import java.util.List;

public class MysqlSubWhereStatement implements SubWhereStatement {
    private List<Object> objects;
    private List<Object> items;

    public MysqlSubWhereStatement() {

    }

    @Override
    public SubWhereStatement start(String s, Object value) {
        objects.add(value);
        items.add(new MysqlWhere(s));
        return this;
    }

    @Override
    public SubWhereStatement start(SubWhereStatement s) {
        items.add(s);
        return this;
    }

    @Override
    public SubWhereStatement AND(String s, Object value) {
        objects.add(value);
        items.add("AND");
        items.add(new MysqlWhere(s));
        return this;
    }

    @Override
    public SubWhereStatement AND(SubWhereStatement s) {
        items.add("AND");
        items.add(s);
        return this;
    }

    @Override
    public SubWhereStatement OR(String s, Object value) {
        objects.add(value);
        items.add("OR");

        items.add(new MysqlWhere(s));
        return this;
    }

    @Override
    public SubWhereStatement OR(SubWhereStatement s) {
        items.add("OR");

        items.add(s);
        return this;
    }

    @Override
    public SubWhereStatement NOT(String s, Object value) {
        objects.add(value);
        items.add("NOT");

        items.add(new MysqlWhere(s));
        return this;
    }

    @Override
    public SubWhereStatement NOT(SubWhereStatement s) {
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
