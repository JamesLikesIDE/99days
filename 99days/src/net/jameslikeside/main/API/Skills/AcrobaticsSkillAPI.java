package net.jameslikeside.main.API.Skills;

import net.jameslikeside.main.MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AcrobaticsSkillAPI {

    public static int getAcrobaticsSkill(final String UUID) {
        try {
            final PreparedStatement ps = MySQL.connection.prepareStatement("SELECT AcrobaticsSkill FROM floorsSystem WHERE UUID=?");
            ps.setString(1, UUID);
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("AcrobaticsSkill");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void setAcrobaticsSkill(final String UUID, final int Level) {
        PreparedStatement st = null;
        try {
            st = MySQL.connection.prepareStatement("UPDATE floorsSystem SET AcrobaticsSkill = ? WHERE UUID = ?");
            st.setString(2, UUID);
            st.setInt(1, Level);
            st.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addAcrobaticsSkill(final String UUID, final int Level) {
        final int current = getAcrobaticsSkill(UUID);
        setAcrobaticsSkill(UUID, Level + current);
    }

    public static void removeAcrobaticsSkill(final String UUID, final int Level) {
        setAcrobaticsSkill(UUID, getAcrobaticsSkill(UUID) - Level);
    }

}
