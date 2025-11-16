
import javax.swing.*;
import java.awt.*;

public class CompSciPage extends JPanel{
    



    private MainFrame mainFrame;

    public CompSciPage(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        setLayout(new BorderLayout());

        JLabel title = new JLabel("Computer Science Page", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 24f));

        

        add(title, BorderLayout.CENTER);
    }
}

