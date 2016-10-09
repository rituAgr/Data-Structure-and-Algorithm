package Divide_Conquer.src;

//To find the square root of number, If perfect square root doesnot exist it floor down
// Time complexity O(n)=log n 
// binary search
public class Square_root
{
	public static void main(String args[])
	{
		int x= find_Square_root(34);
		System.out.println(x);
	}
	public static int find_Square_root(int n)
	{
		if(n<0)
			return Integer.MAX_VALUE;
		if(n==0)
			return 0;
		int start=1;
		int last = n;
		int mid=0;
		while(start<=last)
		{
			mid=start+(last-start)/2;
			if(mid*mid==n)
				return mid;
			if(mid*mid<n)
				start=mid+1;
			else
				last=mid-1;
		}
		return mid;
	}

}
