package net.jameslikeside.main.API.Money;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.entity.Player;

import net.jameslikeside.main.*;
import net.jameslikeside.main.data.*;

public class MoneyAPI {

	public static void removecoins(final Player p, final int moneyFloors) throws SQLException {
        final String uuid = p.getUniqueId().toString();
        final ResultSet rs = Main.mysql.GetResult("SELECT * FROM florrsSystem WHERE uuid='" + uuid + "'");
        if (rs.next()) {
            final int geld = rs.getInt("moneyFloors");
            final int neu = geld - moneyFloors;
            Main.mysql.ExecuteCommand("UPDATE florrsSystem SET coins='" + neu + "' WHERE uuid='" + uuid + "'");
        }
        else {
            p.sendMessage(String.valueOf(Data.GamePrefix) + "§cNo connection to database.");
        }
    }
	
	public static int havecoins(final Player p) throws SQLException {
        final String uuid = p.getUniqueId().toString();
        final ResultSet rs = Main.mysql.GetResult("SELECT * FROM florrsSystem WHERE uuid='" + uuid + "'");
        if (rs.next()) {
            final int geld = rs.getInt("moneyFloors");
            return geld;
        }
        p.sendMessage(String.valueOf(Data.GamePrefix) + "§cNo connection to database.");
        return 0;
    }
	
}
