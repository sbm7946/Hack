package BasicsPages;
import java.awt.*;
import javax.swing.*;

public class BasicsPagesADT extends JPanel{
    static final float TITLE_FONT_SIZE = 15f;
    static final int TITLE_FONT = Font.BOLD;


    public BasicsPagesADT(String subTitle){
        setLayout(new BorderLayout());
        JLabel title = new JLabel(subTitle.concat(" Page"), SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(TITLE_FONT, TITLE_FONT_SIZE));

        add(title, BorderLayout.NORTH);
    }
    
}
