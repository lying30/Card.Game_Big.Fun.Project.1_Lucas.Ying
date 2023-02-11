import java.awt.*;
/**
 * Author: Lucas Ying
 * Date: 2/10/23
 */

public class Card {
    private String rank;
    private String suit;
    private int point;
    private GameViewer a;
    private Image image;
    private int aWidth;
    private int aHeight;
    public Card(String rank, String suit, int point, Image image, GameViewer a) {
        this.rank = rank;
        this.suit = suit;
        this.point = point;

        this.image = image;

        this.a = a;
        this.aWidth = a.getWidth();
        this.aHeight = a.getHeight();

    }
    public void setRank(String rank) {
        this.rank = rank;
    }
    public void setSuit(String suit) {
        this.suit = suit;
    }
    public void setPoint(int point) {
        this.point = point;
    }
    public String getRank() {
        return rank;
    }
    public String getSuit() {
        return suit;
    }
    public int getPoint() {
        return point;
    }
    public String toString() {
        return rank + " of " + suit;
    }

    public void draw(Graphics g, int x, int y) {
        //Draws the image given for that card
        g.drawImage(image,
                x,y, 97, 137,
                a);
    }
}

