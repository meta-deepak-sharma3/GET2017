import java.util.InputMismatchException;
import java.util.Scanner;

public class Transpose {
	public static void transpose(Scanner sc){
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
		// Transpose Matrix
		int inner , outer;
		int temp[][] = new int[inputMatrix[0].length][inputMatrix.length];
		for(outer=0;outer<inputMatrix[0].length;outer++){
			for(inner=0;inner<inputMatrix.length;inner++){
				temp[outer][inner] = inputMatrix[inner][outer];
			}
		}
		//Printing of Transpose Matrix
		System.out.println("The Transpose Matrix is: ");
		for(int row=0;row<temp.length;row++){
					
			for(int column=0;column<temp[0].length;column++){
				System.out.print(temp[row][column]+"\t");
			}
			System.out.println("");
		}
	}
}
