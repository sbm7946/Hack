import javax.swing.*;
import java.awt.*;

public class AthleticPage extends JPanel {

    private MainFrame mainFrame;

    public AthleticPage(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        setLayout(new BorderLayout());

        JLabel title = new JLabel("Athletics Page", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 24f));

        JButton goToSettings = new JButton("Go to Settings");
        goToSettings.addActionListener(e ->
                mainFrame.showPage(MainFrame.PAGE_SETTINGS)
        );

        add(title, BorderLayout.CENTER);
        add(goToSettings, BorderLayout.SOUTH);
    }
}