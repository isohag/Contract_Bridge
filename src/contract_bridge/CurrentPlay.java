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
public class CurrentPlay {
    int suit, rank, highRank;
    String highCard;
    boolean matchesSuit = true;
    boolean higher = true;
    public CurrentPlay(){}
    public CurrentPlay(String card) {
        suit = indexOfCard(card)[0];
        rank = indexOfCard(card)[1];
        highRank = rank;
        highCard = card;
    }
    
    public void set(String card) {
        suit = indexOfCard(card)[0];
        rank = indexOfCard(card)[1];
        highCard = card;
    }
    public boolean isHigher() { return higher;}
    
    public String getHighCard(){return highCard;}
    
    public int getRank(){ return highRank; }
    
    public int getSuit(){ return suit;}
    
    public void add(String card) {
        if (indexOfCard(card)[0] == suit){
            if (indexOfCard(card)[1] > highRank){
                highRank = indexOfCard(card)[1];
                higher = true;
                highCard = card;
            } else
                higher = false;
        } else {matchesSuit = false; higher = false;}
    }
    
    public static int[] indexOfCard(String card) {
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
    
}
