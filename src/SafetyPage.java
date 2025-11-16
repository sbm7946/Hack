import javax.swing.*;
import java.awt.*;

public class SafetyPage extends JPanel {

    private MainFrame mainFrame;

    public SafetyPage(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        setLayout(new BorderLayout());

        JLabel title = new JLabel("Safety Page", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 24f));

        

        add(title, BorderLayout.CENTER);
    }
}