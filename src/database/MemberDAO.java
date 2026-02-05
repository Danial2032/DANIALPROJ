package database;

import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    /* =========================================================
       CREATE
       ========================================================= */

    public boolean addMember(Member member) {

        String sql = "INSERT INTO mem(name, fee, experience, type) VALUES(?,?,?,?)";

        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) return false;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, member.getName());
            ps.setDouble(2, member.getFee());
            ps.setInt(3, member.getExperience());
            ps.setString(4, member.getType());

            int rows = ps.executeUpdate();
            ps.close();

            if (rows > 0) {
                System.out.println("✅ Member added!");
                return true;
            }

        } catch (SQLException e) {
            System.out.println("❌ Insert failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        }

        return false;
    }


    /* =========================================================
       READ ALL
       ========================================================= */

    public List<Member> getAllMembers() {

        List<Member> list = new ArrayList<>();

        String sql = "SELECT * FROM mem";

        Connection conn = DatabaseConnection.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(buildMember(rs));
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        }

        return list;
    }


    /* =========================================================
       SELECT BY ID
       ========================================================= */

    public Member getMemberById(int id) {

        String sql = "SELECT * FROM mem WHERE id=?";

        Connection conn = DatabaseConnection.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Member m = buildMember(rs);
                rs.close();
                ps.close();
                return m;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        }

        return null;
    }


    /* =========================================================
       UPDATE
       ========================================================= */

    public boolean updateMember(Member member) {

        String sql = "UPDATE mem SET name=?, fee=?, experience=? WHERE id=?";

        Connection conn = DatabaseConnection.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, member.getName());
            ps.setDouble(2, member.getFee());
            ps.setInt(3, member.getExperience());
            ps.setInt(4, member.getId());

            int rows = ps.executeUpdate();
            ps.close();

            if (rows > 0) {
                System.out.println("✅ Member updated!");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        }

        return false;
    }


    /* =========================================================
       DELETE
       ========================================================= */

    public boolean deleteMember(int id) {

        String sql = "DELETE FROM mem WHERE id=?";

        Connection conn = DatabaseConnection.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            ps.close();

            if (rows > 0) {
                System.out.println("✅ Member deleted!");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        }

        return false;
    }


    /* =========================================================
       SEARCH
       ========================================================= */

    public void searchByName(String name) {

        String sql = "SELECT * FROM mem WHERE name ILIKE ?";

        Connection conn = DatabaseConnection.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(buildMember(rs));
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
    }


    public void searchByFeeRange(double min, double max) {

        String sql = "SELECT * FROM mem WHERE fee BETWEEN ? AND ?";

        Connection conn = DatabaseConnection.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, min);
            ps.setDouble(2, max);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(buildMember(rs));
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
    }


    public void getHighFeeMembers(double min) {
        searchByFeeRange(min, Double.MAX_VALUE);
    }


    /* =========================================================
       POLYMORPHISM
       ========================================================= */

    public void polymorphismDemo() {

        for (Member m : getAllMembers()) {
            System.out.println(m.getType() + " → " + m.getName());
        }
    }


    /* =========================================================
       HELPER
       ========================================================= */

    private Member buildMember(ResultSet rs) throws SQLException {

        int id = rs.getInt("id");
        String name = rs.getString("name");
        double fee = rs.getDouble("fee");
        int exp = rs.getInt("experience");
        String type = rs.getString("type");

        if ("student".equalsIgnoreCase(type))
            return new StudentMember(id, name, fee, exp);
        else
            return new PremiumMember(id, name, fee, exp);
    }
}