package Sorting_Revision;

import java.util.Arrays;

/**
 * Created by Ritu on 11/11/16.
 *
 * Time Complexity :
 * worst case : O(n^2)
 * Avg case : O(nlogn)
 * Best case : O(n)
 *
 * Space complexity : O(1)
 *
 * Merge Sort VS Quick Sort
 * QuickSort is in place sorting algorithm whereas Merge Sort requires space O(n).
 * The worst case of quick sort is almost avoided by using its randomized version
 *
 * https://www.youtube.com/watch?v=COk73cpQbFQ
 *
 * In MergeSort , we need another method merge to merge two arrays into one array.
 * In quickSort, we need another method which partition the given array and return division index called pivot
 */
public class QuickSort {
    public static void main(String args[])
    {
        int[] arr={10,-1,0,5,3,2,10};
        quick_Sort(arr,0, arr.length-1);
        System.out.print(Arrays.toString(arr));
    }
    private static void quick_Sort(int[] arr, int start, int end)
    {
        if(start<end)
        {
            int pivot=partition(arr, start,end);
            quick_Sort(arr,start,pivot-1);
            quick_Sort(arr,pivot+1,end);
        }
    }
    private static int partition(int[] arr, int start,int end)
    {
        int pivot=end;
        int pIndex=start;
        for(int i=start;i<end;i++)
            if(arr[i]<arr[pivot])
            {
                swap(arr,i,pIndex);
                pIndex++;
            }
        swap(arr,pIndex,pivot);
        return pIndex;
    }
    private static void swap(int[] arr, int i , int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
