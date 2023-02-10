import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameViewer extends JFrame{
    private Game a;
    private Image green;
    private Image[] cards;
    private static final int    WINDOW_WIDTH = 900,
            WINDOW_HEIGHT = 700;

    public GameViewer(Game a){
        this.a = a;
        green = new ImageIcon("Resources/green.jpg").getImage();
        cards = new Image[52];
        int num = 1;
        for(int i = 0; i < 52; i++) {
                cards[i] = new ImageIcon("Resources/"+num+".png").getImage();
                num++;
        }


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("The table");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);

    }
    public Image[] getImages() {
        return cards;
    }

    public void paint(Graphics g) {
        g.drawImage(green, 		// image to draw
                0, 0, 	// (x, y) of upper left corner in output window
                this);
        if(a.getComputerCard() != null){
            a.getComputerCard().draw(g);
        }
        else if(a.getPlayerCard() != null){
            a.getPlayerCard().draw(g);
        }

    }
}
