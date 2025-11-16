import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;

    public static final String PAGE_HOME = "PAGE_HOME";
    public static final String PAGE_SETTINGS = "PAGE_SETTINGS";
    public static final String MAJORS_PAGE = "MAJORS_PAGE";
    public static final String BASICS_PAGE = "BASICS_PAGE";
    public static final String ATHLETICS_PAGE = "ATHLETICS_PAGE";
    


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
        JPanel majors = new Majors(this);
        JPanel basics = new BasicsPage(this);
        JPanel ath = new AthleticPage(this);

        // Add pages to the card panel with a name
        cardPanel.add(homePage, PAGE_HOME);
        cardPanel.add(settingsPage, PAGE_SETTINGS);
        cardPanel.add(majors, MAJORS_PAGE);
        cardPanel.add(basics, BASICS_PAGE);
        cardPanel.add(ath, ATHLETICS_PAGE);

        // Layout: nav bar on top, content in center
        setLayout(new BorderLayout());
        add(createNavBar(), BorderLayout.NORTH);
        add(cardPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }

    // Simple nav bar with buttons to switch pages
    private JComponent createNavBar() {
        JPanel nav = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton homeBtn = new JButton("Home");
        JButton settingsBtn = new JButton("Settings");
        JButton m = new JButton("Majors");
        JButton b = new JButton("Basics");
        JButton ath = new JButton("Athletics");

        homeBtn.addActionListener(e -> showPage(PAGE_HOME));
        settingsBtn.addActionListener(e -> showPage(PAGE_SETTINGS));
        m.addActionListener(e -> showPage(MAJORS_PAGE));
        b.addActionListener(e -> showPage(BASICS_PAGE));
        ath.addActionListener(e -> showPage(ATHLETICS_PAGE));
        nav.add(homeBtn);
        nav.add(settingsBtn);
        nav.add(m);
        nav.add(b);
        nav.add(ath);

        return nav;
    }

    // Helper so pages can ask the frame to switch
    public void showPage(String pageName) {
        cardLayout.show(cardPanel, pageName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame();
        });
    }
}