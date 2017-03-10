package DP_2.LIS;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ritu on 2/22/17.
 * http://www.geeksforgeeks.org/fundamentals-of-algorithms/#DynamicProgramming
 * time complexity : o(n^2)
 */
public class Maximum_Sum_Increasing_Subsequence {
    public static void main(String args[])
    {
        int arr[] = {1, 101, 2, 3, 100, 4, 5};
        find(arr);
    }
    private static void find(int[] arr)
    {
        int l=arr.length;

        int[] track=new int[l];
        for(int i=0;i<l;i++)
            track[i]=arr[i];

        int[] parent=new int[l];
        Arrays.fill(parent,-1);

        for(int j=1;j<l;j++)
            for(int i=0;i<j;i++)
                //Eleements should be increasing and also the sum
                if(arr[j]>arr[i]&&(arr[j]+track[i])>=track[j])
                {
                    track[j]=arr[j]+track[i];
                    parent[j]=i;
                }
        int index=0;
        for(int i=0;i<l;i++)
            if(track[i]>track[index])
                index=i;


        System.out.println(track[index]);
        ArrayList<Integer> list=new ArrayList<>();
        while(index!=-1)
        {
            list.add(0,arr[index]);
            index=parent[index];
        }
        System.out.println(list.toString());
    }
}
