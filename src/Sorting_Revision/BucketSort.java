package Sorting_Revision;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Created by Ritu on 11/13/16.
 * This is another linear time complexity sorting algorithm
 * This along with counting sort, gives a decent sorting mechanism
 * Space & Time complexity : O(n)
 */
public class BucketSort
{
    public static void main(String args[])
    {
        int array[]={66,32,14,65,3,1,43,67,99,80,77,34,44,21,54,2,11,32,4};//{66,32,99,80,4};
        Bucket_Sort(array);
        System.out.println(Arrays.toString(array));
    }
    private static void Bucket_Sort(int[] arr)
    {
        int n=arr.length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(min>arr[i])
                min=arr[i];
            if(arr[i]>max)
                max=arr[i];
        }
        int range=max-min+1;
        //Dynamic number of buckets creation
        int number=10;
        System.out.println("range is "+range);
        ArrayList<ArrayList<Integer>> buckets=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<number;i++)
            buckets.add(new ArrayList<Integer>());
        for(int i=0;i<n;i++)
        {
            float val=(float)(arr[i]-min);
            float pos=val/number;
            int position=(int)(pos);
            if(position==number)
                position--;
            System.out.print(position+"  ");
            (buckets.get(position)).add(arr[i]);
//            ArrayList<Integer> bucket=buckets.get(position);
//            bucket.add(arr[i]);
//            //buckets.remove(position);
//            buckets.add(position,bucket);
        }
        for(int i=0;i<number;i++)
        {
            ArrayList<Integer> bucket=buckets.get(i);
            for(Integer num:bucket) {
                System.out.print(num+" ");
            }
            System.out.println();//(Arrays.toString(num));
        }
        System.out.println("***********");
        int j=0;
        for(int i=0;i<10;i++)
        {
            ArrayList<Integer> bucket=buckets.get(i);
            if(bucket.size()==0)
                continue;
            else if(bucket.size()==1)
                arr[j++]=bucket.get(0);
            else
            {
                int num[]=new int[bucket.size()];
                for(int k=0;k<num.length;k++)
                    num[k]=bucket.get(k);
                CountingSort.Counting_Sort(num);
                for(int k=0;k<num.length;k++)
                    arr[j++]=num[k];
            }
        }
    }
}
