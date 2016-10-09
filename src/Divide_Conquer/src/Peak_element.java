package Divide_Conquer.src;

/*
 * Find a peak element
 * for details refer : http://www.geeksforgeeks.org/find-a-peak-in-a-given-array/
 * Time complexity O(n)=O(log n)
 */
public class Peak_element 
{
	public static void main(String args[])
	{
		int arr[]={10, 20, 15, 2, 23, 90, 67};
		int x=findPeak(arr);
		System.out.println("A peak element is "+x);
	}
	static int findPeak(int arr[])
	{
		int l=arr.length;
		if(l==1)
			return arr[0];
		if(arr[0]>arr[1])
			return arr[0];
		if(arr[l-1]>arr[l-2])
			return arr[l-1];
		int low=0;
		int high=l-1;
		int mid=0;
		while(low<high)
		{
			mid=low+(high-low)/2;
			if(arr[mid]>arr[mid-1]&&arr[mid]>arr[mid+1])
				return arr[mid];
			if(arr[mid+1]>arr[mid])
				low=mid+1;
			else
				high=mid-1;
		}
		return arr[mid];
	}
}
