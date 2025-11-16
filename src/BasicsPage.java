import javax.swing.*;
import java.awt.*;

public class BasicsPage extends JPanel {

    private MainFrame mainFrame;

    public BasicsPage(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        setLayout(new BorderLayout());

        JLabel title = new JLabel("Basics Page", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 24f));

        JButton goToSettings = new JButton("Go to Settings");
        goToSettings.addActionListener(e ->
                mainFrame.showPage(MainFrame.PAGE_SETTINGS)
        );

        add(title, BorderLayout.CENTER);
        add(goToSettings, BorderLayout.SOUTH);
    }
}