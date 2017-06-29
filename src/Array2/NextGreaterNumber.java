package Array2;

import java.util.Stack;

/**
 * Created by Ritu on 3/17/17.
 * http://www.geeksforgeeks.org/next-greater-element/
 * Time Complexity = O(n)
 * Space Complexity = O(n)
 */
public class NextGreaterNumber
{
    public static void main(String[] args)
    {
        int arr[]= {11, 13, 21, 3};
        find(arr);
    }
    private static void find(int[] arr)
    {
        Stack<Integer> st=new Stack<Integer>();
        for(int i=0;i<arr.length;)
        {
            if(st.isEmpty()||st.peek()>arr[i])
            {
                st.push(arr[i]);
                i++;
            }
            else
                System.out.println(st.pop()+"  -->  "+arr[i]);
        }
        while(!st.isEmpty())
            System.out.println(st.pop()+"  -->  -1");

    }
}
