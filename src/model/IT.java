package model;

public class IT extends Employee {
    public IT(int id, String name, String email, double salary, double allowance) {
        super(id, name, email, salary, allowance, EmployeeType.IT);
    }
}
