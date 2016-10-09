package Divide_Conquer.src;

/*
 * Refer the link for more details
 * http://www.geeksforgeeks.org/median-of-two-sorted-arrays/
 * Time Complexity = log n ( considering that elements in both arrays is sorted
 */
public class Median_2_equal_Array 
{
	public static void main(String args[])
	{
		int[] arr1={1, 2, 3, 4,6};
		 int arr2[] = {5,6,7, 8, 10};
		int n =arr1.length-1;
		 float m= Median(arr1,0, n,arr2, 0, n);
		 System.out.println("The median of both combined array is "+m);
	}
	public static float Median(int[] arr1, int low1, int high1, int[] arr2, int low2, int high2)
	{
		/*if(low1>high1||low2>high2)
			return (arr1[low1]+arr2[low2])/2;*/
		if(low1==high1||low2==high2)
			return (arr1[low1]+arr2[low2])/2;
		if(high1-low1==1||high2-low2==1)
			return (float)(Math.max(arr1[low1], arr2[low2])+Math.min(arr1[high1], arr2[high2]))/2;
		float median1=0.0f,median2=00.0f;
		median1=MedianUtil(arr1,low1,high1);
		median2=MedianUtil(arr2,low2,high2);
		int l=high1-low1;
		if(median1==median2)
			return median1;
		if(l%2==1)
		{
		if(median1>median2)
			return Median(arr1,low1,getMid(low1,high1),arr2, getMid(low2,high2)+1,high2);
		else
			return Median(arr1,getMid(low1,high1)+1,high1,arr2, low2,getMid(low2,high2));
		}
		else
		{
			if(median1>median2)
				return Median(arr1,low1,getMid(low1,high1)-1,arr2, getMid(low2,high2)+1,high2);
			else
				return Median(arr1,getMid(low1,high1)+1,high1,arr2, low2,getMid(low2,high2)-1);
		}

	}
	public static float MedianUtil(int[] arr,int low, int high)
	{
		if((high-low)%2==0)
		    {
			int mid=low+(high-low)/2;
			return arr[mid];
		    }
		else
		{
			int mid1=low+(high-low)/2;
			int mid2=mid1+1;
			return ((float)(arr[mid1]+arr[mid2]))/2;
		}
	}
	public static int getMid(int low, int high)
	{
		int x=low+(high-low)/2;
			return x; 
	}
}
