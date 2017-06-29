package HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * COMPLETED
 * Created by Ritu on 2/26/17.
 * https://www.hackerrank.com/challenges/balanced-brackets?h_r=next-challenge&h_v=zen
 */
public class BraceBalanacing {
    static String st;

    static void nextLine(BufferedReader br) throws IOException {
        st=new String(br.readLine());
    }
    static int nextLen() {
        return st.trim().length();
    }
    static int nextInt() {
        return Integer.parseInt(st);
    }
    static char nextChar(int k)
    {
        return (st.trim()).charAt(k);
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        nextLine(br);
        int count=nextInt();

        for(int k=0;k<count;k++)
        {
            nextLine(br);
            Stack<Character> st=new Stack();
            int len=nextLen();
            boolean flag=true;
            for(int pos=0;pos<len;pos++)
            {
                char c =nextChar(pos);
                if (c =='('||c=='{'||c=='[')
                    st.push(c);
                else
                {
                    if(c==')'&&(st.isEmpty()||st.peek()!='('))
                    {
                        flag=false;
                        break;
                    }
                    if(c=='}'&&(st.isEmpty()||st.peek()!='{'))
                    {
                        flag=false;
                        break;
                    }
                    if(c==']'&&(st.isEmpty()||st.peek()!='['))
                    {
                        flag=false;
                        break;
                    }
                    if(!st.isEmpty())
                        st.pop();

                }
            }
            if(flag&&st.isEmpty())
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
