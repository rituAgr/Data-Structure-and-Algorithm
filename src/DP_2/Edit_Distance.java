package DP_2;

import java.util.ArrayList;

/**
 * Created by Ritu on 2/16/17.
 */
public class Edit_Distance {
    public static void main(String[] args) {
        String word1 = "saturday";
        String word2 = "sunday";
        findEdits(word1, word2);
    }
    private static void findEdits(String word1, String word2)
    {
        int len1=word1.length();
        int len2=word2.length();
        int[][] matrix=new int[len2+1][len1+1];

        for(int i=0;i<=len1;i++)
            matrix[0][i]=i;

        for(int i=0;i<=len2;i++)
            matrix[i][0]=i;

        for(int i=1;i<=len2;i++)
            for(int j=1;j<=len1;j++)
                if(word1.charAt(j-1)==word2.charAt(i-1))
                    matrix[i][j]=matrix[i-1][j-1];
                else
                    matrix[i][j]=1+Math.min(matrix[i-1][j-1],Math.min(matrix[i][j-1],matrix[i-1][j]));

        System.out.println("The Min no of edits required are "+matrix[len2][len1]);
        int i=len2,j=len1;
        ArrayList<String> result=new  ArrayList<String>();
        while(i>0||j>0)
        {
            String s;
            if(word2.charAt(i-1)==word1.charAt(j-1))
            {
                i--;j--;
                continue;
            }
            if(matrix[i][j]==1+matrix[i-1][j-1])
            {
                s="Replace "+word2.charAt(i-1)+" with "+word1.charAt(j-1);
                result.add(0,s);
                i--;j--;
                continue;
            }
            if(matrix[i][j]==1+matrix[i-1][j])
            {
                s="Add "+word1.charAt(i-1)+ " to "+word1;
                result.add(0,s);
                i--;
            }
            else
            {
                result.add(0,"delete "+word1.charAt(j-1)+" from "+word1);
                j--;
            }
        }
        for(String s : result)
            System.out.println(s);
    }
}
