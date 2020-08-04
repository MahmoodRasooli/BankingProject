package banking.app;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTextPane;

public class ManagerFrame extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTextField textField_11;
    private JTextField textField_12;
    private JTextField textField_13;
    private JTextField textField_14;
    private JTextField textField_15;
    private JTextField textField_16;
    private JTextField textField_17;
    private JTextField textField_18;

    /**
     * Create the application.
     */
    public ManagerFrame() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        this.setBounds(100, 100, 800, 1024);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Bank Admin Panel");
        this.getContentPane().setLayout(null);

        JButton btnNewButton = new JButton("Add New");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnNewButton.setBounds(75, 165, 135, 25);
        this.getContentPane().add(btnNewButton);

        JLabel lblKarmandan = new JLabel("Karmandan:");
        lblKarmandan.setBounds(25, 13, 97, 16);
        this.getContentPane().add(lblKarmandan);

        textField = new JTextField();
        textField.setBounds(75, 57, 116, 22);
        this.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblId = new JLabel("Id");
        lblId.setBounds(37, 60, 26, 16);
        this.getContentPane().add(lblId);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(241, 57, 116, 22);
        this.getContentPane().add(textField_1);

        JLabel label = new JLabel("date");
        label.setBounds(203, 60, 26, 16);
        this.getContentPane().add(label);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(407, 57, 116, 22);
        this.getContentPane().add(textField_2);

        JLabel label_1 = new JLabel("name");
        label_1.setBounds(369, 60, 53, 16);
        this.getContentPane().add(label_1);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(595, 57, 116, 22);
        this.getContentPane().add(textField_3);

        JLabel label_2 = new JLabel("last name");
        label_2.setBounds(535, 60, 81, 16);
        this.getContentPane().add(label_2);

        JButton button = new JButton("Delete Account");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        button.setBounds(256, 165, 135, 25);
        this.getContentPane().add(button);

        JButton button_1 = new JButton("Change Data");
        button_1.setBounds(441, 165, 135, 25);
        this.getContentPane().add(button_1);

        JLabel label_3 = new JLabel("Decrease salary");
        label_3.setBounds(25, 113, 116, 16);
        this.getContentPane().add(label_3);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(129, 110, 116, 22);
        this.getContentPane().add(textField_4);

        JLabel label_4 = new JLabel("Increase salary");
        label_4.setBounds(277, 113, 116, 16);
        this.getContentPane().add(label_4);

        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(385, 110, 116, 22);
        this.getContentPane().add(textField_5);

        JSeparator separator = new JSeparator();
        separator.setBounds(0, 240, 770, 10);
        this.getContentPane().add(separator);

        JLabel label_5 = new JLabel("Moshtarian:");
        label_5.setBounds(25, 263, 97, 16);
        this.getContentPane().add(label_5);

        JLabel label_6 = new JLabel("Id");
        label_6.setBounds(37, 310, 26, 16);
        this.getContentPane().add(label_6);

        textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setBounds(75, 307, 116, 22);
        this.getContentPane().add(textField_6);

        textField_7 = new JTextField();
        textField_7.setColumns(10);
        textField_7.setBounds(241, 307, 116, 22);
        this.getContentPane().add(textField_7);

        JLabel label_7 = new JLabel("date");
        label_7.setBounds(203, 310, 26, 16);
        this.getContentPane().add(label_7);

        JLabel label_8 = new JLabel("name");
        label_8.setBounds(369, 310, 53, 16);
        this.getContentPane().add(label_8);

        textField_8 = new JTextField();
        textField_8.setColumns(10);
        textField_8.setBounds(407, 307, 116, 22);
        this.getContentPane().add(textField_8);

        JLabel label_9 = new JLabel("last name");
        label_9.setBounds(535, 310, 81, 16);
        this.getContentPane().add(label_9);

        textField_9 = new JTextField();
        textField_9.setColumns(10);
        textField_9.setBounds(385, 360, 116, 22);
        this.getContentPane().add(textField_9);

        JLabel label_10 = new JLabel("Increase Balance");
        label_10.setBounds(277, 363, 116, 16);
        this.getContentPane().add(label_10);

        textField_10 = new JTextField();
        textField_10.setColumns(10);
        textField_10.setBounds(129, 360, 116, 22);
        this.getContentPane().add(textField_10);

        JLabel label_11 = new JLabel("Decrease Balance");
        label_11.setBounds(25, 363, 116, 16);
        this.getContentPane().add(label_11);

        JButton button_2 = new JButton("Add New");
        button_2.setBounds(75, 415, 135, 25);
        this.getContentPane().add(button_2);

        JButton button_3 = new JButton("Delete Account");
        button_3.setBounds(256, 415, 135, 25);
        this.getContentPane().add(button_3);

        JButton button_4 = new JButton("Change Data");
        button_4.setBounds(441, 415, 135, 25);
        this.getContentPane().add(button_4);

        textField_11 = new JTextField();
        textField_11.setColumns(10);
        textField_11.setBounds(595, 307, 116, 22);
        this.getContentPane().add(textField_11);

        JLabel label_12 = new JLabel("Accounts:");
        label_12.setBounds(36, 511, 97, 16);
        this.getContentPane().add(label_12);

        JLabel label_13 = new JLabel("Id");
        label_13.setBounds(48, 558, 26, 16);
        this.getContentPane().add(label_13);

        JLabel label_14 = new JLabel("Decrease Balance");
        label_14.setBounds(36, 611, 116, 16);
        this.getContentPane().add(label_14);

        textField_12 = new JTextField();
        textField_12.setColumns(10);
        textField_12.setBounds(140, 608, 116, 22);
        this.getContentPane().add(textField_12);

        textField_13 = new JTextField();
        textField_13.setColumns(10);
        textField_13.setBounds(86, 555, 116, 22);
        this.getContentPane().add(textField_13);

        JLabel label_15 = new JLabel("date");
        label_15.setBounds(214, 558, 26, 16);
        this.getContentPane().add(label_15);

        textField_14 = new JTextField();
        textField_14.setColumns(10);
        textField_14.setBounds(252, 555, 116, 22);
        this.getContentPane().add(textField_14);

        JLabel label_16 = new JLabel("name");
        label_16.setBounds(380, 558, 53, 16);
        this.getContentPane().add(label_16);

        textField_15 = new JTextField();
        textField_15.setColumns(10);
        textField_15.setBounds(418, 555, 116, 22);
        this.getContentPane().add(textField_15);

        textField_16 = new JTextField();
        textField_16.setColumns(10);
        textField_16.setBounds(396, 608, 116, 22);
        this.getContentPane().add(textField_16);

        JLabel label_17 = new JLabel("Increase Balance");
        label_17.setBounds(288, 611, 116, 16);
        this.getContentPane().add(label_17);

        JButton button_5 = new JButton("Add New");
        button_5.setBounds(86, 663, 135, 25);
        this.getContentPane().add(button_5);

        JButton button_6 = new JButton("Delete Account");
        button_6.setBounds(267, 663, 135, 25);
        this.getContentPane().add(button_6);

        JLabel label_18 = new JLabel("last name");
        label_18.setBounds(546, 558, 81, 16);
        this.getContentPane().add(label_18);

        textField_17 = new JTextField();
        textField_17.setColumns(10);
        textField_17.setBounds(606, 555, 116, 22);
        this.getContentPane().add(textField_17);

        JButton button_7 = new JButton("Change Data");
        button_7.setBounds(452, 663, 135, 25);
        this.getContentPane().add(button_7);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(0, 469, 770, 10);
        this.getContentPane().add(separator_1);

        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(0, 729, 770, 10);
        this.getContentPane().add(separator_2);

        JLabel lblSearch = new JLabel("Search");
        lblSearch.setBounds(0, 729, 56, 16);
        this.getContentPane().add(lblSearch);

        JTextPane textPane = new JTextPane();
        textPane.setBounds(25, 792, 745, 172);
        this.getContentPane().add(textPane);

        JButton button_8 = new JButton("Show custumer");
        button_8.setBounds(94, 752, 135, 25);
        this.getContentPane().add(button_8);

        textField_18 = new JTextField();
        textField_18.setColumns(10);
        textField_18.setBounds(63, 752, 26, 22);
        this.getContentPane().add(textField_18);

        JLabel label_19 = new JLabel("id");
        label_19.setBounds(37, 752, 26, 16);
        this.getContentPane().add(label_19);

        JButton button_9 = new JButton("Show karmand");
        button_9.setBounds(233, 752, 135, 25);
        this.getContentPane().add(button_9);

        JButton button_10 = new JButton("Show all karmand");
        button_10.setBounds(369, 752, 135, 25);
        this.getContentPane().add(button_10);

        JButton button_11 = new JButton("Show all karmand");
        button_11.setBounds(500, 752, 135, 25);
        this.getContentPane().add(button_11);

        JButton button_12 = new JButton("all tarakonesh");
        button_12.setBounds(635, 752, 135, 25);
        this.getContentPane().add(button_12);
        JFrame.setDefaultLookAndFeelDecorated(true);

    }
}