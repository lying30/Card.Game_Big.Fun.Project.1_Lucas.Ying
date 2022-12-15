import java.util.ArrayList;

/**
 * Author: Lucas Ying
 * Date: 12/14/22
 */
public class Player {
    private ArrayList<Card> hand;
    private int points;
    private String name;

    public Player(String name, int points) {
        this.name = name;
        points = 0;
    }
    public Player(String name, ArrayList<Card> hand, int points) {
        this.name = name;
        this.hand = hand;
        points = 0;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int x) {
        points += x;
    }

    public void addCard(Card x) {
        hand.add(x);
    }

    public String toString() {
        return name + " has " + points + " points" + "\n" + name + "'s cards: " + hand;
    }
}
