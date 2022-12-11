package xyz.citywide.stats;

import java.sql.*;

public class StatsDB {
    private Connection connection;
    private Statement command;
    private ResultSet data;
    private String table;

    public StatsDB(String user, String password, String table, String connectionString) {
        this.table = table;
        try {
            connection = DriverManager.getConnection(connectionString, user, password);
            command = connection.createStatement();
            //command.execute("INSERT INTO players (uuid, time) VALUES (\"" + uuid + "\", 5)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Initialized StatsDB");
        }
        /*System.out.println(setTime(uuid, 5));
        System.out.println(getTime(uuid));
        System.out.println(setTime(uuid, 3));
        System.out.println(getTime(uuid));*/
    }

    public int getTime(String uuid) {
        try {
            data = command.executeQuery("SELECT * from " + table + " WHERE uuid = " + "\"" + uuid + "\"");
            data.next();
            return data.getInt("time");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean setTime(String uuid, int time) {
        boolean exists = false;
        try {
            data = command.executeQuery("SELECT * from " + table + " WHERE EXISTS (SELECT uuid FROM " + table + " WHERE uuid = \"" + uuid + "\")");
            exists = data.next();
            if(exists) {
                command.execute("UPDATE " + table + " SET time = " + time + " WHERE uuid = \"" + uuid + "\"");
            } else {
                command.execute("INSERT INTO " + table + " (uuid, time) VALUES (\"" + uuid + "\", " + time + ")");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return exists;
    }
}
