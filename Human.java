/** @author 
*James Davies
*/
import java.util.*;
/** This is an extenstion of the player class specifically for human players.
*/
public class Human extends Player{
	//Fields for this class are the name and the deck of the player.
	protected String humanName;
	ArrayDeque<Card> humanDeck;
	
	/** Constructor for this class containing only the name. 
	*@param name Stores the name of the user.
	*/
	public Human(String name){
		humanName = name;
	}
	
	/** Constructor for this class containing both the name and the deck. 
	@param name Stores the name of the user.
	@param deck Stores the deck of cards for the user.
	*/
	public Human(String name, ArrayDeque<Card> deck){
		humanName = name;
		humanDeck = deck;
	}
	
	/** Returns the attribute choice that user chooses.
	*@param attList Stores the list of attributes.
	*@return Returns the attribute selection.
	*<br>Calls {@link java.util.Scanner#nextInt}.
	*/
	protected int chooseAttribute(ArrayList<Attribute> attList){
		int choice;
		
		System.out.println("What attribute would you like to compare?");
		Scanner input = new Scanner(System.in);
		choice = input.nextInt();
		
		//Validates they have inputted a valid number.
		if (choice > attList.size()){
			System.out.println("Please input a number between and " + attList.size());
			choice = input.nextInt();
		}
		return choice;
	}
	
	/** Returns the name of the user.
	*@return Returns the name of the user.
	*/
	protected String getName(){
		return humanName;
	}
}