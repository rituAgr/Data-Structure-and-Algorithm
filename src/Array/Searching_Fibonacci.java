package Array;

/**
 * Created by Ritu on 11/10/16.
 * Refer my another code wriiten in sorting section
 * time complexity comparsion :
 * linear search>Binary Search>Ternary Search>Interpolation Search
 * Fibonacci fits somewhere in between
 */
public class Searching_Fibonacci {
    public static void main(String args[])
    {
        int arr[]={10, 12, 13, 16, 31, 33, 35, 42, 47};
        int pos=fibonacciSearch(arr,55);
        System.out.print("The position of element "+pos);
    }
    private static int fibonacciSearch(int[] arr, int element)
    {
       int fib2=0,fib1=1;
        int fibM=fib1+fib2;
        int n=arr.length;
        while(fibM<n)
        {
            fib2=fib1;
            fib1=fibM;
            fibM=fib1+fib2;
        }
        int offset=-1;
        while(fib2>=1)//The reason is that index should never turn negative
        {
            int i=Math.min(fib2+offset,n-1);
            if(arr[i]==element)
                return i;
            if(element>arr[i])
            {
                offset=i;//to make sure it searching the upper offset
                fibM=fib1;
                fib1=fib2;//since this is on higher end, we will first get higher value variable, hence fib1
                fib2=fibM-fib1;
            }
            else
            {
                fibM=fib2;
                fib2=fib1-fibM;//since this is on lower end, we will first get lower value variable, hence fib2
                fib1=fibM-fib2;
            }
        }
        return -1;
    }
}
