package Assignments;

public class GCD{
	//Method to find Greatest Common DIvisor between two numbers
	public int gcd(int number1, int number2){
		if (number2 != 0)
		       return gcd(number2, number1%number2);
		    else 
		       return number1;
	}

}
