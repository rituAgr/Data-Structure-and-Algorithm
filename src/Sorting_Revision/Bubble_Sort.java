package Sorting_Revision;

import java.util.Arrays;

/**
 * Created by Ritu on 11/7/16.
 * time complexity =O(n^2)
 */
public class Bubble_Sort {
    public static void main(String args[])
    {
        int[] arr={4,1,0,5,3,2,10};
        bubble_Sort(arr);
        System.out.print(Arrays.toString(arr));
    }
    private static void bubble_Sort(int[] arr)
    {
        int n=arr.length;
        for(int i=n-1;i>0;i--)
        {
            for(int j=0;j<i;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

}
