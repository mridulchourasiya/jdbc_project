package DAO.Impl;

import DAO.GramPanchayatMemberDao;
import DBConnection.DBConnection;
import Model.GramPanchayatMember;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GramPanchayatMemberDaoImpl implements GramPanchayatMemberDao {

    @Override
    public GramPanchayatMember getMemberById(int id) {
        GramPanchayatMember member = null;
        try (Connection con = DBConnection.provideConnection()) {
            String query = "SELECT * FROM GramPanchayatMember WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                member = new GramPanchayatMember(
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return member;
    }

    @Override
    public GramPanchayatMember getMemberByEmail(String email) {
        GramPanchayatMember member = null;
        try (Connection con = DBConnection.provideConnection()) {
            String query = "SELECT * FROM GramPanchayatMember WHERE email = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                member = new GramPanchayatMember(
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return member;
    }

    @Override
    public List<GramPanchayatMember> getAllMembers() {
        List<GramPanchayatMember> memberList = new ArrayList<>();
        try (Connection con = DBConnection.provideConnection()) {
            String query = "SELECT * FROM grampanchayatmember";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                GramPanchayatMember member = new GramPanchayatMember(
                );
                memberList.add(member);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return memberList;
    }

    @Override
    public boolean addMember(GramPanchayatMember member) {
        boolean added = false;
        try (Connection con = DBConnection.provideConnection()) {
            String query = "INSERT INTO GramPanchayatMember (name, email, password, contact_number, address, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, member.getName());
            ps.setString(2, member.getEmail());
            ps.setString(3, member.getPassword());
            ps.setString(4, member.getContactNumber());
            ps.setString(5, member.getAddress());
            ps.setTimestamp(6, Timestamp.valueOf(member.getCreatedAt()));
            ps.setTimestamp(7, Timestamp.valueOf(member.getUpdatedAt()));

            added = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return added;
    }

    @Override
    public boolean updateMember(GramPanchayatMember member) {
        boolean updated = false;
        try (Connection con = DBConnection.provideConnection()) {
            String query = "UPDATE GramPanchayatMember SET name = ?, email = ?, password = ?, contact_number = ?, address = ?, updated_at = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, member.getName());
            ps.setString(2, member.getEmail());
            ps.setString(3, member.getPassword());
            ps.setString(4, member.getContactNumber());
            ps.setString(5, member.getAddress());
            ps.setTimestamp(6, Timestamp.valueOf(member.getUpdatedAt()));
            ps.setInt(7, member.getId());

            updated = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updated;
    }

    @Override
    public boolean deleteMember(int id) {
        boolean deleted = false;
        try (Connection con = DBConnection.provideConnection()) {
            String query = "DELETE FROM GramPanchayatMember WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            deleted = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deleted;
    }
}
