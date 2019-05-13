package me.kingtux.tuxjsql.core.response;

import java.util.function.Consumer;

public interface DBAction {


    DBResult complete();

    void queue();

    void queue(Consumer<DBResult> resultConsumer);
}
