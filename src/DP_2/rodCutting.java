package DP_2;

import java.util.ArrayList;

/**
 * Created by Ritu on 2/20/17.
 */
public class rodCutting {

    public static void main(String args[])
    {
        int arr[] = new int[] {3,5,8,9,10,20,22,25};//{1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is " + cutRodDP(arr, size));
    }
    private static int cutRodDP(int price[],int l)
    {

        int[][] matrix=new int[l+1][l+1];
        for (int i = 1; i<=l; i++)
            for (int j = 1; j <=l; j++) {
                if(i>j)
                    matrix[i][j]=matrix[i-1][j];
                else
                    matrix[i][j]=Math.max((price[i-1]+matrix[i][j-i]),matrix[i-1][j]);
            }

        ArrayList<Integer> len=new ArrayList<Integer>();
        int row=l,col=l;
        while(row>0&&col>0)
        {
            if(matrix[row][col]==matrix[row-1][col])
                row--;
            else
            {
                len.add(0,row-1);
                col=col-row;
            }
        }
        for(int p:len)
            System.out.println("rod of length "+(p+1)+" and price "+price[p]);
//        for (int i = 1; i<=l; i++) {
//            for (int j = 1; j <= l; j++)
//                System.out.print(matrix[i][j] + " ");
//            System.out.println();
//        }
        return matrix[l][l];
    }
}
