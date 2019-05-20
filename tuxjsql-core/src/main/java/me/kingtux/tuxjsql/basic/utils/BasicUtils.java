package me.kingtux.tuxjsql.basic.utils;

import me.kingtux.tuxjsql.basic.response.BasicDBResult;
import me.kingtux.tuxjsql.core.response.DBResult;
import me.kingtux.tuxjsql.core.response.DBRow;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BasicUtils {

    public static DBResult resultSetToDBResult(ResultSet set) {
        List<DBRow> rows = new ArrayList<>();


        return new BasicDBResult(rows);
    }
}
