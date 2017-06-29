package HackerRank.Input_OutputFormats;

/**
 * Created by Ritu on 2/26/17.
 */

import java.io.*;
import java.util.StringTokenizer;


public class readinginputfromConsole {
    private static StringTokenizer st;

    private static void nextLine(BufferedReader br) throws IOException
    {
        st = new StringTokenizer(br.readLine());
    }

    private static int nextInt()
    {
        return Integer.parseInt(st.nextToken());
    }

    private static String next()
    {
        return st.nextToken();
    }

    private static long nextLong()
    {
        return Long.parseLong(st.nextToken());
    }

    private static double nextDouble()
    {
        return Double.parseDouble(st.nextToken());
    }
    public static void main(String[] args) throws IOException {
        int h1 , h2, a , b;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nextLine(br);//passing b
        h1= nextInt();
        h2 = nextInt();

        nextLine(br);
        a= nextInt();
        b = nextInt();
        int days = getdays(h1, h2, a, b);

        BufferedWriter bos = new BufferedWriter(new OutputStreamWriter(System.out));
        bos.write(days+"\n");
        bos.flush();
    }


    public static int getdays(int h1 , int h2 , int a , int b){
        if(h1==h2) return 0;
        if(h1>h2) return -1;

        // starting time 10 AM to 10 PM
        int i;
        int days=0;
//
        if(b>=a)
        {
            int compute = h1 + (a*(8)) - h2;
            if(compute<0)
            {
                return -1;

            }
        }

        while(h1!=h2)
        {
            for(i=15;i<=22;i++)
            {
//                print(h1, h2);
                if(h1<h2)
                {
                    h1=h1+a;
                }

                if(h1>=h2)
                {
                    return days;
                }
            }


            for(i=23;i<=24;i++)
                h1=h1-b;

            for(i=1;i<=10;i++)
                h1=h1-b;


            for(i=11;i<15;i++)
                if(h1<h2)
                {
                    h1=h1+a;
                }

            days++;

        }
        return days;


    }
    public static void print(int h1, int h2)
    {
        System.out.println("h1 = " + h1 + " h2 = " + h2);
    }



}
