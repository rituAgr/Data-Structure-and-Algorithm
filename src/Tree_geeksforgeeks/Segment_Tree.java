package Tree_geeksforgeeks;

import java.util.Arrays;

/**
 * Created by Ritu on 1/11/17.
 */
public class Segment_Tree {
    public static void main(String args[])
    {
        int[] arr={-1,2,4,0};//{0,3,4,2,1,6,-1};//
        int[] segmentTree=createSegmentTree(arr);
        for (int i: segmentTree)
            System.out.print(i+" ");
        System.out.println("\n The smallest value in the given range is "+getMin(segmentTree,1,3,0,segmentTree.length-1,0));
    }
    private static int getMin(int[] segmentTree, int query_start, int query_end, int low,int high, int pos)
    {
        if(high<low||pos>=segmentTree.length)
            return Integer.MAX_VALUE;
        //total overlap
        if(query_start<=low&&query_end>=high)
            return segmentTree[pos];
        //No Overlap
        if(query_end<low||query_start>high)
            return Integer.MAX_VALUE;
        //Partial Overlap
        int mid=(low+high)/2;
        int temp1=getMin(segmentTree,query_start,query_end,low,mid,pos*2+1);
        int temp2=getMin(segmentTree,query_start,query_end,mid+1,high,pos*2+2);
        return Math.min(temp1,temp2);
    }
    private static int[] createSegmentTree(int[] arr)
    {
        int len=arr.length;
        if(len==0)
            return null;
        int bit=0,num=len,count=0;

        while(num!=0)
        {
            if((num&1)==1)
                count++;
            bit=((bit<<1)|1);
            num=num>>1;
        }
        if(count>1)
            num=bit+1;
        else
            num=len;
        int[] segTree=new int[2*num-1];
        Arrays.fill(segTree,Integer.MAX_VALUE);
        construct(arr,0,len-1,segTree,0);
        return segTree;
    }
    private static void construct(int[] arr, int low, int high, int[] segTree, int pos)
    {
        if(high==low)
        {
            segTree[pos]=arr[low];
            return;
        }
        int mid=(low+high)/2;
        construct(arr,low,mid,segTree,2*pos+1);
        construct(arr,mid+1,high,segTree,2*pos+2);
        segTree[pos]=Math.min(segTree[2*pos+1],segTree[2*pos+2]);
    }
}
