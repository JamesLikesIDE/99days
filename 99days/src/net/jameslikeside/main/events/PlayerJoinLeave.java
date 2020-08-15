package net.jameslikeside.main.events;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import net.jameslikeside.main.Main;
import net.jameslikeside.main.data.ActionBar;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.connorlinfoot.bountifulapi.BountifulAPI;

import net.jameslikeside.main.MySQL;
import net.jameslikeside.main.API.Money.MoneyAddRemoveSetReset;
import net.jameslikeside.main.methods.ScoreboardListener;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import static com.sk89q.worldguard.bukkit.BukkitUtil.toVector;

public class PlayerJoinLeave implements Listener{

    ActionBar ab = new ActionBar();
	ChatColor cgreen = ChatColor.GREEN;
	ChatColor cgray = ChatColor.GRAY;
	ChatColor cred = ChatColor.RED;

    @SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent e) throws SQLException, InterruptedException{
		Location spawnLoc = new Location(Bukkit.getServer().getWorld("spawn"), 43.500, 37, 122.500);
		Player p = e.getPlayer();
		final String ps = e.getPlayer().toString();
		final String uuid = p.getUniqueId().toString();
		Location loc = p.getPlayer().getLocation();
		System.out.println("User " + ps + " Has logged into the server with the uuid " + uuid);
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
        if(!p.hasPlayedBefore()) {
        	this.setColumm(p.getUniqueId().toString());
            this.setPlayedBefore(p.getUniqueId().toString(), 1);
        	MoneyAddRemoveSetReset.setCoins(uuid, 1000);
        }
        BountifulAPI.sendTitle(p, 50, 110, 50, ChatColor.GREEN + "Welcome to 99days");
        BountifulAPI.sendSubtitle(p, 50, 110, 50, ChatColor.AQUA + "Have fun C:");
        onJoinActionBar(p);
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		e.setQuitMessage(cgray + "[" + cred + "-" + cgray + "] " + cred + p.getPlayer().getName());
	}
	
	private int getPlayedBefore(final String UUID) {
        try {
            final PreparedStatement ps = MySQL.connection.prepareStatement("SELECT PlayedBefore FROM floorsSystem WHERE UUID=?");
            ps.setString(1, UUID);
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("PlayedBefore");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    private void setPlayedBefore(final String UUID, final int Played) {
        try {
            final PreparedStatement ps = MySQL.connection.prepareStatement("UPDATE floorsSystem SET PlayedBefore = ? WHERE UUID = ?");
            ps.setString(2, UUID);
            ps.setInt(1, Played);
            ps.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void setColumm(final String UUID) {
        try {
            final PreparedStatement ps = MySQL.connection.prepareStatement("INSERT INTO floorsSystem (UUID) VALUES (?)");
            ps.setString(1, UUID);
            ps.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void onJoinActionBar(Player p){
	    new BukkitRunnable(){
            @Override
            public void run() {
                if(!p.isOnline()){
                    cancel();
                }
                ab.ActionBarMessage(ChatColor.RED + "" + p.getHealth() + "/" + p.getMaxHealth() + "\\u2764");
                ab.sendToPlayer(p);
            }
        }.runTaskTimer(Main.instance, 5L, 5L);
    }

	
}
