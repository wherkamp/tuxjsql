package me.kingtux.tuxjsql.basic.sql;

import me.kingtux.tuxjsql.core.sql.SQLDataType;

public enum BasicDataTypes implements SQLDataType {
    /**
     * If you are using a UUID or a Enum
     */
    TEXT,
    REAL,
    INTEGER;

    @Override
    public String key() {
        return name();
    }
}
