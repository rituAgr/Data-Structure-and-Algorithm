package DP_2.SumProblem_DP;

/**
 * Created by Ritu on 3/7/17.
 * http://www.geeksforgeeks.org/count-number-binary-strings-without-consecutive-1s/
 * This Ques is very similar to Fibnacci Series
 * Time Complexity : O(log n)
 * we can count the strings in O(Log n)
 */
public class NonConsecutive1s_String {

    public static void main (String args[])
    {
        int NumDigit=4;
        if(NumDigit==0||NumDigit==1)
        {
            System.out.println("Maximum Number of Sring with non Consecutive 1's are "+1);
            return;
        }
        int[] arr=new int[NumDigit+1];
        arr[0]=1;
        arr[1]=1;

        for(int i=2;i<=NumDigit;i++)
            arr[i]=arr[i-1]+arr[i-2];
        System.out.println("Maximum Number of Sring with non Consecutive 1's are "+arr[NumDigit]);
    }
}
