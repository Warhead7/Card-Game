/** @author 
*James Davies
*/
import java.util.*;

/** This class stores all the game logic so that the game will work.
*/
public class Game{
	Human newPlayer; //Human object for use within the whole class.
	Computer newBot; //Computer object for use within the whole class.
	boolean playerTurn = true; //Boolean to select turn used in the whole class.
	
	/** 
	* This method allows the user to enter their name and
	* store it in the system.
	*<br>Calls {@link Game#newGame()}.
	*<br>Calls {@link java.util.Scanner#nextLine}.
	*/
	protected void InitialisePlayer(){
		//Initialises a scanner for the user to input their name later.
		Scanner input = new Scanner(System.in);
		//Stores the Name parameter.
	    String name;
		
		//Prompts the user to enter their name and takes their input.
		System.out.println("Please enter your name");
		name = input.nextLine();
		
		//Creates a new instance of the Human class.
		newPlayer = new Human(name);
		//Calls the newGame method.
		newGame();	
		
	}
	
	/** Initialises a new game and gets the decks ready.
	*<br>Calls {@link Card#printTop(ArrayDeque , ArrayDeque)}.
	*<br>Calls {@link Game#InitialiseCPU(ArrayDeque)}.
	*<br>Calls {@link Game#compare(ArrayDeque , ArrayDeque)}.
	*<br>Calls {@link java.util.Scanner#nextInt}.
	*/
	protected void newGame(){
		//Asks the user how many cards they would wish to play with.
		Scanner input = new Scanner(System.in);
		System.out.println("How many cards would you like to have in each deck?");
		
		//Takes the input and validates it to be correct.
		int noOfCards = input.nextInt();
		if (noOfCards < 1){
			System.out.println("Please input a valid number");
			noOfCards = input.nextInt();
		}
		
		int noOfAttributes = 5;
		//Creates the player and the bot deck.
		ArrayDeque<Card> deckQueue = generateDeckPlayer(noOfCards, noOfAttributes);
		ArrayDeque<Card> cpuQueue = generateDeckPlayer(noOfCards, noOfAttributes);
		System.out.println("Decks created!");
		
		//Initialises the bot.
		InitialiseCPU(cpuQueue);
		
		//Prints the top card of the player's deck.
		Card card = new Card();
		card.printTop(deckQueue, cpuQueue);
		 
		compare(deckQueue, cpuQueue);
		
	}
	
	/** 
	*This method creates a BOT object for the player to play against.
	*@param cpuQueue Stores the bot's deck.
	*<br>Calls {@link java.util.Scanner#nextInt}.
	*/
	protected void InitialiseCPU(ArrayDeque<Card> cpuQueue){
		//Parameters for the bot.
		String name = "BOT";
		int choice;
		
		//Asks user what sort of bot they wish to play against and takes their input.
		System.out.println("What type of BOT do you wish to play against?");
		System.out.println("1:Normal	2:Random	3:Smart");
		Scanner input = new Scanner(System.in);
		choice = input.nextInt();
		
		//Checks the number they have input is valid.
		if (choice > 3 || choice <= 0){
			System.out.println("Please enter a valid number");
			choice = input.nextInt();
		}
		
		//Creates a new instance of the Computer class for the bot.
		newBot = new Computer(name, choice, cpuQueue);
		
	}
	

	
	/** This generates the players cards and adds them to the deck.
	*@param noOfCards Stores the number of cards in the deck.
	*@param noOfAttributes Stores the number of attributes in a card.
	*@return Returns the completed deck.
	*<br>Calls {@link Game#getTitle()}.
	*<br>Calls {@link Game#getFirstName()}.
	*<br>Calls {@link Game#getLastName()}.
	*/
	protected ArrayDeque<Card> generateDeckPlayer (int noOfCards, int noOfAttributes){
		
		//Creates a new deck equal to the size of the number of cards chosen.
		ArrayDeque<Card> deck = new ArrayDeque<Card>(noOfCards);
		
		//Loops around to add new cards to the deck, whilst getting names and attributes.
		for (int i = 0; i<noOfCards; i++){
			Card newCard = new Card (getTitle() + getFirstName() + getLastName(), noOfAttributes);
			deck.add(newCard);
		}
		
		//Returns the filled deck.
		return deck;
	}
	
	
	
	
	/** This method allows for random names to be generated
	*@return Returns the first name.
	*/
	protected String getFirstName(){
		//Declares a string as the name and generates a random number to be used.
		String name;
		int randNum = (int) (Math.random() * 10);
		
		//Chooses a name based on the random number.
		switch(randNum){
			case 1: name = "Black ";break;
			case 2: name = "Red ";break;
			case 3: name = "Blue ";break;
			case 4: name = "Green ";break;
			case 5: name = "Pink ";break;
			case 6: name = "Maroon ";break;
			case 7: name = "Orange ";break;
			case 8: name = "Yellow ";break;
			case 9: name = "Purple ";break;
			default: name = "White ";
		}
		//Returns the first name.
		return name;
	}
	
