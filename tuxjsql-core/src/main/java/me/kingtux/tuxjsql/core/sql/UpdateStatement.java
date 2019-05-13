package me.kingtux.tuxjsql.core.sql;

import me.kingtux.tuxjsql.core.response.DBAction;
import me.kingtux.tuxjsql.core.sql.where.WhereStatement;

public interface UpdateStatement {


    UpdateStatement value(String key, Object value);

    WhereStatement<UpdateStatement> where();

    DBAction execute();
}
