package net.jameslikeside.main.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.jameslikeside.main.data.CustomSkullData;

public class SpawnMobGUI implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command c, String label, String[] arg3) {
		if(s instanceof Player) {
			Player p = (Player) s;
			if(c.getName().equalsIgnoreCase("spawnmobgui")){
				Inventory SpawnMob = Bukkit.createInventory(p, 9, "Spawn Mob GUI");
				
				ItemStack ZombieSkull = CustomSkullData.getSkull("http://textures.minecraft.net/texture/56fc854bb84cf4b7697297973e02b79bc10698460b51a639c60e5e417734e11");
				ItemMeta ZombieSkullMeta = ZombieSkull.getItemMeta();
				ArrayList<String> ZombieSkullLore = new ArrayList<String>();
				ZombieSkullLore.add("Click to summon a Zombie");
				ZombieSkullMeta.setLore(ZombieSkullLore);
				ZombieSkullMeta.setDisplayName("§6Spawn zombie");
				
				ItemStack SpiderSkull = CustomSkullData.getSkull("http://textures.minecraft.net/texture/cd541541daaff50896cd258bdbdd4cf80c3ba816735726078bfe393927e57f1");
				ItemMeta SpiderSkullMeta = SpiderSkull.getItemMeta();
				ArrayList<String> SpiderSkullLore = new ArrayList<String>();
				SpiderSkullMeta.setDisplayName("§6Spawn spider boss lvl 1");
				SpiderSkullLore.add("Click to spawn spider boss lvl 1"); // spider head done
				SpiderSkullMeta.setLore(SpiderSkullLore);
				
				ZombieSkull.setItemMeta(ZombieSkullMeta);
				SpiderSkull.setItemMeta(SpiderSkullMeta);
				
				SpawnMob.setItem(1, SpiderSkull);
				SpawnMob.setItem(0, ZombieSkull);
				p.openInventory(SpawnMob);
			}
		}
		return false;
	}	

}
