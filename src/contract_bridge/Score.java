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
public class Score {
	private int myScore = 0;
	public String name = "";
	
	public void addOne(){myScore++;}
	public int getScore(){return myScore;}
	public void reset(){myScore=0;}
}
