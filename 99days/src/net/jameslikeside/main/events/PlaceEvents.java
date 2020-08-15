package net.jameslikeside.main.events;

import java.util.Map;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;


public class PlaceEvents implements Listener{
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		if(p.getItemInHand().containsEnchantment(Enchantment.OXYGEN)) {
			e.setCancelled(true);
		} else {
			e.setCancelled(false);
		}
	}

}
