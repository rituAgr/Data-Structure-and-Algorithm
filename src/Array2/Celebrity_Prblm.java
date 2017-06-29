package Array2;

/**
 * Created by Ritu on 3/25/17.
 * http://www.geeksforgeeks.org/the-celebrity-problem/
 */
public class Celebrity_Prblm {
    public static void main(String[] args)
    {
        int[][]  matrix = {{0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0}
        };
        System.out.println(find(matrix));
    }
    private static int find(int[][] matrix)
    {
        int people=matrix.length;

        int start=0,end=people-1;
        while(start<end)
        {
            if(knows(matrix,start,end))
                start++;
            else
                end--;
        }
        int celebrity=start;

        //confirming
        for(int i=0;i<people;i++)
            if(knows(matrix,celebrity, i))
                return -1;
        return celebrity;
    }
    private static boolean knows(int[][] matrix, int a, int b)
    {
        if(matrix[a][b]==1)
            return true;
        return false;
    }
}
