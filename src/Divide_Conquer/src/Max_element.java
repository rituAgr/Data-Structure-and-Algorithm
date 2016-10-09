package Divide_Conquer.src;

/*
 * Refer : http://www.geeksforgeeks.org/find-the-maximum-element-in-an-array-which-is-first-increasing-and-then-decreasing/
 * Time complexity : log n
 */
public class Max_element
{
	public static void main(String args[])
	{
		int arr[]={8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
		int x =max_element(arr);
		System.out.println(x);
	}
	static int max_element(int[] arr)
	{
		int low=0;
		int high=arr.length-1;
		if(arr[low]>arr[low+1])
			return arr[low];
		if(arr[0]>arr[1])
			return arr[0];
		if(arr[high]>arr[high-1])
			return arr[high];
		return max_elementUtil(arr,low,high);
	}
	static int max_elementUtil(int[] arr, int low, int high)
	{
	if(low==high)
		return arr[low];
	int mid= low+(high-low)/2;
	if(arr[mid]>arr[mid-1]&&arr[mid]>arr[mid+1])
		return arr[mid];
	if(arr[mid]>arr[mid+1])
		return max_elementUtil(arr, low, mid-1);
	return max_elementUtil(arr, mid+1, high);
	}
}
