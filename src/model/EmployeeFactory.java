package model;

public final class EmployeeFactory {
    private EmployeeFactory() {
    }

    public static Employee create(EmployeeType type, int id, String name, String email, double salary, double allowance) {
        switch (type) {
            case HR:
                return new HR(id, name, email, salary, allowance);
            case IT:
                return new IT(id, name, email, salary, allowance);
            case FINANCE:
                return new Finance(id, name, email, salary, allowance);
            case CONTRACTUAL:
                return new ContractualEmployee(id, name, email, salary, allowance);
            case PROBATIONARY:
                return new ProbationaryEmployee(id, name, email, salary, allowance);
            case PART_TIME:
                return new PartTimeEmployee(id, name, email, (int) salary, allowance);
            case REGULAR:
            case OTHER:
            default:
                return new RegularEmployee(id, name, email, salary, allowance);
        }
    }
}
