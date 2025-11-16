package BasicsPages;
import javax.swing.*;


import java.awt.*;

public class HealthServicesPage extends BasicsPagesADT{
    public HealthServicesPage() {

        super("");

        setLayout(new BorderLayout());
        JLabel title = new JLabel("ALL SERVICES", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        JTextArea phText = new JTextArea("""
                Primary Health:
                - Basic medical care and treatment
                - Acute illnesses
                - Minor injuries
                - First aid
                - Health screenings and basic wellness exams
                 
                 """);
        phText.setEditable(false);
        phText.setFont(new Font("Monospaced", Font.PLAIN, 14));
        phText.setBackground(getBackground());
        add(new JScrollPane(phText), BorderLayout.WEST);

        title.setFont(new Font("Arial", Font.BOLD, 24));
        JTextArea srhText = new JTextArea("""
                Sexual and Reproductive Health
                - Sexually transmitted infection 
                  (STI) screenings*
                - Family PACT reproductive health services
                - Contraceptive management 
                   (including some implants and IUDs)
                - Annual exams
                - Pap testing*
                - Medication abortion services*
                 """);

        srhText.setFont(new Font("Monospaced", Font.PLAIN, 14));
        srhText.setBackground(getBackground());
        srhText.setEditable(false);
        add(new JScrollPane(srhText), BorderLayout.EAST);


        title.setFont(new Font("Arial", Font.BOLD, 24));
        JTextArea addServices = new JTextArea("""
                Additional Services:
                - Health & Wellness Vending Machine
                - Outside the SHS Pharmacy
                - Telehealth Booths
                - Soundproof booths at Calpulli reservable 
                  for telehealth visits with outside providers
                  via HealtheConnect
                 """);

        addServices.setFont(new Font("Monospaced", Font.PLAIN, 14));
        addServices.setBackground(getBackground());
        addServices.setEditable(false);
        add(new JScrollPane(addServices), BorderLayout.CENTER);
    }
}
