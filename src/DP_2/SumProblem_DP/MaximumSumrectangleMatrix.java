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
    }
    private static void find(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[] arr;
        int maxSum = 0;
        int maxCurrentSum = 0;// It is not not used but stil..
        int L = 0, R = 0;
        int maxLeft = 0, maxRight = 0;
        int maxUp = 0, maxDown = 0;

        while (L < col)
        {
            arr = new int[row];
            R=L;
            while(R<col) {
                for (int j = 0; j < row; j++)
                    arr[j] = arr[j] + matrix[j][R];
                ArrayList<Integer> r=kadane(arr);
                if(maxSum<r.get(2))
                {
                    maxSum=r.get(2);
                    maxLeft=L;
                    maxRight=R;
                    maxUp=r.get(0);
                    maxDown=r.get(1);
                }
                R++;
            }
            L++;
        }
        // printing result
        System.out.println("maxLeft "+maxLeft);
        System.out.println("maxRight "+maxRight);
        System.out.println("maxUp "+maxUp);
        System.out.println("maxDown "+maxDown);

        for(row=maxUp;row<=maxDown;row++)
        {
            for(col=maxLeft;col<=maxRight;col++)
                System.out.print(matrix[row][col]+" ");
            System.out.println();
        }
        System.out.println("Maximum Sum is "+maxSum);


    }
    private static ArrayList<Integer> kadane(int[] arr)
    {
        int maxEndingHere=0;
        int maxSoFar=0;
        int start=-1,end=-1;
        int s=0;

        ArrayList<Integer> result=new ArrayList<Integer>();

        for(int i=0;i<arr.length;i++)
        {
            maxSoFar=maxSoFar+arr[i];
            if(maxSoFar<0)
            {
                maxSoFar=0;
                s=i+1;
            }
            if(maxEndingHere<maxSoFar)
            {
                maxEndingHere=maxSoFar;
                start=s;
                end=i;
            }
        }
        result.add(start);
        result.add(end);
        result.add(maxEndingHere);
        return result;
    }

}
