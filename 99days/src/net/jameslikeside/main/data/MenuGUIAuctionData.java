package net.jameslikeside.main.data;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuGUIAuctionData implements Listener{
	
	public void AuctionClickData(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
	}
	
}
