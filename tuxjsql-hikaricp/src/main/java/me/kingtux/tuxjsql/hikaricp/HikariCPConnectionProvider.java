package me.kingtux.tuxjsql.hikaricp;

import com.google.auto.service.AutoService;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import me.kingtux.tuxjsql.core.TuxJSQL;
import me.kingtux.tuxjsql.core.connection.ConnectionProvider;
import me.kingtux.tuxjsql.core.connection.ConnectionSettings;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

@AutoService(ConnectionProvider.class)
public class HikariCPConnectionProvider implements ConnectionProvider {
    private HikariDataSource dataSource;

    @Override
    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            TuxJSQL.getLogger().error("Unable to get connection for you!", e);
        }
        return null;
    }

    @Override
    public void close() {
        dataSource.close();
    }

    @Override
    public void returnConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            TuxJSQL.getLogger().error("Unable to return connection to pool", e);
        }
    }

    @Override
    public boolean isConnected() {
        return !dataSource.isClosed();
    }

    @Override
    public String name() {
        return "TuxJSQL-HikariCP CP";
    }

    @Override
    public void setup(ConnectionSettings settings, Properties userSettings) {
        HikariConfig hikariConfig = new HikariConfig(userSettings);
        hikariConfig.setJdbcUrl(settings.getUrl());
        hikariConfig.setDriverClassName(settings.getDriver());
        dataSource = new HikariDataSource(hikariConfig);
    }
}
