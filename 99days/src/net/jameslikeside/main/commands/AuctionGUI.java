package net.jameslikeside.main.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import net.jameslikeside.main.data.ItemBuilder;

public class AuctionGUI implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender c, Command s, String string, String[] args) {
		if(s instanceof Player) {
			Player p = (Player) s;
			if(c.getName().equalsIgnoreCase("auctiongui")) {
				//AUCTION INVENTORY
				Inventory auctions = Bukkit.createInventory(null, 9*6, "§b§lAuctions Menu");
				ItemStack glass = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (short) 14).setDisplayName(" ").build();
				ItemStack arrow = new ItemBuilder(Material.ARROW, 1).setDisplayName("§a>> Next").build();
				ItemStack arrow2 = new ItemBuilder(Material.ARROW, 1).setDisplayName("§a<< Back").build();
				ItemStack barrier = new ItemBuilder(Material.BARRIER, 1).setDisplayName("§cClose Menu").build();
				auctions.setItem(0, glass); auctions.setItem(1, glass); auctions.setItem(2, glass);
				auctions.setItem(3, glass); auctions.setItem(4, glass); auctions.setItem(5, glass); 
				auctions.setItem(6, glass); auctions.setItem(7, glass); auctions.setItem(8, glass); 
				auctions.setItem(9, glass); auctions.setItem(17, glass); auctions.setItem(18, glass); 
				auctions.setItem(26, glass); auctions.setItem(27, glass); auctions.setItem(35, glass); 
				auctions.setItem(36, glass); auctions.setItem(44, glass); auctions.setItem(45, arrow2); 
				auctions.setItem(46, glass); auctions.setItem(47, glass); auctions.setItem(48, glass); 
				auctions.setItem(49, barrier); auctions.setItem(50, glass); auctions.setItem(51, glass); 
				auctions.setItem(52, glass); auctions.setItem(53, arrow);
				//AUCTION NAMES
				
				p.openInventory(auctions);
			}
		}
		return false;
	}

}
