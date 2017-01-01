package Array;

import java.util.*;

/**
 * Created by Ritu on 11/12/16.
 * A very important concept to learn
 * Time complexity : O(n)
 * Space complexity : O(k)
 * http://www.geeksforgeeks.org/maximum-of-all-subarrays-of-size-k/
 * This ques is same as the sliding window problem of karamunchi book page 218.
 * This is one of the few ques which are heap & Priority Queue. So revise it and do this way only, not the way done in the book or website
 */
public class MaxSubArrayOfsizeK {
    public static void main(String args[])
    {
        int arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};//{1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 4;
        int[] result=find(arr,k);
        System.out.print(Arrays.toString(result));
    }
    private static int[] find(int[] arr, int k)
    {
        int n=arr.length;
        int[] res=new int[n-k+1];
        Deque<Integer> q=new ArrayDeque<>();
        for(int i=0;i<k;i++)
        {
            while(q.size()>0&&q.peekLast()<arr[i])
                q.removeLast();
            q.addLast(arr[i]);
        }
       res[0]=q.peekFirst();
        int j=1;
        for(int i=k;i<n;i++)
        {
            while(q.size()>0&&q.peekLast()<arr[i])
                q.removeLast();
            q.addLast(arr[i]);
            if(q.size()==k)
                q.pollFirst();
            res[j++]=q.peekFirst();
        }
        return res;
    }
}
