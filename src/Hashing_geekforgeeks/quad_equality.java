package Hashing_geekforgeeks;

import java.util.Map.Entry;
import java.util.*;

/*
 * Refer : http://www.geeksforgeeks.org/find-four-elements-a-b-c-and-d-in-an-array-such-that-ab-cd/
 * Using hashmap and nested class
 */
public class quad_equality// implements Comparable {
{// Class to represent a pair
	class pair
	{
		int first, second;
		pair(int f,int s)
		{
			first = f; second = s;
		}
		
	};
	class pairs
	{
		int first, second, third,fourth;
		pairs(pair p, int t, int four)
		{
			//first = f; second = s;
			first=p.first;
			second=p.second;
			third=t; fourth=four;
		}
		
	};
	boolean findPairs(int arr[])
	{
		TreeMap<Integer,pairs> map = new TreeMap<Integer,pairs>();
		HashMap<Integer,pair> hm= new HashMap<Integer,pair>();
		int n=arr.length;
		// Traverse through all possible pairs of arr[]
		for (int i=0; i<n; ++i)
		{
			for (int j=i+1; j<n; ++j)
			{
				// If sum of current pair is not in hash,
				// then store it and continue to next pair
				int sum = arr[i]+arr[j];
				if (!hm.containsKey(sum))
					hm.put(sum,new pair(arr[i],arr[j]));

				else // Else (Sum already present in hash)
				{
					// Find previous pair
					pair p = hm.get(sum);
					map.put(sum, new pairs(p,arr[i],arr[j]));

				}
			}
		}
		if(map.isEmpty())
			return false;
		Set<Entry<Integer,pairs>> entrySet = map.entrySet();
		for (Entry<Integer, pairs> en: entrySet)
		{
			System.out.print("Sum "+en.getKey());
			pairs p=(pairs) en.getValue();
			System.out.println("  ("+p.first+", "+p.second+") and ("+p.third+", "+p.fourth+")");
		}
		return true;
	}

	// Testing program
	public static void main(String args[])
	{
		int arr[] = {3, 4, 7, 1, 2, 9, 8};
		quad_equality a = new quad_equality();
		a.findPairs(arr);
	}

}
