package Advanced_DS;

/**
 * Created by Ritu on 2/18/17.
 * http://www.geeksforgeeks.org/write-your-own-atoi/
 * Expalination : Atoi is a func which takes any number as string and returns that number as Integer
 * atoi() is the func which exist in C/C++; not in java
 */
public class Atoi {
    public static void main(String args[])
    {
        String s="-122";
        int num=atoi(s);
        System.out.println(num);
    }
    private static int atoi(String s)
    {
        char[] num=s.toCharArray();
        int l=num.length;
        if(l==0)
            return 0;

        int number=0;
        int sign=1;
        int i=0;
        if(num[0]=='-')
        {
            sign=-1;
            i++;
        }
        int n='0';
        //Here we are calculating ascii( or unicode ) value of 0.
        for(;i<l;i++)
        {
            if(Character.isDigit(num[i]))
            {
                int val=(num[i]-n);
                number=number*10+val;
            }
            else
                return 0;
        }
        return number*sign;
    }
}
