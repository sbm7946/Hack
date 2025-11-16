package BasicsPages;
import javax.swing.*;


import java.awt.*;

public class FoodPage extends BasicsPagesADT{
    public FoodPage() {

        super("Food");

        JPanel imagePanel = new JPanel(new GridLayout(2, 2, 10, 10));
        imagePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] imagePaths = {
                "Images/BabasPizza.png",
                "Images/AztecMarket.png",
                "Images/BcbCafe.png",
                "Images/PandaExpres.png",
                "Images/ShakeSmart.png"
        };

        for(String imagePath : imagePaths) {
            ImageIcon image = new ImageIcon(imagePath);
            JLabel imageLabel = new JLabel(image);
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            imagePanel.add(imageLabel);
        }

        add(imagePanel, BorderLayout.CENTER);
        JPanel buttons = new JPanel();
        JButton postButton = new JButton("Post!");
        buttons.add(postButton);
        add(buttons, BorderLayout.SOUTH);
        postButton.addActionListener(e -> openReportDialog());
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

        inputPanel.add(new JLabel("Food"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("What is this place?:"));
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
