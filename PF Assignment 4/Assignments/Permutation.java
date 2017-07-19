package Assignments;

import java.util.*;

public class Permutation{
	ArrayList<String> listOfStrings = new ArrayList<String>();	
	static int startIndex = 0;
	public  void permute(char[] string){
		int left = startIndex;
		if(left==string.length-1){
			if(!(listOfStrings.contains(String.valueOf(string))) ){
				listOfStrings.add(String.valueOf(string));
				System.out.println(String.valueOf(string));
			}
		}else{
			for(int i=left;i<string.length;i++){
				swap(string, left, i);
				startIndex++;
				permute(string);
				swap(string, left, i);
				startIndex = left;
			}
		}
	}

	private void swap(char[] string, int pos1, int pos2){
		char temp = string[pos1];
		string[pos1] = string[pos2];
		string[pos2] = temp;
	}

	public static void main(String args[]){
		Permutation pm = new Permutation();
		Scanner sc = new Scanner(System.in);
		String input = new String();
		input = sc.nextLine();

		pm.permute(input.toCharArray());	
	}
}

