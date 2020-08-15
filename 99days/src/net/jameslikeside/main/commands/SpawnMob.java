package net.jameslikeside.main.commands;

import me.dablakbandit.customentitiesapi.CustomEntitiesAPI;
import me.dablakbandit.customentitiesapi.entities.CustomEntity;
import me.dablakbandit.customentitiesapi.entities.CustomEntitySpider;
import net.jameslikeside.main.CustomMobs.Boss.SpiderBossOne;
import net.jameslikeside.main.CustomMobs.Boss.SpiderBossTwo;
import net.jameslikeside.main.methods.Chat;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;

import net.jameslikeside.main.Main;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SpawnMob implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String string, String[] args) {
		if(s instanceof Player && s.hasPermission("*")) {
			Player p = (Player) s;
			if(args.length == 1) {
				if (args[0].equalsIgnoreCase("spider")) {
					Player player = (Player) s;
					player.sendMessage(ChatColor.GREEN + "Spawning Spider");
					spawnSpider(player.getLocation(), EntityType.SPIDER);
				} else if (args[0].equalsIgnoreCase("zombie")) {
					p.sendMessage(ChatColor.GREEN + "Spawning Zombie");
					spawnZombie(p.getLocation(), EntityType.ZOMBIE);
				} else if (args[0].equals("SPIDER_BOSS_1")) {
					p.sendMessage(ChatColor.GREEN + "Spawned " + ChatColor.YELLOW + "SPIDER_BOSS_1" + ChatColor.GREEN + " at " + ChatColor.YELLOW + s.getName().toString() + ChatColor.GREEN + " location");
					SpiderBossOne.SpiderBossOne(p.getLocation(), p);
				}else if(args[0].equals("SPIDER_BOSS_2")){
					p.sendMessage(ChatColor.GREEN + "Spawned " + ChatColor.YELLOW + "SPIDER_BOSS_2" + ChatColor.GREEN + " at " + ChatColor.YELLOW + s.getName().toString() + ChatColor.GREEN + " location");
					SpiderBossTwo.SpiderBossTwo(p.getLocation(), p);
				}
				else {
					p.sendMessage(ChatColor.RED + "Unknown custom mob");
				}
			} else if(args.length == 0){
				p.sendMessage(ChatColor.RED + "Unknown custom mob");
			}
		} else {
			s.sendMessage(ChatColor.RED + Main.noperm);
		}
		return true;
	}

	private void spawnSpider(Location loc, EntityType spider) {
		loc.getWorld().spawnEntity(loc, spider);//(gimme a sec
	}
	private void spawnZombie(Location loc, EntityType zombie) {
		loc.getWorld().spawnEntity(loc, zombie);
	}
}
