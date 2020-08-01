package net.jameslikeside.main.CustomMobs.Boss;

import net.minecraft.server.v1_8_R3.EntityHuman;
import net.minecraft.server.v1_8_R3.EntitySpider;
import net.minecraft.server.v1_8_R3.IAttribute;
import net.minecraft.server.v1_8_R3.PathfinderGoalNearestAttackableTarget;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SpiderBossOne {

    static ChatColor cdred = ChatColor.DARK_RED;
    static ChatColor cgray = ChatColor.GRAY;
    static ChatColor cred = ChatColor.RED;


    public static void SpiderBossOne(Location loc, Player p) {
        Spider spiderBossLVL1 = (Spider) loc.getWorld().spawnEntity(loc, EntityType.SPIDER);
        ItemStack diasword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta diameta = diasword.getItemMeta();
        diameta.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
        diasword.setItemMeta(diameta);
        spiderBossLVL1.setCustomName(cgray + "[Lvl 1]" +  cdred + " Spider Boss " + cgray + "[" + cred + "400hp" + cgray + "]");
        spiderBossLVL1.setCustomNameVisible(true);
        spiderBossLVL1.setMaxHealth(400);
        spiderBossLVL1.setHealth(400);
        spiderBossLVL1.setTarget(p);
        spiderBossLVL1.getLastDamage();
    }
}
