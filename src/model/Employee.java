/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author glennbaluyot
 */
public class Employee {
    private int id;
    private String name;
    private String email;
    private double salary;
    private double allowance;

    public Employee() {
    }

    public Employee(int id, String name, String email, double salary, double allowance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.allowance = allowance;
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
        
        this.email = "lr." + email;
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
    
    public double getGrossSalary()
    {
        return salary + allowance;
    }
    
}
