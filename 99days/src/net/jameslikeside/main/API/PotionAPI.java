package net.jameslikeside.main.API;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

public class PotionAPI extends Object{

	public static ItemStack getPotionItemStack(PotionType type, int level, boolean extend, boolean splash, int amount) {
		@SuppressWarnings("deprecation")
		Potion potion = new Potion(type, level, false, false);
        if(extend) potion.setHasExtendedDuration(true);
        if(splash) potion.setSplash(true);
        ItemStack itemstack = potion.toItemStack(amount);
        ItemMeta meta = itemstack.getItemMeta();
        itemstack.setItemMeta(meta);
        return itemstack;
	}
	
}
