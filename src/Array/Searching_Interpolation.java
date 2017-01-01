package Array;

/**
 * Created by Ritu on 11/10/16.
 * http://www.geeksforgeeks.org/interpolation-search/
 * https://www.youtube.com/watch?v=YxZIl_1o6z8
 * time complexity : log(log n)
 * Space complexity : O(1)
 */
public class Searching_Interpolation
{
    public static void main(String args[])
    {
        int arr[]={10, 12, 13, 16, 31, 33, 35, 42, 47};
        int pos=interpolationSearch(arr,35);
        System.out.print("The position of element "+pos);
    }
    private static int interpolationSearch(int[] arr, int element)
    {
        int start=0;
        int end=arr.length-1;
        int len=end+1;
        while(start<=end)
        {
            int pos=start+((element-arr[start])*(end-start+1)/(arr[end]-arr[start]));
            if(arr[pos]==element)
                return pos;
            if(element>arr[pos])
                start=pos+1;
            else
                end=pos-1;
        }
        return -1;
    }
}
