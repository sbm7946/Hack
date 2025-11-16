package MajorPages;

import javax.swing.*;


import java.awt.*;

public class ArtPage extends MajorsPageADT{
    




    public ArtPage() {
        super("Postings ");
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Postings!", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        JTextArea info = new JTextArea("empty :/ ");
        info.setEditable(false);
        info.setFont(new Font("Monospaced", Font.PLAIN, 14));
        info.setBackground(getBackground());
        add(title, BorderLayout.NORTH);
        add(new JScrollPane(info), BorderLayout.CENTER);

        

        
    }
}

