package Searching_geeksforgeeks;

/**
 * Created by Ritu on 12/30/16.
 */
public class min_in_sorted_rotated_array {
    public static void main (String[] args) {
        int arr1[] = {5, 6, 1, 2, 3, 4};
        int val1=find_min(arr1);
        System.out.println("The min value is at index "+ val1+"; value is "+arr1[val1]);
    }
     static int find_min(int[] arr)
    {
        int n=arr.length;
        if(n==0)
            return -1;
        int low=0;
        int high=n-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(arr[mid]<=arr[(mid+1)%n]&&arr[mid]<=arr[(mid-1+n)%n])
                return mid;
            if(arr[(mid+1)%n]<arr[high])
                high=mid-1;
            else
                low=mid+1;
        }
        return -1;
    }
}
