package MajorPages;

import javax.swing.*;


import java.awt.*;

public class CompSciPage extends MajorsPageADT{
    




    public CompSciPage() {
        super("Computer Science");
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Computer Science General Page!", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        JTextArea info = new JTextArea("""
                 •College Counseling:
                    Location:
                        • Geology, Mathematics, Computer Science (GMSC) Room 413
                    Times:
                        • Monday-Friday from 8-4:30
                    Email:
                        • sciences.studentsucess@sdsu.edu
                    Number:
                        • 619-594-6191
                 
                 • Tutoring:
                    Location:
                        • Math & Science Learning Center in the Malcom Love Library Room 328
                    Dates & Times:
                        • Tuesday:
                         	- 4:00 - 5:00 PM for CS 240
                        •Thursday:
                         	- 10:30 - 12:30 PM for CS 210
                         	- 2:00 - 3:30 PM for CS 240
                         	- 4:00 - 5:00 PM for CS 240
                        • Friday:
                         	- 10:00 - 11:30 AM for CS 210 & CS 240
                         	- 11:30 - 12:00 PM for CS 210
                         	-12:00 - 2:00 PM for CS 240
                     
                        
                    
                            
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

