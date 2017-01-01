package Array;

/**
 * Created by Ritu on 10/25/16.
 */
public class Kadane_Algorithm {
    public static void main(String args[])
    {
        int[] arr={-2, -3, 4, -1, -5, 2, -1,5, -3,-10};//{-1,-3,-2,-2, -3};//5,-6,1};//{-1,-1,-1,-1};//)
        kadane_Algo(arr);
    }
    private static void kadane_Algo(int[] arr)
    {
        int start=-1,end=-1,start_interm=-1,i=0;
        int sum=0, prev_sum=0;
        while(i<arr.length)
        {
            sum=sum+arr[i];
            if(arr[i]>=0&&start_interm==-1)
                start_interm=i;
            if(sum<=0)
            {
                sum=0;
                start_interm=-1;
            }
            if(sum>prev_sum)
            {
                start=start_interm;
                end=i;
                prev_sum=sum;
            }
            i++;
        }
        if(start==-1||end==-1)
        {
            System.out.print("There is no range in array which sums up greater than 0");
            return;
        }
        System.out.println("Sum is "+prev_sum+"\nIts element are -");
        for(int pos=start;pos<=end;pos++)
            System.out.println(arr[pos]);
    }
}
