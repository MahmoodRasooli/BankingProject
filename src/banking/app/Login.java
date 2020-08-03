package banking.app;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Login {

    private JFrame frame;
    private JTextField username;
    private JPasswordField password;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login window = new Login();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Login() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Login");
        frame.getContentPane().setLayout(null);


        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(69, 47, 63, 14);
        frame.getContentPane().add(lblUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(69, 104, 63, 14);
        frame.getContentPane().add(lblPassword);

        username = new JTextField();
        username.setBounds(142, 44, 108, 20);
        frame.getContentPane().add(username);
        username.setColumns(10);

        password = new JPasswordField();
        password.setBounds(142, 101, 108, 20);
        frame.getContentPane().add(password);

        JRadioButton rdbtnAdmin = new JRadioButton("Admin");
        rdbtnAdmin.setBounds(69, 147, 63, 23);
        frame.getContentPane().add(rdbtnAdmin);

        JRadioButton rdbtnLibrarian = new JRadioButton("Karmand");
        rdbtnLibrarian.setBounds(153, 147, 81, 23);
        frame.getContentPane().add(rdbtnLibrarian);

        JRadioButton rdbtnMember = new JRadioButton("Moshtari");
        rdbtnMember.setBounds(249, 147, 109, 23);
        frame.getContentPane().add(rdbtnMember);

        ButtonGroup Selections = new ButtonGroup();
        Selections.add(rdbtnMember);
        Selections.add(rdbtnLibrarian);
        Selections.add(rdbtnAdmin);

        JButton login = new JButton("Login");

        login.setBounds(69, 207, 89, 23);
        frame.getContentPane().add(login);

        JButton btnReset = new JButton("Reset");
        btnReset.setBounds(187, 207, 89, 23);
        frame.getContentPane().add(btnReset);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(311, 207, 89, 23);
        frame.getContentPane().add(btnExit);


    }

}