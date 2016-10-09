package Hashing_geekforgeeks;// A Java program to find maximum length subarray with 0 sum
import java.util.HashMap;
 
class MaxLenZeroSumSub {
 
    // Returns length of the maximum length subarray with 0 sum
    static int maxLen(int arr[])
    {
        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
 
        int sum = 0;      // Initialize sum of elements
        int max_len = 0;  // Initialize result
 
        // Traverse through the given array
        for (int i = 0; i < arr.length; i++)
        {
        	sum=sum+arr[i];
        	if(sum==0&&i==0)
        		max_len=1;
        	if(sum==0)
        		max_len=i+1;
        	Integer prev_i=hM.get(sum);
        	if(prev_i==null)
        		hM.put(sum, i);
        	else
        		max_len=Math.max(max_len, i-prev_i);
        }
        return max_len;
    }
 
    // Drive method
    public static void main(String arg[])
    {
        int arr[] ={11, 2, -11, -2, -8, 1, 7, -10, 10, 15};//{15, -2, 2, -8, 1, 7, 10, 23};//
        System.out.println("Length of the longest 0 sum subarray is "
                           + maxLen(arr));
    }
}