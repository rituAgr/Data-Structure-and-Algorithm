package Hashing_geekforgeeks;

import java.util.*;

/*
 * Refer : http://www.geeksforgeeks.org/given-an-array-of-pairs-find-all-symmetric-pairs-in-it/
 * Time complexity : O(n)
 */
public class symmetry_pairs 
{
	public static void main(String args[])
	{
		int arr[][] = {{11, 20}, {30, 40}, {5, 10}, {40, 30}, {10, 5}};
		Utilsymmetry_pairs p=new Utilsymmetry_pairs();
		p.symmetry(arr);
	}
}
class Utilsymmetry_pairs
{
	class pair
	{
		int first,second;
		pair(int f, int s)
		{
			first=f;
			second=s;
		}
	};
	void symmetry(int[][] arr)
	{
		ArrayList<pair> result=new ArrayList<pair>();
		HashMap<Integer, Integer> hm= new HashMap<Integer, Integer>();
		for(int i=0;i<arr.length;i++)
		{
			int x=arr[i][0];
			int y = arr[i][1];
			if(hm.containsKey(y))
			{
				if(hm.get(y)==x)
				{
					result.add(new pair(y,x));
					hm.remove(y);
					continue;
				}	
			}
			
			hm.put(x, y);
		}
		for(int i=0;i<result.size();i++)
			System.out.println(result.get(i).first+"  "+result.get(i).second);
	}
}