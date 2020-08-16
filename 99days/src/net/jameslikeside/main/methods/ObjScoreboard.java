package net.jameslikeside.main.methods;

import de.dytanic.cloudnet.api.CloudAPI;
import net.jameslikeside.main.Main;
import net.minecraft.server.v1_8_R3.ScoreboardScore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

import java.sql.SQLException;
import java.text.DecimalFormat;

public class ObjScoreboard {

    public static void setScoreBoard(Player p) throws SQLException {
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = board.registerNewObjective("§6§l99days", "dummy");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score line1 = obj.getScore(" ");
        line1.setScore(11);
        Score line2 = obj.getScore("§f§lMoney:");
        line2.setScore(10);
        Team moneyCounter = board.registerNewTeam("moneyCounter");
        moneyCounter.addEntry(ChatColor.RED + "" + ChatColor.WHITE);
        new BukkitRunnable(){
            @Override
            public void run() {
                if(!p.isOnline()){
                    cancel();
                    return;
                }
                try {
                    double amount1 = Sb.PlayerCoins(p);
                    DecimalFormat formatter1 = new DecimalFormat("#,###");
                    moneyCounter.setPrefix(ChatColor.GRAY + "» " + ChatColor.YELLOW);
                    moneyCounter.setSuffix(ChatColor.YELLOW + formatter1.format(amount1));
                    obj.getScore(ChatColor.RED + "" + ChatColor.WHITE).setScore(9);
                } catch (SQLException throwables1) {
                    throwables1.printStackTrace();
                }
            }
        }.runTaskTimer(Main.instance, 5L, 5L);

        Score line3 = obj.getScore("§b ");
        line3.setScore(8);
        Score line4 = obj.getScore("§f§lLocation:");
        line4.setScore(7);
        Score line5 = obj.getScore("§8» §eSoon!");
        line5.setScore(6);
        Score line6 = obj.getScore("§f ");
        line6.setScore(5);
        Score line7 = obj.getScore("§f§lLanguage:");
        line7.setScore(4);
        try{
            Score line8 = obj.getScore(ChatColor.GRAY + "» " + ChatColor.YELLOW + Sb.Playerlang(p));
            line8.setScore(3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Score line9 = obj.getScore("§6 ");
        line9.setScore(2);
        Score line10 = obj.getScore("§6§nmc.fresh2play.net");
        line10.setScore(1);

        p.setScoreboard(board);
    }

    public static void updateScoreBoard(Player p){
        Scoreboard board = p.getScoreboard();

        try {
            double amount1 = Sb.PlayerCoins(p);
            DecimalFormat formatter1 = new DecimalFormat("#,###");
            board.getTeam("moneyCounter").setPrefix(ChatColor.GRAY + "» " + ChatColor.YELLOW);
            board.getTeam("moneyCounter").setSuffix(ChatColor.YELLOW + formatter1.format(amount1));
        } catch (SQLException throwables1) {
            throwables1.printStackTrace();
        }
    }

}
