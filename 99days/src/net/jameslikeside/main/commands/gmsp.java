package net.jameslikeside.main.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.jameslikeside.main.Main;

public class gmsp implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command c, String string, String[] arg3) {
		if(s instanceof Player && s.hasPermission("minecraft.command.gamemode")) {
			((Player) s).setGameMode(GameMode.SPECTATOR);
			s.sendMessage(Main.gamemodeupdated);
		} else {
			s.sendMessage(Main.mustbeplayer);
		}
		return true;
	}

}
