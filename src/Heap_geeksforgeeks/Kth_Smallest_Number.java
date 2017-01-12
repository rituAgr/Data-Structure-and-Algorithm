package Heap_geeksforgeeks;

/**
 * Created by Ritu on 1/4/17.
 * http://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
 * time complexity=(n-k)logk
 */
public class Kth_Smallest_Number {
public static void main(String args[])
    {
         int arr[]={1, 23, 12, 9, 30, 2, 50};
         int k=4;
        int num=find_Kth_Smallest_Number(arr,k);
        System.out.print(num);
    }
    private static int find_Kth_Smallest_Number(int[] arr, int k)
    {
        int array[]=new int [k];
        System.arraycopy(arr,0,array,0,k);
        heapify(array);
        for(int i=k;i<arr.length;i++)
            if(arr[i]<array[0])
            {
                array[0]=arr[i];
                maxHeap(array,0,k);
            }
            return array[0];
    }
    private static void heapify(int[] arr )
    {
        int n=arr.length;
        for(int i=n/2;i>=0;i--)
            maxHeap(arr, i,n);
    }
    private static void maxHeap(int[] arr,int pos, int end)
    {
        int left = pos*2+1;
        int right= pos*2+2;
        int max=pos;
        if(left<end&&arr[max]<arr[left])
            max=left;
        if(right<end&&arr[max]<arr[right])
            max=right;
        if(max!=pos)
        {
            swap(arr, max,pos);
            maxHeap(arr,max,end);
        }
    }
    private static void swap(int[] arr,int pos1, int pos2)
    {
        int temp=arr[pos1];
        arr[pos1]=arr[pos2];
        arr[pos2]=temp;

    }
}
