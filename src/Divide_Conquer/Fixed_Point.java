package Divide_Conquer.src;

/*
 * Refer : http://www.geeksforgeeks.org/find-a-fixed-point-in-a-given-array/
 * Time complexity : log n
 */
public class Fixed_Point 
{
	public static void main(String args[])
	{
		int arr[] = {-10, -5, 3, 4, 7, 9};//{-10, -5, 0, 3, 7};//{-10, -5, 3, 4, 7, 9};//{0, 2, 5, 8, 17};
		int x = fixedPoint(arr);
		System.out.println(x);
	}
	static int fixedPoint(int arr[])
	{
		int low=0;
		int high=arr.length-1;
		return fixedPointUtil(arr, low, high);
	}
	static int fixedPointUtil(int[] arr,int low,int high)
	{
		if(high==low)
		{
			if(arr[high]==high)
				return high;
			return -1;
		}
		int mid=low+(high-low)/2;
		if(mid==arr[mid])
			return mid;
		if(arr[mid]<mid)
			return fixedPointUtil(arr, mid+1, high);
		return fixedPointUtil(arr, low, mid-1);
	}
}
