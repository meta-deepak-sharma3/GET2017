package Assignments;

import static org.junit.Assert.*;

import org.junit.Test;
public class MatrixTest {

	MatrixClass m = new MatrixClass();
	int matrix1[][] = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
	int expectedMatrix1[][] = new int[][]{{1,4,7},{2,5,8},{3,6,9}};
	int matrix2[][] = new int[][]{{4,5,6},{11,14,12},{76,78,77}};
	int expectedMatrix2[][] = new int[][]{{4,11,76},{5,14,78},{6,12,77}};
	int[][] matrix3 = new int[][]{{1,2},{3,4}};
	int expectedMatrix3[][] = new int[][]{{5,11},{11,25}};
	
	@Test
	//test transpose.
	public void testTranspose(){
		assertArrayEquals(expectedMatrix1, m.transposeMatrix(matrix1));
		assertArrayEquals(expectedMatrix2, m.transposeMatrix(matrix2));
	}

	@Test
	//test Multiplication.
	public void testMultiplication(){
		assertArrayEquals(expectedMatrix3, m.multiplyMatrix(matrix3,m.transposeMatrix(matrix3),2, 2, 2));
		
	}
}	
