package me.kingtux.tuxjsql.basic.connection;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public final class BasicConnection implements Connection, AutoCloseable {
    private Connection connection;

    BasicConnection(Connection connection) {
        this.connection = connection;
    }

    public Statement createStatement() throws SQLException {
        return connection.createStatement();
    }

    public PreparedStatement prepareStatement(String s) throws SQLException {
        return connection.prepareStatement(s);
    }

    public CallableStatement prepareCall(String s) throws SQLException {
        return connection.prepareCall(s);
    }

    public String nativeSQL(String s) throws SQLException {
        return connection.nativeSQL(s);
    }

    public boolean getAutoCommit() throws SQLException {
        return connection.getAutoCommit();
    }

    public void setAutoCommit(boolean b) throws SQLException {
        connection.setAutoCommit(b);
    }

    public void commit() throws SQLException {
        connection.commit();
    }

    public void rollback() throws SQLException {
        connection.rollback();
    }

    public void close() throws SQLException {
    }

    public boolean isClosed() throws SQLException {
        return connection.isClosed();
    }

    public DatabaseMetaData getMetaData() throws SQLException {
        return connection.getMetaData();
    }

    public boolean isReadOnly() throws SQLException {
        return connection.isReadOnly();
    }

    public void setReadOnly(boolean b) throws SQLException {
        connection.setReadOnly(b);
    }

    public String getCatalog() throws SQLException {
        return connection.getCatalog();
    }

    public void setCatalog(String s) throws SQLException {
        connection.setCatalog(s);
    }

    public int getTransactionIsolation() throws SQLException {
        return connection.getTransactionIsolation();
    }

    public void setTransactionIsolation(int i) throws SQLException {
        connection.setTransactionIsolation(i);
    }

    public SQLWarning getWarnings() throws SQLException {
        return connection.getWarnings();
    }

    public void clearWarnings() throws SQLException {
        connection.clearWarnings();
    }

    public Statement createStatement(int i, int i1) throws SQLException {
        return connection.createStatement(i, i1);
    }

    public PreparedStatement prepareStatement(String s, int i, int i1) throws SQLException {
        return connection.prepareStatement(s, i, i1);
    }

    public CallableStatement prepareCall(String s, int i, int i1) throws SQLException {
        return connection.prepareCall(s, i, i1);
    }

    public Map<String, Class<?>> getTypeMap() throws SQLException {
        return connection.getTypeMap();
    }

    public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
        connection.setTypeMap(map);
    }

    public int getHoldability() throws SQLException {
        return connection.getHoldability();
    }

    public void setHoldability(int i) throws SQLException {
        connection.setHoldability(i);
    }

    public Savepoint setSavepoint() throws SQLException {
        return connection.setSavepoint();
    }

    public Savepoint setSavepoint(String s) throws SQLException {
        return connection.setSavepoint(s);
    }

    public void rollback(Savepoint savepoint) throws SQLException {
        connection.rollback(savepoint);
    }

    public void releaseSavepoint(Savepoint savepoint) throws SQLException {
        connection.releaseSavepoint(savepoint);
    }

    public Statement createStatement(int i, int i1, int i2) throws SQLException {
        return connection.createStatement(i, i1, i2);
    }

    public PreparedStatement prepareStatement(String s, int i, int i1, int i2) throws SQLException {
        return connection.prepareStatement(s, i, i1, i2);
    }

    public CallableStatement prepareCall(String s, int i, int i1, int i2) throws SQLException {
        return connection.prepareCall(s, i, i1, i2);
    }

    public PreparedStatement prepareStatement(String s, int i) throws SQLException {
        return connection.prepareStatement(s, i);
    }

    public PreparedStatement prepareStatement(String s, int[] ints) throws SQLException {
        return connection.prepareStatement(s, ints);
    }

    public PreparedStatement prepareStatement(String s, String[] strings) throws SQLException {
        return connection.prepareStatement(s, strings);
    }

    public Clob createClob() throws SQLException {
        return connection.createClob();
    }

    public Blob createBlob() throws SQLException {
        return connection.createBlob();
    }

    public NClob createNClob() throws SQLException {
        return connection.createNClob();
    }

    public SQLXML createSQLXML() throws SQLException {
        return connection.createSQLXML();
    }

    public boolean isValid(int i) throws SQLException {
        return connection.isValid(i);
    }

    public void setClientInfo(String s, String s1) throws SQLClientInfoException {
        connection.setClientInfo(s, s1);
    }

    public String getClientInfo(String s) throws SQLException {
        return connection.getClientInfo(s);
    }

    public Properties getClientInfo() throws SQLException {
        return connection.getClientInfo();
    }

    public void setClientInfo(Properties properties) throws SQLClientInfoException {
        connection.setClientInfo(properties);
    }

    public Array createArrayOf(String s, Object[] objects) throws SQLException {
        return connection.createArrayOf(s, objects);
    }

    public Struct createStruct(String s, Object[] objects) throws SQLException {
        return connection.createStruct(s, objects);
    }

    public String getSchema() throws SQLException {
        return connection.getSchema();
    }

    public void setSchema(String s) throws SQLException {
        connection.setSchema(s);
    }

    public void abort(Executor executor) throws SQLException {
        connection.abort(executor);
    }

    public void setNetworkTimeout(Executor executor, int i) throws SQLException {
        connection.setNetworkTimeout(executor, i);
    }

    public int getNetworkTimeout() throws SQLException {
        return connection.getNetworkTimeout();
    }

    public <T> T unwrap(Class<T> aClass) throws SQLException {
        return connection.unwrap(aClass);
    }

    public boolean isWrapperFor(Class<?> aClass) throws SQLException {
        return connection.isWrapperFor(aClass);
    }

    public Connection getConnection() {
        return connection;
    }
}
