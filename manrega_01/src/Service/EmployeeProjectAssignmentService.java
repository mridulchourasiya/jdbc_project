package Service;

import DAO.EmployeeProjectAssignmentDao;
import DAO.Impl.EmployeeDaoImpl;
import Model.EmployeeProjectAssignment;

import java.util.List;

public class EmployeeProjectAssignmentService {
    private EmployeeProjectAssignmentDao assignmentDao;

    public EmployeeProjectAssignmentService() {
        this.assignmentDao = new EmployeeDaoImpl.EmployeeProjectAssignmentDaoImpl();
    }

    // Add a new employee project assignment
    public boolean addAssignment(EmployeeProjectAssignment assignment) {
        return assignmentDao.addAssignment(assignment);
    }

    // Get an assignment by its ID
    public EmployeeProjectAssignment getAssignmentById(int id) {
        return assignmentDao.getAssignmentById(id);
    }

    // Get all assignments
    public List<EmployeeProjectAssignment> getAllAssignments() {
        return assignmentDao.getAllAssignments();
    }

    // Update an existing assignment
    public boolean updateAssignment(EmployeeProjectAssignment assignment) {
        return assignmentDao.updateAssignment(assignment);
    }

    // Delete an assignment by its ID
    public boolean deleteAssignment(int id) {
        return assignmentDao.deleteAssignment(id);
    }
}
