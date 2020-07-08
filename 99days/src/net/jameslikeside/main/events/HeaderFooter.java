package net.jameslikeside.main.events;

import java.lang.reflect.Field;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;

public class HeaderFooter {

	public static void sendTablistHeaderAndFooter(final Player player, String header, String footer) {
        if (header == null) {
            header = "";
        }
        if (footer == null) {
            footer = "";
        }
        final IChatBaseComponent tabHeader = IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + header + "\"}");
        final IChatBaseComponent tabFooter = IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + footer + "\"}");
        final PacketPlayOutPlayerListHeaderFooter headerPacket = new PacketPlayOutPlayerListHeaderFooter(tabHeader);
        try {
            final Field field = headerPacket.getClass().getDeclaredField("b");
            field.setAccessible(true);
            field.set(headerPacket, tabFooter);
        }
        catch (Exception e) {
            e.printStackTrace();
            return;
        }
        finally {
            ((CraftPlayer)player).getHandle().playerConnection.sendPacket((Packet)headerPacket);
        }
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket((Packet)headerPacket);
    }
	
}
