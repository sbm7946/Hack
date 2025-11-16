package BasicsPages;
import javax.swing.*;


import java.awt.*;

public class FoodPage extends JPanel implements BasicsPagesADT{
    public FoodPage() {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Food Page", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(TITLE_FONT, TITLE_FONT_SIZE));
        add(title, BorderLayout.NORTH);
    }
}
