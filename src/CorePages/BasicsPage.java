package CorePages;
import javax.swing.*;

import BasicsPages.FoodPage;
import BasicsPages.HealthServicesPage;
import Helpers.PageRecord;
import javax.swing.ImageIcon;
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

        sideBar.setLayout(new GridLayout(0, 1, 0, 6));

        for (PageRecord record : basicsPageList){
            JButton b = record.getPageButton();
            b.addActionListener(e -> showPage(record.getPageID()));

            b.setPreferredSize(getPreferredSize());

            sideBar.add(b);
        }

        JPanel wrapper = new JPanel(new GridBagLayout());
        wrapper.add(sideBar);

        return wrapper;
    }

    public void showPage(String pageName) {
        basicsPageManager.show(cardPanel, pageName);
    }

    public BasicsPage() {
        super("Basics");
        basicsPageManager = new CardLayout();
        cardPanel = new JPanel(basicsPageManager);
        basicsPageList = new ArrayList<>();

        cardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));


        //adding pages to side panel
        basicsPageList.add(new PageRecord("FOOD_PAGE",
                new JButton("Food"),
                new FoodPage()));
        basicsPageList.add(new PageRecord("HEALTHCARE_PAGE",
                new JButton("Healthcare"),
                new HealthServicesPage()));

        for (PageRecord record : basicsPageList){
            cardPanel.add(record.getPagPanel(), record.getPageID());
        }


        JLabel title = new JLabel("Basics Page", SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.NORTH);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 24f));

        add(title, BorderLayout.NORTH);

        CONTENT_PANEL.add(createSidebar(), BorderLayout.WEST);
        CONTENT_PANEL.add(cardPanel, BorderLayout.CENTER);


    }
}