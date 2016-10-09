package Hashing;

import java.util.HashMap;

public class Ques_8 {
	public static void main(String[] args)
	{
		HashMap<Integer,Integer> pairs=new HashMap<Integer,Integer>();
		pairs.put(1, 3);
		pairs.put(2, 6);
		pairs.put(3,5);
		pairs.put(7,4);
		pairs.put(2, 6);
		pairs.put(5,3);
		pairs.put(8,7);
		HashMap<Integer,Integer> sym_pairs=new HashMap<Integer,Integer>();
		sym_pairs=check(pairs);
		for(Integer key : sym_pairs.keySet())
			System.out.println(key+"-->"+sym_pairs.get(key));	
	}	
	public static HashMap<Integer,Integer> check(HashMap<Integer,Integer> pairs)
	{
		HashMap<Integer,Integer> sym_pairs=new HashMap<Integer,Integer>();
		for(Integer key:pairs.keySet())
		{
			if(pairs.values().contains(key)&&pairs.keySet().contains(pairs.get(key)))
				sym_pairs.put(key, pairs.get(key));		
		}
		return sym_pairs;
	}
}
