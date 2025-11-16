import javax.swing.*;
import java.awt.*;

public class AthleticPage extends JPanel {

    private MainFrame mainFrame;

    public AthleticPage(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        setLayout(new BorderLayout());

        JLabel title = new JLabel("Athletics Page", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 24f));

        

        add(title, BorderLayout.CENTER);
    }
}