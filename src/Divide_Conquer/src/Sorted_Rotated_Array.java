package Divide_Conquer.src;

/*
 * Find the minimum element in a sorted and rotated array
 * Time complexity O(n) = log(n)
 */
public class Sorted_Rotated_Array 
{
	public static void main(String args[])
	{
		int arr[] = {5, 6, 1, 2, 3, 4};//{1, 4, 6, 7, 9, 11, 45, 87, 88, 90, 100}; //
		int x= findMin(arr, 0, arr.length-1);
		System.out.println(x);
	}
	static int findMin(int arr[], int low, int high)
	{
		if(high<low)
			return -1;
		if(high==low)
			return arr[low];
		int mid=0;
		while(low<=high)
		{
			mid=low+(high-low)/2;
			if(mid<high&&arr[mid+1]<arr[mid])
				return arr[mid+1];
			if(mid>low&&arr[mid]<arr[mid-1])
				return arr[mid];
			if(arr[mid]<arr[high])
				high=mid-1;
			else
				low=mid+1;
		}
		return arr[mid];
	}
}
