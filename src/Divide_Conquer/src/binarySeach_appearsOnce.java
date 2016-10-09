package Divide_Conquer.src;

//Find the element that appears once in a sorted array
//Time complexity= o(logn)
public class binarySeach_appearsOnce
{
	public static void main(String args[])
	{
		int arr[]={1, 1, 3, 3,5, 5, 6,6,7, 7, 8, 8,9};
		int x=find(arr);
		System.out.println(x);
	
	}
	public static int find(int arr[])
	{
		int l=arr.length;
		if(l%2==0||l==0)
			return Integer.MAX_VALUE;
		if(l==1)
			return arr[0];
		if(arr[l-1]!=arr[l-2])
			return arr[l-1];
		if(arr[0]!=arr[1])
			return arr[0];
		int start=0;
		int last=l-1;
		int mid=0;
		while(start<=last)
		{
			mid=start+(last-start)/2;
			if(arr[mid]!=arr[mid-1]&&arr[mid]!=arr[mid+1])
				return arr[mid];
			if(arr[mid]==arr[mid-1])
			{
				int num=mid-2;
				if(num%2==1)
					start=mid+1;
				else
					last=mid-2;
			}
			else
			{
				int num=(l-1)-(mid+1);
				if(num%2==1)
					start=mid+2;
				else
					last=mid-1;
			}
		}
		return Integer.MAX_VALUE;
	}
}
