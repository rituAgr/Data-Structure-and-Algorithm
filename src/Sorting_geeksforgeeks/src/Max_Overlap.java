package Sorting_geeksforgeeks.src;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

/*
 * http://www.geeksforgeeks.org/find-the-point-where-maximum-intervals-overlap/
 */
public class Max_Overlap 
{
	public static void main(String args[])
	{
		int enter[]={1, 2, 9, 5, 5};
		int exit[]={4, 5, 12, 9, 12};
		int num=overlap(enter,exit);
		System.out.println(num);
	}
	static int overlap(int enter[],int exit[])
	{
		HashMap<Integer,Integer> hm= new HashMap<Integer,Integer>();
		int max=-1;
		for(int k=0;k<enter.length;k++)
		{
			while(enter[k]<=exit[k])
			{
				hm.compute(enter[k], (key, value) -> 
				{if(value == null) 
					return 1;
				else
					return value+1;
				});
				enter[k]++;	
			}
		}
		int res=0;
		for (Entry<Integer, Integer> entry : hm.entrySet()) 
		{  // Itrate through hashmap
			if (entry.getValue()>max)
				{
				max=entry.getValue();  
				res=entry.getKey();
				}
		}
		return res;
	}
}