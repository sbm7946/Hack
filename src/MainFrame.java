import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;

    public static final String PAGE_HOME = "PAGE_HOME";
    public static final String PAGE_SETTINGS = "PAGE_SETTINGS";

    public MainFrame() {
        super("Hackathon App");

        // Basic window stuff
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // center

        // Card layout holds all "pages"
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Create pages
        JPanel homePage = new HomePage(this);
        JPanel settingsPage = new Settingspage(this);

        // Add pages to the card panel with a name
        cardPanel.add(homePage, PAGE_HOME);
        cardPanel.add(settingsPage, PAGE_SETTINGS);

        // Layout: nav bar on top, content in center
        setLayout(new BorderLayout());
        add(createNavBar(), BorderLayout.NORTH);
        add(cardPanel, BorderLayout.CENTER);
    }

    // Simple nav bar with buttons to switch pages
    private JComponent createNavBar() {
        JPanel nav = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton homeBtn = new JButton("Home");
        JButton settingsBtn = new JButton("Settings");

        homeBtn.addActionListener(e -> showPage(PAGE_HOME));
        settingsBtn.addActionListener(e -> showPage(PAGE_SETTINGS));

        nav.add(homeBtn);
        nav.add(settingsBtn);

        return nav;
    }

    // Helper so pages can ask the frame to switch
    public void showPage(String pageName) {
        cardLayout.show(cardPanel, pageName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}