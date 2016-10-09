package Hashing_geekforgeeks;

import java.util.HashMap;

/*
 * Refer this link : http://www.geeksforgeeks.org/check-if-an-array-can-be-divided-into-pairs-whose-sum-is-divisible-by-k/
 * Time complexity : O(n)
 */
public class CanPair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]={9, 7, 5, 3};
		int k=6;
		boolean ans=pairs(arr, k);
		System.out.println(ans);
	}
	static boolean pairs(int[] arr, int k)
	{
		int l=arr.length;
		if(l%2!=0||l==0)
			return false;
		HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
		for(int i=0;i<l;i++)
		{
			if(hm.containsKey(arr[i]%k)==false)
				hm.put(arr[i]%k, 1);
			else
				hm.put(arr[i]%k, hm.get(arr[i]%k)+1);
		}
		for(int i=0;i<l;i++)
		{
			int key=k-arr[i]%k;
			if(hm.containsKey(key)==false||hm.get(key)==0)
				return false;
			else
				hm.put(key, hm.get(key)-1);
		}
		return true;
	}
}
