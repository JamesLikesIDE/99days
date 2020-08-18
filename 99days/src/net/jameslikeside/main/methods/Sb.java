package net.jameslikeside.main.methods;

import java.io.*;
import java.sql.*;
//import java.text.*;
import java.util.*;

//import org.bukkit.*;
import org.bukkit.configuration.file.*;
import org.bukkit.entity.*;
//import org.bukkit.plugin.*;
import org.bukkit.scheduler.*;
//import org.bukkit.scoreboard.*;

//import de.dytanic.cloudnet.api.*;
import net.jameslikeside.main.*;
//import net.jameslikeside.main.events.*;
 // sb class is empty cuz i deleted it so it was useless
public class Sb {
	
	public static String nextevent;
    public static File file;
    public static YamlConfiguration yamlcfg;
    public static HashMap<Player, BukkitTask> runnable;
    
    static {
        Sb.nextevent = "Laden";
        Sb.file = new File("plugins/99florrs", "newu.yml");
        Sb.yamlcfg = YamlConfiguration.loadConfiguration(Sb.file);
        Sb.runnable = new HashMap<Player, BukkitTask>();
    }
    
    
    //all of the below = FUCKING AGES TO LEARN
    public static String Playerlang(final Player p) throws SQLException {
        String lang = "";
        final String uuid = p.getUniqueId().toString();
        final ResultSet rs = Main.mysql.GetResult("SELECT lang FROM user_data WHERE uuid='" + uuid + "'");
        if (rs.next()) {
            lang = rs.getString("lang");
        }
        return lang;
    }
    
    public static long PlayerCoins(final Player p) throws SQLException {
        long moneyFloors = 0;
        final String uuid = p.getUniqueId().toString();
        final ResultSet rs = Main.mysql.GetResult("SELECT moneyFloors FROM floorsSystem WHERE uuid='" + uuid + "'");
        if (rs.next()) {
        	moneyFloors = rs.getLong("moneyFloors");
        }
        return moneyFloors;
    }
    
    public static String sbme(final Player p, final String lang, final int ps, final String messageid) throws SQLException {
        if (lang == null) {
            final ResultSet rs = Main.mysql.GetResult("SELECT * FROM plugin_message2 WHERE lang='null' AND messageid='" + messageid + "'");
            if (!rs.next()) {
                return "§cERROR";
            }
            if (ps == 0) {
                return rs.getString("prefix");
            }
            return rs.getString("suffix");
        }
        else {
            final ResultSet rs = Main.mysql.GetResult("SELECT * FROM plugin_message2 WHERE lang='" + Playerlang(p) + "' AND messageid='" + messageid + "'");
            if (rs.next()) {
                if (ps == 0) {
                    return rs.getString("prefix");
                }
                return rs.getString("suffix");
            }
            else {
                final ResultSet rs2 = Main.mysql.GetResult("SELECT * FROM plugin_message2 WHERE lang='en' AND messageid='" + messageid + "'");
                if (!rs2.next()) {
                    return "§cERROR";
                }
                if (ps == 0) {
                    return rs2.getString("prefix");
                }
                return rs2.getString("suffix");
            }
        }
    }
    
    /*
     * Does that mean that u removed the actual SB Part? yes
     * What did u want to have in the SB?
     */

}
