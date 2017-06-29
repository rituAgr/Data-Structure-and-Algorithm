package Array2;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Ritu on 3/22/17.
 */
public class LIS_nlogn {
    public static void main(String[] args)
    {
        int[] arr={2, 5, 3, 7, 11, 8};
        find(arr);
    }
    private static void find(int[] arr)
    {
        int n=arr.length;

        int[] LIS=new int[n];
        int end=0;
        LIS[0]=0;

        int[] parent=new int[n];
        Arrays.fill(parent,-1);

        for(int i=1;i<n;i++)
        {
            if(arr[i]<arr[LIS[0]]) {
                LIS[0] = i;
                continue;
            }
            if(arr[i]>arr[LIS[end]])
            {
                LIS[++end]=i;
                parent[i]=LIS[end-1];
            }
            else
            {
                int position=ceiling(arr,LIS,end,arr[i]);
                LIS[position]=i;
                parent[i]=LIS[position-1];
            }
        }
       int index=LIS[end];

        Stack<Integer> st=new Stack();
        while(index!=-1)
        {
            st.push(arr[index]);
            index=parent[index];
        }
        while(!st.isEmpty())
            System.out.print(st.pop()+" ");
    }
    private static int ceiling(int[] arr, int[] lis,int last, int element)
    {
        int start=0;
        int end=last;
        while(start<=end)
        {
            int mid=(start+end)/2;
//            if(mid==0||mid>last)
//                return -1;
            if(arr[lis[mid]]<element&&arr[lis[mid+1]]>=element)
                return mid+1;
            if(element<arr[lis[mid]])
                end=mid-1;
            else
                start=mid+1;
        }
        return -1;
    }
}
