package Helpers;
import javax.swing.*;


public class PageRecord {
    private final String PAGE_ID;
    private JButton pageButton;
    private JPanel pagePanel;


    public PageRecord(String PAGE_ID, JButton pageButton, JPanel pagePanel){
        this.PAGE_ID = PAGE_ID;
        this.pageButton = pageButton;
        this.pagePanel = pagePanel;
    }

    public String getPageID(){
        return PAGE_ID;
    }

    public JButton getPageButton(){
        return pageButton;
    }

    public JPanel getPagPanel(){
        return pagePanel;
    }
}
