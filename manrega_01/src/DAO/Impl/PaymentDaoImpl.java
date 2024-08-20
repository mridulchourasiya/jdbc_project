package DAO.Impl;

import DAO.PaymentDao;
import DBConnection.DBConnection;
import Model.Payment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PaymentDaoImpl implements PaymentDao {


    @Override
    public boolean addPayment(Payment payment) {
        try (Connection connection = DBConnection.provideConnection()) {
            String query = "INSERT INTO Payment (employee_id, payment_date, amount, status, payment_mode) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, payment.getEmployeeId());
            ps.setDate(2, Date.valueOf(payment.getPaymentDate()));
            ps.setBigDecimal(3, payment.getAmount());
            ps.setString(4, payment.getStatus());
            ps.setString(5, payment.getPaymentMode());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public Payment getPaymentById(int id) {
        try (Connection connection = DBConnection.provideConnection()) {
            String query = "SELECT * FROM Payment WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Payment(
                        rs.getInt("id"),
                        rs.getInt("employee_id"),
                        rs.getDate("payment_date").toLocalDate(),
                        rs.getBigDecimal("amount"),
                        rs.getString("status"),
                        rs.getString("payment_mode")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Payment> getAllPayment() {
        List<Payment> payments = new ArrayList<>();
        try (Connection connection = DBConnection.provideConnection()) {
            String query = "SELECT * FROM Payments";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Payment payment = new Payment(
                        rs.getInt("id"),
                        rs.getInt("employee_id"),
                        rs.getDate("payment_date").toLocalDate(),
                        rs.getBigDecimal("amount"),
                        rs.getString("status"),
                        rs.getString("payment_mode")
                );
                payments.add(payment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payments;
    }

    @Override
    public boolean updatePayment(Payment payment) {
        try (Connection connection = DBConnection.provideConnection()) {
            String query = "UPDATE Payment SET employee_id = ?, payment_date = ?, amount = ?, status = ?, payment_mode = ?, updated_at = CURRENT_TIMESTAMP WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, payment.getEmployeeId());
            ps.setDate(2, Date.valueOf(payment.getPaymentDate()));
            ps.setBigDecimal(3, payment.getAmount());
            ps.setString(4, payment.getStatus());
            ps.setString(5, payment.getPaymentMode());
            ps.setInt(6, payment.getId());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deletePayment(int id) {
        try (Connection connection = DBConnection.provideConnection()) {
            String query = "DELETE FROM Payment WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
