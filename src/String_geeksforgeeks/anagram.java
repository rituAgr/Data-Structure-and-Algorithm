package String_geeksforgeeks;

import java.util.*;
public class anagram {

	public static void main(String[] args)
	{
		String words[]={"cat", "dog", "tac", "god", "act"};
		String[] ans= form_anagram(words);
		System.out.println(Arrays.toString(ans));
	}
	public static String[] form_anagram(String[] words)
	{
		if(words.length==0)
			return null;
		String[] array=new String[words.length];
		array=Arrays.copyOf(words, words.length);
		HashMap<String,ArrayList<Integer>> hm= new HashMap<String,ArrayList<Integer>>();
		for(int i=0;i<words.length;i++)
		{
			char c[]=words[i].toCharArray();
			Arrays.sort(c);
			words[i]=new String(c);
			String s=words[i];
			int pos=i;
			System.out.println(words[i]);
			hm.compute(s, (k,v)->
			{
				if(hm.get(s)==null)
				{
					ArrayList<Integer> a= new ArrayList<Integer>();
					a.add(pos);
					return a;
				}
				else
				{
					ArrayList<Integer> a=hm.get(s);
					a.add(pos);
					return a;
				}
			});
		}
		Arrays.sort(words, new sortWord());
		String[] res= new String[words.length];
		for(int i=0;i<words.length;i++)
		{
			String s= words[i];
			ArrayList<Integer> a=hm.get(s);
			int j=a.get(0);
			a.remove(0);
			res[j]=array[i];
		}
		return res;
	}
}

class sortWord implements Comparator<String>
{
	public int compare(String a, String b)
	{
		if(a.equals(b))
			return 0;
		int l=(a.length()>b.length()?a.length():b.length());
		for(int i=0;i<l;i++)
		{
			if(i==a.length()&&i<b.length())
				return 1;
			if(i==b.length()&&i<a.length())
				return -1;
			char c1=a.charAt(i);
			char c2=b.charAt(i);
			if(c1==c2)
				continue;
			if(c1<c2)
				return -1;
			else 
				return 1;
		}
		return 0;
	}
}
