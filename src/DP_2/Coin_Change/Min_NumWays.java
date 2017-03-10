package DP_2.Coin_Change;

/**
 * Created by Ritu on 2/26/17.
 * http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
 * https://www.youtube.com/watch?v=_fgjrs570YE&t=209s
 * Time complexity - O(n*V)
 */
public class Min_NumWays {
    public static void main(String args[])
    {
        int coins[] =  {1,2,3};//{9, 6, 5, 1};
        int V = 5;//11;
        System.out.println("Minimum coins required is "+ minCoins(coins, V) );
    }
    private static int minCoins(int[]coins, int V)
    {
        int l=coins.length;
        if(l==0)
            return 0;
        if(V==0)
            return 1;
        int[][] matrix=new int[l+1][V+1];
        for(int i=1;i<=l;i++)
        {
            for(int j=0;j<=V;j++)
            {
                if(j==0)
                {
                    matrix[i][j]=1;
                    continue;
                }
                if(j<coins[i-1])
                    matrix[i][j]=matrix[i-1][j];
                else
                    matrix[i][j]=Math.max(matrix[i][j-coins[i-1]],1)+matrix[i-1][j];
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
            return matrix[l][V];
    }
}
