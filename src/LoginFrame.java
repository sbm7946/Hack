import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    public LoginFrame() {
        super("Login");

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
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(signupButton);

        add(panel);

        // what happens when "Login" is pressed
        loginButton.addActionListener(e -> {
            String user = usernameField.getText().trim();
            String pass = new String(passwordField.getPassword());

            if (user.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please enter both username and password.");
                return;
            }

            // 🔴 TODO: put real auth here later
            // for now, anything non-empty is "successful"

            // 1) Open the main app window
            new MainFrame();

            // 2) Close this login window
            dispose();
        });

        // what happens when "Sign Up" is pressed
        signupButton.addActionListener(e -> {
            // for now, just placeholder behavior
            JOptionPane.showMessageDialog(this,
                    "Sign-up not implemented yet.");
        });

        setVisible(true);
    }
}
