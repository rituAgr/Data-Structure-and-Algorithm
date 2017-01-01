package Sorting_Revision;

import java.util.Arrays;

/**
 * Created by Ritu on 11/7/16.
 * time complexity =O(n^2)
 */
public class Selection_Sort {
    public static void main(String args[])
    {
        int[] arr={4,1,0,5,3,2,10};
        selection_Sort(arr);
        System.out.print(Arrays.toString(arr));
    }
    private static void selection_Sort(int[] arr)
    {
        int n=arr.length;
        for(int i=n-1;i>0;i--)
        {
            int maxIndex=i;
            for(int j=0;j<i;j++)
                if(arr[j]>arr[maxIndex])
                    maxIndex = j;
            if(maxIndex==i)
                    continue;
            int temp=arr[i];
            arr[i]=arr[maxIndex];
            arr[maxIndex]=temp;
        }
    }
}
