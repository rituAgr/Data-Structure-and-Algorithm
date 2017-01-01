package Heap;
import java.util.Arrays;
/**
 * Created by Ritu on 10/10/16.
 */
public class HeapImplement
{
    public static void main(String args[])
    {
        int arr[]=new int[]{6,3,7,4,2,1,5};
        Heap h=new Heap(arr.length);
        h.formHeap(arr);
        System.out.println("The maximum element is "+h.FindMax());
        h.insert(10);
        System.out.println("The maximum element after 10 insertion is "+h.FindMax());
    }
}
class Heap
{
    int array[];
    int capacity;
    int end=-1;
    Heap(int n)
    {
        array=new int[n];
        capacity=n;
    }
    void resize()
    {
        capacity=2*capacity;
        int[] array1=new int[capacity];
        System.arraycopy(array,0,array1,0,end+1);
        array=array1;
    }
    void formHeap(int arr[])
    {
        int n=arr.length;
        while(n>capacity)
            resize();
        for(int i=0;i<n;i++)
        {
            array[++end]=arr[i];
            percolateUp(end);
        }
    }
    //Percolate function
    void percolateUp(int pos)
    {
        int parent=getParent(pos);
        while(parent>=0)
        {
            if(array[parent]<array[pos])
                swap(parent, pos);
            else
                return;
            pos=parent;
            parent=getParent(pos);
        }
    }
    //Below are helper functions
    void swap(int pos1, int pos2)
    {
        int temp=array[pos1];
        array[pos1]=array[pos2];
        array[pos2]=temp;
    }
    int getParent(int x)
    {
        if(x==0)
            return -1;
        return (x-1)/2;
    }
    int getLeftChild(int x)
    {
        int l=(x+1)/2;
        if(l>end)
            return -1;
        return l;
    }
    int getRightChild(int x)
    {
        int r=(x+2)/2;
        if(r>end)
            return -1;
        return r;
    }
    //PercolateDown func
    void percolateDown(int pos)
    {
        int l=getLeftChild(pos);
        int r=getRightChild(pos);
        while(array[pos]<array[l]||array[pos]<array[r]) {
            if (array[pos] < array[l] && array[pos] < array[r]) {
                if (array[l] > array[r])
                {
                    swap(pos, l);
                    pos=l;
                }
                else
                {
                    swap(pos, r);
                    pos=r;
                }
            } else {
                if (array[pos] < array[l])
                {
                    swap(pos, l);
                    pos=l;
                }
                else
                {
                    swap(pos, r);
                    pos=r;
                }
            }
        }
    }
    int FindMax()
    {
        return array[0];
    }
    int deleteMax()
    {
        if(end==-1)
            return -1;
        int val=array[0];
        array[0]=array[end];
        end--;
        percolateDown(0);
        return  val;
    }
    void insert(int val)
    {
        if(end==capacity-1)
            resize();
        array[++end]=val;
        percolateUp(end);
    }
}
