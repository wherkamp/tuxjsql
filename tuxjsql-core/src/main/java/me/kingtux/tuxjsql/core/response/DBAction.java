package me.kingtux.tuxjsql.core.response;

import me.kingtux.tuxjsql.core.TuxJSQL;

import java.util.concurrent.*;
import java.util.function.Consumer;

public class DBAction {
    private static final String ERROR_MESSAGE = "Unable to get value from Future";
    private Callable<DBResult> callable;
    private TuxJSQL tuxjsql;

    public DBAction(Callable<DBResult> callable, TuxJSQL tuxjsql) {
        this.callable = callable;
        this.tuxjsql = tuxjsql;
    }

    public DBResult complete() {
        Future<DBResult> future = tuxjsql.getExecutor().submit(callable);
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            TuxJSQL.getLogger().error(ERROR_MESSAGE, e);
        }
        return null;
    }

    public DBResult complete(long time, TimeUnit unit) throws TimeoutException {
        Future<DBResult> future = tuxjsql.getExecutor().submit(callable);
        try {
            return future.get(time, unit);
        } catch (InterruptedException | ExecutionException e) {
            TuxJSQL.getLogger().error(ERROR_MESSAGE, e);
        }
        return null;
    }

    public void queue() {
        tuxjsql.getExecutor().submit(callable);
    }

    public void queue(Consumer<DBResult> handler, long time, TimeUnit unit) {
        Future<DBResult> future = tuxjsql.getExecutor().submit(callable);

        new Thread(() -> {
            try {
                handler.accept(future.get(time, unit));
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                TuxJSQL.getLogger().error(ERROR_MESSAGE, e);
            }
        }).start();
    }

    public void queue(Consumer<DBResult> handler) {
        Future<DBResult> future = tuxjsql.getExecutor().submit(callable);

        new Thread(() -> {
            try {
                handler.accept(future.get());
            } catch (InterruptedException | ExecutionException e) {
                TuxJSQL.getLogger().error(ERROR_MESSAGE, e);
            }
        }).start();
    }


}
