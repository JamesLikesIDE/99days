package net.jameslikeside.main.API.Skills;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.jameslikeside.main.MySQL;

public class CombatSkillAPI {

	public static int getCombatSkill(final String UUID) {
        try {
            final PreparedStatement ps = MySQL.connection.prepareStatement("SELECT CombatSkill FROM floorsSystem WHERE UUID=?");
            ps.setString(1, UUID);
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("CombatSkill");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public static void setCombatSkill(final String UUID, final int Level) {
        PreparedStatement st = null;
        try {
            st = MySQL.connection.prepareStatement("UPDATE floorsSystem SET CombatSkill = ? WHERE UUID = ?");
            st.setString(2, UUID);
            st.setInt(1, Level);
            st.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void addCombatSkill(final String UUID, final int Level) {
        final int current = getCombatSkill(UUID);
        setCombatSkill(UUID, Level + current);
    }
    
    public static void removeCombatSkill(final String UUID, final int Level) {
        setCombatSkill(UUID, getCombatSkill(UUID) - Level);
    }
	
}
