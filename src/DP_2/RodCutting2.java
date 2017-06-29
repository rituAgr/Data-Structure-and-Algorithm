package DP_2;

/**
 * Created by Ritu on 3/23/17.
 */
public class RodCutting2
{
    public static void main(String args[])
    {
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};//{3,5,8,9,10,20,22,25};//

        System.out.println("Maximum Obtainable Value is " + find(arr));
    }
    private static int find(int[] prices)
    {
       int n=prices.length;
        int val[]=new int[n];
        val[0]=prices[0];
        for(int i=1;i<n;i++)
        {
            int max=prices[i];
            for(int j=0;j<i;j++)
                max=Math.max(max,prices[j]+val[i-j-1]);
            // the reason for this [i-j-1] is because index starts from 0 not 1
            // so the value of rod of length 1 is given at given at index 0 not at 1
            val[i]=max;
            System.out.print(val[i]+"  ");
        }
        return val[n-1];
    }
}
