package Array;

/**
 * Created by Ritu on 10/16/16.
 */
public class Sorted_Rotated_Array {
    public static void main(String args[])
    {
        int[] arr={3, 4, 5, 1, 2};
        int pos=find(arr,2);
        System.out.print("The position is "+pos);
    }
    private static int find(int[] arr, int num)
    {
        int low=0;
        int high=arr.length-1;
        int mid=-1;
        while(low<=high)
        {
            mid=low+(high-low)/2;
            if(arr[mid]==num)
                return mid;
            if(num<arr[mid]&&num>=arr[low])
            {
                if(mid-1<0)
                    break;
                else
                    high = mid-1;
            }
            else
            {
                if(mid+1<arr.length)
                    low=mid+1;
                else
                    break;
            }

        }
        return -1;
    }
}

