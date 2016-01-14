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
import java.util.Random;

public class Deck {
	//	Data Field
	public static int[][] deck = new int[4][13];
	public static boolean[][] booleanDeck = new boolean[4][13];
	public static String[][] stringDeck = new String[4][13];
	
	// Constructor
	Deck(){
		// Deck of Cards
		for (int i=0;i<4;i++){
			for (int j=0;j<13;j++){
				deck[i][j] = j+2;			//	Integer Deck
				booleanDeck[i][j] = true;	//	Boolean Deck
				if (i==0) 					//	String Deck
					stringDeck[i][j] = "Playing_card_club_" + (j+2);
				else if (i==1)
					stringDeck[i][j] = "Playing_card_diamond_" + (j+2);
				else if (i==2)
					stringDeck[i][j] = "Playing_card_heart_" + (j+2);
					
				else{
					
                                    stringDeck[i][j] = "Playing_card_spade_" + (j+2);
						
				}
				
			}
		}
	}
	
	//	Methods
	public void print(){
		for (int i=0;i<4;i++){
			for (int j=0;j<13;j++){
				System.out.print(deck[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public void printBoolean(){
		for (int i=0;i<4;i++){
			for (int j=0;j<13;j++){
				System.out.print(booleanDeck[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public boolean hasCard(){
		for (int i=0;i<4;i++) {
			for (int j=0;j<13;j++){
				if (booleanDeck[i][j]==true)
					return true;
			}
		}
		return false;
	}
	
	public static void shuffle(){
		for (int i=0;i<4;i++){
			for (int j=0;j<13;j++){
				booleanDeck[i][j] = true;
			}
		}
	}
	
	public static boolean[][] draw13Cards(){
		boolean[][] result = new boolean[4][13];
		for (int i=0;i<4;i++){
			for (int j=0;j<13;j++){
				result[i][j] = false;
			}
		}
		Random card = new Random();
		int row = card.nextInt(4);
		int column = card.nextInt(13);
		for (int i=0;i<13;i++){
			while (!booleanDeck[row][column]){
				row = card.nextInt(4);
				column = card.nextInt(13);
			}
			booleanDeck[row][column] = false;
			result[row][column] = true;
		}
		return result;
	}
	
	

}

