package DP_2.KnapSack_problem;

import java.util.ArrayList;

/**
 * Created by Ritu on 2/19/17.
 */
public class Knapsack_Prblm_0_1 {
    public static void main(String args[]) {
        int val[] = new int[]{1,4,5,7};
        int wt[] = new int[]{1,3,4,5};
        int W = 7;
        find(wt,val,W);
    }
    private static void find(int wt[], int[] val, int totalWt)
    {
        int l=wt.length;
        int[][] matrix=new int[l+1][totalWt+1];
        for(int i=1;i<=l;i++)
            for(int j=1;j<=totalWt;j++)
                if(j<wt[i-1])
                    matrix[i][j]=matrix[i-1][j];
                else
                    matrix[i][j]=Math.max(val[i-1]+matrix[i][j-wt[i-1]],matrix[i-1][j]);
        System.out.println("Maximum value id "+matrix[l][totalWt]);
        ArrayList<Integer> positions=new ArrayList<Integer>();
        while(l>0&&totalWt>0)
        {
            if(matrix[l][totalWt]==(matrix[l-1][totalWt]))
            {
                l--;
                continue;
            }
            positions.add(0,l);
            totalWt=totalWt-wt[l-1];
            l--;
        }
        for(int k: positions)
            System.out.println("Item with weight "+wt[k]+" & value "+val[k]);
    }
}
