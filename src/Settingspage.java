import javax.swing.*;
import java.awt.*;

public class Settingspage extends JPanel {

    private MainFrame mainFrame;

    public Settingspage(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        setLayout(new BorderLayout());

        JLabel title = new JLabel("Settings Page", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 24f));

        JButton backHome = new JButton("Back to Home");
        backHome.addActionListener(e ->
                mainFrame.showPage(MainFrame.PAGE_HOME)
        );

        add(title, BorderLayout.CENTER);
        add(backHome, BorderLayout.SOUTH);
    }
}