	/** This method allows us to get the last name of the card.
	*@return Returns the last name.
	*/
	protected String getLastName(){
		//Declares a string as the name and generates a random number to be used.
		String name;
		int randNum = (int) (Math.random() * 10);
		
		//Chooses a name based on the random number.
		switch(randNum){
			case 1: name = "Leopard";break;
			case 2: name = "Bear";break;
			case 3: name = "Armadillo";break;
			case 4: name = "Wolf";break;
			case 5: name = "Chicken";break;
			case 6: name = "Cheetah";break;
			case 7: name = "Dragon";break;
			case 8: name = "Kraken";break;
			case 9: name = "Eagle";break;
			default: name = "Blood Worm";
		}
		//Returns the last name.
		return name;
	}
	
	/** Sets the title name of the card. 
	*@return Returns the title of the card.
	*/
	protected String getTitle(){
	//Declares a string as the name and generates a random number to be used.
	String name;
	int randNum = (int) (Math.random() * 10);
		
		//Chooses a name based on the random number.
		switch(randNum){
			case 1: name = "The Unbroken ";break;
			case 2: name = "The Charming ";break;
			case 3: name = "The World Eating ";break;
			case 4: name = "The Fiery ";break;
			case 5: name = "The Ancient ";break;
			case 6: name = "The Unforgiving ";break;
			case 7: name = "The Soul Destroying ";break;
			case 8: name = "The Bad News Bringing ";break;
			case 9: name = "The Sorrowful ";break;
			default: name = "The Big Bad ";break;
		}
		//Returns the title.
		return name;
	}
	
	/** Allows a selected attribute to be compared to assess a winner 
	*@param queue Stores the user's deck.
	*@param botQueue Stores the bot's deck.
	*<br>Calls {@link Card#getAttributes()}.
	*<br>Calls {@link Attribute#getValue()}.
	*<br>Calls {@link Human#getName()}.
	*<br>Calls {@link Computer#getName()}.
	*<br>Calls {@link Attribute#getName()}.
	*/
	protected void compare(ArrayDeque<Card> queue, ArrayDeque<Card> botQueue){
		//Declares a choice variable, as well as a place to store compared attributes
		int choice;
		int playerAtt;
		int botAtt;
		
		
		//gets the attribute list of the card for each deck.
		ArrayList<Attribute> attributes = queue.peek().getAttributes();
		ArrayList<Attribute> botAttributes = botQueue.peek().getAttributes();
		
		//Performs different operations depending on the user's choice and whether it is their turn.
		choice = determineTurn(attributes);
		
		//gets the chosen attribute from both decks ready to compare
		playerAtt = attributes.get(choice-1).getValue();
		botAtt = botAttributes.get(choice-1).getValue();
		
		//compares the 2 numbers
		if (playerAtt >= botAtt){
			
			System.out.println(newPlayer.getName() + " wins this round!");
			System.out.println(queue.peek().returnName() + " has defeated " + botQueue.peek().returnName() + " on " + 
			attributes.get(choice-1).getName() + " (" + playerAtt + "vs" + botAtt + ")");
			newPlayer.addCard(botQueue, queue);
			
			
		} else if (botAtt > playerAtt) {
			System.out.println(newBot.getName() + " wins this round!");
			System.out.println(botQueue.peek().returnName() + " has defeated " + queue.peek().returnName() + " on " + 
			botAttributes.get(choice-1).getName() + " (" + playerAtt + "vs" + botAtt + ")");
			newBot.addCard(queue, botQueue);
			
		}
		
		endCheck(queue, botQueue); //Checks to see if the game should finish.
		
		
	}
	
