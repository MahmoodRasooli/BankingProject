package banking.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame
{
    private JButton clientButton;
    private JButton employeeButton;
    private JLabel welcomeMessage;

    public Login()
    {
        super("Main Page");
        setLayout(new FlowLayout());

        welcomeMessage = new JLabel("welcome to Farabi Bank");
        add(welcomeMessage);

        clientButton = new JButton("Client Login");
        add(clientButton);

        employeeButton = new JButton("Employee Login");
        add(employeeButton);

        ButtonHandler handler = new ButtonHandler();
        clientButton.addActionListener(handler);
        employeeButton.addActionListener(handler);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350, 350);
    }

    private class ButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            JFrame jFrame = new JFrame();

        }
    }
}
