package model;

public class ProbationaryEmployee extends Employee {
    public ProbationaryEmployee(int id, String name, String email, double salary, double allowance) {
        super(id, name, email, salary, allowance, EmployeeType.PROBATIONARY);
    }
}
