package DP_2.LIS;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Ritu on 2/25/17.
 * http://www.geeksforgeeks.org/dynamic-programming-set-20-maximum-length-chain-of-pairs/
 */
public class MaxLen_ChainOfPair {
    static class pair
    {
        int first,second;
        pair(int f, int s)
        {
            first=f;
            second=s;
        }
    }
    public static void main(String[] args)
    {
        pair[] pairs={new pair(5, 24),new pair(15, 25),new pair(27, 40),new pair(50, 60)};
        LIS(pairs);
    }
    private static void LIS(pair[] pairs)
    {
        int l=pairs.length;
        int[] len=new int[l];
        Arrays.fill(len,1);

        int[] parent=new int[l];
        Arrays.fill(parent,-1);

        for(int i=1;i<l;i++)
            for(int j=0;j<i;j++) {
                if(pairs[j].first > pairs[i].first)
                    continue;
                if (pairs[j].second < pairs[i].first && len[i] < len[j] + 1) {
                    len[i] = len[j] + 1;
                    parent[i] = j;
                }
            }
        int index=0;
        for(int i=1;i<l;i++)
            if(len[i]>len[index])
                index=i;
        System.out.println("The max length is "+len[index]);
        Stack<pair> result=new Stack<>();
        while(index!=-1)
        {
            result.push(pairs[index]);
            index=parent[index];
        }
while(!result.isEmpty())
        System.out.println(result.peek().first+" "+result.pop().second);

    }
}
