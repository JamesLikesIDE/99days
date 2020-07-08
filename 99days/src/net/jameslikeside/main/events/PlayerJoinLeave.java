package net.jameslikeside.main.events;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.jameslikeside.main.Main;
import net.jameslikeside.main.data.Data;
import net.jameslikeside.main.methods.ScoreboardListener;

public class PlayerJoinLeave implements Listener{
	
	ChatColor cgreen = ChatColor.GREEN;
	ChatColor cgray = ChatColor.GRAY;
	ChatColor cred = ChatColor.RED;
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) throws SQLException{
		Location spawnLoc = new Location(Bukkit.getServer().getWorld("spawn"), 43.500, 37, 122.500);
		Player p = e.getPlayer();
		final String uuid = p.getUniqueId().toString();
		Location loc = p.getPlayer().getLocation();
		e.setJoinMessage(cgray + "[" + cgreen + "+"  + cgray + "] " + cgreen + p.getPlayer().getName());
		p.teleport(spawnLoc);
		p.playSound(loc, Sound.NOTE_PLING, 100, 1);
		p.playSound(loc, Sound.NOTE_BASS, 100, 1);
		p.setHealth(20);
		p.setFoodLevel(20);
		p.setGameMode(GameMode.SURVIVAL);
		try {
			ScoreboardListener.setScoreboard(p);
		} catch (NullPointerException e1) {
			e1.printStackTrace();
		}
		try {
			Events.HeaderFooter(p);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		final ResultSet test = Main.mysql.GetResult("SELECT * FROM floorsSystem WHERE uuid='" + uuid + "'");
        try {
            if (test.next()) {
                final Date now = new Date();
                final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Main.mysql.ExecuteCommand("UPDATE floorsSystem SET lastonline='" + format.format(now) + "' WHERE uuid='" + uuid + "'");
            }
            else {
                Main.mysql.ExecuteCommand("INSERT INTO floorsSystem SET uuid='" + uuid + "'");
                Bukkit.getConsoleSender().sendMessage(String.valueOf(Data.ServerPrefix) + "§7The Player §e" + p.getDisplayName() + " §7was added to the Databank!");
            }
        }
        catch (SQLException e2) {
            e2.printStackTrace();
        }
        final ResultSet rs = Main.mysql.GetResult("SELECT * FROM floorsSystem WHERE uuid='" + uuid + "'");
        try {
            if (!rs.next()) {
                Main.mysql.ExecuteCommand("INSERT INTO floorsSystem SET uuid='" + uuid + "'");
            }
        }
        catch (SQLException e3) {
            e3.printStackTrace();
        }
        try {
            Events.HeaderFooter(p);
        }
        catch (SQLException e3) {
            e3.printStackTrace();
        }
        try {
            ScoreboardListener.setScoreboard(p);
        }
        catch (SQLException e3) {
            e3.printStackTrace();
        }

	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		e.setQuitMessage(cgray + "[" + cred + "-" + cgray + "] " + cgreen + p.getPlayer().getName());
	}
	
	@EventHandler
	public void onFoodChange(FoodLevelChangeEvent e) {
		e.setCancelled(true);
		e.setFoodLevel(20);
	}
	
}
