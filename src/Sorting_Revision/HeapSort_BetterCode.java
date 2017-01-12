package Sorting_Revision;

import java.util.Arrays;

/**
 * Created by Ritu on 11/9/16.
 * Space complexity = O(1) in all cases
 * Time Complexity -
 * Worst case performance : O(n log n)
 Best case performance : O(n log n)
 Average case performance : O(n log n)
 *
 * This code is best one. The codes available online is not correct. This one written below is correct
 *   When we have to do heap sort; only three functional methods are needed
 * - MaxHeap (or MinHeap)
 * - heapify()
 * - heapSort()
 * A helper method swap()
 * VV Imp => Heapify is called just once; whereas MaxHeap (or Minheap) is called again & again
 */
public class HeapSort_BetterCode {
    public static void main(String args[])
    {
        int[] arr={12,0,1,11, 12, 13, 5, 6, 7};//{4,1,0,5,3,0,2,10};
        heapSort(arr);
        System.out.print(Arrays.toString(arr));
    }
    private static void heapSort(int[] arr)
    {
        Heapify(arr);
        int n=arr.length-1;
        for(int i=n;i>=0;i--)
        {
            swap(arr,0,i);
            maxHeap(arr,0,i);
        }
    }
    private static void Heapify(int[] arr)
    {
        int n=arr.length;
        for(int i=n/2;i>=0;i--)
            maxHeap(arr,i,n);
    }
    private static void maxHeap(int[] arr, int pos,int n)
    {
        int left=2*pos+1;
        int right=2*pos+2;
        if(left>=n&&right>=n)
            return;
        int max=pos;
        if(left<n&&arr[max]<arr[left])
            max=left;
        if(right<n&&arr[max]<arr[right])
            max=right;
        if(max!=pos)
        {
            swap(arr,max,pos);
            maxHeap(arr,max,n);
        }
    }
    private static void swap(int[] arr, int pos1, int pos2)
    {
        int temp=arr[pos1];
        arr[pos1]=arr[pos2];
        arr[pos2]=temp;
    }
}
