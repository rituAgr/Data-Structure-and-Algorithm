package Array2;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Ritu on 3/11/17.
 * http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 */
public class LargestSumContiguousSubArray_DP {
    public static void main(String[] args)
    {
        int arr[] ={1,0,1,1,0,0};//{-2, -3, 4, -1, -2, 1, 5, -3};// {-2, -3, -4, -1, -2, -1, -5, -3};//
        find(arr);
    }
    private static void find(int[] arr)
    {


        int maxEndhere=0;
        int maxTillNow=Integer.MIN_VALUE;
        int start=-1,end=-1, s=-1;

        for(int i=0;i<arr.length;i++)
        {
            maxEndhere+=arr[i];
            if(maxEndhere<0)
            {
                maxEndhere=0;
                s=i+1;
            }

            if(arr[i]<0&&maxTillNow<arr[i])
            {
                maxTillNow=arr[i];
                start=i;
                end=i;
            }
            else if(arr[i]>=0&&maxTillNow<maxEndhere)
            {
                maxTillNow=maxEndhere;
                start=s;
                end=i;
            }

        }
        System.out.println("Max Continuous sum is "+maxTillNow);
        start=(start==-1)?0:start;
        System.out.println("Start index is "+start);
        System.out.println("Ending index is "+end);
        for(int k=start;k<=end;k++)
            System.out.print(arr[k]+" ");
    }
}
