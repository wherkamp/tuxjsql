package me.kingtux.tuxjsql.core;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pw.rayz.vessel.objects.Database;

/**
 * TuxJSQL core class.
 *
 * @author KingTux
 */
public final class TuxJSQL {
    public static Logger LOGGER = LoggerFactory.getLogger(TuxJSQL.class);
    private Database database;
    private SQLBuilder builder;


    public TuxJSQL(Database database, SQLBuilder builder) {
        this.database = database;
        this.builder = builder;
    }

    public enum Implementation {}
}
