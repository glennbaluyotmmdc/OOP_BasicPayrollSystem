/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author glennbaluyot
 */
public class HR extends Employee implements HROperations {

    public HR() {
    }

    public HR(int id, String name, String email, double salary, double allowance) {
        super(id, name, email, salary, allowance);
    }
    
    @Override
    public void updateEmployeeRecord() {}
    
    @Override
    public void deleteEmployeeRecord() {}
    
    @Override
    public void addEmployeeRecord() {}
}





