package DP_2;

/**
 * Created by Ritu on 4/1/17.
 * http://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
 */
public class MaxSize_1Square {
    public static void main(String[] args)
    {
        int matrix[][] = new int[][]  {{0, 1, 1, 0, 1},
        {1, 1, 0, 1, 0},
        {0, 1, 1, 1, 0},
        {1, 1, 1, 1, 0},
        {1, 1, 1, 1, 1},
        {0, 0, 0, 0, 0}};

        find(matrix);
    }
    private static void find(int[][] matrix)
    {
        int row=matrix.length;
        int col=matrix[0].length;

        int max=0,r=-1,c=-1;
       // int[][] mat=new int[row][col];

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(i==0||j==0)
                    continue;
                if(matrix[i][j]==0)
                    continue;
                if(matrix[i-1][j]!=0&&matrix[i-1][j-1]!=0&&matrix[i][j-1]!=0)
                        matrix[i][j]=1+Math.max(matrix[i-1][j],matrix[i-1][j]);
                if(max<=matrix[i][j])
                {
                    max=matrix[i][j];
                    r=i;
                    c=j;
                }
            }
        }

        System.out.println(max);
        System.out.println("Start ro & col is : "+(r-max+1)+" AND "+(c-max+1));
        System.out.println("ending row and col is : "+r+" AND "+c);
    }
}
