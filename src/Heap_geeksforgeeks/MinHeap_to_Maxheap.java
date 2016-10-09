package Heap_geeksforgeeks;/*
 * Refer : http://www.geeksforgeeks.org/convert-min-heap-to-max-heap/
 * Important see how it shows that time complexity is O(n)
 */
import java.util.Arrays;

public class MinHeap_to_Maxheap {

	public static void main(String[] args) {
		int array[]={3, 5, 9, 6, 8, 20, 10, 12, 18, 9};
		Heap h = new Heap(array, 20);
		h.buildHeap_MinHeap(array);
		h.print_Heap();
		h.convert_min_to_Max();
		h.print_Heap();
	}

}
class Heap{
	int array[];
	int capacity;
	int count;
	Heap(int array[], int capacity)
	{
		this.array=array;
		this.capacity=capacity;
		count=array.length;
	}
	public void print_Heap()
	{
		System.out.println(Arrays.toString(array));
	}
	public int get_RightChild(int i)
	{
		int r=2*i+2;
		if(r>=count)
			return -1;
		return r;
	}
	public int get_LeftChild(int i)
	{
		int l=2*i+1;
		if(l>=count)
			return -1;
		return l;
	}
	public int getParent(int i)
	{
		int p=(i-1)/2;
		if(i<0)
			return -1;
		return p;
	}
	public void ReSize()
	{
		int i=array.length;
		int[] newArray = new int[2*i];
		System.arraycopy(array, 0, newArray, 0,count);
		array=newArray;
	}
	public void swap(int i, int j)
	{
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
	// Max Heap functions
	public void percolateDown_MaxHeap(int i)
	{
		if(i<0||i>=count)
			return;
		int max=i,l,r;
		l=get_RightChild(i);
		r=get_LeftChild(i);
		if(l==-1&&l==-1)
			return;
		if(l!=-1)
		  max=(array[l]>array[max])?l:max;
		if(r!=-1)
		  max=(array[r]>array[max])?r:max;
		if(max==i)
			return;
		swap(i,max);
		percolateDown_MaxHeap(max);
	}
	public void percolateUp_MaxHeap(int i)
	{
		if(i<1||i>=count)
			return;
		int p=getParent(i);
		if(array[i]>array[p])
			{
			swap(i,p);
			percolateUp_MaxHeap(p);
			}
	}
	public void insert_MaxHeap(int x)
	{
		count++;
		array[count-1]=x;
		percolateUp_MaxHeap(count-1);
	}
	public int DeleteMax_MaxHeap()
	{
		int x=array[0];
		array[0]=array[count-1];
		count--;
		percolateDown_MaxHeap(0);
		return x;
	}
	public void buildHeap_MaxHeap(int[] A)
	{
		while(array.length<A.length)
			ReSize();
		for(int i=(A.length-1)/2;i>=0;i--)
			percolateDown_MaxHeap(i);
	}
	// Min Heap functions
		public void percolateDown_MinHeap(int i)
		{
			if(i<0||i>=count)
				return;
			int min=i,l,r;
			l=get_RightChild(i);
			r=get_LeftChild(i);
			if(l==-1&&l==-1)
				return;
			if(l!=-1)
			  min=(array[l]<array[min])?l:min;
			if(r!=-1)
			  min=(array[r]<array[min])?r:min;
			if(min==i)
				return;
			swap(i,min);
			percolateDown_MinHeap(min);
		}
		public void percolateUp_MinHeap(int i)
		{
			if(i<1||i>=count)
				return;
			int p=getParent(i);
			if(array[i]<array[p])
				{
				swap(i,p);
				percolateUp_MinHeap(p);
				}
		}
		public void insert_MinHeap(int x)
		{
			count++;
			array[count-1]=x;
			percolateUp_MinHeap(count-1);
		}
		public int Delete_MinHeap()
		{
			int x=array[0];
			array[0]=array[count-1];
			count--;
			percolateDown_MinHeap(0);
			return x;
		}
		public void buildHeap_MinHeap(int[] A)
		{
			while(array.length<A.length)
				ReSize();
			for(int i=(A.length-1)/2;i>=0;i--)
				percolateDown_MinHeap(i);
		}
		//conversion MinHeap to MaxHeap
		//time complexity : O(n). 
		//Refer this link for more explanation : http://www.cs.sfu.ca/CourseCentral/307/petra/2009/SLN_2.pdf
		public void convert_min_to_Max()
		{
			buildHeap_MaxHeap(array);	
			return;
			/*int x= (count-1)/2;
			for(int i=x;i>=0;i--)
				percolateDown_MaxHeap(i);*/
		}
}