	/** Checks to see if the game should end.
	*@param queue Stores the user's deck.
	*@param botQueue Stores the bot's deck.
	*<br>Calls {@link Game#winner(ArrayDeque, ArrayDeque)}.
	*<br>Calls {@link Card#printTop(ArrayDeque, ArrayDeque)}.
	*<br>Calls {@link Game#compare(ArrayDeque, ArrayDeque)}.
	*/	
	protected void endCheck(ArrayDeque<Card> queue, ArrayDeque<Card> botQueue){
			//Checks to see if one of the players has won yet.
		if (queue.size() == 0 || botQueue.size() == 0){
			winner(queue, botQueue);
		}
		
		//Prints the top card again after drawing new cards.
		Card card = new Card();
		card.printTop(queue, botQueue);
		
		//If there are still cards left on both sides then the game continues.
		if (queue.size() > 0 && botQueue.size() > 0){
			compare(queue, botQueue);
			}
		}
	
	/** Checks to see which turn it is.
	*@param attributes Stores the list of attributes.
	*@return Returns the attribute choice.
	*<br>Calls {@link Computer#normalBot()}.
	*<br>Calls {@link Computer#randomBot()}.
	*<br>Calls {@link Computer#smartBot()}.
	*<br>Calls {@link Human#chooseAttribute(ArrayList)}.
	*/
	protected int determineTurn(ArrayList<Attribute> attributes) {
		int choice = 0;
		
		if (playerTurn == true){
			choice = newPlayer.chooseAttribute(attributes); //If it is the human's turn then let them choose an attribute.
			playerTurn = false;
		} else if (playerTurn == false){
			if (newBot.getType() == 1){
				choice = newBot.normalBot(); //Calls method for a normal bot.
				playerTurn = true;
			} else if (newBot.getType() == 2){
				choice = newBot.randomBot(); //Calls method for a random bot.
				playerTurn = true;
			} else  if (newBot.getType() == 3){
				choice = newBot.smartBot(); //Calls method for a smart bot.
				playerTurn = true;
			}
		}
		return choice;
	}
	
	/** The method displays the winner and ask the user if they would like to replay or exit the game.
	*@param queue Stores the user's deck.
	*@param botQueue Stores the bot's queue.
	*<br>Calls {@link Computer#getName()}.
	*<br>Calls {@link Human#getName()}.
	*<br>Calls {@link Game#InitialisePlayer()}.
	*<br>Calls {@link java.util.Scanner#nextInt}.
	*/
	protected void winner(ArrayDeque<Card> queue, ArrayDeque<Card> botQueue){
		
		//If the user's deck is empty then the bot wins.
		if (queue.size() == 0){
			System.out.println(newBot.getName() + " wins!!!");
		} else if (botQueue.size() == 0){ //If the bot's deck is empty then the user wins.
			System.out.println(newPlayer.getName() + " wins!!!");
		}
		
		int choice;
		Scanner input = new Scanner(System.in);
		//User chooses an option about what they want to happen.
		System.out.println("Select an option:"); 
		System.out.println("1: Replay	2:Exit Game");
		choice = input.nextInt();
		
		//Validation on the inputted number.
		if ((choice > 2) || (choice < 1)){
			System.out.println("Please enter a valid option");
			choice = input.nextInt();
		}
		
		
		//Performs different actions based on what the user chooses.
		if (choice == 1){
			InitialisePlayer(); //restarts game
		} else if (choice == 2){
			System.exit(0); //exits game.
		}
		
	}
	
	
}
