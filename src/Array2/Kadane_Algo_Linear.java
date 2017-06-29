package Array2;

/**
 * Created by Ritu on 10/25/16.
 * http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 * The below approach handles both mix of positive & negative numbers;
 * as well just negative numbers too
 */
public class Kadane_Algo_Linear {
    public static void main(String args[])
    {
        int[] arr={-1,-1,-1,-1};//{-1,0,-3,-2,-2, -3};//{-2, -3, 4, -1, -5, 2, -1,5, -3,-10};//5,-6,1};//
        kadane_Algo(arr);
    }
    private static void kadane_Algo(int[] arr)
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
        System.out.println("Elements are : ");
        for(int k=start;k<=end;k++)
            System.out.print(arr[k]+" ");
    }
}
