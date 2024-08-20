package DAO.Impl;

import DAO.EmployeeDao;
import DAO.EmployeeProjectAssignmentDao;
import DBConnection.DBConnection;
import Model.Employee;
import Model.EmployeeProjectAssignment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public boolean addEmployee(Employee employee) {
        try (Connection connection = DBConnection.provideConnection()) {
            String query = "INSERT INTO employee (gpm_id, name, gender, dob, aadhaar_number, address, contact_number, wage_rate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, employee.getGpmId());
            ps.setString(2, employee.getName());
            ps.setString(3, employee.getGender());
            ps.setDate(4, Date.valueOf(employee.getDob()));
            ps.setString(5, employee.getAadhaarNumber());
            ps.setString(6, employee.getAddress());
            ps.setString(7, employee.getContactNumber());
            ps.setBigDecimal(8, employee.getWageRate());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        Employee employee = null;
        try (Connection connection = DBConnection.provideConnection()) {
            String query = "SELECT * FROM employee WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, employeeId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                employee = new Employee(
                        rs.getInt("id"),
                        rs.getInt("gpm_id"),
                        rs.getString("name"),
                        rs.getString("gender"),
                        rs.getDate("dob").toLocalDate(),
                        rs.getString("aadhaar_number"),
                        rs.getString("address"),
                        rs.getString("contact_number"),
                        rs.getBigDecimal("wage_rate")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = DBConnection.provideConnection()) {
            String query = "SELECT * FROM employee";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Employee employee = new Employee(
                        rs.getInt("id"),
                        rs.getInt("gpm_id"),
                        rs.getString("name"),
                        rs.getString("gender"),
                        rs.getDate("dob").toLocalDate(),
                        rs.getString("aadhaar_number"),
                        rs.getString("address"),
                        rs.getString("contact_number"),
                        rs.getBigDecimal("wage_rate")
                );
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        try (Connection connection = DBConnection.provideConnection()) {
            String query = "UPDATE employee SET gpm_id = ?, name = ?, gender = ?, dob = ?, aadhaar_number = ?, address = ?, contact_number = ?, wage_rate = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, employee.getGpmId());
            ps.setString(2, employee.getName());
            ps.setString(3, employee.getGender());
            ps.setDate(4, Date.valueOf(employee.getDob()));
            ps.setString(5, employee.getAadhaarNumber());
            ps.setString(6, employee.getAddress());
            ps.setString(7, employee.getContactNumber());
            ps.setBigDecimal(8, employee.getWageRate());
            ps.setInt(9, employee.getId());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteEmployee(int employeeId) {
        try (Connection connection = DBConnection.provideConnection()) {
            String query = "DELETE FROM employee WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, employeeId);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static class EmployeeProjectAssignmentDaoImpl implements EmployeeProjectAssignmentDao {
        private Connection connection;

        public EmployeeProjectAssignmentDaoImpl() {
            connection = DBConnection.provideConnection();
        }

        @Override
        public boolean addAssignment(EmployeeProjectAssignment assignment) {
            String query = "INSERT INTO EmployeeProjectAssignment (employee_id, project_id, assigned_date, days_worked, wages_earned, status) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setInt(1, assignment.getEmployeeId());
                stmt.setInt(2, assignment.getProjectId());
                stmt.setDate(3, Date.valueOf(assignment.getAssignedDate()));
                stmt.setInt(4, assignment.getDaysWorked());
                stmt.setBigDecimal(5, assignment.getWagesEarned());
                stmt.setString(6, assignment.getStatus());

                return stmt.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override
        public EmployeeProjectAssignment getAssignmentById(int id) {
            String query = "SELECT * FROM EmployeeProjectAssignment WHERE id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    return extractAssignmentFromResultSet(rs);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public List<EmployeeProjectAssignment> getAllAssignments() {
            String query = "SELECT * FROM EmployeeProjectAssignment";
            List<EmployeeProjectAssignment> assignments = new ArrayList<>();

            try (Statement stmt = connection.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                while (rs.next()) {
                    assignments.add(extractAssignmentFromResultSet(rs));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return assignments;
        }

        @Override
        public boolean updateAssignment(EmployeeProjectAssignment assignment) {
            String query = "UPDATE EmployeeProjectAssignment SET employee_id = ?, project_id = ?, assigned_date = ?, days_worked = ?, wages_earned = ?, status = ?, updated_at = CURRENT_TIMESTAMP WHERE id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setInt(1, assignment.getEmployeeId());
                stmt.setInt(2, assignment.getProjectId());
                stmt.setDate(3, Date.valueOf(assignment.getAssignedDate()));
                stmt.setInt(4, assignment.getDaysWorked());
                stmt.setBigDecimal(5, assignment.getWagesEarned());
                stmt.setString(6, assignment.getStatus());
                stmt.setInt(7, assignment.getId());

                return stmt.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override
        public boolean deleteAssignment(int id) {
            String query = "DELETE FROM EmployeeProjectAssignment WHERE id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setInt(1, id);
                return stmt.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        private EmployeeProjectAssignment extractAssignmentFromResultSet(ResultSet rs) throws SQLException {
            return new EmployeeProjectAssignment(
                    rs.getInt("id"),
                    rs.getInt("employee_id"),
                    rs.getInt("project_id"),
                    rs.getDate("assigned_date").toLocalDate(),
                    rs.getInt("days_worked"),
                    rs.getBigDecimal("wages_earned"),
                    rs.getString("status")
            );
        }
    }
}
