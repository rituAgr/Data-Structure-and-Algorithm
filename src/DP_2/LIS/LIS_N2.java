package DP_2.LIS;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ritu on 2/15/17.
 * http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
 * time complexity = O(n^2)
 * https://www.youtube.com/watch?v=CE2b_-XfVDk
 */
public class LIS_N2 {
    public static void main(String[] args) {
        int[] array={50, 3, 10, 7, 40, 80};
        int maxLen=LIS(array);
        System.out.println(maxLen);
    }
    private static int LIS(int[] array)
    {
        int l=array.length;
        if(l==0)
            return -1;
        if(l==1)
            return array[0];

        int[] len=new int[l];
        Arrays.fill(len,1);

        int parent[]=new int[l];
        Arrays.fill(parent,-1);

        for(int j=1;j<l;j++)
            for(int i=0;i<j;i++)
                if(array[i]<array[j]&&len[j]<(1+len[i]))
                {
                    len[j]=1+len[i];
                    parent[j]=i;
                }
        int max=-1,maxIndex=-1;
        for(int pos=0;pos<l;pos++)
            if(max<len[pos])
            {
                max=len[pos];
                maxIndex=pos;
            }
        ArrayList<Integer> result=new ArrayList<>();
            while(maxIndex!=-1)
            {
                result.add(0,array[maxIndex]);
                maxIndex=parent[maxIndex];
            }

        System.out.println(result.toString());
        return max;
    }
}
