package AthleticsPage;
//package MajorPages;

import javax.swing.*;


import java.awt.*;

import MajorPages.MajorsPageADT;

public class ClubSoccerPage extends MajorsPageADT {

    public ClubSoccerPage() {
        super("Club Soccer");
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Club Soccer Page!", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        JTextArea info = new JTextArea("""
                 • Club Email:
                 • Club Insta:
                 """);
        info.setEditable(false);
        info.setFont(new Font("Monospaced", Font.PLAIN, 14));
        info.setBackground(getBackground());
        JPanel buttons = new JPanel();
        JButton reportButton = new JButton("Post!");
        JButton resourcesButton = new JButton("Contact us!");
        buttons.add(reportButton);
        buttons.add(resourcesButton);
        add(title, BorderLayout.NORTH);
        add(new JScrollPane(info), BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);
        reportButton.addActionListener(e -> openReportDialog());


    }

    private void openReportDialog() {
        // Create dialog
        JDialog dialog = new JDialog((Frame) null, "Post!", true);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new BorderLayout(10, 10));

        // Input fields
        JPanel inputPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        JTextField nameField = new JTextField();
        JTextArea descriptionArea = new JTextArea(5, 20);

        inputPanel.add(new JLabel("Club Name"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("When is the event?:"));
        dialog.add(inputPanel, BorderLayout.NORTH);
        dialog.add(new JScrollPane(descriptionArea), BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel();
        JButton submitBtn = new JButton("Submit");
        JButton cancelBtn = new JButton("Cancel");
        buttonPanel.add(submitBtn);
        buttonPanel.add(cancelBtn);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        // Button actions
        submitBtn.addActionListener(ev -> {
            String name = nameField.getText().trim();
            String desc = descriptionArea.getText().trim();

            if (desc.isEmpty()) {
                JOptionPane.showMessageDialog(dialog,
                        "Please describe the incident before submitting.",
                        "Missing Information",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Simulate "sending" the report (you could later save to a DB/file)
            JOptionPane.showMessageDialog(dialog,
                    "Thank you for submitting your report" +
                            (name.isEmpty() ? " anonymously." : ", " + name + "."),
                    "Report Received",
                    JOptionPane.INFORMATION_MESSAGE);

            dialog.dispose(); // Close dialog
        });

        cancelBtn.addActionListener(ev -> dialog.dispose());

        dialog.setVisible(true);
    }


}
