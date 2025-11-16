package BasicsPages;
import javax.swing.*;


import java.awt.*;

public class MentalHealthPage extends JPanel implements BasicsPagesADT{
    public MentalHealthPage() {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Mental Health Page", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(TITLE_FONT, TITLE_FONT_SIZE));
        add(title, BorderLayout.NORTH);
    }
}
