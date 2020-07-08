package net.jameslikeside.main.data;

import java.util.HashMap;
import java.util.List;

import org.bukkit.Location;

public class Data {

	public static String GamePrefix;
    public static String ServerPrefix;
    public static String noperm;
    public static boolean spawnset;
    public static double hohe;
    public static List<String> Maps;
    public static HashMap<String, Location> MapLocation;
    
    static {
        Data.GamePrefix = "§7[§e99Floors§7] ";
        Data.ServerPrefix = "§7[§6Fresh2Play§7] ";
        Data.noperm = "§cI'm sorry, but you do not have permission to perform this command. Please contact the server administrators if you believe that this is in error.";
        Data.MapLocation = new HashMap<String, Location>();
    }
	
}
