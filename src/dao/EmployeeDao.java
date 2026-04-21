package dao;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import model.Employee;

public interface EmployeeDao {
    List<Employee> getAllEmployees() throws IOException;
    Optional<Employee> getEmployeeById(int id) throws IOException;
    Employee addEmployee(Employee employee) throws IOException;
    Employee updateEmployee(Employee employee) throws IOException;
    boolean deleteEmployee(int id) throws IOException;
}
