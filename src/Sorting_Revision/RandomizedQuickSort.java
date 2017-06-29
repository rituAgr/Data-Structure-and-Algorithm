package Sorting_Revision;

import java.util.Arrays;

/**
 * Created by Ritu on 11/12/16.
 * Time complexity : O(Nlogn)
 * Space complexity : O(1)
 */
public class RandomizedQuickSort {
    public static void main(String args[])
    {
        int[] arr={10,-1,0,5,3,2,10};
        randomizedQuickSort(arr,0, arr.length-1);
        System.out.print(Arrays.toString(arr));
    }
    private static void randomizedQuickSort(int arr[], int start, int end)
    {
        if(start>=end)
            return;

        int range=end-start+1;
        int pIndex=start+(int)(Math.random()*range);
        swap(arr,pIndex,end);

        int pivot=partition(arr, start, end);
        randomizedQuickSort(arr,start,pivot-1);
        randomizedQuickSort(arr,pivot+1,end);
    }
    private static void swap(int[] arr, int i, int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    private static int partition(int[] arr, int start, int end)
    {
        int pivot=end;
        int pIndex=0;
        for(int i=0;i<end;i++)
        {
            if(arr[i]<arr[pivot])
            {
                swap(arr, pIndex,i);
                pIndex++;
            }
        }
        swap(arr,pivot,pIndex);
        return pIndex;
    }
}
