package me.kingtux.tuxjsql.core.response;

import java.util.List;

public interface DBResult extends Iterable<DBRow>{


    List<DBRow> getRows();


    DBRow get(int i);

    DBRow first();

    int numberOfRows();

}
