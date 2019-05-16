package me.kingtux.tuxjsql.basic.response;

import me.kingtux.tuxjsql.core.response.DBResult;
import me.kingtux.tuxjsql.core.response.DBRow;

import java.util.Iterator;
import java.util.List;

public class BasicDBResult implements DBResult {
    private List<DBRow> rows;

    public BasicDBResult(List<DBRow> rows) {
        this.rows = rows;
    }

    @Override
    public List<DBRow> getRows() {
        return rows;
    }

    @Override
    public DBRow get(int i) {
        return rows.get(i);
    }

    @Override
    public DBRow first() {
        return get(0);
    }

    @Override
    public int numberOfRows() {
        return rows.size();
    }

    @Override
    public Iterator<DBRow> iterator() {
        return rows.iterator();
    }
}
