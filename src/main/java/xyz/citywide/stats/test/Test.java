package xyz.citywide.stats.test;

import xyz.citywide.stats.StatsDB;

public class Test {
    public static void main(String[] args) {
        StatsDB times = new StatsDB("root", args[0], "players", "jdbc:mysql://localhost:3306/players");

        String uuid = "test";

        System.out.println(times.setTime(uuid, 5));
        System.out.println(times.getTime(uuid));
        System.out.println(times.setTime(uuid, 3));
        System.out.println(times.getTime(uuid));
    }
}
