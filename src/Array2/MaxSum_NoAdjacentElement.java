package Array2;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Ritu on 3/14/17.
 * http://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
 */
public class MaxSum_NoAdjacentElement
{
    public static void main(String[] args)
    {
        int arr[] = {5, 5, 10, 100, 10, 5};
        maxSum(arr);
    }
    private static void maxSum(int[] arr)
    {
        int l=arr.length;
        int[] sum=new int[l];
        for(int i=0;i<l;i++)
            sum[i]=arr[i];

        int[] parent=new int[l];
        Arrays.fill(parent,-1);
        int max=0;

        for(int j=2;j<=l-2;j++)
            if(sum[j-2]+sum[j]>sum[j-1]+sum[j+1])
            {
                sum[j]=sum[j-2]+sum[j];//sum[j]+sum[i];
                parent[j]=j-2;
            }
            else
            {
                sum[j+1]=sum[j-1]+sum[j+1];
                parent[j+1]=j-1;
                j++;
            }
        for(int i=1;i<l;i++)
            if(sum[i]>sum[max])
                max=i;
        System.out.println("Max sum is "+sum[max]);
        Stack<Integer> st=new Stack<>();
        while(max!=-1)
        {
            st.push(arr[max]);
            max=parent[max];
        }
        System.out.println("Elements are : ");

        while(!st.isEmpty())
            System.out.print(st.pop()+" ");
    }
}
