package DP_2;

/**
 * Created by Ritu on 4/1/17.
 * http://www.geeksforgeeks.org/ugly-numbers/
 * https://prismoskills.appspot.com/lessons/Programming_Puzzles/Nth_ugly_number.jsp
 */
public class Ugly_Number {
    public static void main(String[] args)
    { int num=10;
        find(num);
    }
    private static void find(int num)
    {
        int[] uglyNum=new int[num];
        uglyNum[0]=1;

        int i2=0,i3=0,i5=0;
        int ugly2=2, ugly3=3,ugly5=5;
        int pos=1;
        boolean flag=true;
        while(pos<num)
        {
            int min=Math.min(ugly2,Math.min(ugly3,ugly5));
            if(min==ugly2)
                ugly2=ugly2+2;
            else if(min==ugly3)
                ugly3+=3;
            else
                ugly5+=5;
            if(min!=uglyNum[pos-1])
                uglyNum[pos++]=min;
        }
        for(int i=0;i<num;i++)
            System.out.print(uglyNum[i]+" ");

    }

}


