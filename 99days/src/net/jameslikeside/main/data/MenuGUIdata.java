package net.jameslikeside.main.data;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import net.jameslikeside.main.events.hotbar.PlayerHotbarClickStar;

public class MenuGUIdata implements Listener{

	@EventHandler
	public void MenuGUIClickEvents(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		

		if(e.getInventory().getTitle().equals("§b§lMenu")) {
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
				if(e.getCurrentItem().getType() == Material.DIAMOND_SWORD) {
					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bSkills")) {
						PlayerHotbarClickStar.skillsGUI(p);
					}
				} 
			} catch (NullPointerException n) {
				n.printStackTrace();
			}
			try {
				if(e.getCurrentItem().getType() == Material.GRASS) {
					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Locations")) {
						PlayerHotbarClickStar.LocationsGUI(p);
					} 
				}
			} catch (NullPointerException n) {
				n.printStackTrace();
			}
		} 
		if(e.getInventory().getTitle().equals("§b§lSkills Menu")) {
			e.setCancelled(true);
			try {
				if(e.getCurrentItem().getType() == Material.BARRIER) {
					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cClose Menu")) {
						p.closeInventory();
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
					else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a>> Next")) {
						p.sendMessage("§aSoon");
					}
				}
			} catch (NullPointerException n){
				n.printStackTrace();
			}
		} 
	}
	
}
