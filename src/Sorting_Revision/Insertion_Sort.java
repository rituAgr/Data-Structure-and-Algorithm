package Sorting_Revision;

import java.util.Arrays;

/**
 * Created by Ritu on 11/7/16.
 */
public class Insertion_Sort {
    public static void main(String args[])
    {
        int[] arr={4,1,0,5,3,2,10};
        insertion_Sort(arr);
        System.out.print(Arrays.toString(arr));
    }
    private static void insertion_Sort(int[] arr)
    {
    for(int i=1;i<arr.length;i++)
    {
        int position=findPostion(arr,i);
        if(position==i)
            continue;
        insert(i,position,arr);
    }
    }
    private static int findPostion(int[] arr, int end)
    {
        int element=arr[end];
        if(element<arr[0])
            return 0;
        if(element>=arr[end-1])
            return end;
        int start=0;
        int mid;
        while(start<=end)
        {
            mid=start+(end-start)/2;
            if(arr[mid]<=element&&arr[mid+1]>element)
                return mid+1;
            if(arr[mid]>element)
                end=mid;
            else
                start=mid;
        }
        return -1;
    }
    private static void insert(int end, int index, int[] arr)
    {
        int element=arr[end];
        for(int i=index;i<=end;i++)
        {
            int temp=arr[i];
            arr[i]=element;
            element=temp;
        }
    }

}
