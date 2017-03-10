package DP_2.SumProblem_DP;

/**
 * Created by Ritu on 3/2/17.
 * http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 */
public class Kadane_Algo {
    public static void main(String[] args)
    {
        int[] arr= {-2, -3, 4, -1, -2, 1, 5, -3};
        kadane(arr);
    }
    private static void kadane(int[] arr)
    {
        int l=arr.length;
        int max_endingHere=Integer.MIN_VALUE;
        int maxSoFar=0;
        int start=-1,end=-1,s=0;

        for(int i=0;i<l;i++) {
            maxSoFar = maxSoFar + arr[i];
            if (maxSoFar < 0){
                maxSoFar = 0;
                s = i + 1;
            }
            if(max_endingHere<maxSoFar)
            {
                start=s;
                end=i;
                max_endingHere=maxSoFar;
            }
        }

        System.out.println("Maximum ending is "+max_endingHere);
        System.out.println("Elements are ");
        for(int k=start;k<=end;k++)
            System.out.print(arr[k]+" ");
    }
}
