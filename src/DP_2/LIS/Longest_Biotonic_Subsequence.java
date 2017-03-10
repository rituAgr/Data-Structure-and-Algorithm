package DP_2.LIS;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ritu on 2/22/17.
 * http://www.geeksforgeeks.org/dynamic-programming-set-15-longest-bitonic-subsequence/
 */
public class Longest_Biotonic_Subsequence {
    public static void main(String args[])
    {
        int arr[] ={80, 60, 30, 40, 20, 10};//{12, 11, 40, 5, 3, 1};// {1, 11, 2, 10, 4, 5, 2, 1};
        find(arr);
    }
    private static void find(int[] arr)
    {
        int l=arr.length;
        int[] parent1=new int[l];
        int[] parent2=new int[l];

        Arrays.fill(parent1,-1);
        Arrays.fill(parent2,-1);

        int[] LIS1=new int[l];
        int[] LIS2=new int[l];

        Arrays.fill(LIS1,1);
        Arrays.fill(LIS2,1);

        for(int i=1;i<l;i++)
            for(int j=0;j<i;j++)
                if(arr[i]>arr[j]&&LIS1[i]<(LIS1[j]+1))
                {
                    LIS1[i]=LIS1[j]+1;
                    parent1[i]=j;
                }

        for(int i=(l-2);i>=0;i--)
            for(int j=(l-1);j>i;j--)
                if(arr[i]>arr[j]&&LIS2[i]<(LIS2[j]+1))
                {
                    LIS2[i]=LIS2[j]+1;
                    parent2[i]=j;
                }
        int[] biotonic=new int[l];
        int max=0;
        for(int i=0;i<l;i++)
        {
            biotonic[i]=LIS1[i]+LIS2[i]-1;
            if(biotonic[i]>biotonic[max])
                max=i;
        }

        int index=max;
        ArrayList<Integer> list=new ArrayList<Integer>();
        while (index!=-1)
        {
            list.add(0,arr[index]);
            index=parent1[index];
        }
    index=max;
        while (parent2[index]!=-1)
        {
            index=parent2[index];
            list.add(arr[index]);
        }
        System.out.println(list.toString());

    }
}
