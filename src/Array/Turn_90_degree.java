package Array;

import java.util.Arrays;

/**
 * Created by Ritu on 11/8/16.
 * http://www.geeksforgeeks.org/turn-an-image-by-90-degree/
 * time complexity=)(n) = size of matrix;
 * Space complexity : O(1)
 */
public class Turn_90_degree {
    public static void main(String args[])
    {
        int[][] matrix={ {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9,  10, 11, 12},
                {13, 14, 15, 16}  };
        rotateMatrix(matrix);
    }
    private static void rotateMatrix(int[][] matrix)
    {
        int pos_start=0;
        int pos_end=matrix.length-1;
        int len=pos_end-pos_start+1;
        while(pos_start<pos_end)
        {
            for(int pos=pos_start;pos<pos_end;pos++)
            {
                int temp=matrix[pos_start][pos];
                temp=swap(matrix,temp,pos,pos_end);
                temp=swap(matrix,temp,pos_end,len-pos-1);
                temp=swap(matrix,temp,len-pos-1,pos_start);
                temp=swap(matrix,temp,pos_start,pos);
            }
            System.out.println("*** one outer elements rotated *******");
            print(matrix);
            pos_start++;
            pos_end--;
        }
    }
    private static int swap(int[][] mat, int temp,int x1,int y1)
    {
        int temp1=mat[x1][y1];
        mat[x1][y1]=temp;
        return temp1;
    }
    private static void print(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++)
            System.out.println(Arrays.toString(matrix[i]));
       // System.out.println("**********");
    }
}
