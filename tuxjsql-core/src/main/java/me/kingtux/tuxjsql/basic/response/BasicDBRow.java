package me.kingtux.tuxjsql.basic.response;

import me.kingtux.tuxjsql.core.TuxJSQL;
import me.kingtux.tuxjsql.core.response.DBRow;

import java.util.UUID;

public class BasicDBRow implements DBRow {
    private Object value;

    public BasicDBRow(Object value) {
        this.value = value;
    }

    @Override
    public <T> T getAsEnum() {
        String string = getAsString();
        if(string == null) return null;
        String[] split = string.split("#");
        if (split.length == 0) return null;
        Class<T> clazz;
        try {
            clazz = (Class<T>) Class.forName(split[0]);
        } catch (ClassNotFoundException e) {
            TuxJSQL.getLogger().error("Unable to locate class for enum", e);
            return null;
        }

        return (T) Enum.valueOf((Class<? extends Enum>) clazz, split[1]);
    }

    @Override
    public String getAsString() {
        if (value == null) return null;
        if (value instanceof String) return (String) value;
        return value.toString();
    }

    @Override
    public UUID getAsUUID() {
        if (value == null) return null;
        if (value instanceof String) UUID.fromString((String) value);
        return null;
    }

    @Override
    public int getAsInt() {
        if (value == null) return 0;
        if (value instanceof Integer) return (int) value;
        return Integer.parseInt((String) value);
    }

    @Override
    public long getAsLong() {
        if (value == null) return 0L;
        if (value instanceof Long) return (long) value;
        return Long.parseLong((String) value);
    }

    @Override
    public double getAsDouble() {
        if (value == null) return 0D;
        if (value instanceof Double) return (double) value;
        return Double.parseDouble((String) value);
    }

    @Override
    public Object getAsObject() {
        return value;
    }
}
