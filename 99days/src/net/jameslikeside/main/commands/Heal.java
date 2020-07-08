package net.jameslikeside.main.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.jameslikeside.main.Main;

public class Heal implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command c, String string, String[] arg3) {
		Player p = (Player) s;
		if(s instanceof Player && s.hasPermission("minecraft.command.give")) {
			p.setFoodLevel(20);
			p.setHealth(20);
		} else {
			s.sendMessage(ChatColor.RED + Main.noperm);
		}
		return true;
	}
}
