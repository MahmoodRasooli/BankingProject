package banking.app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Employee {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Employee window = new Employee();
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
    public Employee() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 1024);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Karmand Panel");
        frame.getContentPane().setLayout(null);

        JSeparator separator = new JSeparator();
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setBounds(381, 13, 9, 347);
        frame.getContentPane().add(separator);

        JTextPane textPane = new JTextPane();
        textPane.setToolTipText("");
        textPane.setBounds(12, 89, 354, 271);
        frame.getContentPane().add(textPane);

        JLabel lblMoshtari = new JLabel("Moshtari");
        lblMoshtari.setBounds(12, 13, 56, 16);
        frame.getContentPane().add(lblMoshtari);

        textField = new JTextField();
        textField.setBounds(56, 40, 116, 22);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblId = new JLabel("ID");
        lblId.setBounds(22, 42, 24, 16);
        frame.getContentPane().add(lblId);

        JButton btnFind = new JButton("Find");
        btnFind.setBounds(184, 39, 70, 25);
        frame.getContentPane().add(btnFind);

        JButton btnShowAll = new JButton("Show All");
        btnShowAll.setBounds(269, 39, 97, 25);
        frame.getContentPane().add(btnShowAll);

        JTextPane textPane_1 = new JTextPane();
        textPane_1.setToolTipText("");
        textPane_1.setBounds(402, 89, 354, 271);
        frame.getContentPane().add(textPane_1);

        JLabel label = new JLabel("ID");
        label.setBounds(412, 42, 24, 16);
        frame.getContentPane().add(label);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(446, 40, 116, 22);
        frame.getContentPane().add(textField_1);

        JButton button = new JButton("Find");
        button.setBounds(574, 39, 70, 25);
        frame.getContentPane().add(button);

        JButton button_1 = new JButton("Show All");
        button_1.setBounds(659, 39, 97, 25);
        frame.getContentPane().add(button_1);

        JLabel lblAccounts = new JLabel("Accounts");
        lblAccounts.setBounds(402, 13, 56, 16);
        frame.getContentPane().add(lblAccounts);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(12, 383, 744, 2);
        frame.getContentPane().add(separator_1);

        JLabel lblShowBalance = new JLabel("Show Balance");
        lblShowBalance.setBounds(12, 412, 80, 16);
        frame.getContentPane().add(lblShowBalance);

        JLabel lblMoshtariId = new JLabel("Moshtari ID");
        lblMoshtariId.setBounds(41, 453, 65, 16);
        frame.getContentPane().add(lblMoshtariId);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(116, 451, 116, 22);
        frame.getContentPane().add(textField_2);

        JButton button_2 = new JButton("Find");
        button_2.setBounds(244, 450, 70, 25);
        frame.getContentPane().add(button_2);

        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(12, 597, 758, 2);
        frame.getContentPane().add(separator_2);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(27, 519, 65, 25);
        frame.getContentPane().add(lblName);

        JTextPane textPane_2 = new JTextPane();
        textPane_2.setBounds(100, 519, 132, 25);
        frame.getContentPane().add(textPane_2);

        JTextPane textPane_3 = new JTextPane();
        textPane_3.setBounds(326, 519, 132, 25);
        frame.getContentPane().add(textPane_3);

        JLabel lblLastName = new JLabel("Last Name");
        lblLastName.setBounds(253, 519, 65, 25);
        frame.getContentPane().add(lblLastName);

        JTextPane textPane_4 = new JTextPane();
        textPane_4.setBounds(589, 519, 132, 25);
        frame.getContentPane().add(textPane_4);

        JLabel lblBalance = new JLabel("Total Balance");
        lblBalance.setBounds(481, 519, 81, 25);
        frame.getContentPane().add(lblBalance);

        JLabel lblAccountsIds = new JLabel("Accounts IDs");
        lblAccountsIds.setBounds(367, 424, 118, 46);
        frame.getContentPane().add(lblAccountsIds);

        JTextPane textPane_5 = new JTextPane();
        textPane_5.setBounds(471, 424, 250, 65);
        frame.getContentPane().add(textPane_5);

        JLabel lblMoneyTransfer = new JLabel("Money Transfer");
        lblMoneyTransfer.setBounds(12, 628, 94, 16);
        frame.getContentPane().add(lblMoneyTransfer);

        JLabel lblAccountId = new JLabel("Account ID");
        lblAccountId.setBounds(56, 660, 65, 16);
        frame.getContentPane().add(lblAccountId);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(129, 657, 116, 22);
        frame.getContentPane().add(textField_3);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(342, 654, 116, 22);
        frame.getContentPane().add(textField_4);

        JLabel lblAmount = new JLabel("Amount");
        lblAmount.setBounds(269, 657, 65, 19);
        frame.getContentPane().add(lblAmount);

        JLabel lblDestinationAccountId = new JLabel("Destination Account ID");
        lblDestinationAccountId.setBounds(482, 657, 143, 16);
        frame.getContentPane().add(lblDestinationAccountId);

        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(624, 654, 97, 22);
        frame.getContentPane().add(textField_5);

        JSeparator separator_3 = new JSeparator();
        separator_3.setBounds(12, 745, 758, 2);
        frame.getContentPane().add(separator_3);

        JButton btnTransfer = new JButton("Transfer");
        btnTransfer.setBounds(343, 707, 104, 25);
        frame.getContentPane().add(btnTransfer);
    }
}
