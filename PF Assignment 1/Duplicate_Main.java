package PF_Session_1;

import java.util.Scanner;

public class Duplicate_Main {

	public static void main(String[] args) {
		Duplicate dp = new Duplicate();
		int input[] = new int[14];
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < input.length; i++) {
	
			try{
				System.out.println("Enter the element");
				input[i] = sc.nextInt();
			}catch(InputMisMatchException e){
				
				System.out.println('Input Error: '+e.getMessage());

			}

		}

		dp.removeDuplicate(input); //calling function
	}
}

class Duplicate {

	int[] arr2 = new int[8];
	int i, j, len = 14, flag = 1, k = 0;

	/* Function for removing Duplicate*/
	public int[] removeDuplicate(int[] input) {

		arr2[0] = input[0];
		for (i = 0; i < len; i++) {
			flag = 1;
			for (j = 0; j < i; j++) {

				if (input[i] == input[j]) {
					flag = 0;
				}
			}

			if (flag == 1) {
				arr2[k] = input[i];
				k++;
			}
		}

		return arr2;

	}

}
