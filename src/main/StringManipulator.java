package main;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringManipulator {

	private final Comparator<String> WEIGHT_ORDER = new Comparator<String>() {
	    public int compare(String str1, String str2) {
	    	//Get weight for each String
	        Integer avg1 = getWeight(str1);
	        Integer avg2 = getWeight(str2);
	        if (avg1 != null && avg2 != null) {
	        	//Compare their weights.
	            return avg1.compareTo(avg2);
	        }
	        return 0;
	    }
	};
	
	
	public String cleanString (String str){
		StringBuilder strBuild = new StringBuilder();
		//Remove all non-alphabetic characters and convert all characters to upper case
		if(str != null){
			strBuild.append(str.replaceAll("[^a-zA-Z]", "").toUpperCase());			
		}
		return strBuild.toString();
	}
	
	public Boolean hasUniqueChars(String word){
		Boolean containsUnique = false;
		//Call method for not consider non-alphabetic characters
		//and because it should not be case-sensitive
		if(word != null){
			String str = this.cleanString(word);
			
			for(char c : str.toCharArray()){
				if(str.indexOf(c) == str.lastIndexOf(c)){
					containsUnique = true;
				} else {
					return false;
				}
			}
		}
	    return containsUnique;
	}
	
	
	public Integer getWeight(String word){
		Integer average = null;
		Integer count = 0;
		Integer sum = 0;
		if(word != null){
			//Not consider non-alphabetic characters and not to be case-sensitive
			String str = this.cleanString(word);
			//Transforms from char to int and add to sum variable.
			for(char c : str.toCharArray()){
				count = count + 1;
				sum = sum + c;
			}
			average = sum/count;
		}
		return average;	
	}
	
	public List<String> sortStrings(List<String> words){
		//Sort by specific Comparator.
		Collections.sort(words, WEIGHT_ORDER);
		return words;
	}
	
}
