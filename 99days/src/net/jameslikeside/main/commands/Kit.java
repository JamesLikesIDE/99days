package net.jameslikeside.main.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.jameslikeside.main.Main;

public class Kit implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command c, String string, String[] arg3) {
		if(s instanceof Player && s.hasPermission("minecraft.command.give")) {
			
			ItemStack diamond_sword = new ItemStack(Material.DIAMOND_SWORD);
			ItemStack diamond_axe = new ItemStack(Material.DIAMOND_AXE);
			ItemStack diamond_pickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
			ItemStack steak = new ItemStack(Material.COOKED_BEEF);
			ItemStack oak_planks = new ItemStack(Material.WOOD);
			ItemStack diamond_helmet = new ItemStack(Material.DIAMOND_HELMET);
			ItemStack diamond_chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
			ItemStack diamond_leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
			ItemStack diamond_boots = new ItemStack(Material.DIAMOND_BOOTS);
			
			steak.setAmount(64);
			oak_planks.setAmount(64);
			
			((Player) s).getInventory().addItem(diamond_sword);
			((Player) s).getInventory().addItem(diamond_axe);
			((Player) s).getInventory().addItem(diamond_pickaxe);
			((Player) s).getInventory().addItem(steak);
			((Player) s).getInventory().addItem(oak_planks);
			((Player) s).getInventory().addItem(diamond_helmet);
			((Player) s).getInventory().addItem(diamond_chestplate);
			((Player) s).getInventory().addItem(diamond_leggings);
			((Player) s).getInventory().addItem(diamond_boots);
			
			s.sendMessage(ChatColor.GREEN + "Kit given");
			
		} else {
			s.sendMessage(ChatColor.RED + Main.noperm);
		}
		return true;
	}

}
