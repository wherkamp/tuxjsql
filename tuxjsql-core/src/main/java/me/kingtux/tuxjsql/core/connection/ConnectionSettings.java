package me.kingtux.tuxjsql.core.connection;

public class ConnectionSettings {
    private String driver;
    private String url;

    public ConnectionSettings(String driver, String url) {
        this.driver = driver;
        this.url = url;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
