package Array;

import java.util.Arrays;

/**
 * Created by Ritu on 11/3/16.
 * http://www.geeksforgeeks.org/a-product-array-puzzle/
 * time and space complexity = O(n)
 */
public class Prod_Array {
    public static void main(String args[])
    {
        int arr[] = {10, 3, 5, 6, 2};
        int[] array=getProd(arr);
        System.out.print(Arrays.toString(array));
    }
private static int[] getProd(int[] arr)
{
    int n=arr.length;
    int[] array=new int[n];
    int num=1;
    for(int i=0;i<n;i++)
    {
        array[i]=num;
        num=num*arr[i];
    }
    num=1;
    for(int i=n-1;i>=0;i--)
    {
        array[i]=array[i]*num;
        num=num*arr[i];
    }
    return array;
}
}
