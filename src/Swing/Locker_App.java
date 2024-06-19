package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Locker_App extends JFrame {
    private JTextField passcodeField;
    private JButton enterButton, clearButton;
    private JLabel statusLabel;
    private String password;
    private boolean isSettingPassword = true;

    public Locker_App() {
        setTitle("Locker App");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create components
        passcodeField = new JTextField(20);
        enterButton = new JButton("Enter");
        clearButton = new JButton("Clear");
        statusLabel = new JLabel(" ");

        // Add components to the frame
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Passcode:"));
        inputPanel.add(passcodeField);
        add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 3));
        String[] buttonLabels = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    passcodeField.setText(passcodeField.getText() + label);
                }
            });
            buttonPanel.add(button);
        }
        add(buttonPanel, BorderLayout.CENTER);

        JPanel enterPanel = new JPanel();
        enterPanel.add(enterButton);
        enterPanel.add(clearButton); // Add the clear button to the panel
        add(enterPanel,BorderLayout.SOUTH);

        add(statusLabel, BorderLayout.WEST);

        // Add action listener for the enter button
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredPasscode = passcodeField.getText();
                if (isSettingPassword) {
                    setPassword(enteredPasscode);
                } else {
                    verifyPassword(enteredPasscode);
                }
            }
        });

        // Add action listener for the clear button
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passcodeField.setText("");
                statusLabel.setText("");
            }
        });
    }

    private void setPassword(String enteredPasscode) {
        if (enteredPasscode.length() > 0) {
            password = enteredPasscode;
            //statusLabel.setText("Password Set. Please enter your password.");
            isSettingPassword = false;
        } else {
            statusLabel.setText("");
        }
        passcodeField.setText("");
    }

    private void verifyPassword(String enteredPasscode) {
        if (enteredPasscode.equals(password)) {
            statusLabel.setText("Correct Password");
        } else {
            statusLabel.setText("Incorrect Password");
        }
        passcodeField.setText("");
    }


}
