package oop_basicpayrollsystem;

import dao.CsvEmployeeDao;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import model.Employee;
import service.PayrollService;

public class PayrollFrame extends javax.swing.JFrame {
    private static final String CSV = "data/payroll.csv";

    private DefaultTableModel tableModel;
    private PayrollService payrollService;
    private Integer selectedEmployeeId;

    public PayrollFrame() {
        initComponents();
        configureFrame();
        initializeService();
        initializeTable();
        initializeTableSelection();
        loadEmployees();
    }

    private void configureFrame() {
        setTitle("Payroll System - OOP Layered Version");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initializeService() {
        try {
            payrollService = new PayrollService(new CsvEmployeeDao(CSV));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Unable to initialize persistence:\n" + e.getMessage());
        }
    }

    private void initializeTable() {
        tableModel = new DefaultTableModel(
                new String[]{"ID", "Name", "Email", "Salary", "Allowance", "Gross Salary"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable.setModel(tableModel);
    }

    private void initializeTableSelection() {
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            if (!event.getValueIsAdjusting()) {
                loadSelectedEmployeeToFields();
            }
        });
    }

    private void loadEmployees() {
        if (payrollService == null) {
            return;
        }

        tableModel.setRowCount(0);
        try {
            for (Employee employee : payrollService.getAllEmployees()) {
                tableModel.addRow(new Object[]{
                    employee.getId(),
                    employee.getName(),
                    employee.getEmail(),
                    employee.getSalary(),
                    employee.getAllowance(),
                    payrollService.calculateGrossSalary(employee)
                });
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Load Error:\n" + e.getMessage());
        }
    }

    private void loadSelectedEmployeeToFields() {
        int selectedRow = jTable.getSelectedRow();
        if (selectedRow < 0) {
            selectedEmployeeId = null;
            return;
        }

        selectedEmployeeId = Integer.valueOf(jTable.getValueAt(selectedRow, 0).toString());
        jTextName.setText(jTable.getValueAt(selectedRow, 1).toString());
        jTextEmail.setText(jTable.getValueAt(selectedRow, 2).toString());
        jTextSalary.setText(jTable.getValueAt(selectedRow, 3).toString());
        jTextAllowance.setText(jTable.getValueAt(selectedRow, 4).toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jTextName = new javax.swing.JTextField();
        jTextEmail = new javax.swing.JTextField();
        jTextAllowance = new javax.swing.JTextField();
        jTextSalary = new javax.swing.JTextField();
        jLabelName = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelAllowance = new javax.swing.JLabel();
        jLabelSalary = new javax.swing.JLabel();
        jBtnAdd = new javax.swing.JButton();
        jBtnUpdate = new javax.swing.JButton();
        jBtnDelete = new javax.swing.JButton();
        jBtnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable);

        jLabelName.setText("Name:");

        jLabelEmail.setText("Email:");

        jLabelAllowance.setText("Allowance:");

        jLabelSalary.setText("Salary:");

        jBtnAdd.setText("Add New Employee");
        jBtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAddActionPerformed(evt);
            }
        });

