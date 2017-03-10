package DP_2.Palidrome;

import java.util.ArrayList;

/**
 * Created by Ritu on 2/23/17.
 * http://www.geeksforgeeks.org/dynamic-programming-set-17-palindrome-partitioning/
 * Timr complexity : O(n^2)
 */
public class Palindrome_Partitioning
{
    public static void main(String args[])
    {
        String s = "abcbm";
        find(s);
    }
    private static void find(String s)
    {
        int len=s.length();
        if(len==1)
        {
            System.out.println("No Split needed \nPalidrome is "+s);
            return;
        }
        int[][] matrix=new int[len][len];

        for(int l=2;l<=len;l++)
            for(int i=0;i<(len-l+1);i++)
            {
                int j=i+l-1;
                if(s.charAt(i)==s.charAt(j))
                    matrix[i][j] = matrix[i + 1][j - 1];
                else
                    matrix[i][j]=1+Math.min(matrix[i+1][j],matrix[i][j-1]);
            }

        for(int i=0;i<len;i++)
        {
            for(int j=0;j<len;j++)
                System.out.print(matrix[i][j]+" ");
            System.out.println();
        }
    //Tracing back
        int col=len-1,row=0;
        ArrayList<String> result=new ArrayList<>();
        while(row!=col)
        {
            if(s.charAt(row)!=s.charAt(col))
            {
                if((matrix[row][col])==1+matrix[row][col-1])
                {
                    result.add(new String(s.substring(col,col+1)));
                    col--;
                }
                else
                {
                    result.add(0,new String(s.substring(row,row+1)));
                    row++;
                }
            }
            else
            {
                result.add(1,new String(s.substring(row,col+1)));
                row++;col--;
            }
        }
        System.out.println(result.toString());
    }
}
