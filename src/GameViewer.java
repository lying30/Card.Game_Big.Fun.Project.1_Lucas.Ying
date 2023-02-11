/**
 * Author: Lucas Ying
 * Date: 2/10/23
 */
import javax.swing.*;
import java.awt.*;

public class GameViewer extends JFrame{
    private Game a;
    private Image green;
    private Image backCard;
    private Image[] cards;
    private static final int    WINDOW_WIDTH = 900,
            WINDOW_HEIGHT = 700;

    public GameViewer(Game a){
        this.a = a;
        green = new ImageIcon("Resources/green.jpg").getImage();
        backCard = new ImageIcon("Resources/Cards/back.png").getImage();

        cards = new Image[52];
        int num = 1;
        //Iterates through and assigns images to each of the spots in the array
        for(int i = 0; i < 52; i++) {
                cards[i] = new ImageIcon("Resources/"+num+".png").getImage();
                num++;
        }


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("WAR");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);

    }
    public Image[] getImages() {
        return cards;
    }

    public void paint(Graphics g) {
        //Background!
        g.drawImage(green, 		// image to draw
                0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, 	// (x, y) of upper left corner in output window and width, height
                this);
        //Instructions drawn!
        g.setColor(Color.WHITE);
        g.setFont(new Font("Serif", Font.ROMAN_BASELINE, 15));
        g.drawString("Instructions: Both players will draw one card and the highest ranked card wins the round.\n" +
                "The player(you) and the computer will play", 50,50);
        g.drawString("3 rounds and the most amount of rounds won of those 3 rounds wins " +
                "the game.\nGood Luck!", 50, 65);

        //Draw the backs of the cards to start on the board
        g.drawImage(backCard, 100,300, 97,137, this);
        g.drawImage(backCard, 600,300, 97,137, this);

        //If the card has a value and is the computer's card
        //Draw the card on the board
        if(a.getComputerCard() != null && a.getSwitcher() == 1){
            a.getComputerCard().draw(g, 450, 300);
        }
        //If the card has a value and is the player's card
        //Draw the card on the board
        if(a.getPlayerCard() != null && a.getSwitcher() == 2){
            a.getPlayerCard().draw(g, 300, 300);
        }
        //If the player wins fill the first circle
        if(a.getRoundResult() == 1){
            g.setColor(Color.yellow);
            g.fillOval(50,100,40,40);
//            g.drawImage(backCard, 450, 300, 97, 137, this);
//            g.drawImage(backCard, 300, 300, 97, 137, this);
        }
        g.drawOval(50, 100, 40, 40);
        //If player wins the game fill second player circle
        if(a.getWinResult() == 1){
            //Fill circle
            g.setColor(Color.yellow);
            g.fillOval(100,100,40,40);
            //Fill rectangle that is under the win statement
            g.setColor(Color.green);
            g.fillRect(300,500, 300,30);
            //Print the win statement
            g.setColor(Color.BLACK);
            g.setFont(new Font("r", Font.BOLD, 25));
            g.drawString("You Won!", 300,525);

        }
        g.drawOval(100, 100, 40, 40);
        //If the computer wins fill the first circle
        if(a.getRoundResult() == 2){
            g.setColor(Color.yellow);
            g.fillOval(650,100,40,40);
//            g.drawImage(backCard, 450, 300, 97, 137, this);
//            g.drawImage(backCard, 300, 300, 97, 137, this);
        }
        g.drawOval(650, 100, 40, 40);
        //If the computer wins the game fill the second circle
        if(a.getWinResult() == 2){
            //Fill circle
            g.setColor(Color.yellow);
            g.fillOval(600,100,40,40);
            //Fill rectangle that is under the win statement
            g.setColor(Color.green);
            g.fillRect(300,500, 300,30);
            //Print the win statement
            g.setColor(Color.BLACK);
            g.setFont(new Font("r", Font.BOLD, 25));
            g.drawString("The computer won :(", 300,525);
        }
        g.drawOval(600, 100, 40, 40);
        //If the outcome for the round is a tie
        //Draw it!
        if(a.getTie() == true){
            g.setColor(Color.WHITE);
            g.setFont(new Font("r", Font.BOLD, 25));
            g.drawString("Its a tie! Play one more!", 300,525);
        }
    }
}
