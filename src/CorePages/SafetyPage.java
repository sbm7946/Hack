package CorePages;
import javax.swing.*;
import java.awt.*;

public class SafetyPage extends CorePageADT {

    public SafetyPage() {
        super("Safety");
        setLayout(new BorderLayout());
        JLabel title = new JLabel("San Diego State University Safety Hub", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        JTextArea info = new JTextArea("""
                 • Emergency contacts: 911 or Campus Security (619-594-1991)
                 • Safety tips: Walk in groups after dark
                 • Report incidents anonymously via the Safety Form
                 """);
        info.setEditable(false);
        info.setFont(new Font("Monospaced", Font.PLAIN, 14));
        info.setBackground(getBackground());
        JPanel buttons = new JPanel();
        JButton reportButton = new JButton("Report an Incident");
        JButton resourcesButton = new JButton("View Safety Resources");
        buttons.add(reportButton);
        buttons.add(resourcesButton);
        add(title, BorderLayout.NORTH);
        add(new JScrollPane(info), BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);
        reportButton.addActionListener(e -> openReportDialog());
    }
    private void openReportDialog() {
        // Create dialog
        JDialog dialog = new JDialog((Frame) null, "Report an Incident", true);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new BorderLayout(10, 10));

        // Input fields
        JPanel inputPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        JTextField nameField = new JTextField();
        JTextArea descriptionArea = new JTextArea(5, 20);

        inputPanel.add(new JLabel("Your Name (optional):"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Describe the incident:"));
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