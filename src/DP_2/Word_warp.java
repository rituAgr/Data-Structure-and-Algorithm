package DP_2;

import java.util.ArrayList;

/**
 * Created by Ritu on 2/24/17.
 */
public class Word_warp {
    public static void main(String[] args)
    {
        String words1[] ={"Tushar","likes","to","write","code","at", "free", "time"};
        int width1=12;
        find(words1,width1);
        String words2[] ={"Tushar","Roy","likes","to","code"};
        int width2=10;
        find(words2,width2);
    }
    private static void find(String[] words,int width)
    {
        int n=words.length;
        int[][] costMatrix=cost(words,width);
        int[] cost=new int[n];
        int[] range=new int[n];

        int end=n;
        int i=n-1;
        while(i>=0)
        {
            int j=n-1;
            if(costMatrix[i][j]!=Integer.MAX_VALUE)
            {
                cost[i]=costMatrix[i][j];
                range[i]=end;
            }
            else
            {
                int minCost=Integer.MAX_VALUE;
                int splitPosition=j;
                while(j>i)
                {
                    if(costMatrix[i][j-1]!=Integer.MAX_VALUE&&(costMatrix[i][j-1]+cost[j])<minCost)
                    {
                        minCost=costMatrix[i][j-1]+cost[j];
                        splitPosition=j;
                    }
                    j--;
                }
                cost[i]=minCost;
                range[i]=splitPosition;
            }
            i--;
        }
        System.out.println("Minimum cost is "+cost[0]);
        // Stack<String> st=new Stack<>();
        i=0;
        while(i!=end)
        {
            printing(words,i,(range[i]-1));
            //System.out.print(i+" to "+(range[i]-1));
            i=range[i];
        }

    }
    private static void printing(String[] words, int start, int end)
    {
        for(int i=start;i<=end;i++)
            System.out.print(words[i]+" ");
        System.out.println();
    }
    private static int[][] cost(String[] words, int width)
    {
        int n=words.length;
        int[][] matrix=new int[n][n];
        for(int i=0;i<n;i++)
        {
            int len=-1;
            for(int j=i;j<n;j++)
            {
                len=len+1+words[j].length();
                if(len<=width)
                    matrix[i][j]=(width-len)*(width-len);
                else
                    matrix[i][j]=Integer.MAX_VALUE;
            }
        }
        return matrix;
    }
}
