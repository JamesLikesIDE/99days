package net.jameslikeside.main.API.Skills;

import net.jameslikeside.main.MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CookingSkillAPI {

    public static int getCookingSkill(final String UUID) {
        try {
            final PreparedStatement ps = MySQL.connection.prepareStatement("SELECT CookingSkill FROM floorsSystem WHERE UUID=?");
            ps.setString(1, UUID);
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("CookingSkill");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void setCookingSkill(final String UUID, final int Level) {
        PreparedStatement st = null;
        try {
            st = MySQL.connection.prepareStatement("UPDATE floorsSystem SET CookingSkill = ? WHERE UUID = ?");
            st.setString(2, UUID);
            st.setInt(1, Level);
            st.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addCookingSkill(final String UUID, final int Level) {
        final int current = getCookingSkill(UUID);
        setCookingSkill(UUID, Level + current);
    }

    public static void removeCookingSkill(final String UUID, final int Level) {
        setCookingSkill(UUID, getCookingSkill(UUID) - Level);
    }

}
