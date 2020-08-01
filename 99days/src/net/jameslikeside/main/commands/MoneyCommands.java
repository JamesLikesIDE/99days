package net.jameslikeside.main.commands;

import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.jameslikeside.main.API.Money.MoneyAddRemoveSetReset;
import net.jameslikeside.main.methods.ScoreboardListener;

public class MoneyCommands implements CommandExecutor {

	final MoneyAddRemoveSetReset MoneyAPIS = new MoneyAddRemoveSetReset();
	
	@Override
    public boolean onCommand(final CommandSender cs, final Command cmd, final String s, final String[] args) {
        if (cs instanceof Player) {
            final Player player = (Player)cs;
            if (player.hasPermission("*")) {
                if (args.length == 3) {
                    final Player target = Bukkit.getPlayerExact(args[1]);
                    final int Money = Integer.parseInt(args[2]);
                    if (args[0].equalsIgnoreCase("add")) {
                        if (Money > 0) {
                            MoneyAPIS.addCoins(target.getUniqueId().toString(), Money);
                            player.sendMessage("§cAdded a value of §e" + Money + " §cmoney to §e " + target.getName());
                            target.sendMessage("§aYou have recieved §e" + Money + " §amoney from an admin");
                            try {
                            	ScoreboardListener.setScoreboard(target);
                            } catch (SQLException e) {
                            	e.printStackTrace();
                            }
                        }
                        else {
                            player.sendMessage("§cPlease enter a valid value!");
                        }
                    }
                    else if (args[0].equalsIgnoreCase("set")) {
                        if (Money >= 0) {
                            MoneyAddRemoveSetReset.setCoins(target.getUniqueId().toString(), Money);
                            player.sendMessage("§cSet a value of §e" + Money + " §cmoney to §e" + target.getName());
                            target.sendMessage("§aYour money has been set to §e" + Money);
                            try {
                            	ScoreboardListener.setScoreboard(target);
                            } catch (SQLException e) {
                            	e.printStackTrace();
                            }
                        }
                        else {
                            player.sendMessage("§cPlease enter a valid value!");
                        }
                    }
                    else if (args[0].equalsIgnoreCase("remove")) {
                        if (Money > 0) {
                            MoneyAPIS.removeCoins(target.getUniqueId().toString(), Money);
                            player.sendMessage("§cRemoved a value of §e" + Money + " §cmoney from §e" + target.getName());
                            target.sendMessage("§e" + Money + " §amoney has been Removed!");
                            try {
                            	ScoreboardListener.setScoreboard(target);
                            } catch (SQLException e) {
                            	e.printStackTrace();
                            }
                        }
                        else {
                            player.sendMessage("§cPlease enter a valid value!");
                        }
                    }
                    else {
                        player.sendMessage("§cUsage §7/bank <add/set/remove> <Player> <Money>");
                    }
                }
                else if (args.length == 0) {
                    player.sendMessage( "§aYour Money: §e" + MoneyAddRemoveSetReset.getCoins(player.getUniqueId().toString()));
                }
                else {
                    player.sendMessage("§cUsage §7/bank <add/set/remove> <Player> <Money>");
                }
            }
            else {
                player.sendMessage("§cYou do not have permission!");
            }
        }
        return false;
    }

}
