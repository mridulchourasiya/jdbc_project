package DAO.Impl;

import DAO.BDODao;
import DBConnection.DBConnection;
import Model.BDO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BDODaoImpl implements BDODao {

    @Override
    public BDO getBDOById(int id) {
        BDO bdo = null;
        try (Connection con = DBConnection.provideConnection()) {
            String query = "SELECT * FROM BDO WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                bdo = new BDO();
                bdo.setId(rs.getInt("id"));
                bdo.setName(rs.getString("name"));
                bdo.setEmail(rs.getString("email"));
                bdo.setPassword(rs.getString("password"));
                bdo.setContactNumber(rs.getString("contact_number"));
                bdo.setAddress(rs.getString("address"));
                bdo.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                bdo.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bdo;
    }

    @Override
    public BDO getBDOByEmail(String email) {
        BDO bdo = null;
        try (Connection con = DBConnection.provideConnection()) {
            String query = "SELECT * FROM BDO WHERE email = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                bdo = new BDO();
                bdo.setId(rs.getInt("id"));
                bdo.setName(rs.getString("name"));
                bdo.setEmail(rs.getString("email"));
                bdo.setPassword(rs.getString("password"));
                bdo.setContactNumber(rs.getString("contact_number"));
                bdo.setAddress(rs.getString("address"));
                bdo.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                bdo.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bdo;
    }

    @Override
    public List<BDO> getAllBDOs() {
        List<BDO> bdoList = new ArrayList<>();
        try (Connection con = DBConnection.provideConnection()) {
            String query = "SELECT * FROM bdo";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BDO bdo = new BDO();
                bdo.setId(rs.getInt("id"));
                bdo.setName(rs.getString("name"));
                bdo.setEmail(rs.getString("email"));
                bdo.setPassword(rs.getString("password"));
                bdo.setContactNumber(rs.getString("contact_number"));
                bdo.setAddress(rs.getString("address"));
                bdo.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                bdo.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
                bdoList.add(bdo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bdoList;
    }

    @Override
    public boolean addBDO(BDO bdo) {
        boolean added = false;
        try (Connection con = DBConnection.provideConnection()) {
            String query = "INSERT INTO BDO (name, email, password, contact_number, address, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, bdo.getName());
            ps.setString(2, bdo.getEmail());
            ps.setString(3, bdo.getPassword());
            ps.setString(4, bdo.getContactNumber());
            ps.setString(5, bdo.getAddress());
            ps.setTimestamp(6, Timestamp.valueOf(bdo.getCreatedAt()));
            ps.setTimestamp(7, Timestamp.valueOf(bdo.getUpdatedAt()));
            added = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return added;
    }

    @Override
    public boolean updateBDO(BDO bdo) {

        boolean updated = false;
        try (Connection con = DBConnection.provideConnection()) {
            String query = "UPDATE BDO SET name = ?, email = ?, password = ?, contact_number = ?, address = ?, updated_at = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, bdo.getName());
            ps.setString(2, bdo.getEmail());
            ps.setString(3, bdo.getPassword());
            ps.setString(4, bdo.getContactNumber());
            ps.setString(5, bdo.getAddress());
            ps.setTimestamp(6, Timestamp.valueOf(bdo.getUpdatedAt()));
            ps.setInt(7, bdo.getId());
            updated = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updated;
    }

    @Override
    public boolean deleteBDO(int id) {
        boolean deleted = false;
        try (Connection con = DBConnection.provideConnection()) {
            String query = "DELETE FROM BDO WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            deleted = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deleted;
    }
}
