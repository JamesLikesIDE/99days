package net.jameslikeside.main.API.Skills;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.jameslikeside.main.MySQL;

public class DefenceSkillAPI {

	public static int getDefenceSkill(final String UUID) {
        try {
            final PreparedStatement ps = MySQL.connection.prepareStatement("SELECT DefenceSkill FROM floorsSystem WHERE UUID=?");
            ps.setString(1, UUID);
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("DefenceSkill");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public static void setDefenceSkill(final String UUID, final int Level) {
        PreparedStatement st = null;
        try {
            st = MySQL.connection.prepareStatement("UPDATE floorsSystem SET DefenceSkill = ? WHERE UUID = ?");
            st.setString(2, UUID);
            st.setInt(1, Level);
            st.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void addDefenceSkill(final String UUID, final int Level) {
        final int current = getDefenceSkill(UUID);
        setDefenceSkill(UUID, Level + current);
    }
    
    public static void removeCombatSkill(final String UUID, final int Level) {
        setDefenceSkill(UUID, getDefenceSkill(UUID) - Level);
    }
	
}
