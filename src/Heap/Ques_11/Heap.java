package Heap.Ques_11;

import java.util.ArrayList;

public class Heap {
	int count;
	int array[];
	int capacity;
	Heap()
	{
		count=0;
		capacity=0;
		array=new int[capacity];
	}
	Heap(int capacity)
	{
		count=0;
		this.capacity=capacity;
		array=new int[capacity];
	}
	int getParent(int i)
	{
		if(i==0)
			return -1;
		return (i-1)/2;
	}
	int getLeftChild(int i)
	{
		int val = 2*i+1;
		if(val>=count)
			return -1;
		else
			return val;
	}
	int getRightChild(int i)
	{
		int val = 2*i+2;
		if(val>=count)
			return -1;
		else
			return val;
	}
	int getMax()
	{
		if(count==0)
			return -1;
		return array[0];
	}
	int destroyMax()
	{
		if(count==0)
			return -1;
		int value=array[0];
		array[0]=array[count-1];
		count--;
		percolateDown(0);
		return value;
	}
	void percolateDown(int i)
	{
		if(i<0||i>=count-1)
			return;
		int l,r,max,temp;
		while(i<=count-1&&array[i]<array[(i+1)/2])
		{
			l=getLeftChild(i);
			r=getRightChild(i);
			max=(array[r]>array[l]?r:l);
			if(array[i]<array[max])
			{
				temp=array[i];
				array[i]=array[max];
				array[max]=temp;
			}
			i=max;
		}
	}
	public void percolateUp(int i)
	{
		int temp;
		int parent=getParent(i);
		if(parent<0)
			return;
		if(array[(i-1)/2]<array[i])
		{
			temp=array[parent];
			array[parent]=array[i];
			array[i]=temp;
			i=getParent(i);
		}
		else
			return;
		percolateUp(i);
	}
	public void Insert(int data)
	{
		count++;
		array[count-1]=data;
		percolateUp(count-1);
	}
	public ArrayList<Integer> less(int data)
	{
		ArrayList<Integer> arr= new ArrayList<Integer>();
		return less(arr, data,-1);
		
		
	}
	public ArrayList<Integer> less(ArrayList<Integer> arr, int data, int pos)
	{
		if(pos==count-1)
			return arr;
        pos++;
		if(array[pos]<data)
			arr.add(array[pos]);
 	     return less(arr,data, pos);
	}

	public static void main(String args[])
	{
		Heap h= new Heap(7);
		h.Insert(23);
		h.Insert(43);
		h.Insert(12);
		h.Insert(34);
		h.Insert(100);
		h.Insert(200);
		System.out.println("the max element is "+ h.getMax());
		ArrayList<Integer> arr=h.less(50);
		System.out.println("All element less than 50 :");
		for(int i: arr)
			System.out.print(i+" ");
	}
}
