package net.jameslikeside.main.data;

import de.dytanic.cloudnet.api.CloudAPI;
import de.dytanic.cloudnet.bridge.CloudProxy;
import org.apache.commons.lang.NullArgumentException;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import net.jameslikeside.main.Bungee.ServerConnector;
import net.jameslikeside.main.events.hotbar.PlayerHotbarClickStar;

import java.util.UUID;

public class MenuGUILocationData implements Listener{

	@EventHandler
	public void locationsClickEvent(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getTitle().equals("§b§lLocations Menu")) {
			e.setCancelled(true);
			if ((e.getCurrentItem() == null) || e.getCurrentItem().getType().equals(Material.AIR)){
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cClose Menu")) {
				p.closeInventory();
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lSpawn")) {
				locationSpawn(p);
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a<< Back")) {
				PlayerHotbarClickStar.mainGUI(p);
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lAuction House")) {
				locationAuction(p);
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lTemp Floors Teleport 1")) {
				locationFloors1(p);
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lTemp Floors Teleport 2")) {
				locationFloors2(p);
			}
		}

	}


	private void locationSpawn(Player p) {
		Location spawnLoc = new Location(Bukkit.getServer().getWorld("spawn"), 43.500, 37, 122.500);
		Location loc = p.getPlayer().getLocation();
		p.teleport(spawnLoc);
		p.playSound(loc, Sound.NOTE_PLING, 100, 1);
		p.playSound(loc, Sound.NOTE_BASS, 100, 1);
		p.sendMessage(ChatColor.YELLOW + "Teleported to spawn!");
	}
	
	private void locationAuction(Player p) {
		
		Location auctionLoc = new Location(Bukkit.getServer().getWorld("spawn"), 26.500, 34.06250, 134.500);
		Location loc = p.getPlayer().getLocation();
		auctionLoc.setPitch(1);
		auctionLoc.setYaw(180);
		p.teleport(auctionLoc);
		p.playSound(loc, Sound.NOTE_PLING, 100, 1);
		p.playSound(loc, Sound.NOTE_BASS_DRUM, 100, 1);
		p.sendMessage(ChatColor.YELLOW + "Teleported to auction house!");
	}
	
	private void locationFloors1(Player p) {
		Location floorsLoc = new Location(Bukkit.getServer().getWorld("floors"), -85.500, 4, -172.500);
		Location loc = p.getPlayer().getLocation();
		p.teleport(floorsLoc);
		p.playSound(loc, Sound.NOTE_PLING, 100, 1);
		p.playSound(loc, Sound.NOTE_BASS_DRUM, 100, 1);
		p.sendMessage(ChatColor.YELLOW + "Teleported to temp floors spawn! 1");
		
	}

	private void locationFloors2(Player p) {
		Location floorsLoc = new Location(Bukkit.getServer().getWorld("floors"), 8, 4, 737);
		Location loc = p.getPlayer().getLocation();
		p.teleport(floorsLoc);
		p.playSound(loc, Sound.NOTE_PLING, 100, 1);
		p.playSound(loc, Sound.NOTE_BASS_DRUM, 100, 1);
		p.sendMessage(ChatColor.YELLOW + "Teleported to temp floors spawn! 2");

	}
	
}
		
