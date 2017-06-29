package Matrix_revision;

/**
 * Created by Ritu on 2/10/17.
 * http://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
 * time complexity : O(n+m) for m*n matrix
 */
public class SearchIn_SortedMatrix
{
    public static void main(String args[])
    {
        int[][] mat={ {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50},
        };
        System.out.println(search(mat,37));
    }
    private static boolean search(int matrix[][], int element)
    {
        int row=matrix.length;
        if(row==0)
            return false;
        int col=matrix[0].length;
        int startcol=col-1;
        int startrow=0;
        while(startrow<row&&startcol>=0)
        {
            if(matrix[startrow][startcol]==element)
                return true;
            if(matrix[startrow][startcol]>element)
                startcol--;// if we want here can do binary serach, howeer, that won't affect the overall timecomplexity
            else            //O(n+m) -> O(n+logm). In both cases it will result to O(n)
                startrow++;

        }
        return false;
    }
}
