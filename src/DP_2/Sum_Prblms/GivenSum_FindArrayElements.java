package DP_2.Sum_Prblms;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Ritu on 4/5/17.
 * http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/
 */
public class GivenSum_FindArrayElements {
    public static void main (String args[]) {
        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        find(set, sum);
    }
    private static void find(int[] arr, int sum)
    {
        int n=arr.length;
        boolean[][] matrix=new boolean[n+1][sum+1];
        matrix[0][0]=true;

        for(int i=1;i<=n;i++)
            for(int j=0;j<=sum;j++)
                if(j>=arr[i-1])
                    matrix[i][j]=matrix[i-1][j]||matrix[i-1][j-arr[i-1]];
                else
                    matrix[i][j]=matrix[i-1][j];

        int i=n,j=sum;
        System.out.println(matrix[i][j]);
        if(!matrix[i][j])
            return;
        Stack<Integer> st=new Stack();
        while(j!=0)
        {
            if(matrix[i][j]!=matrix[i-1][j])
            {
                st.push(arr[i-1]);
                j=j-arr[i-1];
            }
            i--;
        }
        System.out.println("Elements are : ");
        while(!st.isEmpty())
            System.out.println(st.pop());
    }
}
