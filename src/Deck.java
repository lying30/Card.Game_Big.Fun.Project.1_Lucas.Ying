/**
 * Author: Lucas Ying
 * Date: 12/14/22
 */
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cards;
    private int cardsLeft;

    public Deck(String[] ranks, String[] suits, int[] values, GameViewer window) {
        cards = new ArrayList<Card>();
        //iterate through the suits and ranks and create the cards in the deck
        for(int i = 0; i < suits.length; i++) {
            for(int j = 0; j < ranks.length; j++) {
                //keeps track of the correct image number with the card in the deck
                int num = (j*4) + 1 + i;
                cards.add(new Card(ranks[j], suits[i], values[j], new ImageIcon("Resources/Cards/"+num+".png").getImage(), window));
            }
        }
        // initiate the cards left as the 52 cards or size of cards in the deck
        cardsLeft = cards.size();
        shuffle();
    }
    public boolean isEmpty() {
        if(cardsLeft == 0) {
            return true;
        }
        return false;
    }
    public int getCardsLeft() {
        return cardsLeft;
    }
    public Card deal() {
        //if there are zero cards return null
        if(cardsLeft == 0) {
            return null;
        }
        //return the top card subtract and then return
        return cards.get(--cardsLeft);
    }
    //
    public void shuffle() {
        //loops through starting from the top of the deck going down
        for(int i = cardsLeft-1; i > 0; i--) {
            //creates a random number out of the number of cards left
            int r = (int)(Math.random()*i);
            //creates a variable that holds the top card
            Card top = cards.get(i);
            //creates a variable that holds the random card to be swapped
            Card random = cards.get(r);
            //swaps the random card with top card
            cards.set(i, random);
            cards.set(r, top);
        }
        cardsLeft = cards.size();
    }
}
