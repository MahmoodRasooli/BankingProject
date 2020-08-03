package banking.app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Client {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Client window = new Client();
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
    public Client() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 1024);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Moshtari Panel");
        frame.getContentPane().setLayout(null);

        JLabel lblAccountSection = new JLabel("Accounts Stast");
        lblAccountSection.setBounds(12, 38, 91, 26);
        frame.getContentPane().add(lblAccountSection);

        JTextPane textPane = new JTextPane();
        textPane.setBounds(240, 38, 454, 170);
        frame.getContentPane().add(textPane);

        JButton btnShowAllMy = new JButton("Show All My Accounts");
        btnShowAllMy.setBounds(27, 92, 179, 38);
        frame.getContentPane().add(btnShowAllMy);

        JSeparator separator = new JSeparator();
        separator.setBounds(12, 221, 758, 13);
        frame.getContentPane().add(separator);

        JLabel lblCreateAccount = new JLabel("Create Account");
        lblCreateAccount.setBounds(12, 233, 91, 26);
        frame.getContentPane().add(lblCreateAccount);

        JLabel lblNewLabel = new JLabel("Account ID");
        lblNewLabel.setBounds(63, 295, 91, 16);
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(146, 292, 116, 22);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(356, 292, 116, 22);
        frame.getContentPane().add(textField_1);

        JLabel lblCustumerId = new JLabel("Valid Till");
        lblCustumerId.setBounds(274, 295, 91, 16);
        frame.getContentPane().add(lblCustumerId);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(578, 292, 116, 22);
        frame.getContentPane().add(textField_2);

        JLabel lblNameWallet = new JLabel("Name Wallet");
        lblNameWallet.setBounds(493, 295, 73, 16);
        frame.getContentPane().add(lblNameWallet);

        JLabel lblTypeAccount = new JLabel("Type Account");
        lblTypeAccount.setBounds(49, 353, 91, 16);
        frame.getContentPane().add(lblTypeAccount);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Seporde", "Jari"}));
        comboBox.setBounds(146, 348, 116, 26);
        frame.getContentPane().add(comboBox);

        JLabel label = new JLabel("Money Transfer");
        label.setBounds(12, 423, 94, 16);
        frame.getContentPane().add(label);

        JLabel label_1 = new JLabel("Account ID");
        label_1.setBounds(75, 455, 65, 16);
        frame.getContentPane().add(label_1);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(151, 452, 116, 22);
        frame.getContentPane().add(textField_3);

        JLabel label_2 = new JLabel("Amount");
        label_2.setBounds(291, 452, 65, 19);
        frame.getContentPane().add(label_2);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(364, 449, 116, 22);
        frame.getContentPane().add(textField_4);

        JLabel label_3 = new JLabel("Destination Account ID");
        label_3.setBounds(504, 452, 143, 16);
        frame.getContentPane().add(label_3);

        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(646, 449, 97, 22);
        frame.getContentPane().add(textField_5);

        JButton button = new JButton("Transfer");
        button.setBounds(365, 502, 104, 25);
        frame.getContentPane().add(button);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(12, 397, 758, 13);
        frame.getContentPane().add(separator_1);

        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(12, 549, 758, 13);
        frame.getContentPane().add(separator_2);

        JLabel lblDeleteAccount = new JLabel("Delete Account");
        lblDeleteAccount.setBounds(12, 570, 91, 26);
        frame.getContentPane().add(lblDeleteAccount);

        JSeparator separator_3 = new JSeparator();
        separator_3.setBounds(12, 648, 758, 13);
        frame.getContentPane().add(separator_3);

        textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setBounds(189, 601, 116, 22);
        frame.getContentPane().add(textField_6);

        JLabel label_4 = new JLabel("Account ID");
        label_4.setBounds(113, 604, 65, 16);
        frame.getContentPane().add(label_4);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(348, 600, 104, 25);
        frame.getContentPane().add(btnDelete);

        JLabel lblTarakonesh = new JLabel("Transaction");
        lblTarakonesh.setBounds(12, 683, 91, 26);
        frame.getContentPane().add(lblTarakonesh);

        JButton btnShowAll = new JButton("Show All Transaction");
        btnShowAll.setBounds(450, 674, 157, 38);
        frame.getContentPane().add(btnShowAll);

        JTextPane textPane_1 = new JTextPane();
        textPane_1.setBounds(89, 724, 654, 211);
        frame.getContentPane().add(textPane_1);

        JLabel label_5 = new JLabel("Account ID");
        label_5.setBounds(220, 690, 65, 16);
        frame.getContentPane().add(label_5);

        textField_7 = new JTextField();
        textField_7.setColumns(10);
        textField_7.setBounds(296, 687, 116, 22);
        frame.getContentPane().add(textField_7);
    }

}