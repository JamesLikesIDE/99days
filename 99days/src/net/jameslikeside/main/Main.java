package net.jameslikeside.main;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import net.jameslikeside.main.commands.AuctionGUI;
import net.jameslikeside.main.commands.Heal;
import net.jameslikeside.main.commands.Kit;
import net.jameslikeside.main.commands.Spawn;
import net.jameslikeside.main.commands.SpawnMob;
import net.jameslikeside.main.commands.SpawnMobGUI;
import net.jameslikeside.main.commands.gma;
import net.jameslikeside.main.commands.gmc;
import net.jameslikeside.main.commands.gms;
import net.jameslikeside.main.commands.gmsp;
import net.jameslikeside.main.data.MenuGUIAuctionData;
import net.jameslikeside.main.data.MenuGUILocationData;
import net.jameslikeside.main.data.MenuGUIdata;
import net.jameslikeside.main.events.ForPlayerEnterEvent;
import net.jameslikeside.main.events.PlayerClickInvEvent;
import net.jameslikeside.main.events.PlayerDeathRespawn;
import net.jameslikeside.main.events.PlayerJoinLeave;
import net.jameslikeside.main.events.hotbar.PlayerHotbarClickStar;
import net.jameslikeside.main.methods.Chat;

public class Main extends JavaPlugin implements Listener{
	
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
		loadCommands();
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new PlayerJoinLeave(), this);
		pm.registerEvents(new PlayerClickInvEvent(), this);
		pm.registerEvents(new PlayerDeathRespawn(), this);
		pm.registerEvents(new PlayerHotbarClickStar(), this);
		pm.registerEvents(new MenuGUIdata(), this);
		pm.registerEvents(new MenuGUILocationData(), this);
		pm.registerEvents(new MenuGUIAuctionData(), this);
		pm.registerEvents(new ForPlayerEnterEvent(), this);
		pm.registerEvents(new Chat(), this);
		getServer().getPluginManager().registerEvents(this, this);
		Main.mysql.Connect();
		Main.instance = this;
		
	}

	@Override
	public void onDisable() {
		
	}
	
	public static Main getInstance() {
        return Main.instance;
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
		this.getCommand("spawn").setExecutor(new Spawn());
		this.getCommand("auctiongui").setExecutor(new AuctionGUI());
	}
}
