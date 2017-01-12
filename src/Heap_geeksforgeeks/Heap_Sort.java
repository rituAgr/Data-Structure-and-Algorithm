package Heap_geeksforgeeks;
import java.util.Arrays;

/**
 * Created by Ritu on 1/4/17.
 * http://quiz.geeksforgeeks.org/heap-sort/
 * Inorder to do heapsort; we need mainly three func.-
 * MaxHeap
 * Heapify
 * HeapSort
 */
public class Heap_Sort
{
    public static void main(String args[])
    {
        int[] arr={12, 11, 13, 5, 6, 7};
        HeapSort(arr);
        System.out.print(Arrays.toString(arr));
    }
    private static void HeapSort(int[] arr)
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
    private static void maxHeap(int[] arr, int pos, int end)
    {
        int left=2*pos+1;
        int right=2*pos+2;
        int max=pos;
        if(left<end&&arr[max]<arr[left])
            max=left;

        if(right<end&&arr[max]<arr[right])
            max = right;

        if(max!=pos)
        {
            swap(arr,max,pos);
            maxHeap(arr, max, end);
        }
    }
    private static void swap(int[] arr, int i, int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
