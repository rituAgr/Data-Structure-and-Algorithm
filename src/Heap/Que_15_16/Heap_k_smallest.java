package Heap.Que_15_16;
/*1) Build a Max-Heap MH of the first k elements (arr[0] to arr[k-1]) of the given array. O(k)

2) For each element, after the k’th element (arr[k] to arr[n-1]), compare it with root of MH.
……a) If the element is less than the root then make it root and call heapify for MH
……b) Else ignore it.
// The step 2 is O((n-k)*logk)

3) Finally, root of the MH is the kth smallest element.

Time complexity of this solution is O(k + (n-k)*Logk)*/

public class Heap_k_smallest {
	int array[];
	int count;
	int capacity;
	//max heap
	Heap_k_smallest(int capacity)
	{
		count=0;
		this.capacity=capacity;
		array=new int[capacity];
	}
	public int getLeftChild(int i)
	{
		if(i<=0)
			return -1;
		int left = 2*i+1;	
		if(left>count)
			return -1;
		return left;
	}
	public int getRightChild(int i)
	{
		if(i<0)
			return -1;
		int right = 2*i+1;	
		if(right>count)
			return -1;
		else
			return right;
	}
	public int getParent(int i)
	{
		if(i<=0)
			return -1;
		return (i-1)/2;
	}
	public void percolateUp(int i)
	{
		if(i>=count||i<=0)
			return;
		if(array[i]>array[getParent(i)])
		{
			int temp = array[getParent(i)];
			array[getParent(i)]=array[i];
			array[i]=temp;
			i=getParent(i);
		}
		percolateUp(i);
	}
	public void percolateDown(int i)
	{
		if(i<0||i>=count)
			return;
		int l, r, max;	
		l=getLeftChild(i);
		r=getRightChild(i);
		if(l==-1&&r==-1)
			return;
		if(l!=-1&&r!=-1)
			max=array[l]>array[r]?l:r;
		else
			max=(l>r?l:r);
			if(array[i]<array[max])
			{
				int temp=array[i];
				array[i]=array[max];
				array[max]=temp;
			}
			i=max;
			percolateDown(i);

	}
	public void Insert(int data)
	{
		count++;
		array[count-1]=data;
		percolateUp(count-1);	
	}
	public int deleteMax()
	{
		int data=array[0];
		array[0]=array[count-1];
		count--;
		percolateUp(count-1);
		return data;
	}
	public int getMax()
	{
		int data=array[0];
		return data;
	}
	public void ReplaceZero(int data)
	{
		array[0]=data;
		percolateDown(0);
	}
	public static void main(String args[])
	{
		Heap_k_smallest h= new Heap_k_smallest(10);
		int arr[] = { 12,34,54,78,98,88,99,25,89,100};
		int k=4;
		for(int i=0;i<k;i++)
			h.Insert(arr[i]);
		for(int i=k;i<arr.length;i++)
		{
			if(arr[i]<h.getMax())
				h.ReplaceZero(arr[i]);
		}
		System.out.println("The 4 th smallest element in heap is "+h.getMax());
	}
}






