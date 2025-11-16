import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    private CardLayout pageManager;
    private JPanel cardPanel;
    ArrayList<NavPageRecord> pageList;



    static final int SCREEN_HEIGHT = 600;
    static final int SCREEN_WIDTH = 800;



    


    public MainFrame() {
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
        pageList.add(new NavPageRecord("PAGE_HOME", new JButton("Home"), new HomePage(this)));
        pageList.add(new NavPageRecord("PAGE_MAJORS", new JButton("Majors"), new MajorsPage(this)));
        pageList.add(new NavPageRecord("PAGE_BASICS", new JButton("Basics"), new BasicsPage(this)));
        pageList.add(new NavPageRecord("PAGE_ATHLETICS", new JButton("Athletics"), new AthleticPage(this)));
        pageList.add(new NavPageRecord("PAGE_SAFETY", new JButton("Safety"), new SafetyPage(this)));
        


        // Add pages to the card panel with a name
        for (NavPageRecord record : pageList){
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
        JPanel nav = new JPanel(new FlowLayout(FlowLayout.LEFT));

        for (NavPageRecord record : pageList){
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
            new MainFrame();
        });
    }
}