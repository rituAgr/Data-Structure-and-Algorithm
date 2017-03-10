package Advanced_DS;

import java.util.ArrayList;

/**
 * Created by Ritu on 2/18/17.
 * http://www.geeksforgeeks.org/find-minimum-element-in-a-sorted-and-rotated-array/
 * Time complexity = O(log n)
 */
public class RotatedArray_FindMinMaxElement
{
    public static void main(String args[])
    {
        int arr1[] = {5, 6, 7, 8,9, 10, 1, 2,3};// rotated towards left
        int arr2[] = {9, 10, 1, 2, 3,5, 6, 7, 8};//rotated towards right

        int min1 =searchMin(arr1);
        System.out.println(min1);

        int min2 =searchMin(arr2);
        System.out.println(min2);
    }
    private static int searchMin(int[] arr)
    {
        int l=arr.length;
        if(l==0)
            return -1;

        int min=-1;

        if(l==1)
        return 0;

        int start=0,end=l-1,mid=-1;

        /*
        1. if (current index value is less than its nearby element. Return index
        2. Else, Identify the proper sorted part of array. if The element at its
        end( that comparing side will vary on either side) and then decide which part to go for
         */
        while(start<=end)
        {
            mid=start+(end-start)/2;
            if(arr[mid]<=arr[(mid+1)%l]&&arr[mid]<=arr[(mid-1+l)%l])
                return mid;
            if(arr[start]<=arr[mid])
            {
                if(arr[start]<=arr[end])
                   end=(mid-1+l)%l;
                else
                    start=(mid+1)%l;
            }
            else
            {
                if(arr[end]>=arr[start])
                    start=(mid+1)%l;
                else
                    end=(mid-1+l)%l;
            }
        }
        return mid;
    }
}
