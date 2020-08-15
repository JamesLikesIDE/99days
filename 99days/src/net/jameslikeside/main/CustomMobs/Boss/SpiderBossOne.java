package net.jameslikeside.main.CustomMobs.Boss;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SpiderBossOne {

    static ChatColor cdred = ChatColor.DARK_RED;
    static ChatColor cgray = ChatColor.GRAY;
    static ChatColor cred = ChatColor.RED;


    public static void SpiderBossOne(Location loc, Player p) {
        Spider spiderBossLVL1 = (Spider) loc.getWorld().spawnEntity(loc, EntityType.SPIDER);
        spiderBossLVL1.setCustomName(cgray + "[Lvl 1]" +  cdred + " Spider Boss " + cgray + "[" + cred + "400 Max hp" + cgray + "]");
        spiderBossLVL1.setCustomNameVisible(true);
        spiderBossLVL1.setMaxHealth(400);
        spiderBossLVL1.setHealth(400);
        spiderBossLVL1.setTarget(p);
    }
}
