/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author glennbaluyot
 */
public class NewEmployeeType extends Employee {

    public NewEmployeeType() {
    }

    public NewEmployeeType(int id, String name, String email, double salary, double allowance) {
        super(id, name, email, salary, allowance);
    }

    @Override
    public double getGrossSalary()
    {
        double tax = 0.21;
        return (salary + allowance) - ((salary)*tax);
    }
    
    
    public double getGrossSalary(double tax)
    {
        return (salary + allowance) - ((salary)*tax);
    }
}
