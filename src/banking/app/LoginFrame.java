package banking.app;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import banking.core.ClientManager;
import banking.core.EmployeeManager;
import banking.model.Employee;
import banking.model.role;

import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JTextField username;
    private JPasswordField password;
    private JLabel lblUsername;
    private JLabel lblPassword;
    // private JRadioButton rdbtnAdmin;
    private JRadioButton rdbtnEmployee;
    private JRadioButton rdbtnClient;
    private JButton btnLogin;
    private JButton btnReset;
    private JButton btnExit;

    /**
     * Create the application.
     */
    public LoginFrame() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        this.setBounds(100, 100, 450, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Login");
        this.getContentPane().setLayout(null);

        lblUsername = new JLabel("Username:");
        lblUsername.setBounds(69, 47, 63, 14);
        this.getContentPane().add(lblUsername);

        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(69, 104, 63, 14);
        this.getContentPane().add(lblPassword);

        username = new JTextField();
        username.setBounds(142, 44, 108, 20);
        this.getContentPane().add(username);
        username.setColumns(10);

        password = new JPasswordField();
        password.setBounds(142, 101, 108, 20);
        this.getContentPane().add(password);

        // rdbtnAdmin = new JRadioButton("Manager");
        // rdbtnAdmin.setBounds(69, 147, 63, 23);
        // this.getContentPane().add(rdbtnAdmin);

        rdbtnEmployee = new JRadioButton("Employee");
        rdbtnEmployee.setBounds(69, 147, 150, 23);
        this.getContentPane().add(rdbtnEmployee);
        rdbtnEmployee.setSelected(true);

        rdbtnClient = new JRadioButton("Client");
        rdbtnClient.setBounds(240, 147, 150, 23);
        this.getContentPane().add(rdbtnClient);

        ButtonGroup Selections = new ButtonGroup();
        Selections.add(rdbtnClient);
        Selections.add(rdbtnEmployee);
        // Selections.add(rdbtnAdmin);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(69, 207, 89, 23);
        this.getContentPane().add(btnLogin);

        btnReset = new JButton("Reset");
        btnReset.setBounds(187, 207, 89, 23);
        this.getContentPane().add(btnReset);

        btnExit = new JButton("Exit");
        btnExit.setBounds(311, 207, 89, 23);
        this.getContentPane().add(btnExit);

        btnLogin.addActionListener(new BtnLoginClickListener());
    }

    private class BtnLoginClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (username.getText() == null || username.getText() == "" || password.getText() == null
                    || password.getText() == "") {
                JOptionPane.showMessageDialog(null, "Enter username and password", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            StringBuilder errorMessage = new StringBuilder();

            if (rdbtnEmployee.isSelected()) {
                EmployeeManager employeeManager = new EmployeeManager();
                Employee employee = employeeManager.login(username.getText(), password.getText(), errorMessage);
                if (employee == null) {
                    JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    if (employee.getRole() == role.bankEmployee) {
                        EmployeeFrame frame = new EmployeeFrame();
                        frame.setVisible(true);
                    } else {
                        ManagerFrame frame = new ManagerFrame();
                        frame.setVisible(true);
                    }
                }
            }

            if (rdbtnClient.isSelected()) {
                ClientManager clientManager = new ClientManager();
                if (clientManager.login(username.getText(), password.getText(), errorMessage) == null) {
                    JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    ClientFrame frame = new ClientFrame();
                    frame.setVisible(true);
                }
            }
        }
    }
}