package DP_2;

import java.util.ArrayList;

/**
 * Created by Ritu on 2/17/17.
 */
public class Min_Path_Cost
{
    public static void main(String args[]) {
        int cost[][] = {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};
        minCost_PAth(cost);
    }
    private static void minCost_PAth(int cost[][])//, int row1,int col1, int row2,int col2,ArrayL)
    {
        int row=cost.length;
        int col=cost[0].length;
        if(row==-1||col==-1)
            return;

        int[][] matrix=new int[row][col];

        int prev=0;
        for(int i=0;i<col;i++)
        {
            matrix[0][i]=prev+cost[0][i];
            prev=matrix[0][i];
        }
        prev=0;
        for(int i=0;i<row;i++)
        {
            matrix[i][0]=prev+cost[i][0];
            prev=matrix[i][0];
        }

        for(int i=1;i<row;i++)
            for(int j=1;j<col;j++)
                matrix[i][j]=Math.min(matrix[i-1][j-1],Math.min(matrix[i][j-1],matrix[i-1][j]))+cost[i][j];

        System.out.println("The minimum cost to traverse is "+matrix[row-1][col-1]);
        ArrayList<String> result = new ArrayList<String>();

        row--;col--;
        String s;
        while(row>=0||col>=0)
        {
            if(row==0&&col==0)
                break;
            if(row==0)
            {
                s="right";// to row = "+row+" col = "+ (col-1);
                col--;
                result.add(0,s);
                continue;
            }

            if(col==0)
            {
                s="down";
                row--;
                result.add(0,s);
                continue;
            }
            int val=matrix[row][col]-cost[row][col];
            if(val==matrix[row-1][col])
            {
                s="down";
                row--;
                result.add(0,s);
                continue;
            }
            if(val==matrix[row][col-1])
            {
                s="right";
                col--;
                result.add(0,s);
                continue;
            }
            s="diagonally";
            col--;
            row--;
            result.add(0,s);
        }
        for(int i=0;i<result.size();i++)
            System.out.println(result.get(i));
    }
}
