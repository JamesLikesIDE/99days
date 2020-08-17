package net.jameslikeside.main.CustomMobs.Boss;

import net.minecraft.server.v1_8_R3.AttributeInstance;
import net.minecraft.server.v1_8_R3.AttributeModifier;
import net.minecraft.server.v1_8_R3.EntityInsentient;
import net.minecraft.server.v1_8_R3.GenericAttributes;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftLivingEntity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Spider;
import org.bukkit.event.EventHandler;

import java.util.UUID;

public class SpiderBossTwo {

    static ChatColor cdred = ChatColor.DARK_RED;
    static ChatColor cred = ChatColor.RED;
    static ChatColor cgray = ChatColor.GRAY;

    private static final UUID movementSpeedUID = UUID.fromString("206a89dc-ae78-4c4d-b42c-3b31db3f5a7c");

    public static void SpiderBossTwo(Location loc, Player p){
        Spider spiderBossLVL1 = (Spider) loc.getWorld().spawnEntity(loc, EntityType.SPIDER);
        spiderBossLVL1.setCustomName(cgray + "[Lvl 2]" +  cdred + " Spider Boss " + cgray + "[" + cred + "800 Max hp" + cgray + "]");
        spiderBossLVL1.setCustomNameVisible(true);
        spiderBossLVL1.setMaxHealth(400);
        spiderBossLVL1.setHealth(400);
        EntityInsentient nmsEntity = (EntityInsentient) ((CraftLivingEntity) spiderBossLVL1).getHandle();
        AttributeInstance attributes = nmsEntity.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED);
        AttributeModifier modifier = new AttributeModifier(movementSpeedUID, "Oasis modifier", 1.0d, 1);
        attributes.a(modifier);
    }
}
