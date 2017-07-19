package Tests;

import static org.junit.Assert.*;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.junit.Test;

import Assignments.NQueen;

public class NQueenTest {

	@Test
	public void testQueenProblem() {
		Scanner sc = new Scanner(System.in);
		int n=1;
		
		try{
			n = sc.nextInt();
		}catch(InputMismatchException e){
			System.out.println("Not a valid input");
		}
		
		NQueen Q = new NQueen(n);			//checking for n*n chess board
		Q.placeNqueens(0, n);
	}
}
