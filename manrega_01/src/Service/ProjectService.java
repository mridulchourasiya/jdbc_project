package Service;

import DAO.Impl.ProjectDaoImpl;
import DAO.ProjectDao;
import Model.Project;

import java.util.List;

public class ProjectService {
    private final ProjectDao projectDao;

    public ProjectService() {
        this.projectDao = new ProjectDaoImpl();
    }


    public boolean addProject(Project project) {
        return projectDao.addProject(project);
    }

    public Project getProjectById(int projectId) {
        return projectDao.getProjectById(projectId);
    }

    public List<Project> getAllProjects() {
        return projectDao.getAllProjects();
    }

    public boolean updateProject(Project project) {
        return projectDao.updateProject(project);
    }

    public boolean deleteProject(int projectId) {
        return projectDao.deleteProject(projectId);
    }
}
