/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author glennbaluyot
 */
public class ContractualEmployee extends Employee {

    public ContractualEmployee() {
    }

    public ContractualEmployee(int id, String name, String email, double salary, double allowance) {
        super(id, name, email, salary, 0);
    }
    
    @Override
    public double getGrossSalary()
    {
        return salary;
    }
    
}
