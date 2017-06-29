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
		formWordsUtil(s,chars,1);
		return res;

	}
	public static void formWordsUtil( StringBuilder s,char[] letters,int pos)
	{
		if(pos>=letters.length)
		{
			System.out.println(s.toString());
			return;
		}
		char c=letters[pos];
		formWordsUtil(s.append(c),letters,pos+1);
		s.deleteCharAt(s.length()-1);
		formWordsUtil(s.append(' ').append(c),letters,pos+1);
		s.deleteCharAt(s.length()-1);
		s.deleteCharAt(s.length()-1);

	}

//public static void formWordsUtil( StringBuilder s,char[] letters,int pos,ArrayList<String> res)
//	{
//		if(pos>=letters.length)
//		{
//			res.add(s.append('*').toString());
//			return;
//		}
//		char c=letters[pos];
//		StringBuilder buffer1 = new StringBuilder(s);
//		formWordsUtil(buffer1.append(' ').append(c),letters,pos+1,res);
//
//		StringBuilder buffer2 = new StringBuilder(s);
//		formWordsUtil(buffer2.append(c),letters,pos+1,res);
//	}

}