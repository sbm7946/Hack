import javax.swing.*;
import java.awt.*;

import DataBase.*;

public class LoginFrame extends JFrame {

    public LoginFrame() {
        super("Login");

        //boots up accounts
        Accounts a = Accounts.getInstance();

        // basic window setup
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null); // center on screen

        // main panel
        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JButton signupButton = new JButton("Sign Up");

        // layout the form
        panel.add(new JLabel("Student Email:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(signupButton);

        add(panel);

        // what happens when "Login" is pressed
        loginButton.addActionListener(e -> {
            String userEmail = usernameField.getText().trim();
            String userPassword = new String(passwordField.getPassword());

            if (userEmail.isEmpty() || userPassword.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please enter both username and password.");
                return;
            }


            if (!a.accountExists(userEmail)){
                JOptionPane.showMessageDialog(this, 
                        "Account does not exist.\n Please sign up.");
                
                return;
            }
            
            User user = new User(userEmail, userPassword);
            long hash = user.getPasswordhash();


            if (!a.checkPassword(user.getEmail(), user.getPasswordhash())){
                JOptionPane.showMessageDialog(this, 
                            "Incorrect password.");
                
                return;
            }

            JOptionPane.showMessageDialog(this, "Login Successful!");

            // 1) Open the main app window
            new MainFrame();

            // 2) Close this login window
            dispose();
        });

        // what happens when "Sign Up" is pressed
        signupButton.addActionListener(e -> {
            String userEmail = usernameField.getText().trim();
            String userPassword = new String(passwordField.getPassword());

            if (userEmail.isEmpty() || userPassword.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please enter both username and password.");
                return;
            }
            
            User user = new User(userEmail, userPassword);

            if (!a.addAccount(user)){
                JOptionPane.showMessageDialog(this, 
                                        "Account already exists.\nPlease log in.");
                return;
            }
            

            a.saveAccounts();

            JOptionPane.showMessageDialog(this, "Account created!");
        });

        setVisible(true);
    }
}
