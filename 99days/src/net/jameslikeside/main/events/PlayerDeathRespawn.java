package net.jameslikeside.main.events;

import java.sql.SQLException;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.jameslikeside.main.API.Money.MoneyAddRemoveSetReset;
import net.jameslikeside.main.API.Skills.CombatSkillAPI;
import net.jameslikeside.main.methods.ScoreboardListener;

public class PlayerDeathRespawn implements Listener {

	@EventHandler
	public void onRespawn(PlayerRespawnEvent r) {
		Location spawnLoc = new Location(Bukkit.getServer().getWorld("spawn"), 43.500, 37, 122.500);
		Player p = r.getPlayer();
		
		ItemStack MenuStar = new ItemStack(Material.NETHER_STAR);
		ItemMeta MenuStarMeta = MenuStar.getItemMeta();
		MenuStarMeta.setDisplayName("§9Menu");
		MenuStarMeta.setLore(Arrays.asList("§eClick to open 99Days Menu"));
		MenuStar.setItemMeta(MenuStarMeta); 
		
		p.getInventory().setItem(8, MenuStar); 
		r.setRespawnLocation(spawnLoc);
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent d) throws SQLException {
		Player p = d.getEntity(); // wait
		Player killer = d.getEntity().getKiller();
		if(d.getEntity().getKiller() instanceof Player) {
			killer.sendMessage(ChatColor.GREEN + "+" + ChatColor.GRAY + "15 Coins");
			d.setDeathMessage(ChatColor.YELLOW + "" + d.getEntity().getKiller().getName() + " " + ChatColor.GRAY + "has killed" + ChatColor.YELLOW + " " + d.getEntity().getName());
			final String kuuid = killer.getUniqueId().toString();
			MoneyAddRemoveSetReset.addCoins(kuuid, 15);
			ScoreboardListener.setScoreboard(killer);
			ScoreboardListener.setScoreboard(p);
			if(CombatSkillAPI.getCombatSkill(kuuid) == 500) {
				return;
			} else {
				CombatSkillAPI.addCombatSkill(kuuid, 1);
			}
		} else {
			if(!(d.getEntity().getKiller() instanceof Player)) {
				d.setDeathMessage(ChatColor.YELLOW + "" + d.getEntity().getName() + ChatColor.GRAY + " Died!");
				}
			}
		return;
	}
	
}
