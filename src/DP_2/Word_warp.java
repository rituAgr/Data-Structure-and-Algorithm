package DP_2;

import java.util.ArrayList;

/**
 * Created by Ritu on 2/24/17.
 */
public class Word_warp {
    static int INF=Integer.MAX_VALUE;
    public static void main(String args[]){
        String words1[] ={"Tushar","likes","to","write","code","at", "free", "time"};
        //{"Tushar","roy", "likes","to","code"};

        justify(words1, 12);
    }
    private static void justify(String[] words, int len)
    {
        int l=words.length;
        int[][] matrix=new int[l][l];

        for(int i=0;i<l;i++)
        {
            int total=-1;
            for(int j=i;j<l;j++)
            {
                total=total+1+words[j].length();
                if(total>len)
                    matrix[i][j] = INF;
                else
                    matrix[i][j]=(int)Math.pow((len-total),2);
            }
        }
        for(int i=0;i<l;i++)
        {
            for(int k=0;k<l;k++)
                System.out.print(matrix[i][k]+" ");
            System.out.println();
        }
        int[] cost=new int[l];
        int[] path=new int[l];

        for(int i=(l-1);i>=0;i--)
        {
                cost[i]=matrix[i][l-1];
                path[i]=l;

            for(int j=(l-1);j>i;j--)
                if (matrix[i][j-1]!=INF&&cost[i]>(matrix[i][j-1]+cost[j]))
                {
                    cost[i]=matrix[i][j-1]+cost[j];
                    path[i]= j;
                }
        }

        ArrayList<String> result=new ArrayList<>();
        int start=0;
        while(start<l)
        {
            int end=path[start]-1;
            StringBuilder s= new StringBuilder(words[start]);
            start++;

            while(start<=end)
            {
                s.append(" ");
                s.append(words[start]);
                start++;
            }
            result.add(s.toString());
        }
        for(String s:result)
            System.out.println(s);
    }
}

