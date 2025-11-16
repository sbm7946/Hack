package AthleticsPage;
//package MajorPages;

import javax.swing.*;

import DataBase.Post;
import DataBase.PostsContainer;

import java.awt.*;



import MajorPages.MajorsPageADT;

public class ClubPostings extends MajorsPageADT{

private JPanel feedPanel;
    private PostsContainer pC = PostsContainer.getInstance();

    public ClubPostings() {
        super("Clubs Postings");

        setLayout(new BorderLayout());

        JLabel title = new JLabel("All Club Postings", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        feedPanel = new JPanel();
        feedPanel.setLayout(new BoxLayout(feedPanel, BoxLayout.Y_AXIS));
        JScrollPane scroll = new JScrollPane(feedPanel);
        add(scroll, BorderLayout.CENTER);

        loadPostsIntoFeed();
    }

    private void loadPostsIntoFeed() {
        feedPanel.removeAll();

        for (Post p : pC.getPosts()) {
            feedPanel.add(p);
            feedPanel.add(Box.createVerticalStrut(10));
        }

        feedPanel.revalidate();
        feedPanel.repaint();
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        if (b) loadPostsIntoFeed();
    }
}


