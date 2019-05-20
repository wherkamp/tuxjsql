package me.kingtux.tuxjsql.basic;

import me.kingtux.tuxjsql.core.TableCollection;
import me.kingtux.tuxjsql.core.sql.SQLTable;

import java.util.ArrayList;

public class BasicTableCollection extends ArrayList<SQLTable> implements TableCollection {

    @Override
    public SQLTable getTableByName(String name) {
        for (SQLTable table : this) {
            if (table.getName().equals(name)) {
                return table;
            }
        }
        return null;
    }

}
