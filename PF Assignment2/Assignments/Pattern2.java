import java.lang.Math;
import java.util.Scanner;

public class Pattern2{

	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);
		int n=1;

		try{

			n = Integer.parseInt( sc.next() );

		}catch(NumberFormatException e){
			
			System.out.println("Not a Valid Input");
		
		}

		for (int row=1;row<=n;row++){
			
			Pattern2Class pc = new Pattern2Class();
			System.out.println(pc.space(row, n)+pc.number(row, n));			
		
		}

	}

}

class Pattern2Class{

	String space(int row, int n){
		
		String space_String = "";
		
		for (int i=1;i<=row-1;i++){
			space_String = space_String.concat(" ");			
	
		}
		
		return space_String;
	}

	String number(int row, int n){
		
		String number_String = "";
		int i;

		for (i=1;i<=n-row+1;i++){
			number_String = number_String.concat(String.valueOf(i));			
	
		}
	
		return number_String;
	}

}
