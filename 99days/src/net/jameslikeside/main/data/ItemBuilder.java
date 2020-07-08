package net.jameslikeside.main.data;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {
	
	private ItemStack current;
	
	public ItemBuilder(ItemStack i) {
		this.current = i;
	}

	public ItemBuilder(Material m, int amount, short ID) {
		this(new ItemStack(m, amount, ID));
	}
	
	public ItemBuilder(Material m, int amount) {
		this(new ItemStack(m, amount));
	}
	
	@SuppressWarnings("deprecation")
	public ItemBuilder(int ID, int amount, short DoubleID) {
		this(new ItemStack(ID, amount, DoubleID));
	}
	
	public ItemBuilder setDisplayName(String displayname) {
		ItemMeta m = current.getItemMeta();
		m.setDisplayName(displayname);
		current.setItemMeta(m);
		return this;
	}
	
	public ItemBuilder setLore(List<String> lore) {
		ItemMeta m = current.getItemMeta();
		m.setLore(lore);
		current.setItemMeta(m);
		return this;
	}
	
	public ItemBuilder setAmount(int amount) {
		current.setAmount(amount);
		return this;
	}
	
	public ItemBuilder addEnchantment(Enchantment ench, int level, boolean bool) {
		ItemMeta m = current.getItemMeta();
		m.addEnchant(ench, level, bool);
		current.setItemMeta(m);
		return this;
	}
	
	public ItemStack build() {
		return this.current;
	}
	
}
