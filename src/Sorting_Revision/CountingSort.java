package Sorting_Revision;

import java.util.Arrays;

/**
 * Created by Ritu on 11/13/16.
 * Space complexity : O(n)
 * Time complexity : O(n)
 * The basic usual way of this sorting technique is used for only positive range. It doesnot handle negative numbers.
 * It can handle negative numbers too, if incase we implement it with two arrays - one for positive, another for negative
 *  This sorting technique is best suited for numbers in smaller dense range of input numbers.
 */
public class CountingSort {
    public static void main(String args[])
    {
        int array[]={66,32,-1,14,65,43,67,99,80,77,34,44,21,54,2,11,324};
        Counting_Sort(array);
        System.out.println(Arrays.toString(array));

    }
    protected static void Counting_Sort(int[] arr)
    {
        int n=arr.length;
        int min=Integer.MAX_VALUE;
        int max =Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(arr[i]>max)
                max=arr[i];
            if(arr[i]<min)
                min=arr[i];
        }
        int range=max-min+1;
        int count[]=new int[range];
        Arrays.fill(count,0);
        int pos;
        for(int i=0;i<n;i++)
        {
            pos=arr[i]-min;
            count[pos]++;
        }
        pos=0;
        for(int i=0;i<range;i++)
            while(count[i]>0)
            {
                arr[pos++]=i;
                count[i]--;
            }
    }
}
