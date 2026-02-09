/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author glennbaluyot
 */
public class HRService {
    public void updateSalary(Employee emp, double salary)
    {
        emp.setSalary(salary);
        System.out.println("Salary updated by HR.");
    }
    
    
    public void updateSalary(Employee emp, double salary, double allowance)
    {
        emp.setSalary(salary);
        emp.setAllowance(allowance);
        System.out.println("Salary updated by HR.");
    }
    
    public void updateSalary(Employee emp, double salary, boolean withIncrease)
    {
        if(withIncrease)
        {
            emp.setSalary(emp.getSalary() + salary);
        }
        else 
        {
            System.out.println("Thank you for your hardwork.");
        }
    }
}
