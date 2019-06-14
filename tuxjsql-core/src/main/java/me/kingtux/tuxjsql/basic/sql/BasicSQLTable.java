package me.kingtux.tuxjsql.basic.sql;
import me.kingtux.tuxjsql.core.TuxJSQL;
import me.kingtux.tuxjsql.core.sql.*;
import me.kingtux.tuxjsql.core.sql.select.SelectStatement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class BasicSQLTable implements SQLTable {
    private TuxJSQL tuxJSQL;
    private String name;
    private List<SQLColumn> sqlColumns;

    public BasicSQLTable(TuxJSQL tuxJSQL, String name, List<SQLColumn> sqlColumns) {
        this.tuxJSQL = tuxJSQL;
        this.name = name;
        this.sqlColumns = sqlColumns;
        this.sqlColumns.forEach(column -> {
            ((BasicSQLColumn)column).setTable(this);
        });
    }

    @Override
    public void executeStatement(String string) {
        try (Connection connection = tuxJSQL.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.execute(string);
            }
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


    @Override
    public String getName() {
        return  name;
    }
}
