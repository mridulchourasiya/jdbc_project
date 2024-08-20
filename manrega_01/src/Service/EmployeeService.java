package Service;

import DAO.EmployeeDao;
import DAO.Impl.EmployeeDaoImpl;
import Model.Employee;

import java.util.List;

public class EmployeeService {

    private final EmployeeDao employeeDao;

    public EmployeeService() {
        this.employeeDao = new EmployeeDaoImpl();
    }


    public boolean addEmployee(Employee employee) {
        return employeeDao.addEmployee(employee);
    }

    public Employee getEmployeeById(int id) {
        return employeeDao.getEmployeeById(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    public boolean updateEmployee(Employee employee) {
        return employeeDao.updateEmployee(employee);
    }

    public boolean deleteEmployee(int id) {
        return employeeDao.deleteEmployee(id);
    }


}
