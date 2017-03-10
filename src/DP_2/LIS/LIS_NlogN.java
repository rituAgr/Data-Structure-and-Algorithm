package DP_2.LIS;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ritu on 2/15/17.
 * http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
 * time complexity = O(n logn)
 * https://www.youtube.com/watch?v=S9oUiVYEq7E&t=302s
 */
public class LIS_NlogN {
    public static void main(String[] args) {
        int[] array={50, 3, 10, 7, 40, 80};
        int maxLen=LIS(array);
        System.out.println(maxLen);
    }
    private static int LIS(int[] array)
    {
        int l=array.length;
        int[] parent=new int[l];
        Arrays.fill(parent,-1);

        int[] pos=new int[l];
        int len=0;
        for(int i=1;i<l;i++)
        {
            if(array[i]<array[pos[0]])
                pos[0]=i;
            else if(array[i]>array[pos[len]])
            {
                len++;
                pos[len]=i;
                parent[i]=pos[len-1];
            }
            else
            {
                int ceil=ceiling(array,pos,len,array[i]);
                pos[ceil]=i;
                parent[i]=pos[ceil-1];
            }
        }
        int index=pos[len];
        ArrayList<Integer> result=new ArrayList<>();
        while(index!=-1)
        {
            result.add(0,array[index]);
            index=parent[index];
        }
        System.out.println(result.toString());
        return len+1;
    }
    private static int ceiling(int[] array,int[] pos,int end, int num)
    {
        if(num>array[pos[end]])
            return end+1;
        if(num<array[pos[0]])
            return 0;
        int start=0;
        while(start<=end)
        {
            int mid=(start+end)/2;
            if((mid==0||num>array[pos[mid-1]])&&(num<=array[pos[mid]]))
                return mid;
            if(num>array[pos[mid]])
                start=mid+1;
            else
                end=mid-1;
        }
        return -1;
    }
}
