package net.jameslikeside.main;

import java.io.File;
import java.util.Arrays;

import com.sk89q.worldguard.bukkit.commands.task.RegionLister;
import com.sk89q.worldguard.protection.flags.RegionGroup;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import net.jameslikeside.main.commands.AuctionGUI;
import net.jameslikeside.main.commands.Heal;
import net.jameslikeside.main.commands.Kit;
import net.jameslikeside.main.commands.MoneyCommands;
import net.jameslikeside.main.commands.ShopGUI;
import net.jameslikeside.main.commands.SpawnMob;
import net.jameslikeside.main.commands.SpawnMobGUI;
import net.jameslikeside.main.commands.gma;
import net.jameslikeside.main.commands.gmc;
import net.jameslikeside.main.commands.gms;
import net.jameslikeside.main.commands.gmsp;
import net.jameslikeside.main.data.MenuGUIAuctionData;
import net.jameslikeside.main.data.MenuGUILocationData;
import net.jameslikeside.main.data.MenuGUIdata;
import net.jameslikeside.main.data.ShopGUIData;
import net.jameslikeside.main.events.ForPlayerEnterEvent;
import net.jameslikeside.main.events.PlaceEvents;
import net.jameslikeside.main.events.PlayerClickInvEvent;
import net.jameslikeside.main.events.PlayerDeathRespawn;
import net.jameslikeside.main.events.PlayerJoinLeave;
import net.jameslikeside.main.events.hotbar.PlayerHotbarClickStar;
import net.jameslikeside.main.methods.Chat;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class Main extends JavaPlugin implements Listener{

    public Scoreboard s;
	
    public static String MapName;
    public static String BuilderName;
    public static MySQL mysql;
    public static Main instance;
    public static File file;
    public static YamlConfiguration cfg;
    public static String teamspeak = ChatColor.YELLOW + "Fresh2Play";
    public static String discord = ChatColor.YELLOW + "dc.Fresh2Flay.net";
    public static String website = ChatColor.YELLOW + "Fresh2Flay.net";
    public static boolean boardon;
	
	public static String mustbeplayer = ("You must be a player to use this command!");
	public static String gamemodeupdated = ("Your game mode has been updated");
	public static String noperm = ("I'm sorry, but you do not have permission to perform this command. Please contact the server administrators if you"
			+ " believe that this is an error.");
	
	static {
		Main.mysql = new MySQL("localhost", "f2p_network", "f2padmins", "Fresh2playadmins.");
        Main.file = new File("plugins//99floors//tablist.yml");
        Main.cfg = YamlConfiguration.loadConfiguration(Main.file);
	}
	
	@Override
	public void onEnable() {
	    s = Bukkit.getScoreboardManager().getMainScoreboard();
		System.out.println("Loading 99days Server...");
		loadCommands();
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new PlayerJoinLeave(), this);
		pm.registerEvents(new PlayerClickInvEvent(), this);
		pm.registerEvents(new PlayerDeathRespawn(), this);
		pm.registerEvents(new PlayerHotbarClickStar(), this);
		pm.registerEvents(new MenuGUIdata(), this);
		pm.registerEvents(new MenuGUILocationData(), this);
		pm.registerEvents(new MenuGUIAuctionData(), this);
		pm.registerEvents(new ShopGUIData(), this);
		pm.registerEvents(new ForPlayerEnterEvent(), this);
		pm.registerEvents(new Chat(), this);
		pm.registerEvents(new PlaceEvents(), this);
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		Main.mysql.Connect();
		Main.instance = this;
		recipe();
		registerHealthBar();
	}

	@Override
	public void onDisable() {
		System.out.println("Disabling 99days server...");
	}
	
	public static Main getInstance() {
        return Main.instance;
    }

    public void registerHealthBar(){
	    if(s.getObjective("health") != null){
	        s.getObjective("health").unregister();
        }
        Objective o = s.registerNewObjective("health", "health");
        o.setDisplayName(ChatColor.RED + "\u2764");
        o.setDisplaySlot(DisplaySlot.BELOW_NAME);
    }

	private void loadCommands() {
		this.getCommand("kit").setExecutor(new Kit());
		this.getCommand("gmc").setExecutor(new gmc());
		this.getCommand("gms").setExecutor(new gms());
		this.getCommand("gma").setExecutor(new gma());
		this.getCommand("gmsp").setExecutor(new gmsp());
		this.getCommand("spawnmob").setExecutor(new SpawnMob());
		this.getCommand("heal").setExecutor(new Heal());
		this.getCommand("spawnmobgui").setExecutor(new SpawnMobGUI());
		//this.getCommand("spawn").setExecutor(new Spawn());
		this.getCommand("auctiongui").setExecutor(new AuctionGUI());
		this.getCommand("shop").setExecutor(new ShopGUI());
		this.getCommand("bank").setExecutor((CommandExecutor)new MoneyCommands());
	}
	
	public void recipe() {
		ItemStack LongSword = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta LongSwordMeta = LongSword.getItemMeta();
		LongSwordMeta.setDisplayName(ChatColor.AQUA + "Long Sword");
		LongSwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
		LongSwordMeta.setLore(Arrays.asList(" ", "?eGrants permenent strength when held"));
		LongSword.setItemMeta(LongSwordMeta);
		ShapedRecipe LongSwordRec = new ShapedRecipe(LongSword);
		LongSwordRec.shape("  #", " # ", "D  ");
		LongSwordRec.setIngredient('D', Material.DIAMOND_SWORD);
		LongSwordRec.setIngredient('#', Material.DIAMOND);
		Bukkit.addRecipe(LongSwordRec);
		
		ItemStack EmpoweredIronBlock = new ItemStack(Material.IRON_BLOCK);
		ItemMeta EmpoweredIronBlockMeta = EmpoweredIronBlock.getItemMeta();
		MaterialData EmpoweredIronBlockData = EmpoweredIronBlock.getData().clone();
		EmpoweredIronBlockMeta.setDisplayName(ChatColor.AQUA + "Empowered Iron Block");
		EmpoweredIronBlockMeta.addEnchant(Enchantment.OXYGEN, 1, true);
		EmpoweredIronBlockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		EmpoweredIronBlock.setItemMeta(EmpoweredIronBlockMeta);
		ShapedRecipe EmpoweredIronBlockRec = new ShapedRecipe(EmpoweredIronBlock);
		EmpoweredIronBlockRec.shape("###", "#N#", "###");
		EmpoweredIronBlockRec.setIngredient('#', Material.IRON_BLOCK);
		EmpoweredIronBlockRec.setIngredient('N', Material.NETHER_STAR);
		Bukkit.addRecipe(EmpoweredIronBlockRec);
		
		ItemStack SuperEmpoweredIronIngot = new ItemStack(Material.IRON_INGOT);
		ItemMeta SuperEmpoweredIronIngotMeta = SuperEmpoweredIronIngot.getItemMeta();
		SuperEmpoweredIronIngotMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Super Empowered Iron Ingot");
		SuperEmpoweredIronIngotMeta.addEnchant(Enchantment.OXYGEN, 1, true);
		SuperEmpoweredIronIngotMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		SuperEmpoweredIronIngot.setItemMeta(SuperEmpoweredIronIngotMeta);
		ShapedRecipe SuperEmpoweredIronIngotRec = new ShapedRecipe(SuperEmpoweredIronIngot);
		SuperEmpoweredIronIngotRec.shape("###", "###", "###");
		SuperEmpoweredIronIngotRec.setIngredient('#', EmpoweredIronBlockData);
		
		ItemStack EmpoweredGoldBlock = new ItemStack(Material.GOLD_BLOCK);
		ItemMeta EmpoweredGoldBlockMeta = EmpoweredGoldBlock.getItemMeta();
		EmpoweredGoldBlockMeta.setDisplayName(ChatColor.AQUA + "Empowered Gold Block");
		EmpoweredGoldBlockMeta.addEnchant(Enchantment.OXYGEN, 1, true);
		EmpoweredGoldBlockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		EmpoweredGoldBlock.setItemMeta(EmpoweredGoldBlockMeta);
		ShapedRecipe EmpoweredGoldBlockRec = new ShapedRecipe(EmpoweredGoldBlock);
		EmpoweredGoldBlockRec.shape("###", "#N#", "###");
		EmpoweredGoldBlockRec.setIngredient('#', Material.GOLD_BLOCK);
		EmpoweredGoldBlockRec.setIngredient('N', Material.NETHER_STAR);
		Bukkit.addRecipe(EmpoweredGoldBlockRec);
	}
		
}
