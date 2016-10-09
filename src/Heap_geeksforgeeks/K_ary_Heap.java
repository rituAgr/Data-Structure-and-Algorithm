package Heap_geeksforgeeks;

import java.util.Arrays;

public class K_ary_Heap
{
	public static void main(String[] args)
	{
		int capacity=100;
		int arr[]=new int[capacity];
		int arr1[]={3, 5, 9, 6, 8, 20, 10, 12, 18, 9};
		System.arraycopy(arr1, 0, arr, 0, arr1.length);
		int k=3;		
		System.out.print("The array before forming max heap \n"+Arrays.toString(arr));
		K_Heap h = new K_Heap(arr,k,arr1.length);
		System.out.print("\n The array after forming max heap \n");
		h.printMaxHeap();
		h.insert(7);
		System.out.print("\n The array before after inserting 3 in heap \n");
		h.printMaxHeap();
		int x=h.deleteMax();
		System.out.print("\n The array before after deleting max element from heap \n");
		h.printMaxHeap();
		System.out.print("\n Element deleted is "+x);
		System.out.print("\nReplace key at index 4 by 25");
		h.increaseKey(4,11);
		h.printMaxHeap();
	}
}
//Building k-ary heap
class K_Heap
{
	int[] array;
	int k;
	int capacity;
	int size;
	K_Heap(int arr[], int k, int n)
	{
		array=arr;
		this.k=k;
		capacity=arr.length;
		size=n;
		buildHeap();
	}
	void printMaxHeap()
	{
		//+Arrays.toString(array));
		for(int i=0;i<size;i++)
			System.out.print(" "+array[i]);
	}
	void buildHeap()
	{
		int x= (size-1)/k;
		for(int i=x;i>=0;i--)
			PercolateDown(i);
	}
	void PercolateDown(int i)
	{
		int[] children = new int[k];
		while(true){
			for(int ind=0;ind<k;ind++)
			{
				int x=k*i+ind;
				if(x<size)
					children[ind]=x;
				else
					children[ind]=-1;
			}
			int maxChild=Integer.MIN_VALUE;
			int maxChild_index=-1;
			boolean flag=false;
			for(int ind=0;ind<k;ind++)
			{
				if(children[ind]!=-1&&array[children[ind]]>maxChild)
				{
					flag=true;
					maxChild=array[children[ind]];
					maxChild_index=children[ind];
				}				
			}
			if(!flag||maxChild_index==-1)
				break;
			if(array[maxChild_index]>array[i])
				swap(array,i,maxChild_index);
			i=maxChild_index;
		}
	}
	void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public void insert(int x)
	{
		array[size]=x;
		size++;
		percolateUp(size-1);
	}
	public void percolateUp(int pos)
	{
		if(pos<=0)
			return;
		int p=(pos-1)/k;
		if(array[p]<array[pos])
		{
			swap(array,p,pos);
			percolateUp(p);
		}		
	}
	public int deleteMax()
	{
		if(size<=0)
			return Integer.MIN_VALUE;
		int x=array[0];
		array[0]=array[size-1];
		size--;
		PercolateDown(0);
		return x;
	}
	public void increaseKey(int pos, int val){
		array[pos]=val;
		percolateUp(pos);
		PercolateDown(pos);
	}
}
