package Matrix_revision;

import java.util.ArrayList;

/**
 * Created by Ritu on 2/11/17.
 */
public class Rotate_matrix {
    public static void main(String args[]) {
        int matrix[][] = { {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9,  10, 11, 12},
                {13, 14, 15, 16} };
        rotateBy90(matrix);
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix.length;j++)
                System.out.print(matrix[i][j]+" ");
            System.out.println();
        }
    }

    private static void rotateBy90(int[][] matrix)
    {

        int row_end=matrix.length-1;
        if(row_end==-1)
            return ;
        int col_end=row_end;// for rotating the matrix by 90 degree, matrix has to be square matrix
        int row_start=0,col_start=0;
        while(row_start<row_end)
        {
            int count=col_end-col_start;

            for(int c=0;c<count;c++) {
                int val = matrix[row_start][col_start + c];
                val = exchange(matrix, row_start + c, col_end, val);
                val = exchange(matrix, row_end, col_end - c, val);
                val = exchange(matrix, row_end - c, col_start, val);
                exchange(matrix, row_start, col_start + c, val);
            }
            row_start++;row_end--;
            col_start++;col_end--;
        }
    }
    private static int exchange(int[][] matrix, int row1,int col1,int val)
    {
        int value=matrix[row1][col1];
        matrix[row1][col1]=val;
        return value;
    }

}
