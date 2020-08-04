package banking.app;

import banking.core.FileManager;
import java.awt.EventQueue;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        StringBuilder errorMessage = new StringBuilder();

        if (!FileManager.initiateFiles(errorMessage)) {
            JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
            return;
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