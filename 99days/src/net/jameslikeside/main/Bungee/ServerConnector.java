package net.jameslikeside.main.Bungee;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import net.jameslikeside.main.Main;

public class ServerConnector{
	public static void connect(final String server, final Player p) {
        final ByteArrayDataOutput data = ByteStreams.newDataOutput();
        data.writeUTF("Connect");
        data.writeUTF(server);
        p.sendPluginMessage((Plugin)Main.getInstance(), "BungeeCord", data.toByteArray());
    }
}
