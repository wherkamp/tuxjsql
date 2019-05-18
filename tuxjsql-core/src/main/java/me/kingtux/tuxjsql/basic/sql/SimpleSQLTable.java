package me.kingtux.tuxjsql.basic.sql;
import me.kingtux.tuxjsql.core.TuxJSQL;
import me.kingtux.tuxjsql.core.sql.DeleteStatement;
import me.kingtux.tuxjsql.core.sql.InsertStatement;
import me.kingtux.tuxjsql.core.sql.SQLTable;
import me.kingtux.tuxjsql.core.sql.UpdateStatement;
import me.kingtux.tuxjsql.core.sql.select.SelectStatement;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class SimpleSQLTable implements SQLTable {
    private TuxJSQL tuxJSQL;

    public SimpleSQLTable(TuxJSQL tuxJSQL) {
        this.tuxJSQL = tuxJSQL;
    }

    @Override
    public void executeStatement(String string) {
        try (Connection connection = tuxJSQL.getConnection()) {
            connection.createStatement().execute(string);
        } catch (SQLException e) {
            TuxJSQL.getLogger().error("Unable to execute " + string, e);
        }
    }

    @Override
    public SelectStatement select() {
        return tuxJSQL.createSelectStatement().setTable(this);
    }

    @Override
    public UpdateStatement update() {
        return tuxJSQL.getBuilder().createUpdateStatement().setTable(this);
    }

    @Override
    public DeleteStatement delete() {
        return tuxJSQL.getBuilder().createDeleteStatement().setTable(this);
    }

    @Override
    public InsertStatement insert() {
        return tuxJSQL.getBuilder().createInsertStatement().setTable(this);
    }
}
