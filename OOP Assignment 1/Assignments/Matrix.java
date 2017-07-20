package Assignments;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Matrix {
	public static void main (String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of total rows");
		int row = 0;
		try{
			row = sc.nextInt();
		}catch(InputMismatchException e){
			System.out.println("Input Not Valid");
		}
		
		System.out.println("Enter the value of total columns");
		int column = 0;
		try{
			column = sc.nextInt();
		}catch(InputMismatchException e){
			System.out.println("Input Not Valid");
		}
		
		MatrixClass m = new MatrixClass(row, column);
		
		for(int i=0;i<row;i++){
			for(int j=0;j<column;j++){
				int value = 0;
				try{
					value = sc.nextInt();
				}catch(InputMismatchException e){
					System.out.println("Input Not Valid");
				}
				m.addElements(i,j,value);
				
			}
		
		}
		m.printMatrix(m.matrix);
		int[][] newMat = m.transposeMatrix(m.matrix);
		System.out.println("");
		m.printMatrix(newMat);
		int[][] product = m.multiplyMatrix(m.matrix, newMat, 2, 2, 2);
		System.out.println("");
		m.printMatrix(product);
	}
}

class MatrixClass {
	public int[][] matrix;
	int rows , columns;
	
	// Default constructor for initializing an object.
	public MatrixClass(){
	}
	
	// constructor for initializing a matrix;
	public MatrixClass(int rows,int columns){
		this.rows = rows;
		this.columns = columns;
		matrix = new int[rows][columns];
	}
	
	//getting rows
	int getRows(){
		return this.rows;
	}
	
	int getColumns(){
		return this.columns;
	}
	//adding elements to matrix.
	void addElements (int row , int column , int value){
		
		matrix[row][column] = value;
	}
	//transpose matrix
	int[][] transposeMatrix(int[][] inputMatrix){
		int inner , outer;
		int temp[][] = new int[inputMatrix.length][inputMatrix[0].length];
		for(outer=0;outer<inputMatrix.length;outer++){
			for(inner=0;inner<inputMatrix[0].length;inner++){
				temp[inner][outer] = inputMatrix[outer][inner];
			}
		}
		return temp;
	}

	void printMatrix(int[][] inputMatrix){
		int inner , outer;
		for(outer=0;outer<rows;outer++){
			for(inner=0;inner<columns;inner++){
				System.out.print(inputMatrix[outer][inner]);
			}
			System.out.println();
		}
	}
	
	int[][] multiplyMatrix(int[][] a, int[][] b,int row, int column, int k){
		int[][] newMat = new int[column][row];
		int inner , outer ;
		for(outer=0;outer<row;outer++){
			for(inner=0;inner<column;inner++){
				for(k=0;k<row;k++){
					newMat[inner][outer] = newMat[inner][outer] + a[inner][k] * b[k][outer];
				}
				
			}
		} 
		return newMat;
	}

}
