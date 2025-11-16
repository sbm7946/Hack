import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MajorsPage extends JPanel {

    private MainFrame mainFrame;

    private CardLayout majorsPageManager;
    private JPanel cardPanel;
    ArrayList<NavPageRecord> majorsPageList;


    private JComponent createSidebar(){
        JPanel sideBar = new JPanel();
        sideBar.setLayout(new BoxLayout(sideBar, BoxLayout.Y_AXIS));
        sideBar.setAlignmentY(0);

        sideBar.setLayout(new GridLayout(0, 1, 0, 10));

        for (NavPageRecord record : majorsPageList){
            JButton b = record.getPageButton();
            b.addActionListener(e -> showPage(record.getPageID()));

            b.setPreferredSize(getPreferredSize());

            sideBar.add(b);
        }

        //has side panel centered at y = 0 (center to the left)
        JPanel wrapper = new JPanel(new GridBagLayout());
        wrapper.add(sideBar);

        return wrapper;
    }

    public void showPage(String pageName) {
        majorsPageManager.show(cardPanel, pageName);
    }



    public MajorsPage(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        setLayout(new BorderLayout());

        //side bar for majors to select
        majorsPageManager = new CardLayout();
        cardPanel = new JPanel(majorsPageManager);
        majorsPageList = new ArrayList<>();

        //gives panel a box around it
        cardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));


        //adding pages to side panel
        majorsPageList.add(new NavPageRecord("ART_PAGE", 
                                            new JButton("Art"), 
                                            new ArtPage(mainFrame)));
        majorsPageList.add(new NavPageRecord("COMP_SCI_PAGE", 
                                        new JButton("Computer Science"), 
                                        new CompSciPage(mainFrame)));

        for (NavPageRecord record : majorsPageList){
            cardPanel.add(record.getPagPanel(), record.getPageID());
        }

        
        JLabel title = new JLabel("Majors Page", SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.NORTH);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 24f));

        add(title, BorderLayout.NORTH);

        add(createSidebar(), BorderLayout.WEST);
        add(cardPanel, BorderLayout.CENTER);


    }
}