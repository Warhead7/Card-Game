/** @author 
*James Davies
*/
import java.util.*;
/**
* This class stores player information and holds the deck collection info.
*/
public class Player{
	protected String name;
	protected int numCards;
	
	/** Empty constructor */
	public Player(){
		
	}
	
	/** Constructor containing the name 
	*@param n Stores the name of the player.
	*/
	public Player(String n ){
		name = n;
		
	}
	
	/** Returns the name of the player
	*@return Returns the name of the player.
	*/
	protected String getName(){
		return name;
	}
	
	/** Method for adding a card to the winner's deck whilst taking that card from the loser.
	*@param loserQueue Stores the deck of the user that lost. 
	*@param winnerQueue Stores the deck of the user that won. 
	*<br>Calls {@link Card#returnName()}. 
	*<br>Calls {@link java.util.ArrayDeque#poll}.
	*<br>Calls {@link java.util.ArrayDeque#add}.
	*/
	protected void addCard(ArrayDeque<Card> loserQueue, ArrayDeque<Card> winnerQueue){
		
		
		
		Card newCard = loserQueue.poll(); //takes the loser's card away
		Card topCard = winnerQueue.poll(); //adds the top card of the winner's deck back to the bottom of the deck
		
		//Adds the last round's cards to the winners deck.
		winnerQueue.add(newCard);
		winnerQueue.add(topCard);
		System.out.println(newCard.returnName() + " has been added to the winner's deck.");
	}
}