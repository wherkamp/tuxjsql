package me.kingtux.tuxjsql.sqlite.sql;

public enum Queries {
    FOREIGN_VALUE("FOREIGN KEY ('%1$s') REFERENCES %2$s('%3$s')"),
    INSERT("INSERT INTO %1$s (%2$s) VALUES (%3$s);"),
    SELECT("SELECT %1$s FROM %2$s"),
    WHERE("WHERE %1$s"),
    DELETE("DELETE FROM %1$s WHERE %2$s"),
    UPDATE("UPDATE %1$s SET %2$s WHERE %3$s"),
    CREATE_TABLE_IF_NOT_EXISTS("CREATE TABLE IF NOT EXISTS %1$s (%2$s);"),
    CREATE_TABLE("CREATE TABLE %1$s (%2$s);"),
    MAX("SELECT MAX(%1$s) FROM %2$s"),
    MIN("SELECT MIN(%1$s) FROM %2$s"),
    DROP_TABLE("DROP TABLE %1$s"),
    DROP_COLUMN("ALTER TABLE %1$s DROP COLUMN %2$s"),
    ADD_COLUMN("ALTER TABLE %1$s ADD COLUMN %2$s"),
    MODIFY_COLUMN("ALTER TABLE %1$s MODIFY COLUMN %2$s");

    private String string;

    Queries(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
