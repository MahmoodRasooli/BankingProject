package banking.app;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private JTextField username;
    private JPasswordField password;

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


        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(69, 47, 63, 14);
        this.getContentPane().add(lblUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(69, 104, 63, 14);
        this.getContentPane().add(lblPassword);

        username = new JTextField();
        username.setBounds(142, 44, 108, 20);
        this.getContentPane().add(username);
        username.setColumns(10);

        password = new JPasswordField();
        password.setBounds(142, 101, 108, 20);
        this.getContentPane().add(password);

        JRadioButton rdbtnAdmin = new JRadioButton("Admin");
        rdbtnAdmin.setBounds(69, 147, 63, 23);
        this.getContentPane().add(rdbtnAdmin);

        JRadioButton rdbtnLibrarian = new JRadioButton("Karmand");
        rdbtnLibrarian.setBounds(153, 147, 81, 23);
        this.getContentPane().add(rdbtnLibrarian);

        JRadioButton rdbtnMember = new JRadioButton("Moshtari");
        rdbtnMember.setBounds(249, 147, 109, 23);
        this.getContentPane().add(rdbtnMember);

        ButtonGroup Selections = new ButtonGroup();
        Selections.add(rdbtnMember);
        Selections.add(rdbtnLibrarian);
        Selections.add(rdbtnAdmin);

        JButton login = new JButton("Login");

        login.setBounds(69, 207, 89, 23);
        this.getContentPane().add(login);

        JButton btnReset = new JButton("Reset");
        btnReset.setBounds(187, 207, 89, 23);
        this.getContentPane().add(btnReset);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(311, 207, 89, 23);
        this.getContentPane().add(btnExit);
    }
}