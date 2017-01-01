package Sorting_Revision;

import java.util.Arrays;

/**
 * Created by Ritu on 11/7/16.
 *
 * Time complexity = O(nlog n)
 *
 * Space complexity = The mergesort algorithm is recursive, so it requires O(log n) stack
 * space, for both the array and linked list cases. But in the array case also allocates an
 * additional O(n) space, which dominates the O(log n) space required for the stack. So the
 * array version is O(n), and the linked list version is O(log n)
 */
public class MergeSort1 {
    public static void main(String args[])
    {
        int[] arr={4,1,0,5,3,2,10};
        merge_Sort(arr);
        System.out.print(Arrays.toString(arr));
    }
    private static int[] merge_Sort(int[] arr)
    {
        if(arr.length<=1)
            return arr;
        if(arr.length==2)
        {
            if(arr[0]>arr[1])
            {
                int temp=arr[0];
                arr[0]=arr[1];
                arr[1]=temp;
            }
            return arr;
        }
        int mid=arr.length/2;
        int[] arr1=new int[mid];
        int[] arr2=new int[arr.length-mid];
        System.arraycopy(arr,0,arr1,0,mid);
        System.arraycopy(arr,mid,arr2,0,arr.length-mid);
        arr1=merge_Sort(arr1);
        arr2=merge_Sort(arr2);
        merge(arr1,arr2,arr);
        return arr;
    }
    private static void merge(int[] arr1, int[] arr2, int[] arr)
    {
        int n1=arr1.length;
        int n2=arr2.length;
        if(n1==0) {
            arr= arr2;
            return;
        }
        if(n2==0){
            arr= arr1;
            return;
        }
        int n=n1+n2;
        //int[] arr=new int[n];
        int pos1=0,pos2=0,pos=0;
        while(pos1<n1&&pos2<n2)
        {
            if(arr1[pos1]<arr2[pos2])
                arr[pos++]=arr1[pos1++];
            else
                arr[pos++]=arr2[pos2++];
        }
        if(pos1<n1)
            System.arraycopy(arr1,pos1,arr,pos,n-pos);
        if(pos2<n2)
            System.arraycopy(arr2,pos2,arr,pos,n-pos);
    }
}
