package Sorting_Revision;

import java.util.Arrays;

/**
 * Created by Ritu on 11/8/16.
 */
public class Heap_Sort1
{
    public static void main(String args[])
    {
        int[] arr={4,1,0,5,3,2,10};
        Heap h=new Heap(arr.length);
        h.heapSort(arr);
        System.out.print(Arrays.toString(arr));
    }
}
class Heap
{
    int[] arr;
    int size;
    Heap(int n)
    {
        size=n;
    }
    //helper methods
    int getparent(int pos)
    {
        if(pos==0)
            return -1;
        int p=(pos-1)/2;
        return p;
    }
    int getleftChild(int pos)
    {
        int left=2*pos+1;
        if(left>=size)
            return -1;
        return  left;
    }
    int getrightChild(int pos)
    {
        int right=2*pos+2;
        if(right>=size)
            return -1;
        return  right;
    }
    void swap(int pos1, int pos2)
    {
        int temp=arr[pos1];
        arr[pos1]=arr[pos2];
        arr[pos2]=temp;
    }
    //forming maxheap for ascending order sort
    void heapify(int[] array) {
        arr = array;
        int position = arr.length - 1;
        while (position > 0) {
            int pos = position;
            while (pos > 0) {
                int p = getparent(pos);
                if (arr[p] < arr[pos])
                {
                    swap(p, pos);
                    pos=p;
                }
                else
                    break;
            }
            position--;
        }
    }
    void heapSort(int[] array)
    {
        heapify(array);
        int position=array.length-1;
        for(int i=0;i<array.length;i++)
        {
            swap(position,0);
            position--;
            size--;
            int pos=0;
            while(true)
            {
                int l=getleftChild(pos);
                int r=getrightChild(pos);
                int max=arr[pos];
                //if()
                if((l==-1||max>arr[l])&&(r==-1||max>arr[r]))
                    break;
                if((r==-1)&&(max<arr[l]))
                {
                    swap(l,pos);
                    pos=l;
                    continue;
                }
                if((l==-1)&&(max<arr[r]))
                {
                    swap(r,pos);
                    pos=r;
                    continue;
                }
                if(arr[r]>arr[l])
                {
                    swap(pos,r);
                    pos=r;
                }
                else
                {
                    swap(pos,l);
                    pos=l;
                }
            }
        }
    }
}