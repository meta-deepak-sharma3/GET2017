import java.util.InputMismatchException;
import java.util.Scanner;

public class AddElements {
	public static void addElements(Scanner sc){
		int rows = 1, columns=1;
		System.out.println("Enter the value of rows and column");
		try{
			rows = sc.nextInt();
		}catch(InputMismatchException e){
			System.out.println("Not a valid rows Input");
		}
		try{
			columns = sc.nextInt();
		}catch(InputMismatchException e){
			System.out.println("Not a valid columns Input");
		}
		
		int[][] inputMatrix = new int[rows][columns];
		System.out.println("Enter the input Array elements");
		for(int row = 0;row < rows;row++){
			for(int column = 0;column<columns;column++){
				inputMatrix[row][column] = sc.nextInt();
			}
		}
		
		//Printing of Initial Matrix
		System.out.println("The initial Matrix is: ");
		for(int row=0;row<rows;row++){
			
			for(int column=0;column<columns;column++){
				System.out.print(inputMatrix[row][column]+"\t");
			}
			System.out.println("");
		}
		System.out.println("Enter the row and column where to add the element ");
		System.out.println("Note: row should be less than"+rows+". column should be less than "+columns);
		int row = sc.nextInt();
		int column = sc.nextInt();
		System.out.println("Enter the value to be entered in integer");
		int value = sc.nextInt();
		if(row<rows && column<columns){
			inputMatrix[row][column] = value;
		}else{
			System.out.println("The index at which element is added is invalid.Therefore cannot add");
		}
		//Printing of Matrix after adding elements
		System.out.println("The initial Matrix is: ");
		for(row=0;row<rows;row++){
			
			for(column=0;column<columns;column++){
				System.out.print(inputMatrix[row][column]+"\t");
			}
			System.out.println("");
		}
	}
}
