package net.jameslikeside.main.API.Money;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.entity.Player;

import net.jameslikeside.main.MySQL;

public class MoneyAddRemoveSetReset {
	
	public static long getCoins(final String UUID) {
        try {
            final PreparedStatement ps = MySQL.connection.prepareStatement("SELECT MoneyFloors FROM floorsSystem WHERE UUID=?");
            ps.setString(1, UUID);
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getLong("MoneyFloors");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public static void setCoins(final String UUID, final long Coins) {
        PreparedStatement st = null;
        try {
            st = MySQL.connection.prepareStatement("UPDATE floorsSystem SET MoneyFloors = ? WHERE UUID = ?");
            st.setString(2, UUID);
            st.setLong(1, Coins);
            st.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void addCoins(final String UUID, final long Coins) {
        final long current = getCoins(UUID);
        setCoins(UUID,Coins + current);
    }
    
    public static void removeCoins(final String UUID, final long Coins) {
        setCoins(UUID, getCoins(UUID) - Coins);
    }
	
}