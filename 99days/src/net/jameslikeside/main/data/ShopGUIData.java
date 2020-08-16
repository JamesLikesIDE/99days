package net.jameslikeside.main.data;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import org.bukkit.potion.PotionType;

import net.jameslikeside.main.API.PotionAPI;
import net.jameslikeside.main.API.Money.MoneyAddRemoveSetReset;
import net.jameslikeside.main.API.Skills.CombatSkillAPI;
import net.jameslikeside.main.methods.ScoreboardListener;

public class ShopGUIData implements Listener {
	
	final String noCoins = "§cYou do not have enough money!";
	final String noSkill = "§cYou do not have the required skill level!";
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void ShopGUIMainClick(InventoryClickEvent e) throws SQLException {
		Player p = (Player) e.getWhoClicked();
		final String uuid = e.getWhoClicked().getUniqueId().toString();
		
		/*
		 * MAIN GUI
		 */
		if(e.getInventory().getTitle().equalsIgnoreCase("§bShop")) {
			e.setCancelled(true);
			if((e.getCurrentItem() == null) || e.getCurrentItem().getType().equals(Material.AIR))
				return;
			if((e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bFood")))
				foodInvGUI(p);
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bArmor"))
				armorInvGUI(p);
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bWeapons"))
				weaponsInvGUI(p);
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bPotions"))
				potionsInvGUI(p);
		}
		/*
		 * FOOD GUI
		 */
		if(e.getInventory().getName().equals("§bFood")) {
			e.setCancelled(true);
			if ((e.getCurrentItem() == null) || e.getCurrentItem().getType().equals(Material.AIR)){
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b1 Cake")) {
				if(MoneyAddRemoveSetReset.getCoins(uuid) < 1) {
					p.sendMessage(noCoins);
				} else {
					MoneyAddRemoveSetReset.removeCoins(uuid, 1);
					ItemStack giveNormalCake = new ItemStack(Material.CAKE);
					p.getInventory().addItem(giveNormalCake);
				}
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b16 Steak")) {
				if(MoneyAddRemoveSetReset.getCoins(uuid) < 10) {
					p.sendMessage(noCoins);
				} else {
					MoneyAddRemoveSetReset.removeCoins(uuid, 10);
					ItemStack giveNormalSteak = new ItemStack(Material.COOKED_BEEF);
					giveNormalSteak.setAmount(16);
					p.getInventory().addItem(giveNormalSteak);
				}
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b1 Golden Apple")) {
				if(MoneyAddRemoveSetReset.getCoins(uuid) < 40) {
					p.sendMessage(noCoins);
				} else {
					MoneyAddRemoveSetReset.removeCoins(uuid, 40);
					ItemStack giveNormalGap = new ItemStack(Material.GOLDEN_APPLE);
					p.getInventory().addItem(giveNormalGap);
				}
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b1 Enchanted Golden Apple")) {
				if (MoneyAddRemoveSetReset.getCoins(uuid) < 320) {
					p.sendMessage(noCoins);
				} else {
					MoneyAddRemoveSetReset.removeCoins(uuid, 320);
					ItemStack giveEnchGap = new ItemStack(Material.GOLDEN_APPLE);
					giveEnchGap.setDurability((short) 1);
					p.getInventory().addItem(giveEnchGap);
				}
			}
		}
		/*
		 * ARMOR GUI
		 */
		if(e.getInventory().getName().equalsIgnoreCase("§bArmor")) {
			e.setCancelled(true);
			if ((e.getCurrentItem() == null) || e.getCurrentItem().getType().equals(Material.AIR)){
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bGold Helmet")) {
				if(MoneyAddRemoveSetReset.getCoins(uuid) < 150) {
					p.sendMessage(noCoins);
				} else {
					MoneyAddRemoveSetReset.removeCoins(uuid, 150);
					ItemStack giveNormalGoldHelmet = new ItemStack(Material.GOLD_HELMET);
					p.getInventory().addItem(giveNormalGoldHelmet);
				}
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bGold Chestplate")) {
				if(MoneyAddRemoveSetReset.getCoins(uuid) < 300) {
					p.sendMessage(noCoins);
				} else {
					MoneyAddRemoveSetReset.removeCoins(uuid, 300);
					ItemStack giveNormalGoldChestplate = new ItemStack(Material.GOLD_CHESTPLATE);
					p.getInventory().addItem(giveNormalGoldChestplate);
				}
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bGold Leggings")) {
				if(MoneyAddRemoveSetReset.getCoins(uuid) < 200) {
					p.sendMessage(noCoins);
				} else {
					MoneyAddRemoveSetReset.removeCoins(uuid, 200);
					ItemStack giveNormalGoldLeggings = new ItemStack(Material.GOLD_LEGGINGS);
					p.getInventory().addItem(giveNormalGoldLeggings);
				}
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bGold Boots")) {
				if(MoneyAddRemoveSetReset.getCoins(uuid) < 100) {
					p.sendMessage(noCoins);
				} else {
					MoneyAddRemoveSetReset.removeCoins(uuid, 100);
					ItemStack giveNormalGoldboots = new ItemStack(Material.GOLD_BOOTS);
					p.getInventory().addItem(giveNormalGoldboots);
				}
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bUltimate Skelly Helmet")) {
				if(MoneyAddRemoveSetReset.getCoins(uuid) < 500000) {
					p.sendMessage(noCoins);
				} else if(CombatSkillAPI.getCombatSkill(uuid) < 500) {
					p.sendMessage(noSkill);
				} else {
					MoneyAddRemoveSetReset.removeCoins(uuid, 500000);
					ItemStack giveUltimateSkellyHelmet = new ItemBuilder(CustomSkullData.getSkull("http://textures.minecraft.net/texture/77b9dfd281deaef2628ad5840d45bcda436d6626847587f3ac76498a51c861")).setDisplayName("§bUltimate Skelly Helmet").setLore(Arrays.asList("§3Protection XX", "§3Aqua Affinity", " ", "§7Ability: Protection 20 and unlimited night vision", " ", "§7Full set ability: Take less damage from projectiles", " ", "§cRequires combat level 500", "§3Unbreakable"))
							.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 20, true)
							.addEnchantment(Enchantment.OXYGEN, 1, true)
							.addEnchantment(Enchantment.DURABILITY, 100000, true)
							.addItemFlag(ItemFlag.HIDE_ENCHANTS).build();
					p.getInventory().addItem(giveUltimateSkellyHelmet);
				}
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bUltimate Skelly Chestplate")) {
				if(MoneyAddRemoveSetReset.getCoins(uuid) < 750000) {
					p.sendMessage(noCoins);
				} else if(CombatSkillAPI.getCombatSkill(uuid) < 500) {
					p.sendMessage(noSkill);
				} else {
					MoneyAddRemoveSetReset.removeCoins(uuid, 750000);
					ItemStack giveUltimateSkellyChestplate = new ItemBuilder(Material.DIAMOND_CHESTPLATE, 1).setDisplayName("§bUltimate Skelly Chestplate").setLore(Arrays.asList("§3Protection XX"," ", "§7Ability: Protection 20", " ", "§7Full set ability: Take less damage from projectiles", " ", "§cRequires combat level 500", "§3Unbreakable"))
							.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 20, true)
							.addEnchantment(Enchantment.DURABILITY, 100000, true)
							.addItemFlag(ItemFlag.HIDE_ENCHANTS).build();
					p.getInventory().addItem(giveUltimateSkellyChestplate);
				}
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bUltimate Skelly Leggings")) {
				if(MoneyAddRemoveSetReset.getCoins(uuid) < 700000) {
					p.sendMessage(noCoins);
				} else if(CombatSkillAPI.getCombatSkill(uuid) < 500) {
					p.sendMessage(noSkill);
				} else {
					MoneyAddRemoveSetReset.removeCoins(uuid, 700000);
					ItemStack giveUltimateSkellyLeggings = new ItemBuilder(Material.DIAMOND_LEGGINGS, 1).setDisplayName("§bUltimate Skelly Leggings").setLore(Arrays.asList("§3Protection XX", " ", "§7Ability: Protection 20", " ", "§7Full set ability: Take less damage from projectiles", " ", "§cRequires combat level 500", "§3Unbreakable"))
							.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 20, true)
							.addEnchantment(Enchantment.DURABILITY, 100000, true)
							.addItemFlag(ItemFlag.HIDE_ENCHANTS)
							.addItemFlag(ItemFlag.HIDE_UNBREAKABLE).build();
					p.getInventory().addItem(giveUltimateSkellyLeggings);
				}
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bUltimate Skelly Boots")) {
				if(MoneyAddRemoveSetReset.getCoins(uuid) < 650000) {
					p.sendMessage(noCoins);
				} else if(CombatSkillAPI.getCombatSkill(uuid) < 500) {
					p.sendMessage(noSkill);
				} else {
					MoneyAddRemoveSetReset.removeCoins(uuid, 650000);
					ItemStack giveUltimateSkellyBoots = new ItemBuilder(Material.DIAMOND_BOOTS, 1).setDisplayName("§bUltimate Skelly Boots").setLore(Arrays.asList("§3Protection XX", "§3Feather Falling 5", " ", "§7Ability: Protection 20 and featherfalling 5", " ", "§7Full set ability: Take less damage from projectiles", " ", "§cRequires combat level 500", "§3Unbreakable"))
							.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 20, true)
							.addEnchantment(Enchantment.PROTECTION_FALL, 5, true)
							.addEnchantment(Enchantment.DURABILITY, 100000, true)
							.addItemFlag(ItemFlag.HIDE_ENCHANTS)
							.addItemFlag(ItemFlag.HIDE_UNBREAKABLE).build();
					p.getInventory().addItem(giveUltimateSkellyBoots);

				}
			}
		}
		if(e.getInventory().getName().equalsIgnoreCase("§bWeapons")) {
			e.setCancelled(true);
			if ((e.getCurrentItem() == null) || e.getCurrentItem().getType().equals(Material.AIR)){
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bStarter Bow")) {
				if(MoneyAddRemoveSetReset.getCoins(uuid) < 20) {
					p.sendMessage(noCoins);
				} else {
					MoneyAddRemoveSetReset.removeCoins(uuid, 20);
					ItemStack giveStarterBow = new ItemBuilder(Material.BOW, 1).setDisplayName("§bStarter Bow")
							.addEnchantment(Enchantment.ARROW_DAMAGE, 2, true).build();
					p.getInventory().addItem(giveStarterBow);

				}
			}
		}
		if(e.getInventory().getName().equalsIgnoreCase("§bPotions")) {
			e.setCancelled(true);
			if ((e.getCurrentItem() == null) || e.getCurrentItem().getType().equals(Material.AIR)){
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bRegeneration Potion 1")) {
				if(MoneyAddRemoveSetReset.getCoins(uuid) < 20) {
					p.sendMessage(noCoins);
				} else {
					MoneyAddRemoveSetReset.removeCoins(uuid, 20);
					ItemStack giveRegenOnePot = PotionAPI.getPotionItemStack(PotionType.REGEN, 1, true, true, 1);
					p.getInventory().addItem(giveRegenOnePot);
				}
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bRegeneration Potion 2")) {
				if(MoneyAddRemoveSetReset.getCoins(uuid) < 40) {
					p.sendMessage(noCoins);
				} else {
					MoneyAddRemoveSetReset.removeCoins(uuid, 40);
					ItemStack giveRegenTwoPot = PotionAPI.getPotionItemStack(PotionType.REGEN, 2, true, true, 1);
					p.getInventory().addItem(giveRegenTwoPot);
				}
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bStrength Potion 1")) {
				if(MoneyAddRemoveSetReset.getCoins(uuid) < 40) {
					p.sendMessage(noCoins);
				} else {
					MoneyAddRemoveSetReset.removeCoins(uuid, 40);
					ItemStack giveStrOne = PotionAPI.getPotionItemStack(PotionType.STRENGTH, 1, false, true, 1);
					p.getInventory().addItem(giveStrOne);
				}
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bStrength Potion 2")) {
				if(MoneyAddRemoveSetReset.getCoins(uuid) < 90) {
					p.sendMessage(noCoins);
				} else {
					MoneyAddRemoveSetReset.removeCoins(uuid, 90);
					ItemStack giveStrTwo = PotionAPI.getPotionItemStack(PotionType.STRENGTH, 2, true, true, 1);
					p.getInventory().addItem(giveStrTwo);
				}
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bSpeed Potion 1")) {
				if(MoneyAddRemoveSetReset.getCoins(uuid) < 20) {
					p.sendMessage(noCoins);
				} else {
					MoneyAddRemoveSetReset.removeCoins(uuid, 20);
					ItemStack giveSpeedOne = PotionAPI.getPotionItemStack(PotionType.SPEED, 1, false, true, 1);
					p.getInventory().addItem(giveSpeedOne);
				}
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bSpeed Potion 2")) {
				if(MoneyAddRemoveSetReset.getCoins(uuid) < 40) {
					p.sendMessage(noCoins);
				} else {
					MoneyAddRemoveSetReset.removeCoins(uuid, 40);
					ItemStack giveSpeedTwo = PotionAPI.getPotionItemStack(PotionType.SPEED, 2, true, true, 1);
					p.getInventory().addItem(giveSpeedTwo);
				}
			}
		}
		
	}
	
	public void foodInvGUI(Player p) {
		Inventory foodInv = Bukkit.createInventory(p, 27, "§bFood");
		
		ItemStack normalCake = new ItemBuilder(Material.CAKE, 1).setDisplayName("§b1 Cake").setLore(Arrays.asList("§ePrice: §c1 Coin")).build();
		ItemStack normalSteak = new ItemBuilder(Material.COOKED_BEEF, 1).setDisplayName("§b16 Steak").setLore(Arrays.asList("§ePrice: §c16 Coins")).setAmount(16).build();
		ItemStack normalGap = new ItemBuilder(Material.GOLDEN_APPLE, 1).setDisplayName("§b1 Golden Apple").setLore(Arrays.asList("§ePrice: §c40 Coins")).build();
		ItemStack EnchGap = new ItemBuilder(Material.GOLDEN_APPLE, 1).setDisplayName("§b1 Enchanted Golden Apple").setLore(Arrays.asList("§ePrice: §c320 Coins")).build();
		EnchGap.setDurability((short) 1);
		
		foodInv.addItem(normalCake);
		foodInv.addItem(normalSteak);
		foodInv.addItem(normalGap);
		foodInv.addItem(EnchGap);

		p.openInventory(foodInv);
	}
	
	public void armorInvGUI(Player p) {
		Inventory armorInv = Bukkit.createInventory(p, 27, "§bArmor");

		DecimalFormat formatter1 = new DecimalFormat("#,###");
		double amount1 = 500000;
		double amount2 = 750000;
		double amount3 = 700000;
		double amount4 = 400000;
		
		ItemStack normalGoldHelmet = new ItemBuilder(Material.GOLD_HELMET, 1).setDisplayName("§bGold Helmet").setLore(Arrays.asList("§ePrice: §c150 Coins")).build();
		ItemStack normalGoldChestplate = new ItemBuilder(Material.GOLD_CHESTPLATE, 1).setDisplayName("§bGold Chestplate").setLore(Arrays.asList("§ePrice: §c300 Coins")).build();
		ItemStack normalGoldLeggings = new ItemBuilder(Material.GOLD_LEGGINGS, 1).setDisplayName("§bGold Leggings").setLore(Arrays.asList("§ePrice: §c200 Coins")).build();
		ItemStack normalGoldBoots = new ItemBuilder(Material.GOLD_BOOTS, 1).setDisplayName("§bGold Boots").setLore(Arrays.asList("§ePrice: §c100 Coins")).build();
		ItemStack ultimateCustomSkellyHelmet = new ItemBuilder(CustomSkullData.getSkull("http://textures.minecraft.net/texture/77b9dfd281deaef2628ad5840d45bcda436d6626847587f3ac76498a51c861")).setDisplayName("§bUltimate Skelly Helmet").setLore(Arrays.asList("§ePrice: §c" + formatter1.format(amount1) + " Coins", " ", "§7Ability: Grants protection 20 and the ", "§7ability to have infinite night vision", " ", "§7Full set ability: Take less damage from projectiles", " ", "§cRequires combat level 500")).build();
		ItemStack ultimateCustomSkellyChestplate = new ItemBuilder(Material.DIAMOND_CHESTPLATE, 1).setDisplayName("§bUltimate Skelly Chestplate").setLore(Arrays.asList("§ePrice: §c" + formatter1.format(amount2) + " Coins", " ", "§7Ability: Protection 20", " ", "§7Full set ability: Take less damage from projectiles"," ", "§cRequires combat level 500")).build();
		ItemStack ultimateCustomskellyLeggings = new ItemBuilder(Material.DIAMOND_LEGGINGS, 1).setDisplayName("§bUltimate Skelly Leggings").setLore(Arrays.asList("§ePrice: §c" + formatter1.format(amount3) + " Coins", " ", "§7Ability: Protection 20", " ", "§7Full set ability: Take less damage from projectiles", " ", "§cRequires combat level 500")).build();
		ItemStack ultimateCustomSkellyBoots = new ItemBuilder(Material.DIAMOND_BOOTS, 1).setDisplayName("§bUltimate Skelly Boots").setLore(Arrays.asList("§ePrice: §c" + formatter1.format(amount4) + " Coins", " ", "§7Ability: Protection 20 and feather falling 5", " ", "§7Full set ability: Take less damage from projectiles", " ", "§cRequires combat level 500")).build();
		
		armorInv.addItem(normalGoldHelmet);
		armorInv.addItem(normalGoldChestplate);
		armorInv.addItem(normalGoldLeggings);
		armorInv.addItem(normalGoldBoots);
		armorInv.addItem(ultimateCustomSkellyHelmet);
		armorInv.addItem(ultimateCustomSkellyChestplate);
		armorInv.addItem(ultimateCustomskellyLeggings);
		armorInv.addItem(ultimateCustomSkellyBoots);
		
		p.openInventory(armorInv);
	}
	
	public void weaponsInvGUI(Player p) {
		Inventory weaponsInv = Bukkit.createInventory(p, 27, "§bWeapons");
		
		ItemStack startBow = new ItemBuilder(Material.BOW, 1).setDisplayName("§bStarter Bow").setLore(Arrays.asList("§ePrice: §c20 Coins","A simple Starter Bow")).build();
		
		weaponsInv.addItem(startBow);
		
		p.openInventory(weaponsInv);
	}
	
	public void potionsInvGUI(Player p) {
		Inventory potInv = Bukkit.createInventory(p, 27, "§bPotions");
		
		ItemStack regenOne = new ItemBuilder(Material.POTION, 1).setDisplayName("§bRegeneration Potion 1").setLore(Arrays.asList("§ePrice: §c20 Coins")).build();
		regenOne.setDurability((short) 16385);
		ItemStack regenTwo = new ItemBuilder(Material.POTION, 1).setDisplayName("§bRegeneration Potion 2").setLore(Arrays.asList("§ePrice: §c40 Coins")).build();
		regenTwo.setDurability((short) 16385);
		ItemStack strOne = new ItemBuilder(Material.POTION, 1).setDisplayName("§bStrength Potion 1").setLore(Arrays.asList("§ePrice: §c40 Coins")).build();
		strOne.setDurability((short) 16393);
		ItemStack strTwo = new ItemBuilder(Material.POTION, 1).setDisplayName("§bStrength Potion 2").setLore(Arrays.asList("§ePrice: §c90 Coins")).build();
		strTwo.setDurability((short) 16425);
		ItemStack speedOne = new ItemBuilder(Material.POTION, 1).setDisplayName("§bSpeed Potion 1").setLore(Arrays.asList("§ePrice: §c20 Coins")).build();
		speedOne.setDurability((short) 16386);
		ItemStack speedTwo = new ItemBuilder(Material.POTION, 1).setDisplayName("§bSpeed Potion 2").setLore(Arrays.asList("§ePirce: §c40 Coins")).build();
		speedTwo.setDurability((short) 16418);
		
		potInv.addItem(regenOne);
		potInv.addItem(regenTwo);
		potInv.addItem(strOne);
		potInv.addItem(strTwo);
		potInv.addItem(speedOne);
		potInv.addItem(speedTwo);
		
		p.openInventory(potInv);
	}

}
