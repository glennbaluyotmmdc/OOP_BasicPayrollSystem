package service;

import dao.EmployeeDao;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import model.Employee;
import model.EmployeeType;
import model.RegularEmployee;

public class PayrollService {
    private final EmployeeDao employeeDao;

    public PayrollService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<Employee> getAllEmployees() throws IOException {
        return employeeDao.getAllEmployees();
    }

    public Optional<Employee> getEmployeeById(int id) throws IOException {
        return employeeDao.getEmployeeById(id);
    }

    public Employee addEmployee(String name, String email, double salary, double allowance) throws IOException {
        validateEmployeeInput(name, email, salary, allowance);
        int nextId = generateNextId();
        Employee employee = new RegularEmployee(nextId, name.trim(), email.trim(), salary, allowance);
        employee.setType(EmployeeType.REGULAR);
        return employeeDao.addEmployee(employee);
    }

    public Employee updateEmployee(int id, String name, String email, double salary, double allowance) throws IOException {
        validateEmployeeInput(name, email, salary, allowance);
        Employee existingEmployee = employeeDao.getEmployeeById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee with ID " + id + " was not found."));

        existingEmployee.setName(name.trim());
        existingEmployee.setEmail(email.trim());
        existingEmployee.setSalary(salary);
        existingEmployee.setAllowance(allowance);

        return employeeDao.updateEmployee(existingEmployee);
    }

    public boolean deleteEmployee(int id) throws IOException {
        if (id <= 0) {
            throw new IllegalArgumentException("A valid employee ID is required.");
        }
        return employeeDao.deleteEmployee(id);
    }

    public double calculateGrossSalary(Employee employee) {
        return employee.getGrossSalary();
    }

    private int generateNextId() throws IOException {
        int maxId = 0;
        for (Employee employee : employeeDao.getAllEmployees()) {
            if (employee.getId() > maxId) {
                maxId = employee.getId();
            }
        }
        return maxId + 1;
    }

    private void validateEmployeeInput(String name, String email, double salary, double allowance) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is required.");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email is required.");
        }
        if (salary < 0 || allowance < 0) {
            throw new IllegalArgumentException("Salary and allowance must not be negative.");
        }
    }
}
