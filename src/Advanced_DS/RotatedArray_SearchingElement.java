package Advanced_DS;

/**
 * Created by Ritu on 2/18/17.
 * Time complexity = O(log n)
 * http://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 */
public class RotatedArray_SearchingElement {
    public static void main(String args[])
    {
        int arr1[] = {5, 6, 7, 8,9, 10, 1, 2,3};// rotated towards left
        int arr2[] = {9, 10, 1, 2, 3,5, 6, 7, 8};//rotated towards right

        int index1=search(arr1,9);
        System.out.println(index1);

        int index2=search(arr2,9);
        System.out.println(index2);
    }
    private static int search(int[] arr, int element)
    {
        int l=arr.length;
        int start=0,end=l-1,mid=-1;

        /*The steps is as follows -
        1. compare the element at mid index; if it matches return index;
         2. find, which part of element s sorted. DO the safe and trustd processing inside it only.
         whichever, part left part or right part is sorted, check is the element lies if that range(make sure to include mid.
         if -
         else -
         */
        while(start<=end)
        {
            mid=start+(end-start)/2;
            if(arr[mid]==element)
                return mid;
            if(arr[start]<=arr[mid])
            {
                if(element>=arr[start]&&element<=arr[mid])
                    end=mid-1;
                else
                    start=mid+1;
                continue;
            }
            if(arr[mid]<arr[end])
            {
                if(element>=arr[mid]&&element<=arr[end])
                    start=mid+1;
                else
                    end=mid-1;
            }
        }
        return -1;
    }
}
