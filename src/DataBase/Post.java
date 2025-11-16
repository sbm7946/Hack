package DataBase;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class Post extends JPanel implements Serializable{

    private static final long serialVersionUID = 1L;
    private String clubName;
    private String eventName;
    private String eventDate;
    private String eventTime;
    private String eventDesc;
    private ImageIcon eventImg;


    public Post(String clubname, String eventName, String eventDate,
                        String eventTime, String eventDesc, ImageIcon eventImg){

        this.clubName = clubname;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventDesc = eventDesc;
        this.eventImg = eventImg;

        generatePost();
    }


    public String getClubName(){
        return clubName;
    }
    public String getEventName(){
        return eventName;
    }
    public String geteventDate(){
        return eventDate;
    }
    public String getEventTime(){
        return eventTime;
    }
    public String getEventDesc(){
        return eventDesc;
    }
    public ImageIcon getEventImg(){
        return eventImg;
    }




    public void generatePost(){
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setLayout(new BorderLayout(10, 10));

        //for post titles
        JPanel header = new JPanel(new GridLayout(0, 1));
        header.add(new JLabel("Club: " + clubName));
        header.add(new JLabel("Event: " + eventName));
        header.add(new JLabel("Date: " + eventDate + " Time: " + eventTime));

        //for event description:

        JTextArea desc = new JTextArea(eventDesc);
        

        //wraps text
        desc.setLineWrap(true);
        desc.setWrapStyleWord(true);
    
        desc.setEditable(false);

        JScrollPane descScroll = new JScrollPane(desc); 
        descScroll.setBorder(null);

        add(header, BorderLayout.NORTH);
        add(descScroll, BorderLayout.CENTER);


        if (eventImg != null){
            JLabel img = new JLabel(eventImg);
            add(img, BorderLayout.EAST);
        }
    }
}