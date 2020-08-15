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
		

		if(e.getInventory().getTitle().equalsIgnoreCase("§b§lMenu")) {
			e.setCancelled(true);
			if ((e.getCurrentItem() == null) || e.getCurrentItem().getType().equals(Material.AIR)){
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cClose Menu")) {
				p.closeInventory();
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bSkills")) {
				PlayerHotbarClickStar.skillsGUI(p);
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Locations")) {
				PlayerHotbarClickStar.LocationsGUI(p);
			}
		} 
		if(e.getInventory().getTitle().equalsIgnoreCase("§b§lSkills Menu")) {
			e.setCancelled(true);
			if ((e.getCurrentItem() == null) || e.getCurrentItem().getType().equals(Material.AIR)){
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cClose Menu")) {
				p.closeInventory();
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a<< Back")) {
				PlayerHotbarClickStar.mainGUI(p);
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a>> Next")) {
				p.sendMessage("§aSoon");
			}
		} 
	}
	
}
