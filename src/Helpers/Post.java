package Helpers;

import javax.swing.*;


public class Post extends JPanel{
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

}
