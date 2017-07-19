import java.lang.Math;
import java.util.Scanner;

public class PyramidMain{
	//Main Function
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = 1;
		
		try{
			n = Integer.parseInt( sc.next() );
		}catch(NumberFormatException e){
			System.out.println("Not a Valid Input");
		}

		for (int row=1;row<2*n;row++){
			Pyramid pc = new Pyramid();
			System.out.println(pc.space(row, n)+pc.number(row, n)+pc.space(row, n));			
		}
	}
}

class Pyramid{
	//Returns string of spaces
	String space(int row, int n){	
		String spaceString = "";
		
		for (int i=1;i<=Math.abs(n-row);i++){
			spaceString = spaceString.concat(" ");			
		}	
		
		return spaceString;
	}
	//Returns string of numbers
	String number(int row, int n){
		String numberString = "";
		int i;

		for (i=1;i<=n-Math.abs(n-row);i++){
			numberString = numberString.concat(String.valueOf(i));			
		}

		for (int j=i-2;j>=1;j--){
			numberString = numberString.concat(String.valueOf(j));			
		}
			
		return numberString;
	}
}
