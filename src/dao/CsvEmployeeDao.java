package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import model.Employee;
import model.EmployeeFactory;
import model.EmployeeType;

public class CsvEmployeeDao implements EmployeeDao {
    private static final String HEADER = "id,name,email,salary,allowance,type";
    private final Path csvPath;

    public CsvEmployeeDao(String filePath) throws IOException {
        this.csvPath = Path.of(filePath);
        initializeFile();
    }

    private void initializeFile() throws IOException {
        Path parent = csvPath.getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }

        if (!Files.exists(csvPath)) {
            Files.writeString(csvPath, HEADER + System.lineSeparator(), StandardOpenOption.CREATE);
        }
    }

    @Override
    public List<Employee> getAllEmployees() throws IOException {
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(csvPath)) {
            String line = reader.readLine();
            if (line == null) {
                return employees;
            }

            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }
                employees.add(parse(line));
            }
        }

        return employees;
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) throws IOException {
        return getAllEmployees().stream().filter(emp -> emp.getId() == id).findFirst();
    }

    @Override
    public Employee addEmployee(Employee employee) throws IOException {
        List<Employee> employees = getAllEmployees();
        employees.add(employee);
        writeAll(employees);
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) throws IOException {
        List<Employee> employees = getAllEmployees();
        boolean found = false;

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == employee.getId()) {
                employees.set(i, employee);
                found = true;
                break;
            }
        }

        if (!found) {
            throw new IllegalArgumentException("Employee with ID " + employee.getId() + " was not found.");
        }

        writeAll(employees);
        return employee;
    }

    @Override
    public boolean deleteEmployee(int id) throws IOException {
        List<Employee> employees = getAllEmployees();
        boolean removed = employees.removeIf(employee -> employee.getId() == id);
        if (removed) {
            writeAll(employees);
        }
        return removed;
    }

    private void writeAll(List<Employee> employees) throws IOException {
        List<String> lines = new ArrayList<>();
        lines.add(HEADER);
        for (Employee employee : employees) {
            lines.add(toCsv(employee));
        }
        Files.write(csvPath, lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    private Employee parse(String line) {
        String[] data = line.split(",", -1);
        int id = Integer.parseInt(data[0].trim());
        String name = data[1].trim();
        String email = data[2].trim();
        double salary = Double.parseDouble(data[3].trim());
        double allowance = Double.parseDouble(data[4].trim());
        EmployeeType type = data.length > 5 && !data[5].isBlank()
                ? EmployeeType.valueOf(data[5].trim().toUpperCase())
                : EmployeeType.REGULAR;

        return EmployeeFactory.create(type, id, name, email, salary, allowance);
    }

    private String toCsv(Employee employee) {
        return String.join(",",
                String.valueOf(employee.getId()),
                employee.getName(),
                employee.getEmail(),
                String.valueOf(employee.getSalary()),
                String.valueOf(employee.getAllowance()),
                employee.getType().name());
    }
}
