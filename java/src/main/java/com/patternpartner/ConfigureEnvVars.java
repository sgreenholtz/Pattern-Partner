package com.patternpartner;

/**
 * This class gets and returns environment variables for database read and write.
 * @author Sebastian Greenholtz
 */
public class ConfigureEnvVars {

    private String username;
    private String password;
    private String port;
    private String host;
    private String URL;

    /**
     * Sets the four environment variables based on OpenShift environment
     */
    public ConfigureEnvVars() {
        host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
        port = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
        username = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
        password = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
        URL = String.format("jdbc:mysql://%s:%s/tomcat", host, port);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public String getURL() {
        return URL;
    }
}
