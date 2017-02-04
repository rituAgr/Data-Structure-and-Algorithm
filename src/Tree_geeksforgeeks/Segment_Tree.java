package Tree_geeksforgeeks;

import java.util.Arrays;

/**
 * Created by Ritu on 1/11/17.
 * http://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/
 * http://www.geeksforgeeks.org/segment-tree-set-1-range-minimum-query/
 *https://www.youtube.com/watch?v=ZBHKZF5w4YU&t=1376s
 * below youtube is optimzed version of segment tree
 * https://www.youtube.com/watch?v=xuoQdt5pHj0
 * Time complexity to construct : O(n)
 * Time complexity to query : O(logn)
 */
public class Segment_Tree {
    public static void main(String args[])
    {
        int[] arr={-1,2,4,0};//{0,3,4,2,1,6,-1};//
        int[] segmentTree=createSegmentTree(arr);
        for (int i: segmentTree)
            System.out.print(i+" ");
        System.out.println("\n The smallest value in the given range is "+getMin(segmentTree,1,3,0,arr.length-1,0));
        // Now once after creation of segement tree, We may need to update the value, for this a optimized way is to do it.
        int lazy[]=new int[segmentTree.length];
        int update_start=1;
        int update_end=3;
        int val=3;

        UpdateSegment_Tree(lazy,segmentTree,update_start,update_end,0,arr.length-1,0,val);
        //System.out.println("\n The smallest value in the given range after updation is "+min);
        for (int i: segmentTree)
            System.out.print(i+" ");
        System.out.println("\n The lazy tree is ");
        for (int i: lazy)
            System.out.print(i+" ");
        System.out.println("\n The smallest value in the given range is "+Lazy_RangeMinQuery(lazy,segmentTree,update_start,update_end,0,arr.length-1,0));
        for (int i: segmentTree)
            System.out.print(i+" ");
    }
    private static void UpdateSegment_Tree(int[] lazy,int[] segmentTree, int update_start,int update_end, int low, int high,int pos,int val)
    {
        if(low>high||pos>=segmentTree.length)
            return ;
        if(lazy[pos]!=0)
        {
            segmentTree[pos]=segmentTree[pos]+lazy[pos];
            if(2*pos+1<segmentTree.length)
                lazy[2*pos+1]=lazy[pos];
            if(2*pos+2<segmentTree.length)
                lazy[2*pos+2]=lazy[pos];
            lazy[pos]=0;
        }
        //No Overlap
        if(update_start>high||update_end<low)
            return ;

        //total overlap
        if(update_start<=low&&update_end>=high) {
            segmentTree[pos]= segmentTree[pos]+val;
            if(2*pos+1<segmentTree.length)
                lazy[2*pos+1]=val;
            if(2*pos+2<segmentTree.length)
                lazy[2*pos+2]=val;
            return;
        }

        //Partial Overlap
        int mid=(low+high)/2;
        UpdateSegment_Tree(lazy,segmentTree,update_start,update_end,0,mid,2*pos+1,val);
        UpdateSegment_Tree(lazy,segmentTree,update_start,update_end,mid+1,high,2*pos+2,val);

    }

    private static int Lazy_RangeMinQuery(int[] lazy,int[] segmentTree, int update_start,int update_end, int low, int high,int pos)
    {
        if(low>high||pos>=segmentTree.length)
            return Integer.MAX_VALUE;
        if(lazy[pos]!=0)
        {
            segmentTree[pos]=segmentTree[pos]+lazy[pos];
            if(2*pos+1<segmentTree.length)
                lazy[2*pos+1]=lazy[pos];
            if(2*pos+2<segmentTree.length)
                lazy[2*pos+2]=lazy[pos];
            lazy[pos]=0;
        }
        //No Overlap
        if(update_start>high||update_end<low)
            return Integer.MAX_VALUE;

        //total overlap
        if(update_start<=low&&update_end>=high)
            return segmentTree[pos];


        //Partial Overlap
        int mid=(low+high)/2;
        int temp1=Lazy_RangeMinQuery(lazy,segmentTree,update_start,update_end,0,mid,2*pos+1);
        int temp2=Lazy_RangeMinQuery(lazy,segmentTree,update_start,update_end,mid+1,high,2*pos+2);
        return Math.min(temp1,temp2);
    }

    private static int getMin(int[] segmentTree, int query_start, int query_end, int low,int high, int pos)
    {
        //No Overlap
        if(query_end<low||query_start>high)
            return Integer.MAX_VALUE;

        //total overlap
        if(query_start<=low&&query_end>=high)
            return segmentTree[pos];

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
