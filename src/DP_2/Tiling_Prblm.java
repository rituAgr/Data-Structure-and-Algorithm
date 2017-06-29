package DP_2;

/**
 * Created by Ritu on 4/10/17.
 * http://www.geeksforgeeks.org/tiling-problem/
 * Time complexity : O(n)
 * Space Complexity : O(n)
 * Its solution is just genertaion of fibonaccci
 */
public class Tiling_Prblm {
    public static void main(String[] args)
    {
        int n=4;//This means floor size is 2 x 4 and tile size is 2 x 1
        find(n);
    }
    private static void find(int n)
    {
        int[] tiles_required=new int[n+1];
        tiles_required[0]=0;
        tiles_required[1]=1;
        tiles_required[2]=2;
        for(int i=3;i<=n;i++)
            tiles_required[i]=tiles_required[i-2]+tiles_required[i-1];
        System.out.println("The Number of tile required are "+tiles_required[n]);
    }
}
