import javax.swing.*;

import CorePages.AthleticsPage;
import CorePages.BasicsPage;
import CorePages.HomePage;
import CorePages.MajorsPage;
import CorePages.SafetyPage;
import Helpers.PageRecord;

import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    private CardLayout pageManager;
    private JPanel cardPanel;
    ArrayList<PageRecord> pageList;

    static final int SCREEN_HEIGHT = 600;
    static final int SCREEN_WIDTH = 800;


    public MainFrame() {
        //App title
        super("Hackathon App");

        // Basic window stuff
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setLocationRelativeTo(null); // center

        //Page Manager holds all our pages
        pageManager = new CardLayout();
        cardPanel = new JPanel(pageManager);
        pageList = new ArrayList<>();

        // Create page records and add them to the page list
        pageList.add(new PageRecord("PAGE_HOME", new JButton("Home"), new HomePage()));
        pageList.add(new PageRecord("PAGE_MAJORS", new JButton("Majors"), new MajorsPage()));
        pageList.add(new PageRecord("PAGE_BASICS", new JButton("Basics"), new BasicsPage()));
        pageList.add(new PageRecord("PAGE_ATHLETICS", new JButton("Athletics"), new AthleticsPage()));
        pageList.add(new PageRecord("PAGE_SAFETY", new JButton("Safety"), new SafetyPage()));
        
        // Add pages to the card panel with a name
        for (PageRecord record : pageList){
            cardPanel.add(record.getPagPanel(), record.getPageID());
        }
        

        // Layout: nav bar on top, content in center
        setLayout(new BorderLayout());
        add(createNavBar(), BorderLayout.NORTH);
        add(cardPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }


    // Simple nav bar with buttons to switch pages
    private JComponent createNavBar() {
        JPanel nav = new JPanel(new FlowLayout(FlowLayout.CENTER));

        for (PageRecord record : pageList){
            record.getPageButton().addActionListener(e -> showPage(record.getPageID()));
            nav.add(record.getPageButton());
        }

        
        return nav;
    }

    // Helper so pages can ask the frame to switch
    public void showPage(String pageName) {
        pageManager.show(cardPanel, pageName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginFrame();
        });
    }
}