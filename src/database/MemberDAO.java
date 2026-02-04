package database;

import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    /* ================= CREATE ================= */
    public void addMember(Member member) throws Exception {

        String sql =
                "INSERT INTO mem(name, fee, experience, type) VALUES(?,?,?,?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, member.getName());
            ps.setDouble(2, member.getFee());
            ps.setInt(3, member.getExperience());
            ps.setString(4, member.getType());

            ps.executeUpdate();
        }
    }

    /* ================= READ ALL ================= */
    public List<Member> getAllMembers() throws Exception {

        List<Member> list = new ArrayList<>();

        String sql = "SELECT * FROM mem";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(buildMember(rs));
            }
        }

        return list;
    }

    /* ================= SELECT BY ID ================= */
    public Member getMemberById(int id) throws Exception {

        String sql = "SELECT * FROM mem WHERE id=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildMember(rs);
            }
        }

        return null;
    }

    /* ================= SEARCH ================= */
    public List<Member> searchByName(String keyword) throws Exception {

        List<Member> list = new ArrayList<>();

        String sql =
                "SELECT * FROM mem WHERE LOWER(name) LIKE LOWER(?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(buildMember(rs));
            }
        }

        return list;
    }

    /* ================= UPDATE ================= */
    public void updateMember(Member member) throws Exception {

        String sql =
                "UPDATE mem SET name=?, fee=?, experience=?, type=? WHERE id=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, member.getName());
            ps.setDouble(2, member.getFee());
            ps.setInt(3, member.getExperience());
            ps.setString(4, member.getType());
            ps.setInt(5, member.getId());

            ps.executeUpdate();
        }
    }

    /* ================= DELETE ================= */
    public void deleteMember(int id) throws Exception {

        String sql = "DELETE FROM mem WHERE id=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    /* ================= HELPER ================= */
    private Member buildMember(ResultSet rs) throws Exception {

        int id = rs.getInt("id");
        String name = rs.getString("name");
        double fee = rs.getDouble("fee");
        int exp = rs.getInt("experience");
        String type = rs.getString("type");

        if (type.equals("STUDENT")) {
            return new StudentMember(id, name, fee, exp);
        } else {
            return new PremiumMember(id, name, fee, exp);
        }
    }
    }