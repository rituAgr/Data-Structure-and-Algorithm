package Heap.Ques_21;

import java.util.ArrayList;
import java.util.Random;
import java.lang.*;

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
		l=getLeftChild(i);
		r=getRightChild(i);
		if(l==-1&&r==-1)
			return;
		if(l==-1)
			max=r;
		else if(r==-1)
			max=l;
		else
			max=(array[r]>array[l]?r:l);
		if(array[i]<array[max])
		{
			temp=array[i];
			array[i]=array[max];
			array[max]=temp;
			percolateDown(max);
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
	public void BuildHeap(Heap h , int[] A, int n)// n is no of elements starting from 1
	{
		if(h==null)
			return;
		for(int i=0;i<n;i++)
			array[i]=A[i];
		count=n;
		for(int i=(n-1)/2;i>=0;i--)
			percolateDown(i);
	}
	public static int[] random_number(int limit)
	{
		int arr[]=new int[limit];
		Random rm= new Random();
		for(int i=0; i<limit;i++)
			arr[i]=rm.nextInt(100000099);
		return arr;
	}
	public static void main(String args[])
	{
		int arr[]=new int[100];
		arr=random_number(100);
		for(int i=1;i<=100;i++)
		{
			Heap h= new Heap(100);
			h.BuildHeap(h,arr,100);
			int count=0;
			while(count<10)
			{
				arr[count]=h.destroyMax();
				count++;
			}
			System.arraycopy(random_number(90), 0, arr, 10, 90);
		}
		System.out.print("the max 10 numbers are :\n");
		for(int i=0;i<10;i++)
			System.out.print(arr[i]+" ");
	}
}
