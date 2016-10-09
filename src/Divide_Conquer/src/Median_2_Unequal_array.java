package Divide_Conquer.src;

/*
 * http://www.geeksforgeeks.org/median-of-two-sorted-arrays-of-different-sizes/
 * Time Complexity = (log n + log m) ( considering that elements in both arrays is sorted)
 */
public class Median_2_Unequal_array 
{
	public static void main(String args[])
	{
		int[] arr1= { 7, 8, 10};
		 int arr2[] ={1, 2, 3, 4,5, 6};
		 float m= Median(arr1,0, arr1.length-1,arr2, 0, arr2.length-1);
		 System.out.println("The median of both combined array is "+m);
	}
	 static float Median(int[] arr1, int low1, int high1, int arr2[], int low2, int high2)
	{
		/*
		 * The difference betwen equal size and unequal size arrays for finding median is of base case
		 * The base case for unequal sizes is more. One by one we will cover the base cases
		 * Let N -> No. of elements in first array
		 * Let M -> No. of elements in second array
		 */
		//Case 0: N = 0, M = 2
		int N=(high1-low1+1);
		int M=high2-low2+1;
		if(N==0&&M==2)
			return (float)(arr2[low2]+arr2[high2])/2;
		//Case 1: N = 1, M = 1.
		if(N==1&&M==1)
			return (float)(arr1[low1]+arr2[low2])/2;
		//Case 2: N = 1, M is odd
		if(N==1&&M%2==1)
		{
			int mid=(high2+low2)/2;
			if(arr1[low1]<arr2[mid-1])
				return (float)(arr2[mid-1]+arr2[mid])/2;
			else if(arr1[low1]>arr2[mid+1])
					return (float)(arr2[mid+1]+arr2[mid])/2;
			else
				return (float)(arr1[low1]+arr2[mid])/2;
		}
		//Case 3: N = 1, M is even
		if(N==1&&M%2==0)
		{
			int mid=(high2+low2)/2;
			if(arr1[low1]<arr2[mid])
				return (float)(arr2[mid+1]+arr2[mid])/2;
			else if(arr1[low1]>arr2[mid+1])
					return (float)(arr2[mid+1]+arr2[mid])/2;
			else
				return (float)(arr1[low1]+arr2[mid])/2;
		}
		//Case 4: N = 2, M = 2
		if(N==2&&M==2)
			return  (float)(Math.max(arr1[low1], arr2[low2])+ Math.min(arr1[high1],arr2[high2]))/2;
		//Case 5: N = 2, M is odd
		if(N==2&&M%2==1)
		{
			int mid=(high2+low2)/2;
			int a = Math.max(arr1[low1], arr2[mid-1]);
			int b= Math.min(arr1[high1], arr2[mid+1]);
			return MO3(a,b,arr2[mid]);
			
		}
		//Case 6: N = 2, M is even
		if(N==2&&M%2==0)
		{
			int mid=(high2+low2)/2;
			int a = arr2[mid];
			int b =arr2[mid-1];
			int c = Math.max(arr1[low1],arr2[mid-2]);
			int d = Math.min(arr1[high1],arr2[mid+1]);
			return MO4(a,b,c,d);
		}
		//Below is similar step as same size array
		float median1=0.0f,median2=00.0f;
		median1=MedianUtil(arr1,low1,high1);
		median2=MedianUtil(arr2,low2,high2);
		//int l=high1-low1;
		if(median1==median2)
			return median1;
		//if(l%2==1)
		//{
		if(median1>median2)
			return Median(arr1,low1,getMid(low1,high1),arr2, getMid(low2,high2),high2);
		else
			return Median(arr1,getMid(low1,high1),high1,arr2, low2,getMid(low2,high2));
	/*	}
		else
		{
			if(median1>median2)
				return Median(arr1,low1,getMid(low1,high1)-1,arr2, getMid(low2,high2)+1,high2);
			else
				return Median(arr1,getMid(low1,high1)+1,high1,arr2, low2,getMid(low2,high2)-1);
		}*/
	}
	static float  MO3(int a, int b, int c)
	{
	    return a + b + c - Math.max(a, Math.max(b, c))
	                     - Math.min(a, Math.min(b, c));
	}
	 
	// A utility function to find median of four integers
	static float MO4(int a, int b, int c, int d)
	{
	    int Max = Math.max( a, Math.max( b, Math.max( c, d ) ) );
	    int Min = Math.min( a, Math.min( b, Math.min( c, d ) ) );
	    return (float)( a + b + c + d - Max - Min ) / 2;
	}
	static float MedianUtil(int[] arr, int low, int high)
	{
		if(low==high)
			return arr[low];
		if(high-low==1)
			return (float)(arr[high]+arr[low])/2;
		int mid=(high+low)/2;
		if((high-low)%2==1)//even
			return (float)(arr[mid]+arr[mid+1])/2;
		else		
			return arr[mid];// odd
	}
	public static int getMid(int low, int high)
	{
		int x=low+(high-low)/2;
			return x; 
	}
}
