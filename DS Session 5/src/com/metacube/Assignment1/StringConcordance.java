package com.metacube.Assignment1;

import java.util.*;

public class StringConcordance {
	
	private String getStringFormat(Map<Character, List<Integer>> charIndicesMap) {
		String result = "{";
		for(char iterateCharacter: charIndicesMap.keySet()) {
			result = result + iterateCharacter+" = "+charIndicesMap.get(iterateCharacter).toString()+", ";
		}
		result = result + "}";
		return result;
	}
	
	public String getStringConcordance(String input) {
		Map<Character, List<Integer>> charIndicesMap = new HashMap<Character, List<Integer>>();
		for(int i=0;i<input.length();i++) {
			char character = input.charAt(i);
			
			if(character!=' ') {
				if(charIndicesMap.get(character) == null) {
					List<Integer> posArray = new ArrayList<Integer>();
					charIndicesMap.put(character, posArray);
				}
				
				charIndicesMap.get(character).add(i);
				charIndicesMap.put(character, charIndicesMap.get(character));
			}
		}
		
		for(char iterateCharacter: charIndicesMap.keySet()) {
			List<Integer> posArray = charIndicesMap.get(iterateCharacter);
			Collections.sort(posArray);
			charIndicesMap.put(iterateCharacter, posArray);
		}
		
		return getStringFormat(charIndicesMap);
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the input for which you want concordance:");
		String input = sc.nextLine();
		String result = new StringConcordance().getStringConcordance(input);
		System.out.println("The output is: ");
		System.out.println(result);
		sc.close();
	}
	
}
