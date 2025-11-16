package Authentication;

import javax.swing.*;


import java.awt.*;

public class PopupADT extends JPanel{

    public static void showLogin() {
        showDialog("Login", "Username:", "Password:");
    }

    public static void showSignup() {
        showDialog("Sign Up", "Email:", "Password:");
    }

    // Generic dialog used for both login and signup
    private static void showDialog(String title, String field1Label, String field2Label) {

        JDialog dialog = new JDialog((Frame) null, title, true);
        dialog.setSize(350, 200);
        dialog.setLayout(new BorderLayout(10, 10));
        dialog.setLocationRelativeTo(null); // centers dialog

        // Title for page
        JLabel label = new JLabel(title, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        dialog.add(label, BorderLayout.NORTH);

        // inouts
        JPanel fields = new JPanel(new GridLayout(2, 2, 5, 5));
        JTextField field1 = new JTextField();
        JPasswordField field2 = new JPasswordField();

        fields.add(new JLabel(field1Label));
        fields.add(field1);
        fields.add(new JLabel(field2Label));
        fields.add(field2);

        dialog.add(fields, BorderLayout.CENTER);

        
        JPanel buttons = new JPanel();
        JButton confirm = new JButton("Confirm");
        JButton cancel = new JButton("Cancel");

        buttons.add(confirm);
        buttons.add(cancel);
        dialog.add(buttons, BorderLayout.SOUTH);

        // Logic
        confirm.addActionListener(e -> {
            String v1 = field1.getText().trim();
            String v2 = new String(field2.getPassword());

            if (v1.isEmpty() || v2.isEmpty()) {
                JOptionPane.showMessageDialog(dialog,
                        "Please fill out all fields.");
                return;
            }

            JOptionPane.showMessageDialog(dialog,
                    title + " successful for: " + v1);
            dialog.dispose();
        });


        //undoes what user input
        cancel.addActionListener(e -> dialog.dispose());

        dialog.setVisible(true);
    }
}