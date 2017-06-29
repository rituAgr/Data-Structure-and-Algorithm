package DP_2.Coin_Change;

import java.util.Arrays;

/**
 * Created by Ritu on 2/26/17.
 * http://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
 * https://www.youtube.com/watch?annotation_id=annotation_2195265949&feature=iv&src_vid=Y0ZqKpToTic&v=NJuKJ8sasGk
 * Time complexity - O(n*V)
 */
public class Min_Coin
{
    public static void main(String args[]) {
        int coins[] = {7, 2, 3, 6};
        int total = 15;
        find(coins, total);
    }
    private static void find(int coins[], int total)
    {
        int l=coins.length;
        int[] minCoins=new int[total+1];
        int[] parent=new int[total+1];

        int INF=Integer.MAX_VALUE;
        Arrays.fill(parent,-1);
        Arrays.fill(minCoins,INF);
        minCoins[0]=0;
// This problem can bedone by matrix of sum of coins denomination * sum; same as Total_NumWays coin problem
        // the space and time complexity would be O(n*V)

        for(int i=0;i<l;i++)
        {  for(int j=1;j<=total;j++)
        {
            if(j<coins[i])
                continue;
            if(minCoins[j-coins[i]]==INF)
                continue;
            if(minCoins[j]>(1+minCoins[j-coins[i]]))
            {
                minCoins[j]=1+minCoins[j-coins[i]];
                parent[j]=i;
            }
            System.out.print(minCoins[j]+" ");
        }

        }
        System.out.println("\nMinimum number of coins required is "+minCoins[total]);
        int index=total;
        while(index>0)
        {
            int coin=parent[index];
            System.out.print(coins[coin]+"  ");
            total-=coins[coin];
            index=total;
        }
    }
}

