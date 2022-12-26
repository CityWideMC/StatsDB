/*package xyz.citywide.stats.test;

import xyz.citywide.stats.StatsDB;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        StatsDB times = new StatsDB("root", "pass", "time", "jdbc:mysql://localhost:3306/players");

        String uuid = "testd";

        ResultSet data;

        System.out.println(times.setValue(uuid, 5));
        data = times.getValue(uuid);
        data.next();
        System.out.println(data.getInt("value"));
        System.out.println(times.setValue(uuid, 3));
        data = times.getValue(uuid);
        data.next();
        System.out.println(data.getInt("value"));
    }
}*/
