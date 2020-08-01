package net.jameslikeside.main.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerClickInvEvent implements Listener{
	
	@EventHandler
	public void inventoryClickSpawnMob(InventoryClickEvent event) {
		Player p = (Player) event.getWhoClicked();
		
		if(event.getInventory().getTitle().equals("Spawn Mob GUI")) {
			event.setCancelled(true);
			try {
				if(event.getCurrentItem().getType() == Material.SKULL_ITEM) {
					if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Spawn Zombie")) {
						spawnZombieBossLVL1(p.getLocation());
					}else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Spawn spider boss lvl 1")) {
						spawnSpiderBossLVL1(p.getLocation(), p.getPlayer());
					}
				} 
			} catch(NullPointerException e) {
				e.printStackTrace();
			}
		} else {
			return;
		}

	}
	
	private void spawnZombieBossLVL1(Location loc) {
		Zombie zombieBossLVL1 = (Zombie) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
		zombieBossLVL1.setCustomName("§cCustom Zombie Name");
		zombieBossLVL1.setCustomNameVisible(true);
	}
	private void spawnSpiderBossLVL1(Location loc, Player player) {
		Spider spiderBossLVL1 = (Spider) loc.getWorld().spawnEntity(loc, EntityType.SPIDER);
		Zombie spiderBossLVL1Zombie = (Zombie) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
		spiderBossLVL1Zombie.setBaby(true);
		spiderBossLVL1Zombie.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
		spiderBossLVL1Zombie.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
		spiderBossLVL1Zombie.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
		spiderBossLVL1Zombie.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
		ItemStack diasword = new ItemStack(Material.DIAMOND_SWORD); 
		ItemMeta diameta = diasword.getItemMeta();
		diameta.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
		diasword.setItemMeta(diameta);
		spiderBossLVL1Zombie.getEquipment().setItemInHand(diasword);
		spiderBossLVL1Zombie.setCustomName("boss.spiderzombie.lvl1");
		spiderBossLVL1Zombie.setCustomNameVisible(false);
		spiderBossLVL1.setCustomName("boss.spider.lvl1");
		spiderBossLVL1.setCustomNameVisible(false);
		spiderBossLVL1.setPassenger((Entity) spiderBossLVL1Zombie);
		spiderBossLVL1.setMaxHealth(400d);
		spiderBossLVL1.setHealth(400d);
		spiderBossLVL1Zombie.setMaxHealth(400d);
		spiderBossLVL1Zombie.setHealth(400d);
	}
}
