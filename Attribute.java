/** @author 
*James Davies
*/
import java.util.Random;
/** This class holds the name and value of the attributes.
*/
 
public class Attribute {
	//The fields for this class are the name and the value of an attribute.
	private String name;
	private int value;
	
	/** The constructor for the attribute class has 2 fields - name and number.
	*@param n Stores the name of the attribute.
	*@param num Stores the value of the attribute.
	*/
	Attribute(String n, int num){
		name = n;
		value = num;
	} 
	
	/** Empty Constructor */
	Attribute(){
		
	}
	
	/** Prints the value of the attribute */
	protected void print(){
		System.out.println(name + " value = " + value);
	}
	
	/** Returns the value of an attribute.
	*@return returns the value of an attribute.
	*/
	protected int getValue() {
		return value;
	}
	
	/** Returns the name of an attribute.
	*@return returns the name of an attribute.
	*/
	protected String getName() {
		return name;
	}
}