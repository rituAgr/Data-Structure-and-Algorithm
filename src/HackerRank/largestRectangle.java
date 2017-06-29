package HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * COMPLETED
 * Created by Ritu on 2/27/17.
 * https://www.hackerrank.com/challenges/largest-rectangle
 */
public class largestRectangle {
    private static StringTokenizer st;

    public static void nextLine(BufferedReader br) throws IOException
    {
        st = new StringTokenizer(br.readLine());
    }

    public static int nextInt()
    {
        return Integer.parseInt(st.nextToken());
    }
    /*5
    1 2 3 4 5*/
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        nextLine(br);
        int count=nextInt();

        int num[]=new int[count];
        nextLine(br);
        for(int i=0;i<count;i++)
            num[i]=nextInt();

        int[][] matrix=new int[count][count];

        int max=0;
        for(int i=0;i<count;i++)
            for(int j=i;j<count;j++)
            {
                if(i==j)
                    matrix[i][j]=num[i];
                else
                    matrix[i][j]=Math.min(num[j],num[i])*(j-i+1);
                if(max<matrix[i][j])
                    max=matrix[i][j];
            }
        System.out.println(max);
    }
}
