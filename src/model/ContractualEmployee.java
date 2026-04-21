package model;

public class ContractualEmployee extends Employee {
    public ContractualEmployee(int id, String name, String email, double salary, double allowance) {
        super(id, name, email, salary, allowance, EmployeeType.CONTRACTUAL);
    }

    @Override
    public double getGrossSalary() {
        return getSalary();
    }
}
