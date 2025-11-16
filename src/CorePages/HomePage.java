package CorePages;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;

public class HomePage extends JPanel {
    public HomePage() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // ===== Main content area =====
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBorder(new EmptyBorder(20, 40, 40, 40));
        content.setBackground(Color.WHITE);

        JLabel hello = new JLabel("Hello! Welcome to the SDSU Community App!");
        hello.setFont(hello.getFont().deriveFont(Font.BOLD, 22f));
        hello.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel instr1 = new JLabel("Please navigate to the top to select the community you wish to view!");
        instr1.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel emailRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        emailRow.setOpaque(false);
        JLabel contactText = new JLabel("If you have any questions, please reach out at ");
        JTextField email = new JTextField("______@sdsu.edu", 18);
        email.setBorder(new LineBorder(new Color(0xBBBBBB)));
        emailRow.add(contactText);
        emailRow.add(email);
        emailRow.setAlignmentX(Component.LEFT_ALIGNMENT);

        content.add(hello);
        content.add(Box.createVerticalStrut(8));
        content.add(instr1);
        content.add(Box.createVerticalStrut(8));
        content.add(emailRow);
        content.add(Box.createVerticalStrut(20));

        // ===== Resources box =====
        JPanel box = new JPanel();
        box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
        box.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.BLACK, 1),
                new EmptyBorder(12, 14, 12, 14)
        ));
        box.setBackground(Color.WHITE);
        box.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel hdr = new JLabel("Useful Resources:");
        hdr.setFont(hdr.getFont().deriveFont(Font.BOLD, 16f));
        hdr.setAlignmentX(Component.LEFT_ALIGNMENT);

        box.add(hdr);
        box.add(Box.createVerticalStrut(8));
        addLines(box, List.of(
                "Emergency: Call 911!",
                "Campus Police Number: 619-594-1991",
                "SDSU Amnesty Number: 619-594-1991",
                "National Sexual Assault Hotline: 800-656-4673",
                "Suicide and Crisis Lifeline: 988"
        ));

        box.add(Box.createVerticalStrut(8));
        box.add(makeLine("Suicide Text Line:"));
        box.add(makeBullet("English: Text \"HOME\" to 741741"));
        box.add(makeBullet("Español: Envía \"AYUDA\" a 741741"));
        box.add(makeBullet("WhatsApp en Español: Textear a 442-AYÚDAME"));
        box.add(makeBullet("WhatsApp in English: Text 442-SUPPORT"));

        content.add(box);

        // Center the content
        JPanel wrapper = new JPanel(new GridBagLayout());
        wrapper.setBackground(Color.WHITE);
        wrapper.add(content);

        add(wrapper, BorderLayout.CENTER);
    }

    private void addLines(JPanel parent, List<String> lines) {
        for (String s : lines) parent.add(makeLine(s));
    }

    private JComponent makeLine(String text) {
        JLabel l = new JLabel("• " + text);
        l.setAlignmentX(Component.LEFT_ALIGNMENT);
        return l;
    }

    private JComponent makeBullet(String text) {
        JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 0));
        row.setOpaque(false);
        JLabel dash = new JLabel("–");
        JLabel lbl = new JLabel(text);
        row.add(Box.createHorizontalStrut(14));
        row.add(dash);
        row.add(lbl);
        row.setAlignmentX(Component.LEFT_ALIGNMENT);
        return row;
    }
}
