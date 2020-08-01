package net.jameslikeside.main.API.Money;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.entity.Player;

import net.jameslikeside.main.MySQL;

public class MoneyAddRemoveSetReset {
	
	public static int getCoins(final String UUID) {
        try {
            final PreparedStatement ps = MySQL.connection.prepareStatement("SELECT MoneyFloors FROM floorsSystem WHERE UUID=?");
            ps.setString(1, UUID);
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("MoneyFloors");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public static void setCoins(final String UUID, final int Coins) {
        PreparedStatement st = null;
        try {
            st = MySQL.connection.prepareStatement("UPDATE floorsSystem SET MoneyFloors = ? WHERE UUID = ?");
            st.setString(2, UUID);
            st.setInt(1, Coins);
            st.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void addCoins(final String UUID, final int Coins) {
        final int current = getCoins(UUID);
        setCoins(UUID, Coins + current);
    }
    
    public static void removeCoins(final String UUID, final int Coins) {
        setCoins(UUID, getCoins(UUID) - Coins);
    }
	
}