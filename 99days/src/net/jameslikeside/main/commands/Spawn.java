package net.jameslikeside.main.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.jameslikeside.main.Main;

public class Spawn implements CommandExecutor {

	Location spawnLoc = new Location(Bukkit.getServer().getWorld("spawn"), 43.500, 37, 122.500);
	@Override
	public boolean onCommand(CommandSender s, Command c, String string, String[] args) {
		if(s instanceof Player) {
			Player p = (Player) s;
			Location loc = p.getPlayer().getLocation();
			p.teleport(spawnLoc);
			p.playSound(loc, Sound.NOTE_PLING, 100, 1);
			p.playSound(loc, Sound.NOTE_BASS, 100, 1);
			s.sendMessage(ChatColor.YELLOW + "Teleported to spawn!");
		} else {
			s.sendMessage(Main.mustbeplayer);
		}
		return true;
	}

}
