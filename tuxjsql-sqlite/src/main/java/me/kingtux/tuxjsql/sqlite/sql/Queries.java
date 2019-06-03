package me.kingtux.tuxjsql.sqlite.sql;

public enum Queries {
    FOREIGN_VALUE("FOREIGN KEY ('%1$s') REFERENCES %2$s('%3$s')");

    private String string;

    Queries(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
