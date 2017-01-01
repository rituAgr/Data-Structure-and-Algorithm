package DP.Revision;

/**
 * Created by Ritu on 10/9/16.
 */
public class BinomialCoefficient {
    public static void main(String args[])
    {
        int x=find(12, 3);
        System.out.print("The coefficient is "+x);
    }
    private static int find(int n, int k)
    {
        int[][] matrix=new int[n+1][k+1];
        for(int i=0;i<=n;i++)
            for(int j=0;j<=Math.min(k,i);j++)
                if(i==j||j==0)
                    matrix[i][j]=1;
                else
                    matrix[i][j]=matrix[i-1][j-1]+matrix[i-1][j];
        return matrix[n][k];
    }
}
