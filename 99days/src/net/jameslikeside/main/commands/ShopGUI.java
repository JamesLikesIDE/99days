package net.jameslikeside.main.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import net.jameslikeside.main.data.ItemBuilder;

public class ShopGUI implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command c, String string, String[] arg3) {
		if(s instanceof Player) {
			Player p = (Player) s;
			if(c.getName().equalsIgnoreCase("shop")) {
				Inventory shopGUIMain = Bukkit.createInventory(p, 27, "§bShop");
				
				ItemStack foodCat = new ItemBuilder(Material.CAKE, 1).setDisplayName("§bFood").setLore(Arrays.asList("§eClick here to open the food catagory")).build();
				ItemStack armorCat = new ItemBuilder(Material.DIAMOND_CHESTPLATE, 1).setDisplayName("§bArmor").setLore(Arrays.asList("§eClick here to open the armor catagory")).build();
				ItemStack weapCat = new ItemBuilder(Material.DIAMOND_SWORD, 1).setDisplayName("§bWeapons").setLore(Arrays.asList("§eClick here to open the weapons catagory")).build();
				ItemStack potCat = new ItemBuilder(Material.POTION, 1).setDisplayName("§bPotions").setLore(Arrays.asList("§eClick here to open potions catagory")).build();
				
				shopGUIMain.setItem(10, foodCat);
				shopGUIMain.setItem(12, armorCat);
				shopGUIMain.setItem(14, weapCat);
				shopGUIMain.setItem(16, potCat);
				
				p.openInventory(shopGUIMain);
			}
		}
		return false;
	}

}
