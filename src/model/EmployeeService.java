/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author glennbaluyot
 */
public class EmployeeService {

    public EmployeeService() {
    }
    
    public void viewEmployee(Employee emp)
    {
        System.out.println("ID: " + emp.getId());
        System.out.println("Name: " + emp.getName());
        System.out.println("Email: " + emp.getEmail());
        System.out.println("Salary: " + emp.getSalary());
    }
    
    public void viewEmployee(int id, String name, String email)
    {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);  
    }
    
        
    public void viewEmployee(String name)
    {
        System.out.println("Name: " + name);
    }
}
