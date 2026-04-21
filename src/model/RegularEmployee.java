package model;

public class RegularEmployee extends Employee {
    public RegularEmployee(int id, String name, String email, double salary, double allowance) {
        super(id, name, email, salary, allowance, EmployeeType.REGULAR);
    }
}
