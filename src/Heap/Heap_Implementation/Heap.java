package Heap.Heap_Implementation;

 class Heap {
	int[] array; 
	int count; //Number of elements in Heap
	int capacity;//Size of heap
	int heap_type;//heap up or heap down
	//constructor
	public Heap(int capacity, int heap_type) //must
	{
		this.array= new int[capacity];
		count=0;
		this.capacity=capacity;
		this.heap_type=heap_type;
	}
	//get parent index
	public int Parent(int i)
	{
		if(i<=0||i>count)
			return -1;
		return (i-1)/2;
	}
	//get left child index
	public int LeftChild(int i)
	{
		int left=2*i+1;
		if(left>=count)
			return -1;
		return left;
	}
	//get right child index
	public int RightChild(int i)
	{
		int right=2*i+2;
		if(right>=count)
			return -1;
		return right;
	}
	//Considering the heap is heapUp
	public int getMax()
	{
		if(this.count==0)
			return -1;
		return array[0];
	}
	// Percolating the element at a location
	// function is never used directly from main function, but is indirectly very useful
	// in insert func and heapifying func.
	public void PercolateDown(int i)
	{
		if(i==Integer.MIN_VALUE)
			return;
		int l,r, max=Integer.MIN_VALUE,temp;
		l=LeftChild(i);
		r=RightChild(i);
		if(l==-1&&r==-1)
			return;
		if(l!=-1&&array[l]>array[i])
			max=l;
		else 
			max=i;
		if(r!=-1&&array[r]>array[max])
			max=r;
		if(max!=i)
		{
			temp=array[i];
			array[i]=array[max];
			array[max]=temp;
			PercolateDown(max);
		}

	}
	public int deleteMax()
	{
		int data=array[0];
		array[0]=array[count-1];
		count--;
		PercolateDown(0);
		return data;
	}
	//Inserting the data into heap
	//It is inserted as leaf node
	public void Insert(int data)
	{
		if(count==capacity)
			ResizeHeap();
		if(count==0)
		{
			count++;
			array[0]=data;
			return;
		}
		count++;
		array[count-1]=data;
		PercolateUp(count-1);
		//percolate Up
		/*int i=count-1;
		while(i>0&&data>array[(i-1)/2])
		{
			array[i]=array[(i-1)/2];
			i=(i-1)/2;
		}
		array[i]=data;*/
	}
	void PercolateUp(int i)
	{
		int temp=0;
	  while(i>0&&array[i]>array[(i-1)/2])	
	  {
		  temp=array[(i-1)/2];
		  array[(i-1)/2]=array[i];
		  array[i]=temp;
		  i=(i-1)/2;
	  }
	}
	//Increasing the size of heap
	public void ResizeHeap()
	{
		int size=array.length;
		capacity=size*2;
		int new_array[]=new int[capacity];
		System.arraycopy(array,0,new_array,0,size-1);
		array=new_array;
		new_array=null;        
	}
	//Destroying the heap
	public void destroy()
	{
		array=null;
		count=0;
	}
	//if in case we want to bulid heap in one go with array to ints provided
	public void BuildHeap(Heap h , int[] A, int n)// n is no of elements starting from 1
	{
		if(h==null)
			return;
		while(n>capacity)
			ResizeHeap();
		for(int i=0;i<n;i++)
			array[i]=A[i];
		count=n;
		for(int i=(n-1)/2;i>=0;i--)
			PercolateDown(i);

	}
	//heapSort
	public void HeapSort()
	{
		int temp,c=count;
		for(int i=count-1;i>0;i--)
		{
			temp=array[0];
			array[0]=array[count-1];
			array[count-1]=temp;
			count--;
			PercolateDown(0);
		}
		count=c;
		System.out.print("Sorted array is \n");
		for(int i=0;i<count;i++)
			System.out.print(array[i]+" ");
	}

	public static void main(String args[])
	{
		Heap h= new Heap(7,1);
		int[] arr={12,22,65,34,22,44};
		h.Insert(23);
		//h.Insert(43);
		//h.Insert(12);
		//h.Insert(34);
		//h.Insert(100);
		
		//h.destroy();
		//h= new Heap(5,1);
		h.BuildHeap(h,arr,6);
		h.Insert(200);
		System.out.println("the max element is "+ h.getMax());
	    h.HeapSort();

	}

}














