package me.kingtux.tuxjsql.core.response;

public interface DBRow {


    <T> T getAsEnum();

    String getAsString();
}
