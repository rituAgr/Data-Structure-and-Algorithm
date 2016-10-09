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
		int end=(l1>l2)?l1:l2;
		for(int interval=1;interval<=end;interval++)
			insert_word(word1,word2,res,interval);
	}
	static void insert_word(String word1,String word2,ArrayList<String> res,int interval)
	{
		StringBuilder s=new StringBuilder();
		int l1=word1.length(), l2=word2.length();
		int start=0;
		while(start<=l1&&start<=l2)
		{
			int end=start+interval;
			int end1=(end>=l1?l1:end);
			String s1=word1.substring(start,end1);
			s.append(s1);
			int end2=end1;
			while(end2<l2)
			{
				String s2=word2.substring(start,end2);
				s.append(s2);
				end2=end2+interval;
			}
			while(s.length()<l1+l2)
			{
				int e=(end1+l1+l2-s.length())>l1?l1:(end1+l1+l2-s.length());
				s.append(word1.substring(end1,e));
			}
				res.add(s.toString());
			start=end1;
		}
		//res.add(s.toString());
	}

}