        jBtnUpdate.setText("Update Employee");
        jBtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnUpdateActionPerformed(evt);
            }
        });

        jBtnDelete.setText("Delete Employee");
        jBtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDeleteActionPerformed(evt);
            }
        });

        jBtnClear.setText("Clear Selection");
        jBtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelName)
                    .addComponent(jLabelEmail))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(jTextName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelAllowance)
                    .addComponent(jLabelSalary))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextAllowance, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(jTextSalary))
                .addGap(80, 80, 80))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jBtnAdd)
                .addGap(18, 18, 18)
                .addComponent(jBtnUpdate)
                .addGap(18, 18, 18)
                .addComponent(jBtnDelete)
                .addGap(18, 18, 18)
                .addComponent(jBtnClear)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAllowance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelName)
                    .addComponent(jLabelAllowance))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEmail)
                    .addComponent(jLabelSalary))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAdd)
                    .addComponent(jBtnUpdate)
                    .addComponent(jBtnDelete)
                    .addComponent(jBtnClear))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAddActionPerformed
        addEmployee();
    }//GEN-LAST:event_jBtnAddActionPerformed

    private void jBtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnUpdateActionPerformed
        updateEmployee();
    }//GEN-LAST:event_jBtnUpdateActionPerformed

    private void jBtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDeleteActionPerformed
        deleteEmployee();
    }//GEN-LAST:event_jBtnDeleteActionPerformed

    private void jBtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClearActionPerformed
        clearSelectionAndInputs();
    }//GEN-LAST:event_jBtnClearActionPerformed

    private void addEmployee() {
        if (payrollService == null) {
            return;
        }

        try {
            String name = jTextName.getText();
            String email = jTextEmail.getText();
            double allowance = Double.parseDouble(jTextAllowance.getText());
            double salary = Double.parseDouble(jTextSalary.getText());

            payrollService.addEmployee(name, email, salary, allowance);
            clearSelectionAndInputs();
            loadEmployees();
            JOptionPane.showMessageDialog(this, "Employee saved successfully.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Salary and allowance must be numeric.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Save Error:\n" + e.getMessage());
        }
    }

    private void updateEmployee() {
        if (payrollService == null) {
            return;
        }
        if (selectedEmployeeId == null) {
            JOptionPane.showMessageDialog(this, "Select an employee record first.");
            return;
        }

        try {
            String name = jTextName.getText();
            String email = jTextEmail.getText();
            double allowance = Double.parseDouble(jTextAllowance.getText());
            double salary = Double.parseDouble(jTextSalary.getText());

            payrollService.updateEmployee(selectedEmployeeId.intValue(), name, email, salary, allowance);
            loadEmployees();
            reselectUpdatedEmployee();
            JOptionPane.showMessageDialog(this, "Employee updated successfully.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Salary and allowance must be numeric.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Update Error:\n" + e.getMessage());
        }
    }

    private void deleteEmployee() {
        if (payrollService == null) {
            return;
        }
        if (selectedEmployeeId == null) {
            JOptionPane.showMessageDialog(this, "Select an employee record first.");
            return;
        }

        int choice = JOptionPane.showConfirmDialog(
                this,
                "Delete employee ID " + selectedEmployeeId + "?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION
        );

        if (choice != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            boolean deleted = payrollService.deleteEmployee(selectedEmployeeId.intValue());
            if (!deleted) {
                JOptionPane.showMessageDialog(this, "Employee was not found.");
                return;
            }
            clearSelectionAndInputs();
            loadEmployees();
            JOptionPane.showMessageDialog(this, "Employee deleted successfully.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Delete Error:\n" + e.getMessage());
        }
    }

    private void reselectUpdatedEmployee() {
        if (selectedEmployeeId == null) {
            return;
        }
        for (int row = 0; row < tableModel.getRowCount(); row++) {
            int rowId = Integer.parseInt(tableModel.getValueAt(row, 0).toString());
            if (rowId == selectedEmployeeId.intValue()) {
                jTable.setRowSelectionInterval(row, row);
                return;
            }
        }
    }

    private void clearSelectionAndInputs() {
        selectedEmployeeId = null;
        jTable.clearSelection();
        jTextName.setText("");
        jTextEmail.setText("");
        jTextSalary.setText("");
        jTextAllowance.setText("");
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PayrollFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new PayrollFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAdd;
    private javax.swing.JButton jBtnClear;
    private javax.swing.JButton jBtnDelete;
    private javax.swing.JButton jBtnUpdate;
    private javax.swing.JLabel jLabelAllowance;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelSalary;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextAllowance;
    private javax.swing.JTextField jTextEmail;
    private javax.swing.JTextField jTextName;
    private javax.swing.JTextField jTextSalary;
    // End of variables declaration//GEN-END:variables
}
