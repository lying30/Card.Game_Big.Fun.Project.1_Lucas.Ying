/**
 * Game: Blackjack
 * Author: Lucas Ying
 * Date: 12/07/22
 */
public class Game {

    public static void main(String[] args) {
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] suits = {"Hearts", "Clubs", "Spades", "Diamonds"};
        int[] values = {1,2,3,4,5,6,7,8,9,10,11,12,13};

        Deck deck = new Deck(ranks, suits, values);


    }
}
