package Array2;

import java.util.Stack;

/**
 * Created by Ritu on 4/8/17.
 * http://www.geeksforgeeks.org/find-number-of-islands/
 */
public class Num_islands
{
    public static void main(String[] args)
    {
        int M[][]= {  {1, 1, 0, 0, 0},
        {0, 1, 0, 0, 1},
        {1, 0, 0, 1, 1},
        {0, 0, 0, 0, 0},
        {1, 0, 1, 0, 1}};
        island(M);
    }
    private static void island(int[][] matrix)
    {
        int n=matrix.length;

        boolean[] visited=new boolean[n];
        int count=0;

        for(int i=0;i<n;i++)
        {
            Stack<Integer> st=new Stack();
            if(visited[i]==false)
                DFS(i, matrix,visited);
            count++;
        }
        System.out.println(count);
    }

    private static void DFS(int start,int[][] matrix, boolean[] visited)
    {
        if(visited[start])
            return;
        visited[start]=true;
        for(int i=0;i<matrix.length;i++)
            if(matrix[start][i]==1)
                DFS(i,matrix,visited);
    }
}
