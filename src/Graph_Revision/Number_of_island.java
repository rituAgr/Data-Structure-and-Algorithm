package Graph_Revision;

import java.util.Stack;

/**
 * Created by Ritu on 2/1/17.
 * http://www.geeksforgeeks.org/find-number-of-islands/
 * https://www.youtube.com/watch?v=CGMNePwovA0
 * Time and space complexity = O(row*col)
 */
public class Number_of_island
{
    public static void main (String[] args)
    {
        int M[][]=  new int[][] {{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        Islands I = new Islands();
        System.out.println("\nTotal number of islands is "+ I.countIslands(M));
    }
}
class Islands{
    int countIslands(int[][] matrix)
    {
        int l=matrix.length;
        int count=0;
        boolean visited[][]=new boolean[l][l];
        for(int i=0;i<l;i++)
            for(int j=0;j<l;j++)
            {
                if(matrix[i][j]==0||visited[i][j])
                    continue;
                System.out.print("\n Another islands is: ");
                DFS(matrix,i,j,visited);
                count++;
            }
        return count;
    }
    void DFS(int[][] mat,int row,int col,boolean visited[][])
    {
        System.out.print("["+row+"]"+"["+col+"]"+", ");
        visited[row][col]=true;
        for(int i=row-1;i<=row+1;i++)
            for(int j=col-1;j<=col+1;j++)
            {
                if(i<0||i>=mat.length||j<0||j>=mat.length)
                    continue;
                if(mat[i][j]==0||visited[i][j])
                    continue;
                DFS(mat,i,j,visited);
            }
    }
}
