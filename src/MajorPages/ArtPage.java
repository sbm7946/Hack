package MajorPages;

import javax.swing.*;


import java.awt.*;

public class ArtPage extends JPanel implements MajorsPageADT{
    




    public ArtPage() {

        setLayout(new BorderLayout());

        JLabel title = new JLabel("Art Page", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(TITLE_FONT, TITLE_FONT_SIZE));

        

        add(title, BorderLayout.NORTH);
    }
}

