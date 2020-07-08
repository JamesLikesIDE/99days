package net.jameslikeside.main.events;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import de.dytanic.cloudnet.api.CloudAPI;
import net.jameslikeside.main.Main;

public class Events implements Listener{
	
	public static void HeaderFooter(final Player p) throws SQLException {
        final String lang = Playerlang(p);
        if (lang.equals("en")) {
            HeaderFooter.sendTablistHeaderAndFooter(p, " \n    §b§lFresh2Play §8\u00d7 §3MiniGames Network §f\n §8\u25ba §7You are online on §8\u25cf §b" + Servername() + " §8\u25c4 \n ", " \n §7Website §8» §e" + Main.website + " §8\u258e §7TeamSpeak §8» §e" + Main.teamspeak + " \n §7Discord §8» §e" + Main.discord + " \n ");
        }
        else if (lang.equals("de")) {
            HeaderFooter.sendTablistHeaderAndFooter(p, " \n    §b§lFresh2Play §8\u00d7 §3MiniGames Netzwerk §f\n §8\u25ba §7Du bist Online auf §8\u25cf §b" + Servername() + " §8\u25c4 \n ", " \n §7Webseite §8» §e" + Main.website + " §8\u258e §7TeamSpeak §8» §e" + Main.teamspeak + " \n §7Discord §8» §e" + Main.discord + " \n ");
        }
        else {
            HeaderFooter.sendTablistHeaderAndFooter(p, " \n    §b§lFresh2Play §8\u00d7 §3MiniGames Netwerk §f\n §8\u25ba §7You are online on §8\u25cf §b" + Servername() + " §8\u25c4 \n ", " \n §7Website §8» §e" + Main.website + " §8\u258e §7TeamSpeak §8» §e" + Main.teamspeak + " \n §7Discord §8» §e" + Main.discord + " \n ");
        }
    }
	
    public static String Servername() {
        final String serverid = CloudAPI.getInstance().getServerId();
        return serverid;
    }
	
	 public static String Playerlang(final Player p) throws SQLException {
	        String lang = "";
	        final String uuid = p.getUniqueId().toString();
	        final ResultSet rs = Main.mysql.GetResult("SELECT lang FROM user_data WHERE uuid='" + uuid + "'");
	        if (rs.next()) {
	            lang = rs.getString("lang");
	        }
	        return lang;
	 }
	 
	 public static int PlayerCoins(final Player p) throws SQLException {
	        int moneyFloors = 0;
	        final String uuid = p.getUniqueId().toString();
	        final ResultSet rs = Main.mysql.GetResult("SELECT moneyFloors FROM user_data WHERE uuid='" + uuid + "'");
	        if (rs.next()) {
	        	moneyFloors = rs.getInt("moneyFloors");
	        }
	        return moneyFloors;
	 }
}
