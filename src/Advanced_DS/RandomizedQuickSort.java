package Advanced_DS;

/**
 * Created by Ritu on 2/16/17.
 * Almost Worst case time complexity is reduced to O(nlogn)
 * Space Complexity : O(1)
 * http://www.geeksforgeeks.org/can-quicksort-implemented-onlogn-worst-case-time-complexity/
 */
public class RandomizedQuickSort {

    public static void main(String[] args)
    {
        int arr[] = {1, 11,11, 13, 5, 6, 7};
        do_RandomizedQuickSort(arr,0,arr.length-1);
        for(int num: arr)
            System.out.print(num+" ");
    }
    // Since quick sort is inplace sorting algorithm; there is no need to return arr.
    // The arr provided is itself sorted in its array
    private static void do_RandomizedQuickSort(int[] arr,int start, int end)
    {
        if(start>=end)
            return ;
        int pos=start+(int)((end-start+1)*Math.random());
        swap(arr,pos,end);
        int pivot=partition(arr,start,end);
        do_RandomizedQuickSort(arr,0,pivot-1);
        do_RandomizedQuickSort(arr,pivot+1,end);
    }
    private static int partition(int[] arr, int start, int end)
    {
        int pIndex=start;
        int pivot=end;
        for(int i=start;i<end;i++)
        {
            if(arr[i]<arr[pivot])
            {
                swap(arr,i,pIndex);
                pIndex++;
            }
        }
        swap(arr,pIndex,pivot);
        return pIndex;
    }
    private static void swap(int[] arr, int pos1, int pos2)
    {
        int val=arr[pos1];
        arr[pos1]=arr[pos2];
        arr[pos2]=val;
    }
}
