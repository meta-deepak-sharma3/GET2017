import java.lang.Math;
import java.util.Scanner;

public class HalfPyramidMain{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n=0;

		//Input for n from user.
		try{
			n = Integer.parseInt( sc.next() );
		}catch(NumberFormatException e){
			System.out.println("Not a Valid Input");
		}
		
		//Printing of HalfPyramid
		for (int row=1;row<=n;row++){
			
			HalfPyramid pc = new HalfPyramid();
			System.out.println(pc.space(row, n)+pc.number(row, n));			
		}	
	}
}

class HalfPyramid{
	// Returns String of Spaces for corresponding row and n
	String space(int row, int n){
		String spaceString = "";
		
		for (int i=1;i<=row-1;i++){
			spaceString = spaceString.concat(" ");			
		}
		
		return spaceString;
	}
	//Returns String of Number for corresponding row and n
	String number(int row, int n){
		String numberString = "";
		int i;

		for (i=1;i<=n-row+1;i++){
			numberString = numberString.concat(String.valueOf(i));			
		}
	
		return numberString;
	}
}
