package Sorting_Revision;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ritu on 11/15/16.
 */
public class RadixSort {
    public static void main(String args[])
    {
        int[] arr={66,32,14,65,43,67,99,80,77,34,44,21,54,11,324};
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
         if(arr[i]>max)
             max=arr[i];
        int number=1;
        System.out.println("max ix "+max);
        while(max/number!=0)
        {
            number=number*10;
            radixSort(arr,number);
            System.out.println(Arrays.toString(arr));
        }
       // System.out.println(Arrays.toString(arr));
    }
    private static void radixSort(int[] arr, int position)
    {
        int position2=position/10;
        //int div=(int)Math.pow(10,position);
        //int div2=(int)Math.pow(10,position-1);
        ArrayList<ArrayList<Integer>> buckets=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<10;i++)
            buckets.add(new ArrayList<Integer>());
        for(int k=0;k<arr.length;k++)
        {
            int pos1=(arr[k]%position);
            int pos2=(arr[k]%position2);
            int pos=pos1;
            if(pos2!=0)
                pos=pos/pos2;
            while(pos>=10)
                pos=pos/10;
            (buckets.get(pos)).add(arr[k]);
        }
        int j=0;
        for(int i=0;i<10;i++)
        {
            ArrayList<Integer> bucket=new ArrayList<Integer>();
            bucket=buckets.get(i);
            if(bucket.size()==0)
                continue;
            for(int number:bucket)
                arr[j++]=number;
        }
    }
}
