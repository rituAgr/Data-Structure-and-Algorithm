package HackerRank;

/**
 * COMPLETED
 * Created by Ritu on 2/26/17.
 * https://www.hackerrank.com/challenges/maximum-element
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StackQues {
    private static StringTokenizer st;

    private static void nextLine(BufferedReader br) throws IOException {
        st=new StringTokenizer(br.readLine());
    }
    private static int nextInt()
    {
        return Integer.parseInt(st.nextToken());
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        nextLine(br);
        int count=nextInt();

        int max=Integer.MIN_VALUE;
        ArrayList<Integer> st=new ArrayList<>();
        int top=-1;
        for(int i=0;i<count;i++)
        {
            nextLine(br);
            int operation=nextInt();
            if(operation==1)
            {
                int val=nextInt();
                st.add(++top,val);
                if(max<val)
                    max=val;
            }
            if(operation==2)
            {
                int val=st.get(top);
                top--;
                if(max==val)
                {
                    max=Integer.MIN_VALUE;
                    for(int k=0;k<=top;k++)
                        if(st.get(k)>max)
                            max=st.get(k);
                }
            }
            if(operation==3)
            {
                System.out.println(max);
            }
        }
    }
}