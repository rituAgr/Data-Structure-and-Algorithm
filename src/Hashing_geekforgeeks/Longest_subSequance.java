package Hashing_geekforgeeks;

import java.util.HashSet;

public class Longest_subSequance {

	public static void main(String[] args) {
		int[] arr={1, 9, 3, 10, 4, 20, 2};
		System.out.println("The lonqest subseqence is "+Seq_length(arr));
	}
	static int Seq_length(int[] arr)
	{
		if(arr.length==0)
			return 0;
		HashSet<Integer> s= new HashSet<Integer>();
		for(int i=0;i<arr.length;i++)
			s.add(arr[i]);
		int ans=0;
		for(int i=0;i<arr.length;i++)
		{
			if(!s.contains(arr[i]-1))
			{
				int j= arr[i];
				while(s.contains(j))
					j++;
				if(ans<j-arr[i])
					ans=j-arr[i];
			}
		}
		return ans;
	}

}
