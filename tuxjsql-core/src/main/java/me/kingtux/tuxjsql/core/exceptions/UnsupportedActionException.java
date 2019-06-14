package me.kingtux.tuxjsql.core.exceptions;

import me.kingtux.tuxjsql.core.builders.SQLBuilder;
import me.kingtux.tuxjsql.core.sql.SQLAction;

/**
 * This exception is thrown whenver a specific dialect doesnt support an action
 *
 * @author wherkamp
 */
public class UnsupportedActionException extends RuntimeException {

    public UnsupportedActionException(SQLBuilder builder, SQLAction action) {
        super(String.format("%s does not support %s", builder.name(), action.name()));
    }
}
