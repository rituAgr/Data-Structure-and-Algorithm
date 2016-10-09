package DP;

/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
 */
public class RodCuttingProblem {

	public static void main(String[] args) {
		int lengths[]={1,2,3,4,5,6,7,8};
		int prices[]={1, 5, 8, 9, 10, 17, 17, 20};
		Maxprice(lengths,prices);
	}
	private static void Maxprice(int[] lengths,int[] prices)
	{
		int n=prices.length;
		int maxPrice[]=new int[n];
		for(int i=0;i<n;i++)
		{
			int start=0,max=Integer.MIN_VALUE;
			int end=i-1;
			while(start<=end)
			{
			if((prices[start]+prices[end])>max)	
				max=prices[start]+prices[end];
			start++;end--;
			}
			if(max>prices[i])
				maxPrice[i]=max;
			else
				maxPrice[i]=prices[i];
		}
		System.out.println("The maximum amount : "+maxPrice[n-1]);
	}
}
