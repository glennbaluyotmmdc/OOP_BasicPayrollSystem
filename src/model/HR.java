package model;

public class HR extends Employee {
    public HR(int id, String name, String email, double salary, double allowance) {
        super(id, name, email, salary, allowance, EmployeeType.HR);
    }
}
