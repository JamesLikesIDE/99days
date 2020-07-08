package net.jameslikeside.main.data;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import net.jameslikeside.main.events.hotbar.PlayerHotbarClickStar;

public class MenuGUILocationData implements Listener{

	@EventHandler
	public void locationsClickEvent(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getTitle().equals("§b§lLocations Menu")) {
			e.setCancelled(true);
			try {
				if(e.getCurrentItem().getType() == Material.BARRIER) {
					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cClose Menu")) {
						p.closeInventory();
						return;
					}
				}
			} catch (NullPointerException n) {
				n.printStackTrace();
			}
			try {
				if(e.getCurrentItem().getType() == Material.GRASS) {
					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lSpawn")) {
						locationSpawn(p);
					}
				}
			} catch (NullPointerException n) {
				n.printStackTrace();
			}
			try {
				if(e.getCurrentItem().getType() == Material.ARROW) {
					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a<< Back")) {
						PlayerHotbarClickStar.mainGUI(p);
					}
				}
			} catch (NullPointerException n) {
				n.printStackTrace();
			}
			try {
				if(e.getCurrentItem().getType() == Material.GOLD_INGOT) {
					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lAuction House")) {
						locationAuction(p);
					}
				}
			} catch (NullPointerException n) {
				n.printStackTrace();
			}
			try {
				if(e.getCurrentItem().getType() == Material.STONE) {
					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lTemp Floors Teleport")) {
						locationFloors(p);
					}
				}
			} catch (NullPointerException n) {
				n.printStackTrace();
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
	
	private void locationFloors(Player p) {
		Location floorsLoc = new Location(Bukkit.getServer().getWorld("floors"), -85.500, 4, -172.500);
		Location loc = p.getPlayer().getLocation();
		p.teleport(floorsLoc);
		p.playSound(loc, Sound.NOTE_PLING, 100, 1);
		p.playSound(loc, Sound.NOTE_BASS_DRUM, 100, 1);
		p.sendMessage(ChatColor.YELLOW + "Teleported to temp floors spawn!");
		
	}
	
}
		
