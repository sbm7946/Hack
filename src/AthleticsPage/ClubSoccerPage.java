package AthleticsPage;
//package MajorPages;

import javax.swing.*;


import java.awt.*;

import MajorPages.MajorsPageADT;

public class ClubSoccerPage extends MajorsPageADT {

    public ClubSoccerPage() {
        super("Club Soccer");
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Club Soccer General Page!", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        JTextArea info = new JTextArea("""
                 •Insta:
                        • Womens Club Insta: @sdsuwomensclubsoccer
                        • Mens Club Insta: @mensclubsoccer
  
                 • About us:
                        We are a intramural club soccer team dediacated to ever improving our skills and love for the game. 
                        
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
        JPanel buttons = new JPanel();
        JButton reportButton = new JButton("Post!");
        //JButton resourcesButton = new JButton("Contact us!");
        buttons.add(reportButton);
        //buttons.add(resourcesButton);
        add(title, BorderLayout.NORTH);
        add(new JScrollPane(info), BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);
        reportButton.addActionListener(e -> openReportDialog());
        //resourcesButton.addActionListener(e -> openReportDialog());


    }

    private void openReportDialog() {
        // Create dialog
        JDialog dialog = new JDialog((Frame) null, "Post!", true);
        dialog.setSize(700, 900);
        dialog.setLocationRelativeTo(null);
        dialog.setLayout(new BorderLayout(1, 1));

        // Input fields
        JPanel inputPanel = new JPanel(new GridLayout(20, 10));
        JTextField club = new JTextField();
        JTextField day = new JTextField();
        JTextField eventName = new JTextField();
        JTextField time = new JTextField();
        JTextArea nameArea = new JTextArea(1, 1);
        JTextField description = new JTextField();
        JTextArea descriptionArea = new JTextArea(3, 4);
        JTextArea dayArea = new JTextArea(1, 1);
        JTextArea timeArea = new JTextArea(1, 1);

        inputPanel.add(new JLabel(" Club Name"));
        inputPanel.add(club);
        inputPanel.add(new JLabel(" What Day Is The Event? (DD/MM/YYYY):"));
        inputPanel.add(day);
        inputPanel.add(new JLabel(" What Time Is The Event? (24:00)"));
        inputPanel.add(time);
        inputPanel.add(new JLabel(" What Is The Event Name?"));
        inputPanel.add(eventName);
        inputPanel.add(new JLabel(" What Is The Event?"));
        inputPanel.add(description);
        dialog.add(inputPanel,BorderLayout.NORTH);
        dialog.add(dayArea, BorderLayout.CENTER);
        dialog.add(timeArea, BorderLayout.SOUTH);
        //dialog.add();
        dialog.add(descriptionArea, BorderLayout.SOUTH);
        //dialog.add(new JScrollPane(description), BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel();
        JButton submitBtn = new JButton("Submit");
        JButton cancelBtn = new JButton("Cancel");
        buttonPanel.add(submitBtn);
        buttonPanel.add(cancelBtn);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        // Button actions
        submitBtn.addActionListener(ev -> {
            String name = club.getText().trim();
            String desc = description.getText().trim();
            String timeString = time.getText().trim();
            String dayString = day.getText().trim();
            String event = eventName.getText().trim();

            if(!name.isEmpty() || !desc.isEmpty() || !timeString.isEmpty() || !dayString.isEmpty()) {
                JOptionPane.showMessageDialog(dialog,
                        "Posted by: " +name +"\nDay: "+dayString+ "\nTime: " +timeString +"\nEvent name: " + event +"\nEvent Description: " +desc,
                        "Posted!",
                        JOptionPane.INFORMATION_MESSAGE);
                dialog.dispose();
            }

//            if (desc.isEmpty()) {
//                JOptionPane.showMessageDialog(dialog,
//                        "Please describe the incident before submitting.",
//                        "Missing Information",
//                        JOptionPane.WARNING_MESSAGE);
//                return;
//            }

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
