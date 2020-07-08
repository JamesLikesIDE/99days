package net.jameslikeside.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {
	
	private String Host;
    private String Database;
    private String Username;
    private String Password;
    public static Connection connection;
    
    public MySQL(final String host, final String database, final String username, final String password) {
        this.Host = host;
        this.Database = database;
        this.Username = username;
        this.Password = password;
    }
    
    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e1) {
            System.out.println("[MySQLAPI] Error 01.1");
            System.out.println("[MySQLAPI] The required classes are missing!");
            e1.printStackTrace();
        }
        final String url = "jdbc:mysql://" + Host + ":3306/" + Database + "?autoReconnect=true";
        try {
            connection = DriverManager.getConnection(url, Username, Password);
        }
        catch (SQLException e2) {
            System.out.println("[MySQLAPI] Error 02.1");
            System.out.println("[MySQLAPI] Error on MySQL connection!");
            e2.printStackTrace();
        }
    }
    
    public void Disconnect() {
        try {
            if (!this.connection.isClosed() && this.connection != null) {
                this.connection.close();
                System.out.println("[MySQLAPI] Connection to the MySQL server was successfully disconnected!");
            }
            else {
                System.out.println("[MySQLAPI] Connection is already disconnected!");
            }
        }
        catch (SQLException e3) {
            System.out.println("[MySQLAPI] Error 03.1");
            System.out.println("[MySQLAPI] Failed to disconnect!");
            e3.printStackTrace();
        }
    }
    
    public boolean isConnected() {
        try {
            return !this.connection.isClosed();
        }
        catch (SQLException e2) {
            System.out.println("[MySQLAPI] Error 02.2");
            System.out.println("[MySQLAPI] Error on MySQL connection!");
            e2.printStackTrace();
            return false;
        }
    }
    
    public ResultSet GetResult(final String command) {
        try {
            if (this.connection.isClosed()) {
                this.Connect();
            }
            final Statement st = this.connection.createStatement();
            st.executeQuery(command);
            return st.getResultSet();
        }
        catch (SQLException e4) {
            System.out.println("[MySQLAPI] Error 04.1");
            System.out.println("[MySQLAPI] Command execution failed!");
            e4.printStackTrace();
            return null;
        }
    }
    
    public int GetResult2(final String command) {
        try {
            if (this.connection.isClosed()) {
                this.Connect();
            }
            final Statement st = this.connection.createStatement();
            st.executeQuery(command);
        }
        catch (SQLException e4) {
            System.out.println("[MySQLAPI] Error 04.2");
            System.out.println("[MySQLAPI] Command execution failed!");
            e4.printStackTrace();
        }
        return 0;
    }
    
    public void ExecuteCommand(final String command) {
        try {
            if (this.connection.isClosed()) {
                this.Connect();
            }
            final Statement st = this.connection.createStatement();
            st.executeUpdate(command);
        }
        catch (SQLException e4) {
            System.out.println("[MySQLAPI] Error 04.3");
            System.out.println("[MySQLAPI] Command execution failed!");
            e4.printStackTrace();
        }
    }

}
