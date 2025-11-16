package CorePages;
import javax.swing.*;

import BasicsPages.FoodPage;
import BasicsPages.HealthCarePage;
import BasicsPages.MentalHealthPage;
import Helpers.PageRecord;
import MajorPages.ArtPage;
import MajorPages.CompSciPage;

import java.awt.*;
import java.util.ArrayList;

public class BasicsPage extends CorePageADT{


    private CardLayout basicsPageManager;
    private JPanel cardPanel;
    ArrayList<PageRecord> basicsPageList;


    private JComponent createSidebar(){
        JPanel sideBar = new JPanel();
        sideBar.setLayout(new BoxLayout(sideBar, BoxLayout.Y_AXIS));
        sideBar.setAlignmentY(0);

        sideBar.setLayout(new GridLayout(0, 1, 0, 10));

        for (PageRecord record : basicsPageList){
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
        basicsPageManager.show(cardPanel, pageName);
    }

    public BasicsPage() {
        super("Basics");
        //side bar for majors to select
        basicsPageManager = new CardLayout();
        cardPanel = new JPanel(basicsPageManager);
        basicsPageList = new ArrayList<>();

        //gives panel a box around it
        cardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));


        //adding pages to side panel
        basicsPageList.add(new PageRecord("HEALTHCARE_PAGE",
                new JButton("Healthcare"),
                new HealthCarePage()));
        basicsPageList.add(new PageRecord("FOOD_PAGE",
                new JButton("Food"),
                new FoodPage()));
        basicsPageList.add(new PageRecord("MENTAL_HEALTH_PAGE",
                new JButton("Mental Health"),
                new MentalHealthPage()));

        for (PageRecord record : basicsPageList){
            cardPanel.add(record.getPagPanel(), record.getPageID());
        }


        //have to do this manually becasue of box
        JLabel title = new JLabel("Basics Page", SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.NORTH);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 24f));

        add(title, BorderLayout.NORTH);

        CONTENT_PANEL.add(createSidebar(), BorderLayout.WEST);
        CONTENT_PANEL.add(cardPanel, BorderLayout.CENTER);


    }
}