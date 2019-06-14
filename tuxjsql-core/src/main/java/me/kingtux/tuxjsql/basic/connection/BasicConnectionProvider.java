package me.kingtux.tuxjsql.basic.connection;

import com.google.auto.service.AutoService;
import me.kingtux.tuxjsql.core.TuxJSQL;
import me.kingtux.tuxjsql.core.connection.ConnectionProvider;
import me.kingtux.tuxjsql.core.connection.ConnectionSettings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
@AutoService(ConnectionProvider.class)
public class BasicConnectionProvider implements ConnectionProvider {
    private Connection connection;

    @Override
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void close() {
        try {
            ((BasicConnection) connection).getConnection().close();
        } catch (SQLException e) {
            TuxJSQL.getLogger().error("Unable to close connection", e);
        }
    }

    @Override
    public void returnConnection(Connection connection) {
    }

    @Override
    public boolean isConnected() {
        try {
            return !connection.isClosed();
        } catch (SQLException e) {
            TuxJSQL.getLogger().error("Unable to get isClosed status", e);
        }
        return false;
    }

    @Override
    public String name() {
        return "Basic Connection";
    }

    @Override
    public void setup(ConnectionSettings connectionRules, Properties userRules) {
        try {
            Class.forName(connectionRules.getDriver());
            connection = DriverManager.getConnection(connectionRules.getUrl(), userRules);
        } catch (ClassNotFoundException | SQLException e) {
            TuxJSQL.getLogger().error("Unable to connect to db", e);
        }
    }
}
