/**
 * Game: War
 * Author: Lucas Ying
 * Date: 12/14/22
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Player player1;
    private Player computer;
    private Deck deck;

    private Scanner scanner;

    public static final String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    public static final String[] suits = {"Hearts", "Clubs", "Spades", "Diamonds"};
    public static final int[] values = {1,2,3,4,5,6,7,8,9,10,11,12,13};
    public Game() {
        deck = new Deck(ranks, suits, values);
        ArrayList<Card> player1Cards = new ArrayList<Card>();
        ArrayList<Card> player2Cards = new ArrayList<Card>();

        player1 = new Player("Player 1", player1Cards,0);
        computer = new Player("Computer", player2Cards, 0);
    }

    public void printInstructions() {
        System.out.println();
        System.out.println("WAR!!!!!");
        System.out.println();
        System.out.println();
        System.out.println("Instructions: Both players will draw one card and the highest ranked card wins the round." +
                "The player(you) and the computer will play 3 rounds and the most amount of rounds won of those 3 rounds wins " +
                "the game. Good Luck!");

        scanner = new Scanner(System.in);
        System.out.println("Would you like to start? (y/n)");
        String yes = scanner.nextLine();
        System.out.println("If you said no we are starting anyways, thank you! :)");
    }



    public void playGame() {
        //loop through 26 times
        for (int i = 0; i < 26; i++) {
            player1.getHand().add(deck.deal());
            computer.getHand().add(deck.deal());
        }
        //loop through the rounds 3 times
        for (int i = 0; i < 3; i++) {
            //gets point value of the players 1st card
            ArrayList<Card> hand1 = player1.getHand();
            Card firstCard1 = hand1.remove(0);
            System.out.println();
            System.out.println("Would you like to place your card? (y/n)");
            String yes = scanner.nextLine();
            System.out.println("Your card is " + firstCard1);
            int point1 = firstCard1.getPoint();

            //gets point value of the computers first card
            ArrayList<Card> hand2 = computer.getHand();
            Card firstCard2 = hand2.remove(0);
            System.out.println("Would you like to let the computer go? (y)");
            String yes2 = scanner.nextLine();
            System.out.println("The computers card is " + firstCard2);
            int point2 = firstCard2.getPoint();

            //checking to see who won the round
            if (point1 > point2) {
                player1.addPoints(1);
                System.out.println("Nice you won this round!");
                System.out.println();
            } else if (point2 > point1) {
                computer.addPoints(1);
                System.out.println("The computer won this round :(");
                System.out.println();
            }
            //if the cards are equal point values they place one more card
            else {
                tiebreak(hand1, hand2);
            }

            //get points of the players to compare who won the most amount of rounds
            int player1Points = player1.getPoints();
            int computerPoints = computer.getPoints();

            if (player1Points >= 2) {
                System.out.println();
                System.out.println("You Won!!!!");
                break;
            } else if (computerPoints >= 2) {
                System.out.println();
                System.out.println("The computer Won :(");
                break;
            }
        }
    }

    //If there is a tie it will do it again and place one more card until it finds a winner of that round
    public void tiebreak(ArrayList<Card> hand1, ArrayList<Card> hand2) {
        System.out.println("Its a tie :( ---- play another card");
        System.out.println("Would you like to place your card? (y/n)");
        String yes3 = scanner.nextLine();
        Card firstCard1 = hand1.remove(0);
        System.out.println();
        System.out.println("Your card is " + firstCard1);
        int point1 = firstCard1.getPoint();

        Card firstCard2 = hand2.remove(0);
        System.out.println("The computers card is " + firstCard2);
        int point2 = firstCard2.getPoint();

        if(point1 > point2) {
            player1.addPoints(1);
            System.out.println("You won the tie!");
        }
        else if(point2 > point1) {
            computer.addPoints(1);
            System.out.println("You lost the tie :(");
        }
        else {
            tiebreak(hand1, hand2);
        }
    }

    public static void main(String[] args) {
        //make game object to call the methods in the game class
        Game game = new Game();
        game.printInstructions();
        game.playGame();
    }
}

