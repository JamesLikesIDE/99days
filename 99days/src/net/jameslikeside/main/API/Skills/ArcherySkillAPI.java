package net.jameslikeside.main.API.Skills;

import net.jameslikeside.main.MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArcherySkillAPI {

    public static int getArcherySkill(final String UUID) {
        try {
            final PreparedStatement ps = MySQL.connection.prepareStatement("SELECT ArcherySkill FROM floorsSystem WHERE UUID=?");
            ps.setString(1, UUID);
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("ArcherySkill");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void setArcherySkill(final String UUID, final int Level) {
        PreparedStatement st = null;
        try {
            st = MySQL.connection.prepareStatement("UPDATE floorsSystem SET ArcherySkill = ? WHERE UUID = ?");
            st.setString(2, UUID);
            st.setInt(1, Level);
            st.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addArcherySkill(final String UUID, final int Level) {
        final int current = getArcherySkill(UUID);
        setArcherySkill(UUID, Level + current);
    }

    public static void removeArcherySkill(final String UUID, final int Level) {
        setArcherySkill(UUID, getArcherySkill(UUID) - Level);
    }

}
