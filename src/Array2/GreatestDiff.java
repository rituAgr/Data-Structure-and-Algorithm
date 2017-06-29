package Array2;

import java.util.Arrays;

/**
 * Created by Ritu on 3/18/17.
 * http://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
 * Time complexity : O(n)
 * Space Complexity : O(n)
 */
public class GreatestDiff {
    public static void main(String[] args)
    {
        int[] arr={34, 8, 10, 3, 2, 80, 30, 33, 1};
        find(arr);
        arr=new int[]{9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
        find(arr);
       arr=new int[] {1, 2, 3, 4, 5, 6};
       find(arr);
    }
    private static void find(int[] arr)
    {
        int n=arr.length;
        int[] Lmin=new int[n];
        int[] Rmax=new int[n];

        int min=0;
        for(int i=0;i<n;i++){
            if(arr[i]<arr[min])
                min=i;
            Lmin[i]=arr[min];
        }

        int max=n-1;
        for(int i=n-1;i>=0;i--){
            if(arr[i]>arr[max])
                max=i;
            Rmax[i]=arr[max];
        }

        int left=-1;
        int right=-1;
        int Maxdiff=-1;
        int i=0,j=0;
        while(i<n&&j<n)
        {
            if(Lmin[i]<Rmax[j]&&(Maxdiff<(j-i)))
            {
                Maxdiff=j-i;
                left=i;
                right=j;
            }
            else
                i++;
            j++;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("Maximum value of j-i is "+Maxdiff);
        System.out.println("Left is "+left+" and right is "+right);
        System.out.println("**************");
    }
}
