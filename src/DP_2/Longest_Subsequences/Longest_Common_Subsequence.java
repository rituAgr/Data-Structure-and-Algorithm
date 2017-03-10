package DP_2.Longest_Subsequences;

/**
 * Created by Ritu on 2/20/17.
 */
import java.util.ArrayList;

/**
 * Created by Ritu on 2/16/17.
 *http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
 * https://www.youtube.com/watch?v=NnD96abizww
 * Time complexity and Space complexity = O(length of string1 * length of string2)
 * The trick to most of longest subsequence is comparinring character at two positions.
 * If same do 1+diagonal number to the diagonal. else Math (of the either two )
 */
public class Longest_Common_Subsequence
{
    public static void main(String[] args)
    {
        String word1="abcdaf";
        String word2="acbcf";
        find_LCS(word1,word2);
    }
    private static void find_LCS(String word1, String word2)
    {
        int len1=word1.length();
        int len2=word2.length();
        int[][] matrix=new int[len1+1][len2+1];
        for( int i=0;i<=len1;i++)
            for(int j=0;j<=len2;j++)
            {
                if(i==0||j==0)
                    continue;
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    matrix[i][j]=1+ matrix[i-1][j-1];
                else
                    matrix[i][j]=Math.max( matrix[i-1][j], matrix[i][j-1]);
            }
        System.out.println("The length of longest common subsequence is "+matrix[len1][len2]);
        ArrayList<Character> result=new ArrayList<Character>();
        int i=len1,j=len2;
        //Tracing back is just the reverse sequence to matrix making
        while(i>0&&j>0)
        {
            if(matrix[i][j]==matrix[i-1][j])
                i--;
            else if(matrix[i][j]==matrix[i][j-1])
                j--;
            else
            {
                result.add(0,word1.charAt(i-1));
                j--;i--;
            }
        }
        System.out.println("The common subsequence is - "+result.toString());
    }
}

