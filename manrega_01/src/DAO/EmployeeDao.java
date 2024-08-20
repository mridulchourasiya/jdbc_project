package DAO;

import Model.Employee;

import java.util.List;

public interface EmployeeDao {
    boolean addEmployee(Employee employee);

    Employee getEmployeeById(int employeeId);

    List<Employee> getAllEmployees();

    boolean updateEmployee(Employee employee);

    boolean deleteEmployee(int employeeId);
}
