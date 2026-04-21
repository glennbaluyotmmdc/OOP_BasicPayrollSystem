package model;

public abstract class Employee implements Payables {
    private int id;
    private String name;
    private String email;
    private double salary;
    private double allowance;
    private EmployeeType type;

    protected Employee(int id, String name, String email, double salary, double allowance, EmployeeType type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.allowance = allowance;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    public EmployeeType getType() {
        return type;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }

    @Override
    public double getGrossSalary() {
        return salary + allowance;
    }
}
