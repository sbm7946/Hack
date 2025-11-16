package BasicsPages;
import javax.swing.*;


import java.awt.*;

public class HealthcarePage extends JPanel implements BasicsPagesADT{
    public HealthcarePage() {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Healthcare Page", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(TITLE_FONT, TITLE_FONT_SIZE));
        add(title, BorderLayout.NORTH);
    }
}
