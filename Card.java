/** @author 
*James Davies
*/

import java.util.*;
/** This class holds the properties and attributes of each card in the deck.
*/

public class Card {
	//The fields for this class are the name of the card and an attribute list.
	private String cardName;
	protected ArrayList<Attribute> attributes;
	
	/** Empty constructor for the card class.*/
	public Card(){
		
	}
	
	/** Constructor for the card class that only has the cardName.
	*@param name Stores the name of the card.
	*/
	public Card(String name){
		cardName = name;
		
	}
	
	/** This constructor allocates the name and value of the attributes of a single card 
	*when a new instance of the Card class is made.
	*@param name Stores the name of the card.
	*@param noOfAttributes Stores the number of attributes that are in a card.
	*<br>Calls {@link java.util.ArrayList#add}.
	*<br>Calls {@link java.lang.Math#random}.
	*/
	public Card (String name, int noOfAttributes){
		this.cardName = name;
		attributes = new ArrayList<Attribute>(noOfAttributes); //store the arrayList of attributes in this variable.
		String attName;
		
		//Allocates attribute names based on how many attributes are needed.
		for (int i = 0; i<noOfAttributes; i++){
			switch (i) {
				
				case 0: attName = "1: Strength"; 
				break;
				case 1: attName = "2: Intelligence";
				break;
				case 2: attName = "3: Charisma"; 
				break;
				case 3: attName = "4: Endurance";
				break;
				case 4: attName = "5: Luck"; 
				break;
				case 5: attName = "6: Perception";
				break;
				case 6: attName = "7: Agility";
				break;
				default: attName = "Coolness";
			} 
			
			
			//Creates a value for the attribute
			int value = (int) (Math.random() * 10);
			if (value > 5){
				int limit = (int) (Math.random() * 10); //Creates a chance that the value will be lessened. This is to stop frequent high values.
				if (limit < 5){
					value = value -3;
				}
			}
			
			//Adds the name and value to the attribute list.
			attributes.add(new Attribute(attName, value));
			
			
		}
	}
	
	/** Returns the attribute list.
	*@return Returns the attribute list.
	*/
	protected ArrayList<Attribute> getAttributes(){
		return attributes;
	}
	
	/** Returns the name of the card.
	*@return Returns the name of the card.
	*/
	protected String returnName(){
		return cardName;
	}
	
	/** Prints the top card of the deck.
	*<br>Calls {@link Attribute#print()}.
	*/
	protected void print(){
		System.out.println("----- " + cardName + " -----" ); //Prints the name of the card
		
		for (Attribute a : attributes) {
			a.print();} //Prints the list of attributes
	}
	
	/** This method is a series of print statements which then leads to printing the top card of the deck.
	*@param queue Stores the user's deck.
	*@param botQueue stores the bot's deck.
	*<br>Calls {@link Card#print()}.
	*<br>Calls {@link java.util.ArrayDeque#peek}.
	*/
	protected void printTop(ArrayDeque<Card> queue, ArrayDeque<Card> botQueue){
		System.out.println("You have " + queue.size() + " cards in your deck.");
		System.out.println("Computer has " + botQueue.size() + " cards in their deck.");
		try {Thread.sleep(3000);}catch (InterruptedException e) {}; //Used to create delay so the lines do not pass by the user too fast before they read what they say.
		System.out.println("You draw: ");
		queue.peek().print();
	}
	
}