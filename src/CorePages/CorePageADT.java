package CorePages;
import javax.swing.*;


import java.awt.*;

public class CorePageADT extends JPanel{
    
    static final int TITLE_FONT = Font.BOLD;
    static final float TITLE_TEXT_SIZE = 24f;

    protected final JPanel CONTENT_PANEL;

    public CorePageADT( String pageTitle) {

        setLayout(new BorderLayout());

        JLabel title = new JLabel(pageTitle.concat(" Page"), SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(TITLE_FONT, TITLE_TEXT_SIZE));

        

        add(title, BorderLayout.NORTH);

        CONTENT_PANEL = new JPanel();
        CONTENT_PANEL.setLayout(new BorderLayout());
        add(CONTENT_PANEL, BorderLayout.CENTER);

        
        
    }
}
