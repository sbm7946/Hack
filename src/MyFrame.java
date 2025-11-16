import javax.swing.*;




public class MyFrame extends JFrame{
    static final int WIDTH = 720;
    static final int HEIGHT = 1080;


    public MyFrame(){



        this.setSize(  WIDTH, HEIGHT);
        this.setTitle("The Swaggy Math");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);


    }


    public static void main(String[] args) {
        new MyFrame();
    }
}
