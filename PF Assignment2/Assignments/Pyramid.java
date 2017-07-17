import java.lang.Math;
import java.util.Scanner;

public class Pyramid{

	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);
		
		int n = 1;
		
		try{

			n = Integer.parseInt( sc.next() );

		}catch(NumberFormatException e){
			
			System.out.println("Not a Valid Input");
		
		}

		for (int row=1;row<2*n;row++){
			
			PyramidClass pc = new PyramidClass();
			System.out.println(pc.space(row, n)+pc.number(row, n)+pc.space(row, n));			
		
		}


	}


}

class PyramidClass{

	String space(int row, int n){
		
		String space_String = "";
		
		for (int i=1;i<=Math.abs(n-row);i++){
			space_String = space_String.concat(" ");			
	
		}
		
		return space_String;
	}

	String number(int row, int n){
		
		String number_String = "";
		int i;

		for (i=1;i<=n-Math.abs(n-row);i++){
			number_String = number_String.concat(String.valueOf(i));			
	
		}

		for (int j=i-2;j>=1;j--){
			number_String = number_String.concat(String.valueOf(j));			
	
		}
			
		return number_String;
	}


}
