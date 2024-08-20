package DAO;

import Model.Project;

import java.util.List;

public interface ProjectDao {
    boolean addProject(Project project);

    Project getProjectById(int projectId);

    List<Project> getAllProjects();

    boolean updateProject(Project project);

    boolean deleteProject(int projectId);
}
