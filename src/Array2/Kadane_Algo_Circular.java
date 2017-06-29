package Array2;

import java.util.ArrayList;
/**
 * Created by Ritu on 4/5/17.
 * http://www.geeksforgeeks.org/maximum-contiguous-circular-sum/
 * https://www.youtube.com/watch?v=mDLiP3Jxkf4
 */
public class Kadane_Algo_Circular {
    public static void main(String[] args)
    {
        int arr[] =  {11, 10, -20, 5, -3, -5, 8, -13, 10};
        find(arr);
    }
    private static void find(int[] arr)
    {
        ArrayList<Integer> maxsum1=kadane(arr);
        int sum1=maxsum1.get(0);
        int sum=0;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            arr[i]=-arr[i];
        }
        ArrayList<Integer> maxsum2=kadane(arr);
        int sum2=sum+maxsum2.get(0);
        if(sum1>sum2)
        {
            System.out.println("Sum is "+sum1);
            System.out.println("Elements are : ");
            for(int k=maxsum1.get(1);k<=maxsum1.get(2);k++)
                System.out.print(-arr[k]+" ");
        }
        else
        {
            System.out.println("Sum is "+sum2);
            System.out.println("Elements are : ");
            for(int k=0;k<arr.length;k++)
            {
                if(k>=maxsum2.get(1)&&k<=maxsum2.get(2))
                    continue;
                System.out.print(-arr[k]+" ");
            }
        }
    }
    private static ArrayList<Integer> kadane(int[] arr)
    {
        int n=arr.length;
        int MaxTillHere=Integer.MIN_VALUE;
        int maxEndingHere=0;
        int s=0,start=-1,end=-1;
        for(int i=0;i<n;i++)
        {
            maxEndingHere+=arr[i];
            if(maxEndingHere<0)
            {
                maxEndingHere=0;
                s=i+1;
            }
            if(arr[i]<0&&arr[i]>MaxTillHere)
            {
                MaxTillHere=arr[i];
                start=i;
                end=i;
            }
            if(arr[i]>0&&MaxTillHere<maxEndingHere)
            {
                MaxTillHere=maxEndingHere;
                start=s;
                end=i;
            }
        }
        ArrayList<Integer> result=new ArrayList<>();
        result.add(MaxTillHere);
        result.add(start);
        result.add(end);
        return result;
    }
}
