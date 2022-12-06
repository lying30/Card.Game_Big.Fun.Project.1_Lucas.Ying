/**
 * Author: Lucas Ying
 * Date: 12/07/22
 */

public class Card {
    private String rank;
    private String suit;
    private int point;

    public Card(String rank, String suit, int point) {
        this.rank = rank;
        this.suit = suit;
        this.point = point;
    }

    public void setRank() {
        this.rank = rank;
    }
    public void setSuit() {
        this.suit = suit;
    }
    public void setPoint() {
        this.point = point;
    }
    public String getRank(String rank) {
        return rank;
    }
    public String getSuit(String suit) {
        return suit;
    }
    public int getPoint(int point) {
        return point;
    }
    public String toString() {
        return rank + " of " + suit;
    }
}
