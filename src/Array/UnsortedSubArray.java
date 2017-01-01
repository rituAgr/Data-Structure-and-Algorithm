package Array;

import java.util.ArrayList;

/**
 * Created by Ritu on 11/6/16.
 * http://www.geeksforgeeks.org/minimum-length-unsorted-subarray-sorting-which-makes-the-complete-array-sorted/
 *
 */
public class UnsortedSubArray {
    public static void main(String args[])
    {
        int[] arr= {0, 1, 15, 25, 6, 7, 30, 40, 50};//{10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
        ArrayList<Integer> res=find(arr);
        System.out.print(res.toString());

    }
    private static ArrayList<Integer> find(int[] arr)
    {
        int start=0,end=0;
        int i;
        ArrayList<Integer> res=new ArrayList<Integer>();
        for( i=0;i<arr.length;i++)
        {
            if(arr[i]>arr[end])
            {
                if(i==arr.length-1||arr[i+1]>arr[i])
                     end=i;
                else
                {
                    res.add(i);
                    break;
                }
            }
        }
        if(i==arr.length)
            return null;
        for(i=arr.length-1;i>end;i--)
        {
            if(arr[i]>arr[i-1])
            {
                if(i==0||arr[i-1]>arr[i-2])
                    start=i;
                else
                {
                    res.add(i);
                    break;
                }
            }
        }
        int k=res.get(0);
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        while(k<=res.get(1))
        {
            if(arr[k]>max)
                max=arr[k];
            if(arr[k]<min)
                min=arr[k];
            k++;
        }
        //getting lower end
        int st=0,en=res.get(0);
        int mid;
        while(st<=en)
        {
            mid=st+(en-st)/2;
            if(arr[mid]>=min&&arr[mid-1]<min)
            {
                res.add(mid);
                break;
            }
            if(arr[mid]>min)
                en=mid-1;
            else
                st=mid+1;
        }
        //getting higher end
        st=res.get(1);
        en=arr.length-1;
        while(st<=en)
        {
            mid=st+(en-st)/2;
            if(max<=arr[mid]&&max>arr[mid-1])
            {
                res.add(mid-1);
                break;
            }
            if(arr[mid]>max)
                st=mid+1;
            else
                en=mid-1;
        }
        res.remove(0);
        res.remove(0);
        return res;
    }
}
