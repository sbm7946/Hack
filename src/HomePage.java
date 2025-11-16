import javax.swing.*;
import java.awt.*;

public class HomePage extends JPanel {

    private MainFrame mainFrame;

    public HomePage(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        setLayout(new BorderLayout());

        JLabel title = new JLabel("Home Page", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 24f));

        JButton goToSettings = new JButton("Go to Settings");
        goToSettings.addActionListener(e ->
                mainFrame.showPage(MainFrame.PAGE_SETTINGS)
        );

        add(title, BorderLayout.CENTER);
        add(goToSettings, BorderLayout.SOUTH);
    }
}