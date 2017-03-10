package DP_2;

/**
 * Created by Ritu on 3/8/17.
 */
public class WildCard_Matching
{
    public static void main(String[] args)
    {
        String str = "baaabab";//"xaylmz";//
        String pattern = "*****ba*****ab";//"x?y*z";//
        System.out.println(isMatch(str, pattern));
    }
    private static boolean isMatch(String str, String pattern)
    {
        int patternLen=pattern.length();
        int strLen=str.length();

        boolean[][] matrix=new boolean[strLen+1][patternLen+1];

        matrix[0][0]=true;

        for (int j = 1; j <= patternLen; j++)
            if (pattern.charAt(j-1) == '*')
                matrix[0][j] = matrix[0][j - 1];

        for(int i=1;i<=strLen;i++)
            for(int j=1;j<=patternLen;j++)
            {
                if(pattern.charAt(j-1)=='?'||str.charAt(i-1)==pattern.charAt(j-1))
                    matrix[i][j]=matrix[i-1][j-1];
                else if(pattern.charAt(j-1)=='*')
                    matrix[i][j]=matrix[i-1][j]||matrix[i][j-1];

            }
//        for(int i=0;i<=strLen;i++)
//        {
//            for(int j=0;j<=patternLen;j++)
//                System.out.print(matrix[i][j]+" ");
//            System.out.println();
//
//        }
        return matrix[strLen][patternLen];
    }


}
