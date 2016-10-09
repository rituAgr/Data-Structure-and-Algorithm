package Hashing_geekforgeeks;

/*
 * http://www.geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-1/
 * It is basically array based question. However, The varition of this problem is this :
 * http://www.geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-2/. here, we used hashing. 
 * But, to understand that, we first need to do this.
 * * Time complexity : O(n2)
 */
public class Max_subArray {	 
	// Returns length of the longest contiguous subarray
	static int findLength(int arr[], int n)
	{
	    int max_len = 0;  // Initialize result
	    for (int i=0; i<n-1; i++)
	    {
	        // Initialize min and max for all subarrays starting with i
	        int mn = arr[i], mx = arr[i];
	 
	        // Consider all subarrays starting with i and ending with j
	        for (int j=i+1; j<n; j++)
	        {
	            // Update min and max in this subarray if needed
	            mn = Math.min(mn, arr[j]);
	            mx = Math.max(mx, arr[j]);
	 
	            // If current subarray has all contiguous elements
	            if ((mx - mn) == j-i)
	                max_len = Math.max(max_len, mx-mn+1);
	        }
	    }
	    return max_len;  // Return result
	}
	 
	// Driver program to test above function
	public static void main(String args[])
	{
	    int arr[] = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
	    int n = arr.length;
	    System.out.println( "Length of the longest contiguous subarray is "+findLength(arr, n));
	}

}
