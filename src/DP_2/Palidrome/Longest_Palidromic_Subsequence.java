package DP_2.Palidrome;

/**
 * Created by Ritu on 2/20/17.
 */
public class Longest_Palidromic_Subsequence {
    public static void main(String[] args)
    {
        String word1="agbdba";

        System.out.println(find(word1));
    }
    private static int find(String str)
    {
        int l=str.length();
        int[][] matrix=new int[l][l];

        for(int i=0;i<l;i++)
            matrix[i][i]=1;
        for(int cl=2;cl<=l;cl++)
            for(int i=0;i<(l-cl+1);i++)
            {
                int j=i+cl-1;
                if(i>=l||j>=l)
                    continue;
                if(str.charAt(i)==str.charAt(j)&&(j-i+1)==2)
                    matrix[i][j]=2;
                else if(str.charAt(i)==str.charAt(j))
                    matrix[i][j]=2+matrix[i+1][j-1];
                else
                    matrix[i][j]=Math.max(matrix[i][j-1],matrix[i+1][j]);
            }
        int totalLen=matrix[0][l-1];
        char position[]=new char[totalLen];
        int first=0,last=totalLen-1;
        int row=0,col=l-1;
        while(matrix[row][col]!=1)
        {
            if(str.charAt(row)==str.charAt(col))
            {
                position[first++]=str.charAt(row);
                position[last--]=str.charAt(col);
                row++;
                col--;
                continue;
            }
            if(matrix[row][col]==matrix[row][col-1])
                col--;
            else
                row++;
        }
        position[last]=str.charAt(row);
        String s=new String(position);
        System.out.println("Palidromic subsequence "+s);
        return matrix[0][l-1];
    }
}
