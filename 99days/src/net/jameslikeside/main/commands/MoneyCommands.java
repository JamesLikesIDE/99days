package net.jameslikeside.main.commands;

import java.sql.SQLException;
import java.text.DecimalFormat;

import net.jameslikeside.main.methods.Sb;
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
                    final long Money = Long.parseLong(args[2]);
                    if (args[0].equalsIgnoreCase("add")) {
                        if (Money > 0) {
                            MoneyAPIS.addCoins(target.getUniqueId().toString(), Money);
                            double amount0 = Money;
                            DecimalFormat formatter0 = new DecimalFormat("#,###");
                            player.sendMessage("§cAdded a value of §e" + formatter0.format(amount0) + " §cmoney to §e " + target.getName());
                            target.sendMessage("§aYou have recieved §e" + formatter0.format(amount0) + " §amoney from an admin");
                        }
                        else {
                            player.sendMessage("§cPlease enter a valid value!");
                        }
                    }
                    else if (args[0].equalsIgnoreCase("set")) {
                        if (Money >= 0) {
                            MoneyAddRemoveSetReset.setCoins(target.getUniqueId().toString(), Money);
                            double amount1 = Money;
                            DecimalFormat formatter1 = new DecimalFormat("#,###");
                            player.sendMessage("§cSet a value of §e" + formatter1.format(amount1) + " §cmoney to §e" + target.getName());
                            target.sendMessage("§aYour money has been set to §e" + formatter1.format(amount1));
                        }
                        else {
                            player.sendMessage("§cPlease enter a valid value!");
                        }
                    }
                    else if (args[0].equalsIgnoreCase("remove")) {
                        if (Money > 0) {
                            MoneyAPIS.removeCoins(target.getUniqueId().toString(), Money);
                            double amount2 = Money;
                            DecimalFormat formatter2 = new DecimalFormat("#,###");
                            player.sendMessage("§cRemoved a value of §e" + formatter2.format(amount2) + " §cmoney from §e" + target.getName());
                            target.sendMessage("§e" + formatter2.format(amount2) + " §amoney has been Removed!");
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
                    double amount3 = MoneyAddRemoveSetReset.getCoins(player.getUniqueId().toString());
                    DecimalFormat formatter3 = new DecimalFormat("#,###");
                    player.sendMessage( "§aYour Money: §e" + formatter3.format(amount3));
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
