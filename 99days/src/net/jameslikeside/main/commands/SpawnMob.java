package net.jameslikeside.main.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import net.jameslikeside.main.Main;

public class SpawnMob implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String string, String[] args) {
		if(s instanceof Player) {
			if(args[0].equals("spider") && s.hasPermission("*")) {
				Player player = (Player) s;
				player.sendMessage(ChatColor.GREEN + "Spawning Spider");
				spawnSpider(player.getLocation(), EntityType.SPIDER);
			} 
			if(args[0].equals("zombie") && s.hasPermission("*")) {
				Player player = (Player) s;
				player.sendMessage(ChatColor.GREEN + "Spawning Zombie");
				spawnZombie(player.getLocation(), EntityType.ZOMBIE);
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
