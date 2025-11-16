
import javax.swing.*;
import java.awt.*;

public class ArtPage extends JPanel{
    



    private MainFrame mainFrame;

    public ArtPage(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        setLayout(new BorderLayout());

        JLabel title = new JLabel("Art Page", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 24f));

        

        add(title, BorderLayout.CENTER);
    }
}

