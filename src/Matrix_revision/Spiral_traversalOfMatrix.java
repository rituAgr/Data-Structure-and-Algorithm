package Matrix_revision;

import java.util.ArrayList;

/**
 * Created by Ritu on 2/10/17.
 */
public class Spiral_traversalOfMatrix
{
    public static void main(String args[])
    {
        int[][] matrix= { {1,  2,  3,  4,  5,  6},
                {7,  8,  9,  10, 11, 12},
                {13, 14, 15, 16, 17, 18}
        };
        ArrayList<Integer> spiral=spiral_traversal(matrix);
        System.out.println(spiral.toString());
    }
    private enum directions{
        str_LTR, str_RTL,DOWN, UP
    }
    private static ArrayList<Integer>  spiral_traversal(int[][] matrix)
    {
        int row=matrix.length-1;
        if(row==-1)
            return null;
        int col=matrix[0].length-1;
        directions dir=directions.str_LTR;
        int row_start=0,col_start=0;
        ArrayList<Integer> result=new ArrayList<>();
        while(row_start<=row&&col_start<=col)
        {
            switch(dir)
            {
                case str_LTR:// str left to right
                    for(int c=col_start;c<=col;c++)
                        result.add(matrix[row_start][c]);
                    row_start++;
                    dir=directions.DOWN;
                    break;

                case DOWN: // down in a column
                    for(int r=row_start;r<=row;r++)
                        result.add(matrix[r][col]);
                    col--;
                    dir=directions.str_RTL;
                    break;

                case str_RTL: // str right to left
                    for(int c=col;c>=col_start;c--)
                        result.add(matrix[row][c]);
                    row--;
                    dir=directions.UP;
                    break;

                case UP: // Up in a column
                    for(int r=row;r>=row_start;r--)
                        result.add(matrix[r][col_start]);
                    col_start++;
                    dir=directions.str_LTR;
                    break;
            }
        }
        return result;
    }
}
