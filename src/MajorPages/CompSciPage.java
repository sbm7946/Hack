package MajorPages;

import javax.swing.*;


import java.awt.*;

public class CompSciPage extends JPanel implements MajorsPageADT{
    




    public CompSciPage() {

        setLayout(new BorderLayout());

        JLabel title = new JLabel("Computer Science Page", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(TITLE_FONT, TITLE_FONT_SIZE));

        

        add(title, BorderLayout.NORTH);
    }
}

