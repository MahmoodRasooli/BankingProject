package banking.app;

import banking.core.EmployeeManager;
import banking.core.FileManager;
import banking.model.role;

import java.awt.EventQueue;
import java.util.Date;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        StringBuilder errorMessage = new StringBuilder();

        if (!FileManager.initiateFiles(errorMessage)) {
            JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        EmployeeManager employeeManager = new EmployeeManager();
        if(employeeManager.find(1) == null) {
            employeeManager.createEmployee("admin", "admin", "male", "0912", "Qom", role.bankManager, 0, "admin@bank.com", 1, new Date(), "123456", errorMessage);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginFrame window = new LoginFrame();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error in starting the application", "Error", JOptionPane.ERROR_MESSAGE);                    
                }
            }
        });
    }
}