package OOPs_Session1;
import java.util.*;
//Buttons, Layout, Display, Command/Operation
interface Display{
	//print operator operands and result
	void printExpression(String Expression);	
}
public class CalculatorMain{
	// Input the operand and operator
	// set the button for it.
	// Button button = new Button();
	button.setType(String input);  //input should be mapped with button.
	//calling calculator class
	Calculator calculator = new Calculator(buttonOne, buttonTwo, operator);
	
}

class Calculator {
	String operandOneButtonType;
	String operandTwoButtonType;
	String operator;
	// Constructor definition
	Calculator(Button operandOne, Button operandTwo, Button operator){
		this.operandOneButtonType = operandOne.getType();
		this.operandTwoButtonType = operandTwo.getType();
		this.operator = operator.getType();
	}	

	/* starting with layout of screen and then with layout of buttons
	  then setting values of buttons for different numbers and operators.  
	 */
	// each calculator has its own layout so let it be private
	private Layout layout = new Layout();
	// using object setting display values of screen and then using button object array
	//and setting display values of each button.
	
	/* setting values for each button 
	  specifying their functions for operators or operands
	  using setButtonType method. 
	 */
	Button button[] = new Button[20];				//number of buttons can be taken from the user.
	//assigning type for button .
	/*//button[0].setButtonType("+");	*/
	
	/* Evaluating any value, calling operation class 
	and displaying final values in queues.
	 */
	
	Operation operation1 = new Operation(button[0]);
	operation1.getResult(operandOneButton, operandTwoButton, operator);      //retrieving result for operation by retrieving valuesqueue using getButtonType and calculating result.
	operation1.printExpression  //method will be printing all values present in queue
	operation1.emptyQueue	 //remove all values present in queue when button '=' is called.		
}
//class for specifications for each button. 
class Button{
	int buttonSizeLength;
	int buttonSizeWidth;
	int buttonPositionX;
	int buttonPositionY;
	String buttonType;
	boolean ispressed;
	
	public void setButtonType(String str){
		buttonType = str;						
		// method to set the type of whether its a operator or operand.
	}
	public String getButtonType(){
		//method to get type of button pressed
		/*switch cases will be used to represent different button types, with number cases 
		for numbers and Alphabets for different operators.
		*/
		return "";			//return string for type of button used in expression.
	}
}
//Performs operations
class Operation implements Display {
	float operandOne;
	float operandTwo;
	static Queue<String> resultQueue = new LinkedList<String>();
	//initializing values of operand1 and operand2
	void Operation(String op1, String op2, String operator){
		operandOne = op1;
		operandTwo = op2;
	}
	Operation(Button b){
		// get buttonType
		// add the appropriate buttonType into queue
		// check if the type is of operand type or operator type.
			//check if operator is before operand just push the operator
			// if operand is before operator perform the result and add it to the queue
	}
	String getResult(float operandOne, float operandTwo , String operator){
		String value ="";
		//check what is in queue . if its a operand before then retrieves operand and operator 
		//from queue and insert result.
		// return result of queue.
		//check button type to be "="
		printExpression(value);  //print value on screen
		return value;
	}
	void emptyQueue(){
		// empty the queue (reset the queue)
	}

	@Override
	public void printExpression(String Expression) {
		// printing values in queue.		
	}	
	//printing final Expression.
}
// layout of screen and buttons
class Layout{
	int screenSizeLength,  screenSizeWidth;
	int posScreenX, posScreenY;
	List<Button> buttonList;				// for getting lists of all available buttons
	//Displaying buttons
	Button button[] = new Button[100];
	/*making object for class button
	 * displaying positions and size of buttons using button object
	 * like button[5].int buttonPositionX;
	 */
}


