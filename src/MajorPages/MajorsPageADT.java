package MajorPages;
import javax.swing.*;
import java.awt.*;

public class MajorsPageADT extends JPanel{
    static final float TITLE_FONT_SIZE = 15f;
    static final int TITLE_FONT = Font.BOLD;


    public MajorsPageADT(String subTitle){
        setLayout(new BorderLayout());
        JLabel title = new JLabel(subTitle.concat(" Page"), SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(TITLE_FONT, TITLE_FONT_SIZE));

        add(title, BorderLayout.NORTH);
    }
    
}
