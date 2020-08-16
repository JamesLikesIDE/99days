package net.jameslikeside.main.methods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import de.dytanic.cloudnet.api.CloudAPI;
import net.jameslikeside.main.Main;
import net.minecraft.server.v1_8_R3.IScoreboardCriteria;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardDisplayObjective;
import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardObjective;
import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardScore;
import net.minecraft.server.v1_8_R3.Scoreboard;
import net.minecraft.server.v1_8_R3.ScoreboardObjective;
import net.minecraft.server.v1_8_R3.ScoreboardScore;
import org.bukkit.scheduler.BukkitRunnable;

public class ScoreboardListener {
	
	public static void setScoreboard(Player p) throws SQLException {
		String uuid = p.getUniqueId().toString();
		Scoreboard scoreboard = new Scoreboard();
		ScoreboardObjective obj = scoreboard.registerObjective("zagd", IScoreboardCriteria.b);
		obj.setDisplayName("§6§l99Days");
		PacketPlayOutScoreboardObjective createPacket = new PacketPlayOutScoreboardObjective(obj, 0);
		PacketPlayOutScoreboardDisplayObjective display = new PacketPlayOutScoreboardDisplayObjective(1, obj);

		ScoreboardScore a1 = new ScoreboardScore(scoreboard, obj, " ");//1 Line
		ScoreboardScore a2 = new ScoreboardScore(scoreboard, obj, "§f§lMoney:");
		ScoreboardScore a3 = null;//2 Line and so on
		try {
			double amount1 = Sb.PlayerCoins(p);
			DecimalFormat formatter1 = new DecimalFormat("#,###");
			a3 = new ScoreboardScore(scoreboard, obj, "§8» §e" + formatter1.format(amount1));
		} catch (SQLException throwables1) {
			throwables1.printStackTrace();
		}
		ScoreboardScore a4 = new ScoreboardScore(scoreboard, obj, "§b ");
		ScoreboardScore a5 = new ScoreboardScore(scoreboard, obj, "§f§lLocation:");
		ScoreboardScore a6 = new ScoreboardScore(scoreboard, obj, "§8» §eSoon!");//this will take more time to code
		ScoreboardScore a7 = new ScoreboardScore(scoreboard, obj, "§f ");
		ScoreboardScore a8 = new ScoreboardScore(scoreboard, obj, "§f§lLanguage:");
		ScoreboardScore a9 = null;
		try {
			a9 = new ScoreboardScore(scoreboard, obj, "§8» §e" + Sb.Playerlang(p));
		} catch (SQLException throwables2) {
			throwables2.printStackTrace();
		}
		ScoreboardScore a10 = new ScoreboardScore(scoreboard, obj, "§6 ");
		ScoreboardScore a11 = new ScoreboardScore(scoreboard, obj, "§6§nmc.fresh2play.net");



		a1.setScore(11);
		a2.setScore(10);
		a3.setScore(9);
		a4.setScore(8);
		a5.setScore(7);
		a6.setScore(6);
		a7.setScore(5);
		a8.setScore(4);
		a9.setScore(3);
		a10.setScore(2);
		a11.setScore(1);

		PacketPlayOutScoreboardObjective removePacket = new PacketPlayOutScoreboardObjective(obj, 1);
		PacketPlayOutScoreboardScore pa1 = new PacketPlayOutScoreboardScore(a1);
		PacketPlayOutScoreboardScore pa2 = new PacketPlayOutScoreboardScore(a2);
		PacketPlayOutScoreboardScore pa3 = new PacketPlayOutScoreboardScore(a3);
		PacketPlayOutScoreboardScore pa4 = new PacketPlayOutScoreboardScore(a4);
		PacketPlayOutScoreboardScore pa5 = new PacketPlayOutScoreboardScore(a5);
		PacketPlayOutScoreboardScore pa6 = new PacketPlayOutScoreboardScore(a6);
		PacketPlayOutScoreboardScore pa7 = new PacketPlayOutScoreboardScore(a7);
		PacketPlayOutScoreboardScore pa8 = new PacketPlayOutScoreboardScore(a8);
		PacketPlayOutScoreboardScore pa9 = new PacketPlayOutScoreboardScore(a9);
		PacketPlayOutScoreboardScore pa10 = new PacketPlayOutScoreboardScore(a10);
		PacketPlayOutScoreboardScore pa11 = new PacketPlayOutScoreboardScore(a11);

		sendPacket(removePacket, p);
		sendPacket(createPacket, p);
		sendPacket(display, p);

		sendPacket(pa1, p);
		sendPacket(pa2, p);
		sendPacket(pa3, p);
		sendPacket(pa4, p);
		sendPacket(pa5, p);
		sendPacket(pa6, p);
		sendPacket(pa7, p);
		sendPacket(pa8, p);
		sendPacket(pa9, p);
		sendPacket(pa10, p);
		sendPacket(pa11, p);
	}
	
	private static void sendPacket(Packet<?> packet, Player p) {
		((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	}
	
}
