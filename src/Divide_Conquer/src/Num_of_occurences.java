package Divide_Conquer.src;

/*
 * http://www.geeksforgeeks.org/count-number-of-occurrences-in-a-sorted-array/
 * Time complexity : log n
 */
public class Num_of_occurences
{
	public static void main(String args[])
	{
		int arr[]={1, 1, 2, 2, 2, 2, 3,};
		int x= count_occurences(arr,1);
		System.out.println(x);
	}
	static int count_occurences(int[] arr,int n)
	{
		int high=arr.length-1;
		int low=0,mid;
		int lower_limit=-1;
		int upper_limit=-1;
		//checking lower limit
		while(low<=high&&lower_limit==-1)
		{
			mid=low+(high-low)/2;
			if(arr[mid]==n)
			{
				if((mid!=0&&arr[mid-1]<arr[mid])||mid==0)
					lower_limit=mid;	
				else
					high=mid-1;
			}
			else if(arr[mid]<n)
				low=mid+1;
			else
				high=mid-1;
		}
		//checking upper limit
		high=arr.length-1;
		low=0;
		while(low<=high&&upper_limit==-1)
		{
			mid=low+(high-low)/2;
			if(arr[mid]==n)
			{
				if((mid<arr.length-1&&arr[mid+1]>arr[mid])||mid==arr.length-1)
					upper_limit=mid;
				else
					low=mid+1;
			}
			else if(arr[mid]<n)
				low=mid+1;
			else
				high=mid-1;
		}
		if(lower_limit==-1&&upper_limit==-1)
			return -1;
		else if(lower_limit==-1||upper_limit==-1)
			return 1;
		else
			return upper_limit-lower_limit+1;
	}
}
