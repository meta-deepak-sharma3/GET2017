package Assignments;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TOH{
	int numRing;
	
	public TOH(int n){
		numRing = n;
	}

	public void printTOH(String src, String des, String aux, int n){
		
		if(n==1){
			System.out.println("Move disc "+(numRing)+" from "+src+" --> "+des);
		}else{
			printTOH(src, aux, des, n-1);
			System.out.println("Move disc "+(numRing-n+1)+" from "+src+" --> "+des);
			printTOH(des, src, aux, n-1);	
		}
	}
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		//Enter the source string
		System.out.println("Enter the source string");
		String src = sc.nextLine();
		//Enter the auxillary string
		System.out.println("Enter the auxillary string");
		String aux = sc.nextLine();
		//Enter the destination string
		System.out.println("Enter the destination string");
		String des = sc.nextLine();
		//Enter the number of discs.
		System.out.println("Enter the number of disc");
		int n = 1;
		try{
			n = sc.nextInt();
		}catch(InputMismatchException e){
			System.out.println("Not a valid input");
		}
		TOH toh = new TOH(n);
		toh.printTOH(src, aux, des, n);
		
	}
}

