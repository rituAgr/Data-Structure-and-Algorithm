package Array2;

/**
 * Created by Ritu on 3/11/17.
 * http://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 */
public class FindElementin_RotatedSortedArray
{
    public static void main(String[] args)
    {
        int arr[] = { 9, 10, 1, 2, 3, 5, 6, 7, 8};
        int key = 0;
        System.out.println(find(arr,key));
    }
    private static int find(int[] arr, int key)
    {
        int start=0;
        int end=arr.length-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(arr[mid]==key)
                return mid;
            if(arr[start]<arr[mid])
            {
                if(key>=arr[start]&&key<arr[mid])
                    end=mid-1;
                else
                    start=mid+1;
            }
            else
            {
                if(key>arr[mid]&&key<=arr[end])
                    start=mid+1;
                else
                    end=mid-1;

            }
        }
        return -1;
    }
}
