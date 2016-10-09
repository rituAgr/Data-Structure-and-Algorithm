package Searching_geeksforgeeks;

/*
 * http://www.geeksforgeeks.org/fibonacci-search/
 * time complexity : O(log n)
 */
public class Fibonacci_search {
	public static void main(String[] args)
	{
		int arr[]={2, 3, 4, 10, 40};
		int x= 3;
		System.out.println("The position is "+find(arr,x));
	}
	static int find(int[] arr, int x)
	{
		int n=arr.length;
		int fib2=0;
		int fib1=1;
		int fibM=fib1+fib2;
		while(fibM<n)
		{
			fib2=fib1;
			fib1=fibM;
			fibM=fib1+fib2;
		}
		int offset=-1;

		while(fibM>1)
		{
		 int i=Math.min(fib2+offset, n-1);	
		 if(arr[i]==x)
			 return i;
		 if(arr[i]<x)
		 {
			 fibM=fib1;
			 fib1=fib2;
			 fib2=fibM-fib1;
			 offset=i;
		 }
		 else
		 {
			 fibM=fib2;
			 fib1=fib1-fib2;
			 fib2=fibM-fib1;
		 }
		}
		if(arr[offset+1]==x)
			return offset+1;
		return -1;
	}
}