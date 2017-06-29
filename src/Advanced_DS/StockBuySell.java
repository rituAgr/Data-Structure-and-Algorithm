package Advanced_DS;

import java.util.ArrayList;

/**
 * Created by Ritu on 3/1/17.
 * There are many variation of buying ans selling stocks(See trello)
 * The one done in below code is max profit with k non overlapping through DP
 * Time & space complexity= O(n*k)
 */
public class StockBuySell
{
    public static void main(String[] args) {
        int prices[] = {2, 5, 7, 1, 4, 3, 1, 3};
        int k=3;
        maximum_profit(prices,k);
    }
    private static void maximum_profit(int[] prices, int k)
    {
        int l=prices.length;
        int[][] matrix=new int[k+1][l];
        for(int i=1;i<=k;i++) {
            int maxDiff=Integer.MIN_VALUE;
            for (int j = 1; j < l; j++) {
                maxDiff=Math.max(maxDiff,matrix[i-1][j-1]-prices[j-1]);
                matrix[i][j]=Math.max(matrix[i][j-1],maxDiff+prices[j]);
            }
        }
        System.out.println(matrix[k][l-1]);
        ArrayList<String> result=new ArrayList<String>();
        int i=k,j=l-1;

        while(i>0&&j>0)
        {
            if(matrix[i][j]==matrix[i][j-1])
            {
                j--;
                continue;
            }
            if(matrix[i][j]==matrix[i-1][j])
                i--;
            else
            {
                result.add(0,"Sell on day "+j);
                int val=matrix[i][j]-prices[j];
                j--;
                while(j>=0)
                {
                    if(val==matrix[i][j]-prices[j])
                    {
                        result.add(0,"Buy on day "+j);
                        j--;
                        break;
                    }
                    j--;
                }
            }
        }
        for(String s: result)
            System.out.println(s);
    }
}
