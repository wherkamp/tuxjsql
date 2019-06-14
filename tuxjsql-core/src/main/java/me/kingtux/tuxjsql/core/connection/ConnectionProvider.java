package me.kingtux.tuxjsql.core.connection;

import java.sql.Connection;
import java.util.Properties;

public interface ConnectionProvider {

    Connection getConnection();

    void close();

    void returnConnection(Connection connection);

    boolean isConnected();

    String name();
    void setup(ConnectionSettings settings, Properties userSettings);
}
