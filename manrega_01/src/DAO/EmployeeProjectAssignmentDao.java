package DAO;

import Model.EmployeeProjectAssignment;

import java.util.List;

public interface EmployeeProjectAssignmentDao {
    boolean addAssignment(EmployeeProjectAssignment assignment);

    EmployeeProjectAssignment getAssignmentById(int id);

    List<EmployeeProjectAssignment> getAllAssignments();

    boolean updateAssignment(EmployeeProjectAssignment assignment);

    boolean deleteAssignment(int id);
}
