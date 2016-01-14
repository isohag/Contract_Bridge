/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contract_bridge;

/**
 *
 * @author rashedul
 */
public class Player {

    public boolean[][] myCards = new boolean[4][13];
    Deck d = new Deck();
    private int numOfCards = 0;
    //	Constructor

    Player() {

    }

    //	Methods

    public void printCards() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                if (myCards[i][j]) {
                    System.out.println(Deck.stringDeck[i][j]);
                }
            }
        }
    }

    public String[] hand() {
        String[] hand = new String[13];
        int k = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                if (myCards[i][j]) {
                    hand[k] = Deck.stringDeck[i][j];
                    k++;
                }
            }
        }
        return hand;
    }

    public void drawCards() {
        numOfCards = 13;
        myCards = d.draw13Cards();
    }

    public void popCard(String card) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                if (Deck.stringDeck[i][j].equals(card)) {
                    myCards[i][j] = false;
                    numOfCards--;
                }
            }
        }
    }
    
    public int getNumOfCards(){return numOfCards;}

    public String play() {
        String card = "";

        for (int i = 0; i < 4; i++) {
            for (int j=0; j<13;j++){
                if (myCards[i][j]) {
                    card = Deck.stringDeck[i][j];
                    
                }
            }
        }

        return card;
    }

    public String play(String card) {
        int count = 0;
        int row = indexOfCard(card)[0];
        int column = indexOfCard(card)[1];
        String pickCard = "";
        for (int j = 0; j < 13; j++) {
            if (myCards[row][j] && j > column) {
                pickCard = Deck.stringDeck[row][j];
            }
            if (count == 0 && myCards[row][j]) {
                ++count;
                pickCard = Deck.stringDeck[row][j];
            }
        }
        if (pickCard.isEmpty()) {
            pickCard = minCard();
        }
        return pickCard;
    }

    // Returns Index of Card
    public int[] indexOfCard(String card) {
        int[] result = new int[2];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                if (Deck.stringDeck[i][j].equals(card)) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    // Returns Minimum Card
    public String minCard() {
        int min = 99;
        String card = "";
        for (int i = 0; i < 4; i++) {
            for (int j = 12; j >= 0; j--) {
                if (myCards[i][j] && min > Deck.deck[i][j]) {
                    card = Deck.stringDeck[i][j];
                    min = Deck.deck[i][j];
                }

            }
        }
        return card;
    }

}
