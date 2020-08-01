package net.jameslikeside.main.methods;

import java.sql.ResultSet;
import java.sql.SQLException;

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

public class ScoreboardListener {
	
	public static void setScoreboard(Player p) throws SQLException {
		String uuid = p.getUniqueId().toString();
		Scoreboard scoreboard = new Scoreboard();
		ScoreboardObjective obj = scoreboard.registerObjective("zagd", IScoreboardCriteria.b);
		obj.setDisplayName("§6§lFresh2Play"); 
		PacketPlayOutScoreboardObjective createPacket = new PacketPlayOutScoreboardObjective(obj, 0);
		PacketPlayOutScoreboardDisplayObjective display = new PacketPlayOutScoreboardDisplayObjective(1, obj);
		
		ScoreboardScore a1 = new ScoreboardScore(scoreboard, obj, " ");//1 Line
		ScoreboardScore a2 = new ScoreboardScore(scoreboard, obj, "§f§lMoney:");
		ScoreboardScore a3 = new ScoreboardScore(scoreboard, obj, "§8» §e" + Sb.PlayerCoins(p));//2 Line and so on
		ScoreboardScore a4 = new ScoreboardScore(scoreboard, obj, "§b ");
		ScoreboardScore a5 = new ScoreboardScore(scoreboard, obj, "§f§lLocation:");
		ScoreboardScore a6 = new ScoreboardScore(scoreboard, obj, "§8» §eSoon!");//this will take more time to code
		ScoreboardScore a7 = new ScoreboardScore(scoreboard, obj, "§f ");
		ScoreboardScore a8 = new ScoreboardScore(scoreboard, obj, "§f§lLanguage:");
		ScoreboardScore a9 = new ScoreboardScore(scoreboard, obj, "§8» §e" + Sb.Playerlang(p));

		
		
		a1.setScore(9);
		a2.setScore(8);
		a3.setScore(7);
		a4.setScore(6);
		a5.setScore(5);
		a6.setScore(4);
		a7.setScore(3);
		a8.setScore(2);
		a9.setScore(1);

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

	}
	
	private static void sendPacket(Packet<?> packet, Player p) {
		((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	}
	
}
