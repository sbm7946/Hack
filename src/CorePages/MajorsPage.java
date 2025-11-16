package CorePages;
import javax.swing.*;

import Helpers.PageRecord;
import MajorPages.ArtPage;
import MajorPages.CompSciPage;

import java.awt.*;
import java.util.ArrayList;

public class MajorsPage extends CorePageADT{


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



    public MajorsPage() {
        super("Majors");
        //side bar for majors to select
        majorsPageManager = new CardLayout();
        cardPanel = new JPanel(majorsPageManager);
        majorsPageList = new ArrayList<>();

        //gives panel a box around it
        cardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));


        //adding pages to side panel
        majorsPageList.add(new PageRecord("ART_PAGE", 
                                            new JButton("Art"), 
                                            new ArtPage()));
        majorsPageList.add(new PageRecord("COMP_SCI_PAGE", 
                                        new JButton("Computer Science"), 
                                        new CompSciPage()));

        for (PageRecord record : majorsPageList){
            cardPanel.add(record.getPagPanel(), record.getPageID());
        }

        
        //have to do this manually becasue of box
        JLabel title = new JLabel("Majors Page", SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.NORTH);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 24f));

        add(title, BorderLayout.NORTH);

        CONTENT_PANEL.add(createSidebar(), BorderLayout.WEST);
        CONTENT_PANEL.add(cardPanel, BorderLayout.CENTER);


    }
}