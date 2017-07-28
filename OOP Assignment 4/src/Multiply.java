import java.util.InputMismatchException;
import java.util.Scanner;
public class Multiply {
	public static void multiply(Scanner sc){
		int rows = 1, columns=1;
		// Multiplication for square Matrix
		//For First Matrix
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
		if(rows == columns){
			int[][] inputMatrixOne = new int[rows][columns];
			System.out.println("Enter the input Array One elements");
			for(int row = 0;row < rows;row++){
				for(int column = 0;column<columns;column++){
					inputMatrixOne[row][column] = sc.nextInt();
				}
			}
			
			//Printing of First Matrix
			System.out.println("The first Matrix is: ");
			for(int row=0;row<rows;row++){
				
				for(int column=0;column<columns;column++){
					System.out.println(inputMatrixOne[row][column]);
				}
				System.out.println("");
			}
			//For Second Matrix;
			int[][] inputMatrixTwo = new int[rows][columns];
			System.out.println("Enter the input Array One elements");
			for(int row = 0;row < rows;row++){
				for(int column = 0;column<columns;column++){
					inputMatrixTwo[row][column] = sc.nextInt();
				}
			}
			
			//Printing of Second Matrix
			System.out.println("The first Matrix is: ");
			for(int row=0;row<rows;row++){
				
				for(int column=0;column<columns;column++){
					System.out.println(inputMatrixTwo[row][column]);
				}
				System.out.println("");
			}
			// Multiplication Matrix
			int[][] newMat = new int[columns][rows];
			int inner , outer ;
			for(outer=0;outer<rows;outer++){
				for(inner=0;inner<columns;inner++){
					for(int k=0;k<rows;k++){
						newMat[inner][outer] = newMat[inner][outer] + inputMatrixOne[inner][k] * inputMatrixTwo[k][outer];
					}
					
				}
			} 
			
			//Printing of Multiplication Matrix
			System.out.println("The Multiplication Matrix is: ");
			for(int row=0;row<rows;row++){
				
				for(int column=0;column<columns;column++){
					System.out.println(newMat[row][column]);
				}
				System.out.println("");
			}
		}else{
			System.out.println("Not a Square Matrix");
		}
			
	}
}
