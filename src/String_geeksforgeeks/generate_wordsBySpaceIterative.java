package String_geeksforgeeks;

import java.util.ArrayList;

public class generate_wordsBySpaceIterative {

	public static void printStrings(String inStr){
		
		ArrayList<String> allStrings = new ArrayList<String>(); 
		StringBuilder buffer = new StringBuilder();
		char[] chars = inStr.toCharArray(); 
		
		buffer.append(chars[0]);
		
		printStrings(buffer, chars, 1, allStrings); 
		
		for(String str:allStrings){
			System.out.println(str+"*"); 
		}	
	}
	
	
	public static void printStrings(StringBuilder buffer, char[] chars, int charStart, ArrayList<String> allStrings){
		
		if(charStart == chars.length){
			allStrings.add(buffer.toString());
			return ; 
		}
			
		// recursion here 
		int strLen = buffer.length();
		String currStr = buffer.toString();
		if( currStr.charAt(strLen-1) != ' ')
		{
			StringBuilder copy = new StringBuilder(buffer); 
			printStrings(buffer.append(' '), chars, charStart, allStrings);
			printStrings(copy.append(chars[charStart]), chars, charStart+1, allStrings); 
		}
		else
			printStrings(buffer.append(chars[charStart]), chars, charStart+1, allStrings); 		
	}
		
	
	public  static void main(String[] args){
	
		//String inStr = "ABC"; 
		//printStrings(inStr);
		
		
		String inStr = "ABCD"; 
		printStrings(inStr);
		
	}
	
}