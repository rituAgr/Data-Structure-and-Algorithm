package DP_2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Ritu on 2/27/17.
 * http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
 */
public class MinJumps {
    public static void main(String[] args)
    {
        int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        find(arr);
    }
    private static void find(int[] arr)
    {
        int l=arr.length;
        int[] len=new int[l];
        Arrays.fill(len, Integer.MAX_VALUE);
        len[0]=0;

        int[] parents=new int[l];
        Arrays.fill(parents,-1);

        for(int i=1;i<l;i++)
            for(int j=0;j<i;j++)
            {
                if(j+arr[j]>=i&&len[i]>len[j]+1)
                {
                    len[i]=len[j]+1;
                    parents[i]=j;
                }
            }
        System.out.println("Minimum num of jumps is "+len[l-1]);
//        for(int i=0;i<l;i++)
//            System.out.print(len[i]+" ");

        int index=l-1;
        Stack<Integer> st=new Stack<>();

        while(index!=-1)
        {
            st.push(arr[index]);
            index=parents[index];
        }
        System.out.println("Jumps are as follows -");
        while(!st.isEmpty())
            System.out.print(st.pop()+" ");
    }
}
