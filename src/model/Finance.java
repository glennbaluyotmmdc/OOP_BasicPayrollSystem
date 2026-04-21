package model;

public class Finance extends Employee {
    public Finance(int id, String name, String email, double salary, double allowance) {
        super(id, name, email, salary, allowance, EmployeeType.FINANCE);
    }
}
