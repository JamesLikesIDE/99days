package net.jameslikeside.main.CustomMobs.Boss;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Spider;

public class SpiderBossTwo {

    static ChatColor cdred = ChatColor.DARK_RED;
    static ChatColor cred = ChatColor.RED;
    static ChatColor cgray = ChatColor.GRAY;

    public static void SpiderBossTwo(Location loc, Player p){
        Spider SpiderBossLVL2 = (Spider) loc.getWorld().spawnEntity(loc, EntityType.SPIDER);
        SpiderBossLVL2.setCustomName(cgray + "[Lvl 2]" +  cdred + " Spider Boss " + cgray + "[" + cred + "800 Map hp" + cgray + "]");
        SpiderBossLVL2.setCustomNameVisible(true);
        SpiderBossLVL2.setMaxHealth(800);
        SpiderBossLVL2.setHealth(800);
        SpiderBossLVL2.setTarget(p);
    }

}
