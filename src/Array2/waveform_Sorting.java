package Array2;

import java.util.Arrays;

/**
 * Created by Ritu on 4/9/17.
 * http://www.geeksforgeeks.org/sort-array-wave-form-2/
 * There are two kind of wave form sorting.
 * 1: Smooth and consisitently increasing wave form
 * 2: Unsmooth and zigzag wave form sorting
 * Time complexity for Smooth and consisitently increasing wave form : O(nlogn)
 * Time complexity for Unsmooth and zigzag wave form sorting : O(n)
 */
public class waveform_Sorting {
    public static void main(String[] args)
    {
        int arr1[] = {10, 90, 49, 2, 1, 5, 23};
        int arr2[] = {90, 100, 10,  120,2, 1, 5, 23};
        waveform_Sorting1(arr1);
        waveform_Sorting2(arr2);
    }
    //1: Smooth and consisitently increasing wave form
    private static void waveform_Sorting1(int[] arr)
    {
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i=i+2)
        {
            if((i+1)>=arr.length)
                break;
            swap(arr, i,i+1);
        }
        System.out.println("After Sorting "+Arrays.toString(arr));
    }

    //2: Unsmooth and zigzag wave form sorting
    private static void waveform_Sorting2(int[] arr)
    {
        for(int i=0;i<arr.length;i=i+2)
        {
            if(i>0&&arr[i-1]>arr[i])
                swap(arr,i,i-1);
            if((i+1)<arr.length&&arr[i+1]>arr[i])
                swap(arr,i+1,i);
        }
        System.out.println("After Sorting "+Arrays.toString(arr));
    }
    private static void swap(int[] arr, int pos1, int pos2)
    {
        int temp=arr[pos1];
        arr[pos1]=arr[pos2];
        arr[pos2]=temp;
    }
}
