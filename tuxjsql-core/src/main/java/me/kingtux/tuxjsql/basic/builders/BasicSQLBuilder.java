package me.kingtux.tuxjsql.basic.builders;

import me.kingtux.tuxjsql.core.builders.SQLBuilder;
import me.kingtux.tuxjsql.core.sql.SQLAction;

public abstract class BasicSQLBuilder implements SQLBuilder {


    @Override
    public boolean supportsAction(SQLAction actions) {
        for (SQLAction action : supportedActions()) {
            if (action == actions) {
                return true;
            }
        }
        return false;
    }
}
