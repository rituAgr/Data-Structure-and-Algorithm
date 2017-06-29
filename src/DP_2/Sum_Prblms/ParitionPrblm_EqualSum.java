package DP_2.Sum_Prblms;

/**
 * Created by Ritu on 3/25/17.
 * http://www.geeksforgeeks.org/dynamic-programming-set-18-partition-problem/
 */
public class ParitionPrblm_EqualSum {
    public static void main(String[] args)
    {
        int arr[] = new int[]{3, 1, 1, 2, 2,1};
        find(arr);

        arr = new int[]{1, 5, 11, 5};
        find(arr);
    }
    private static void find(int[] arr)
    {
        int n=arr.length;
        int sum=0;

        for(int num:arr)
            sum+=num;

        if(sum%2!=0)
        {
            System.out.println("Partition of array such that both part has equal sum is impossible");
            return;
        }

        boolean[][] matrix=new boolean[n+1][sum/2+1];

        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<(sum/2+1);j++)
            {
                if(j==0)
                {
                    matrix[i][j]=true;
                    continue;
                }
                if (j >= arr[i-1])
                    matrix[i][j]=matrix[i-1][j]||(matrix[i-1][j-arr[i-1]]);
                else
                    matrix[i][j]=matrix[i-1][j];
            }
        }
        System.out.println(matrix[n][sum/2]);


        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<(sum/2+1);j++)
                System.out.print(matrix[i][j]+"  ");
            System.out.println();
        }

    }
}
