package CorePages;
import Helpers.PageRecord;
import AthleticsPage.ClubSoccerPage;
import AthleticsPage.RockClimbingPage;
import javax.swing.*;


import java.awt.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AthleticsPage extends CorePageADT {

    private CardLayout majorsPageManager;
    private JPanel cardPanel;
    ArrayList<PageRecord> majorsPageList;


    private JComponent createSidebar(){
        JPanel sideBar = new JPanel();
        sideBar.setLayout(new BoxLayout(sideBar, BoxLayout.Y_AXIS));
        sideBar.setAlignmentY(0);

        sideBar.setLayout(new GridLayout(0, 1, 0, 6));

        for (PageRecord record : majorsPageList){
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



    public AthleticsPage() {
        super("Athletics");
        //side bar for majors to select
        majorsPageManager = new CardLayout();
        cardPanel = new JPanel(majorsPageManager);
        majorsPageList = new ArrayList<>();

        //gives panel a box around it
        cardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));


        //adding pages to side panel
        majorsPageList.add(new PageRecord("ROCK_CLIMBING_PAGE",
                new JButton("Club Soccer"),
                new ClubSoccerPage()));
        majorsPageList.add(new PageRecord("CLUB_SOCCER_PAGE",
                new JButton("Rock Climbing Club"),
                new RockClimbingPage()));

        for (PageRecord record : majorsPageList){
            cardPanel.add(record.getPagPanel(), record.getPageID());
        }


        //have to do this manually becasue of box
        JLabel title = new JLabel("Athletics Page", SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.NORTH);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 24f));

        add(title, BorderLayout.NORTH);

        CONTENT_PANEL.add(createSidebar(), BorderLayout.WEST);
        CONTENT_PANEL.add(cardPanel, BorderLayout.CENTER);


    }

}