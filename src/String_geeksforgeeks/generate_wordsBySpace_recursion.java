package String_geeksforgeeks;

import java.util.ArrayList;

/*
 * http://www.geeksforgeeks.org/print-possible-strings-can-made-placing-spaces/
 */
public class generate_wordsBySpace_recursion {

	public static void main(String[] args) {
		String word="ABCD";
		ArrayList<String> res= formWords(word);
		//formWords(word,res);
		for(String s:res)
			System.out.println(s);
	}
	public static ArrayList<String> formWords(String word)
	{
		ArrayList<String> res=new ArrayList<String>();
		StringBuilder s=new StringBuilder();
		char[] chars=word.toCharArray();
		s.append(chars[0]);
		formWordsUtil(s,chars,1,res);
		return res;

	}
	public static void formWordsUtil( StringBuilder s,char[] letters,int pos,ArrayList<String> res)
	{
		if(pos>=letters.length)
		{
			res.add(s.append('*').toString());
			return;
		}
		char c=s.charAt(s.length()-1);
		if(c!=' ')
		{
			StringBuilder buffer = new StringBuilder(s); 
			formWordsUtil(buffer.append(' '),letters,pos,res);
			formWordsUtil(s.append(letters[pos]),letters,pos+1,res);
		}
		else
			formWordsUtil(s.append(letters[pos]),letters,pos+1,res);
	}
}