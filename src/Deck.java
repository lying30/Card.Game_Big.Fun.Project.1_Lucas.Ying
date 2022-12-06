/**
 * Author: Lucas Ying
 * Date: 12/07/22
 */
import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cards;
    private int cardsLeft;

    public Deck(String[] ranks, String[] suits, int[] values) {
        cards = new ArrayList<Card>();
        for(int i = 0; i < suits.length; i++) {
            for(int j = 0; j < ranks.length; j++) {
                cards.add(new Card(ranks[j], suits[i], values[j]));
            }
        }
        int cardsLeft = cards.size();
    }
    public boolean isEmpty() {
        if(cardsLeft == 0) {
            return true;
        }
        return false;
    }
    public int getCardsLeft(int cardsLeft) {
        return cardsLeft;
    }
    public Card deal() {
        if(cardsLeft == 0) {
            return null;
        }
        return cards.get(--cardsLeft);
        //cardsLeft - 1 then return the cardsleft to return the top card subtract and then return
    }
    public void shuffle() {
        for(int i = cardsLeft-1; i > 0; i--) {

        }
    }
}
