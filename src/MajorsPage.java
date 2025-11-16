import javax.swing.*;
import java.awt.*;

public class MajorsPage extends JPanel {

    private MainFrame mainFrame;

    public MajorsPage(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        setLayout(new BorderLayout());

        JLabel title = new JLabel("MajorsPage Page", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 24f));

        

        add(title, BorderLayout.CENTER);
    }
}