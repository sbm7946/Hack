package AthleticsPage;

import javax.swing.*;
import java.awt.*;
import MajorPages.MajorsPageADT;

public class ClubSoccerPage extends MajorsPageADT {

    public ClubSoccerPage() {
        super("Club Soccer");
        setLayout(new BorderLayout());

        // ===== Title =====
        JLabel title = new JLabel("Club Soccer General Page!", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        // ===== Text content =====
        JTextArea info = new JTextArea("""
                 • Insta:
                        • Womens Club Insta: @sdsuwomensclubsoccer
                        • Mens Club Insta: @mensclubsoccer
  
                 • About us:
                        We are an intramural club soccer team dedicated to improving our skills and love for the game.
                        
                        Men's Leadership:
                            President: Jose Rodriguez at jrodriguez3818@sdsu.edu
                            Vice President: Sayf Mamory at smamory5394@sdsu.edu
                            Head Coach (A Team): Nick Lopez at nlopez8@sdsu.edu
                            Assistant Coach: Sean Connors at sconnors@sdsu.edu
                        
                        Women's Leadership:
                            President: Taylor Gallagher at tgallaher7386@sdsu.edu
                            Vice President: Kelly Fleischer at kfleischer1795@sdsu.edu
                            Coach: Eric Wohl at ewohl@sdsu.edu
                            Coach: Rubi Mena at rmena@sdsu.edu
                            
                 Please Contact Us With Any Inquiries!
                 """);
        info.setEditable(false);
        info.setFont(new Font("Monospaced", Font.PLAIN, 14));
        info.setBackground(getBackground());
        info.setLineWrap(true);
        info.setWrapStyleWord(true);

        // ===== Main content panel =====
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(getBackground());
        contentPanel.add(new JScrollPane(info));

        // ===== Image section (BOTTOM of the page) =====
        JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        imagePanel.setBackground(getBackground());
        imagePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // FoodPage-style: directly load from "assets/..." or wherever your images are stored
        String[] imagePaths = {
                "assets/ball-throw.jpg",
                "assets/kick.jpg"
        };

        for (String imagePath : imagePaths) {
            ImageIcon icon = new ImageIcon(imagePath);
            // scale images to a consistent width
            Image scaled = icon.getImage().getScaledInstance(280, 170, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(scaled));
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            imagePanel.add(imageLabel);
        }

        // Add image section BELOW the text
        contentPanel.add(imagePanel);

        // ===== Scrollable main area =====
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane, BorderLayout.CENTER);

        // ===== Post button at bottom =====
        JPanel buttons = new JPanel();
        JButton reportButton = new JButton("Post!");
        buttons.add(reportButton);
        add(buttons, BorderLayout.SOUTH);
        reportButton.addActionListener(e -> openReportDialog());
    }

    private void openReportDialog() {
        JDialog dialog = new JDialog((Frame) null, "Post!", true);
        dialog.setSize(700, 900);
        dialog.setLocationRelativeTo(null);
        dialog.setLayout(new BorderLayout(10, 10));

        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 6, 6));
        JTextField club = new JTextField();
        JTextField day = new JTextField();
        JTextField time = new JTextField();
        JTextField eventName = new JTextField();
        JTextField description = new JTextField();

        inputPanel.add(new JLabel("Club Name"));
        inputPanel.add(club);
        inputPanel.add(new JLabel("What Day Is The Event? (DD/MM/YYYY):"));
        inputPanel.add(day);
        inputPanel.add(new JLabel("What Time Is The Event? (24:00):"));
        inputPanel.add(time);
        inputPanel.add(new JLabel("Event Name:"));
        inputPanel.add(eventName);
        inputPanel.add(new JLabel("Event Description:"));
        inputPanel.add(description);

        dialog.add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton submitBtn = new JButton("Submit");
        JButton cancelBtn = new JButton("Cancel");
        buttonPanel.add(submitBtn);
        buttonPanel.add(cancelBtn);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        submitBtn.addActionListener(ev -> {
            JOptionPane.showMessageDialog(dialog,
                    "Posted by: " + club.getText() +
                            "\nDay: " + day.getText() +
                            "\nTime: " + time.getText() +
                            "\nEvent name: " + eventName.getText() +
                            "\nDescription: " + description.getText(),
                    "Posted!",
                    JOptionPane.INFORMATION_MESSAGE);
            dialog.dispose();
        });

        cancelBtn.addActionListener(ev -> dialog.dispose());
        dialog.setVisible(true);
    }
}
