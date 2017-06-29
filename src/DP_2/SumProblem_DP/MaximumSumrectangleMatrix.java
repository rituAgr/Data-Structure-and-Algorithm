package DP_2.SumProblem_DP;

import java.util.ArrayList;

/**
 * Created by Ritu on 3/6/17.
 * http://www.geeksforgeeks.org/dynamic-programming-set-27-max-sum-rectangle-in-a-2d-matrix/
 * https://www.youtube.com/watch?v=yCQN096CwWM
 *
 * Time complexity:O(row*Col*Col) or O(col*row*row) [ depends how it is implemented]
 * In our case Time complexity is O(row*Col*Col)
 *
 * Space Complexity = O(row) or O(col) [ depends how it is implemented]
 * In our case Space complexity is O(row)
 *
 * This ques is actually extension of kadane algo from 1 D to 2D
 *The condition than matrix should fulfill in order for this algo to work is it should have atleast 1 positive number in matrix
 */
public class MaximumSumrectangleMatrix
{
    public static void main(String args[])
    {
        int matrix[][] = {{ 2,  1, -3, -4,  5},
                { 0,  6,  3,  4,  1},
                { 2, -2, -1,  4, -5},
                {-3,  3,  1,  0,  3}};
        find(matrix);
        System.out.println("**********");
        matrix =new int[][]{{1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 10, 1, 3},
                {-4, -1, 1, 7, -6}};
        find(matrix);
    }
    private static void find(int[][] matrix) {
        int maxSum=0;
        int maxLeft=0;
        int maxRight=0;
        int maxUp=0;
        int maxDown=0;
        int n=matrix[0].length;
        int row=matrix.length;

        for(int L=0;L<n;L++)
        {
            int sum[]=new int[row];
            for(int R=L;R<n;R++)
            {
                for(int i=0;i<row;i++)
                    sum[i]+=matrix[i][R];
                ArrayList<Integer> res=kadane(sum);
                if(res.get(0)>maxSum)
                {
                    maxSum=res.get(0);
                    maxLeft=L;
                    maxRight=R;
                    maxUp=res.get(1);
                    maxDown=res.get(2);
                }
            }
        }

        System.out.println("Maximum sum is "+maxSum);

        for(int i=maxUp;i<=maxDown;i++)
        {
            for(int j=maxLeft;j<=maxRight;j++)
                System.out.print(matrix[i][j]+" ");
            System.out.println();
        }
    }
    private static ArrayList<Integer> kadane(int[] arr)
    {
        ArrayList<Integer> result=new ArrayList<Integer>();
        int maxEndingHere=0;
        int maxTillNow=0;
        int s=0,start=0,end=0;
        for(int i=0;i<arr.length;i++)
        {
            maxEndingHere+=arr[i];
            if(maxEndingHere<0)
            {
                maxEndingHere=0;
                s=i+1;
            }
            if(maxTillNow<maxEndingHere)
            {
                maxTillNow=maxEndingHere;
                start=s;
                end=i;
            }
        }
        result.add(maxTillNow);
        result.add(start);
        result.add(end);
        return result;
    }

}
