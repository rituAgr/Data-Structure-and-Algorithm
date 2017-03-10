package DP_2;

/**
 * Created by Ritu on 3/7/17.
 * http://www.geeksforgeeks.org/count-ways-reach-nth-stair/
 */
public class WaysToReachNthStair {
    public static void main(String[] args)
    {
        int stairs=4;
        int maxStairinJump=2;
        find(stairs,maxStairinJump);
    }
    private static void find(int stairs, int maxStairinJump)
    {
        int[] ways=new int[stairs+1];
        ways[0]=0;
        int i=1;
        int sum=0;
        for(;i<=maxStairinJump;i++)
        {
            ways[i]=i;
            sum+=ways[i];
        }
        for(;i<=stairs;i++)
        {
            sum=sum-ways[i-1-maxStairinJump];
            ways[i]=sum;
            sum+=ways[i];
        }
        System.out.println(ways[stairs]);

    }
}
