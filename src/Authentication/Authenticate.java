package Authentication;

import javax.swing.*;
import java.awt.*;
public class Authenticate extends JPanel{
    JPanel buttons;
    

    public Authenticate(){

        JLabel title = new JLabel("Login / Signup", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));

        buttons = new JPanel();
        JButton loginButton = new JButton("Login");
        JButton signupButton = new JButton("Sign Up");
        buttons.add(loginButton);
        buttons.add(signupButton);

        add(title, BorderLayout.CENTER);
        add(buttons, BorderLayout.CENTER);

        loginButton.addActionListener(e ->PopupADT.showLogin());
        signupButton.addActionListener(e -> PopupADT.showSignup());
        
    }
}
