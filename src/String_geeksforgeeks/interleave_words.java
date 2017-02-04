package String_geeksforgeeks;

import java.util.*;
public class interleave_words {

	public static void main(String[] args)
	{
		String word1="AB";
		String word2="CD";
		ArrayList<String> res = new ArrayList<String>();
		interleaving(word1,word2, res);
		System.out.println(res.toString());
	}
	static void interleaving(String word1, String word2,ArrayList<String> res)
	{
		if(word1.length()==0&&word2.length()==0)
			return;
		if(word1.length()==0)
		{
			res.add(word2);
			return;
		}
		if(word2.length()==0)
		{
			res.add(word1);
			return;
		}
		int l1=word1.length(), l2=word2.length();
//		int end=(l1>l2)?l1:l2;
//		for(int interval=1;interval<=end;interval++)
		String s="";
		insert_word(word1,word2,s,0,0,res);
	}
	static void insert_word(String word1,String word2,String s,int pos1,int pos2,ArrayList<String> res)
	{
		if(s.length()==(word1.length()+word2.length()))
		{
			res.add(s.toString());
			return;
		}
		StringBuilder s1 = new StringBuilder(s);
		StringBuilder s2 = new StringBuilder(s);
		if(pos1<word1.length()) {
			s1.append(word1.charAt(pos1));
			insert_word(word1, word2, s1.toString(), pos1 + 1, pos2, res);
		}

		if(pos2<word2.length()) {
			s2.append(word2.charAt(pos2));
			insert_word(word1, word2, s2.toString(), pos1 , pos2 + 1, res);
		}
	}
}


