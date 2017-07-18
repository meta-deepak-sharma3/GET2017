package Assignments;

public class LargestDigit {
	//Assuming initially maxNumber is -1.
	int maxNumber = -1;
	//Method to find largest Digit.
	public int largestDigit(int number){
		if(number%10>maxNumber){
			maxNumber = number%10;
		}
		
		if (number/10==0){
			return maxNumber;
		}
		
		return largestDigit(number/10);
	}
}
