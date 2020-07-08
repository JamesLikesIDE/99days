package net.jameslikeside.main.events;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.jameslikeside.main.MySQL;

public class MoneyAddRemoveSetReset {
	
	public static int getCoins(String UUID) {
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("SELECT moneyFloors FROM floorsSystem WHERE UUID=?"); // you gotta change the Names
			ps.setString(1, UUID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt("moneyFloors");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static void setCoins(String UUID, int Coins) {
		if(getCoins(UUID) == 0) {
			try {
				PreparedStatement ps = MySQL.connection.prepareStatement("INSERT INTO floorsSystem (UUID,moneyFloors) VALUES (?,?)");
				ps.setString(1, UUID);
				ps.setInt(2, Coins);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else{
            PreparedStatement st = null;
            try {
                st = MySQL.connection.prepareStatement("UPDATE floorsSystem SET moneyFloors = ? WHERE UUID = ?");
                st.setString(2, UUID);
                st.setInt(1, Coins);
                st.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}
	
	public void addCoins(String UUID, int Coins) {
        int current = getCoins(UUID);
        setCoins(UUID, Coins + current);
		
	}

	public void removeCoins(String UUID, int Coins) {
		setCoins(UUID, getCoins(UUID) - Coins);
	}
	
}