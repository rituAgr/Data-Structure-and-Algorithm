package DP.Revision;

/**
 * Created by Ritu on 10/13/16.
 */
public class knapSack_prblm {
    public static void main(String args[]) {
        int val[] = {1, 4, 5, 7};
        int wt[] = {1, 3, 4, 5};
        int totalWeight = 7;
        find(val, wt, totalWeight);
    }

    private static void find(int[] val, int[] wt, int total) {
        int n = val.length;
        int matrix[][] = new int[n + 1][total + 1];
       // for(int col=0;col<=total;col++)
        //matrix[0][col]=0;
        int sum=0;
        for(int row=1;row<=n;row++)
        {
            sum=sum+wt[row-1];
            for(int weight=1;weight<=total;weight++)
            {
                if(weight<wt[row-1])
                    matrix[row][weight]=matrix[row-1][weight];
                else
                    matrix[row][weight]=Math.max(matrix[row-1][weight],matrix[row-1][weight-wt[row-1]]+val[row-1]);
            }
        }
    System.out.print("Max value is "+matrix[n][total]);
    }
}