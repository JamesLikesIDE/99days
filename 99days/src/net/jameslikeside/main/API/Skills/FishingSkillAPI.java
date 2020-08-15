package net.jameslikeside.main.API.Skills;

import net.jameslikeside.main.MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FishingSkillAPI {

    public static int getFishingSkill(final String UUID) {
        try {
            final PreparedStatement ps = MySQL.connection.prepareStatement("SELECT FishingSkill FROM floorsSystem WHERE UUID=?");
            ps.setString(1, UUID);
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("FishingSkill");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void setFishingSkill(final String UUID, final int Level) {
        PreparedStatement st = null;
        try {
            st = MySQL.connection.prepareStatement("UPDATE floorsSystem SET FishingSkill = ? WHERE UUID = ?");
            st.setString(2, UUID);
            st.setInt(1, Level);
            st.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addFishingSkill(final String UUID, final int Level) {
        final int current = getFishingSkill(UUID);
        setFishingSkill(UUID, Level + current);
    }

    public static void removeFishingSkill(final String UUID, final int Level) {
        setFishingSkill(UUID, getFishingSkill(UUID) - Level);
    }

}
