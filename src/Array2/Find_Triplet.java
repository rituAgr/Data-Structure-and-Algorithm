package Array2;

import java.util.Arrays;

/**
 * Created by Ritu on 3/24/17.
 * http://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
 * time complexity= O(N^2)
 */
public class Find_Triplet {
    public static void main(String[] args)
    {
        int arr[] = {1, 4, 45, 6, 10, 8};
        int sum = 22;
        find(arr,sum);
    }
    private static void find(int[] arr, int sum)
    {
        Arrays.sort(arr);
        int l,r;
        int n=arr.length;

        for(int i=0;i<n-2;i++)
        {
            l=i+1;
            r=n-1;
            while(l<r)
            {
                if((arr[i]+arr[l]+arr[r])==sum)
                {
                    System.out.println("Elements are "+arr[i]+" ,"+arr[l]+", "+arr[r]);
                    l++;
                    r--;
                }
                else if((arr[i]+arr[l]+arr[r])<sum)
                    l++;
                else
                    r--;
            }
        }
    }
}
