package DP_2.SumProblem_DP;

import java.util.Stack;

/**
 * Created by Ritu on 3/6/17.
 * http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/
 * subset problem is similiar to knap sack problem
 */
public class SubsetSumPrblm {
    public static void main(String[] args)
    {
        int[] arr= {3, 34, 4, 12, 5, 2};
        int sum = 7;
        find(arr,sum);
    }
    private static void find(int[] arr, int sum)
    {
        int l=arr.length;
        boolean[][] matrix=new boolean[l+1][sum+1];

        for(int i=1;i<=l;i++)
        {
            for(int j=0;j<=sum;j++)
            {
                if(j==0)
                {
                    matrix[i][j]=true;
                    continue;
                }
                if(j<arr[i-1])
                    matrix[i][j]=matrix[i-1][j];
                else if(j==arr[i-1])
                    matrix[i][j]=true;
                else
                    matrix[i][j]=matrix[i-1][j-arr[i-1]]||matrix[i-1][j];
            }
        }
        if(!matrix[l][sum])
        {
            System.out.println("False");
            return;
        }
        int j=sum,i=l;
        Stack<Integer> st=new Stack();
        while(i>0&&j>0)
        {
            if(matrix[i][j]==matrix[i-1][j])
                i--;
            else
            {
                st.push(arr[i-1]);
                j=j-arr[i-1];
                i--;
            }
        }
        while(!st.isEmpty())
            System.out.print(st.pop()+" ");

    }

}
