package Array;

import java.util.Arrays;

/**
 * Created by Ritu on 10/12/16.
 * http://www.geeksforgeeks.org/majority-element/
 */
public class findMajority {
    public static void main(String args[])
    {
        int[] arr={2, 2, 3, 5, 5,2, 2, 6,5,5,5,5,5};
        Integer num=find_Majority(arr);
        System.out.println("Array is"+Arrays.toString(arr));
        if(num==null)
            System.out.print("There is no majority number occuring more than half the number of Times");
        else
            System.out.print("The majority number is "+num.intValue());
    }
    private static Integer find_Majority(int[] arr)
    {
        //Firstly finding the element occuring maximum number of time in O(n) time
        int index=0;
        int count=1;
        int len=arr.length;
        for(int i=1;i<len;i++)
        {
            if(arr[index]==arr[i])
                count++;
            else
                count--;
            if(count==0)
            {
                index=++i;
                count=1;
            }
        }
        count=0;
        for(int i=0;i<len;i++)
            if(arr[i]==arr[index])
                count++;
        if(count>len/2)
            return new Integer(arr[index]);
        return null;

    }
}
