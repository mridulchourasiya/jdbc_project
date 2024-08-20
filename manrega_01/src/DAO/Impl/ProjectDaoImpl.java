package DAO.Impl;

import DAO.ProjectDao;
import DBConnection.DBConnection;
import Model.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDaoImpl implements ProjectDao {

    @Override
    public boolean addProject(Project project) {
        try (Connection connection = DBConnection.provideConnection()) {
            String query = "INSERT INTO Project (bdo_id, name, description, budget, start_date, end_date, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, project.getBdoId());
            ps.setString(2, project.getProjectName());
            ps.setString(3, project.getProjectDescription());
            ps.setBigDecimal(4, project.getBudget());
            ps.setDate(5, Date.valueOf(project.getStartDate()));
            ps.setDate(6, Date.valueOf(project.getEndDate()));
            ps.setString(7, project.getStatus());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error adding project: " + e.getMessage());
        }
        return false;
    }

    @Override
    public Project getProjectById(int projectId) {
        Project project = null;
        try (Connection connection = DBConnection.provideConnection()) {
            String query = "SELECT * FROM Project WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, projectId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                project = new Project(
                        rs.getInt("id"),
                        rs.getInt("bdo_id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getBigDecimal("budget"),
                        rs.getDate("start_date").toLocalDate(),
                        rs.getDate("end_date").toLocalDate(),
                        rs.getString("status"));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving project by ID: " + e.getMessage());
        }
        return project;
    }

    @Override
    public List<Project> getAllProjects() {
        List<Project> projects = new ArrayList<>();
        try (Connection connection = DBConnection.provideConnection()) {
            String query = "SELECT * FROM Project";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Project project = new Project(
                        rs.getInt("id"),
                        rs.getInt("bdo_id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getBigDecimal("budget"),
                        rs.getDate("start_date").toLocalDate(),
                        rs.getDate("end_date").toLocalDate(),
                        rs.getString("status"));
                projects.add(project);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving all projects: " + e.getMessage());
        }
        return projects;
    }

    @Override
    public boolean updateProject(Project project) {
        try (Connection connection = DBConnection.provideConnection()) {
            String query = "UPDATE Project SET bdo_id = ?, name = ?, description = ?, budget = ?, start_date = ?, end_date = ?, status = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, project.getBdoId());
            ps.setString(2, project.getProjectName());
            ps.setString(3, project.getProjectDescription());
            ps.setBigDecimal(4, project.getBudget());
            ps.setDate(5, Date.valueOf(project.getStartDate()));
            ps.setDate(6, Date.valueOf(project.getEndDate()));
            ps.setString(7, project.getStatus());
            ps.setInt(8, project.getProjectId());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error updating project: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteProject(int projectId) {
        try (Connection connection = DBConnection.provideConnection()) {
            String query = "DELETE FROM Project WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, projectId);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error deleting project: " + e.getMessage());
        }
        return false;
    }
}
