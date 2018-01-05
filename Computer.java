/** @author 
*James Davies
*/
import java.util.*;

/** This class controls the BOT behaviour when selecting what attributes to compare.
 */
public class Computer extends Player {
	//The fields for this class are the name of the bot, the type of the bot and the bot's deck.
	protected String botName;
	protected int botType;
	ArrayDeque<Card> botDeck;
	
	/** Constructor of the Computer class.
	*@param name Stores the name of the bot.
	*@param type Stores the type of bot the user is playing against.
	*@param deck Stores the bot's deck.
	*/
	public Computer(String name, int type, ArrayDeque<Card> deck){
		botName = name;
		botType = type;
		botDeck = deck;
	}
	
	/** Returns the name of the bot.
	*@return returns the name of the bot.
	*/
	protected String getName(){
		return botName;
	}
	
	/** Returns what type of bot the user is playing against.
	*@return returns the bot type.
	*/
	protected int getType(){
		return botType;
	}
	
	/** Returns a predictable value as a choice if playing against a normal bot.
	@return returns the same int each time.
	*/
	protected int normalBot(){
		return 1; //Returns a predictable number.
	}
	
	/** Returns a random value as a choice if playing a random bot.
	*@return returns the value of their choice + 1.
	*<br>Calls {@link Card#getAttributes()}.
	*<br>Calls {@link java.lang.Math#random}.
	*<br>Calls {@link java.util.ArrayList#size}.
	*/
	protected int randomBot(){
		ArrayList<Attribute> attList = botDeck.peek().getAttributes(); //Gets the list of attributes
		int value = (int) (Math.random() * attList.size() ); //Allocates a random number
		
		return value + 1;
	}
	
	/** Returns the best value as a choice if playing a smart bot. 
	*@return Returns the index of the highest value in the list.
	*<br>Calls {@link Attribute#getValue()}.
	*<br>Calls {@link java.util.ArrayList#size}.	
	*<br>Calls {@link java.util.ArrayDeque#peek}.	
	*/
	protected int smartBot(){
		ArrayList<Attribute> attList = botDeck.peek().getAttributes(); //Gets the list of attributes.
		int size = attList.size();
		int index = 0;
		
		ArrayList<Integer> valueList = new ArrayList<Integer>(); //Creates a new integer array list.
		
		for (int i = 0; i < size; i++){
			valueList.add(attList.get(i).getValue()); //Adds values of attributes to integer array list.
		}
		
		int max = Collections.max(valueList); //Finds the maximum number in the list.
		
		
		index = valueList.indexOf(max) + 1; //Allocates the index of the maximum number in the array.
		
		return index;
		
		
		
		
	}
}