package net.jameslikeside.main.events.hotbar;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.jameslikeside.main.data.ItemBuilder;

public class PlayerHotbarClickStar implements Listener{

	@EventHandler
	public void onJoinStar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		ItemStack MenuStar = new ItemStack(Material.NETHER_STAR);
		ItemMeta MenuStarMeta = MenuStar.getItemMeta();
		MenuStarMeta.setDisplayName("§9Menu");
		MenuStarMeta.setLore(Arrays.asList("§eClick to open 99Days Menu"));
		MenuStar.setItemMeta(MenuStarMeta); 
		
		p.getInventory().setItem(8, MenuStar); 
	}
	
	@EventHandler
	public void onClickStar(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
			if(p.getItemInHand().getType() == Material.NETHER_STAR && p.getItemInHand().getItemMeta().getDisplayName().equals("§9Menu")) {
				e.setCancelled(true);
				mainGUI(p);
			}
		} 
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(p.getItemInHand().getType() == Material.NETHER_STAR && p.getItemInHand().getItemMeta().getDisplayName().equals("§9Menu")) {
				e.setCancelled(true);
				mainGUI(p);
			}
		} 
		
	}
	
	@EventHandler
	public void InventoryStarClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if(e.getCurrentItem().getType() == Material.NETHER_STAR && e.getCurrentItem().getItemMeta().getDisplayName().equals("§9Menu")) {
			e.setCancelled(true);
			mainGUI(p);
		} else {
		}
	}
	
	public static void mainGUI(Player p) {
		//MAIN INVENTORY
		Inventory menu = Bukkit.createInventory(null, 9*6, "§b§lMenu");
		ItemStack glass = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (short) 14).setDisplayName(" ").build();
		ItemStack arrow = new ItemBuilder(Material.ARROW, 1).setDisplayName("§a>> Next").build();
		ItemStack barrier = new ItemBuilder(Material.BARRIER, 1).setDisplayName("§cClose Menu").build();
		ItemStack skillMenu = new ItemBuilder(Material.DIAMOND_SWORD, 1).setDisplayName("§bSkills").setLore(Arrays.asList("§eShows all of your skill levels")).build();
		ItemStack Locations = new ItemBuilder(Material.GRASS, 1).setDisplayName("§6Locations").setLore(Arrays.asList("§eShows all avaiable Locations")).build();
		menu.setItem(0, glass); menu.setItem(1, glass); menu.setItem(2, glass);
		menu.setItem(3, glass); menu.setItem(4, glass); menu.setItem(5, glass); 
		menu.setItem(6, glass); menu.setItem(7, glass); menu.setItem(8, glass); 
		menu.setItem(9, glass); menu.setItem(10, skillMenu); menu.setItem(17, glass); 
		menu.setItem(18, glass); menu.setItem(26, glass); menu.setItem(27, glass);  //Ill create a extra class for the locations.
		menu.setItem(36, glass); menu.setItem(44, glass); menu.setItem(45, glass); 
		menu.setItem(46, glass); menu.setItem(47, glass); menu.setItem(48, glass); 
		menu.setItem(49, barrier); menu.setItem(50, glass); menu.setItem(51, glass); 
		menu.setItem(52, glass); menu.setItem(53, arrow); menu.setItem(35, glass); 
		menu.setItem(13, Locations); 

		p.openInventory(menu); 
	}

	public static void skillsGUI(Player p) {
		//SKILLS INVENTORY
		Inventory skills = Bukkit.createInventory(null, 9*6, "§b§lSkills Menu");
		ItemStack glass = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (short) 14).setDisplayName(" ").build();
		ItemStack arrow = new ItemBuilder(Material.ARROW, 1).setDisplayName("§a>> Next").build();
		ItemStack arrow2 = new ItemBuilder(Material.ARROW, 1).setDisplayName("§a<< Back").build();
		ItemStack barrier = new ItemBuilder(Material.BARRIER, 1).setDisplayName("§cClose Menu").build();
		skills.setItem(0, glass); skills.setItem(1, glass); skills.setItem(2, glass);
		skills.setItem(3, glass); skills.setItem(4, glass); skills.setItem(5, glass); 
		skills.setItem(6, glass); skills.setItem(7, glass); skills.setItem(8, glass); 
		skills.setItem(9, glass); skills.setItem(17, glass); skills.setItem(18, glass); 
		skills.setItem(26, glass); skills.setItem(27, glass); skills.setItem(35, glass); 
		skills.setItem(36, glass); skills.setItem(44, glass); skills.setItem(45, arrow2); 
		skills.setItem(46, glass); skills.setItem(47, glass); skills.setItem(48, glass); 
		skills.setItem(49, barrier); skills.setItem(50, glass); skills.setItem(51, glass); 
		skills.setItem(52, glass); skills.setItem(53, arrow); 
		
		//SKILL NAMES
		String SwordSkillName = "§b§lSword Skill";
		String DefSkillName = "§b§lDefensive Skill";
		String SpySkillName = "§b§lSpy Skill";
		String CookingSkillName = "§b§lCooking Skill";
		String EngineeringSkillName = "§b§lEngineering Skill";
		String FishSkillName = "§b§lFishing Skill";
		//SKILL LEVEL
		Integer SwordSkillLvl = 1;
		Integer DefSkillLvl = 1; 
		Integer SpySkillLvl = 1;
		Integer CookingSkillLvl = 1;
		Integer EngineeringSkillLvl = 1;
		Integer FishingSkillLvl = 1;
		//SKILL LEVEL LORE
		String SwordSkillLore = "§eCurrent Level: " + SwordSkillLvl;
		String DefSkillLore = "§eCurrent Level: " + DefSkillLvl;
		String SpySkillLore = "§eCurrent Level: " + SpySkillLvl;
		String CookingSkillLore = "§eCurrent Level: " + CookingSkillLvl;
		String EngineeringSkillLore = "§eCurrent Level: " + EngineeringSkillLvl;
		String FishingSkillLore = "§eCurrent Level: " + FishingSkillLvl;
		//SKILL ITEMS
		ItemStack SwordSkill = new ItemBuilder(Material.IRON_SWORD, 1).setDisplayName(SwordSkillName).setLore(Arrays.asList(SwordSkillLore)).build();
		ItemStack Defense = new ItemBuilder(Material.DIAMOND_CHESTPLATE, 1).setDisplayName(DefSkillName).setLore(Arrays.asList(DefSkillLore)).build();
		ItemStack Spy = new ItemBuilder(Material.EYE_OF_ENDER, 1).setDisplayName(SpySkillName).setLore(Arrays.asList(SpySkillLore)).build();
		ItemStack Cooking = new ItemBuilder(Material.COOKED_BEEF, 1).setDisplayName(CookingSkillName).setLore(Arrays.asList(CookingSkillLore)).build();
		ItemStack Engineering = new ItemBuilder(Material.REDSTONE, 1).setDisplayName(EngineeringSkillName).setLore(Arrays.asList(EngineeringSkillLore)).build();
		ItemStack Fishing = new ItemBuilder(Material.COOKED_FISH, 1).setDisplayName(FishSkillName).setLore(Arrays.asList(FishingSkillLore)).build();
		
		skills.addItem(SwordSkill);
		skills.addItem(Defense);
		skills.addItem(Spy);
		skills.addItem(Cooking);
		skills.addItem(Engineering);
		skills.addItem(Fishing);
		
		p.openInventory(skills);
	}
	
	public static void LocationsGUI(Player p) {
		//LOCATIONS INVENTORY
		Inventory locations = Bukkit.createInventory(null, 9*6, "§b§lLocations Menu");
		ItemStack glass = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (short) 14).setDisplayName(" ").build();
		ItemStack arrow = new ItemBuilder(Material.ARROW, 1).setDisplayName("§a>> Next").build();
		ItemStack arrow2 = new ItemBuilder(Material.ARROW, 1).setDisplayName("§a<< Back").build();
		ItemStack barrier = new ItemBuilder(Material.BARRIER, 1).setDisplayName("§cClose Menu").build();
		locations.setItem(0, glass); locations.setItem(1, glass); locations.setItem(2, glass);
		locations.setItem(3, glass); locations.setItem(4, glass); locations.setItem(5, glass); 
		locations.setItem(6, glass); locations.setItem(7, glass); locations.setItem(8, glass); 
		locations.setItem(9, glass); locations.setItem(17, glass); locations.setItem(18, glass); 
		locations.setItem(26, glass); locations.setItem(27, glass); locations.setItem(35, glass); 
		locations.setItem(36, glass); locations.setItem(44, glass); locations.setItem(45, arrow2); 
		locations.setItem(46, glass); locations.setItem(47, glass); locations.setItem(48, glass); 
		locations.setItem(49, barrier); locations.setItem(50, glass); locations.setItem(51, glass); 
		locations.setItem(52, glass); locations.setItem(53, arrow); 
		//LOCATION NAMES
		String SpawnName = "§6§lSpawn";
		String AuctionName = "§6§lAuction House";
		String FloorsName = "§6§lTemp Floors Teleport";
		//LOCATION LORES
		String SpawnLore = "§eTeleports you to spawn";
		String AuctionLore = "§eTeleports you to the auction house";
		String FloorsLore = "§eTeleports you to the floors world (Temp)";
		//LOCATION ITEMS
		ItemStack Spawn = new ItemBuilder(Material.GRASS, 1).setDisplayName(SpawnName).setLore(Arrays.asList(SpawnLore)).build();
		ItemStack Auction = new ItemBuilder(Material.GOLD_INGOT, 1).setDisplayName(AuctionName).setLore(Arrays.asList(AuctionLore)).build();
		ItemStack Floors = new ItemBuilder(Material.STONE, 1).setDisplayName(FloorsName).setLore(Arrays.asList(FloorsLore)).build();
		
		locations.addItem(Spawn);
		locations.addItem(Auction);
		locations.addItem(Floors);
		
		p.openInventory(locations);
	}
	
}
