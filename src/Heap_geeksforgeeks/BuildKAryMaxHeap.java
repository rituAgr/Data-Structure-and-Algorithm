package Heap_geeksforgeeks;

class KAryMaxHeap {
	int capacity;
	int k;
	int arr[];
	int size;

	public KAryMaxHeap(int k, int[] arr, int size) {
		this.capacity = arr.length;
		this.k = k;
		this.arr= arr;
		this.size = size;
		buildMaxHeap();
	}

	void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	int parent(int i) {
		return (i-1)/k;
	}

	int getMax() {
		if(size <= 0) {
			System.out.println("Heap underflow");
			return Integer.MIN_VALUE;
		}
		return arr[0];
	}

	int extractMax() {
		if(size <= 0) {
			System.out.println("Heap underflow");
			return Integer.MIN_VALUE;
		}
		if(size == 1) {
			size--;
			return arr[0];
		}

		int root = arr[0];
		arr[0] = arr[size-1];
		size--;
		maxHeapify(0);

		return root;
	}

	void maxHeapify(int i) // percolateDown(int i)
	{
		int[] children = new int[k];

		while(true) {

			for(int ind=0;ind<k;ind++)
				children[ind] = (k*i + ind < size)?k*i + ind:-1;
			int maxChild = Integer.MIN_VALUE, maxChildIndex = -1;
			boolean flag = false;

			for(int ind=0;ind<k;ind++) {
				if(children[ind] != -1 && arr[children[ind]] > maxChild) {
					flag = true;
					maxChildIndex= children[ind];
					maxChild = arr[children[ind]];
				}
			}

			if(!flag || maxChildIndex==-1)
				break;

			if(arr[maxChildIndex] > arr[i])
				swap(arr,i,maxChildIndex);

			i = maxChildIndex;
		}
	}

	void fixUpwards(int i) {
		int parentIndex = parent(i);
		while(parentIndex >= 0 && arr[i] > arr[parentIndex]) {
			swap(arr,i,parentIndex);
			i = parentIndex;
			parentIndex = parent(i);
		}
	}

	void increaseKey(int i, int newKey) {
		arr[i] = newKey;
		fixUpwards(i); 
	}

	void insert(int key) {
		if(size == capacity) {
			System.out.println("Heap overflow");
			return;
		}

		arr[size++] = key;
		fixUpwards(size-1);
	}

	void delete(int i) {
		increaseKey(i,Integer.MAX_VALUE);
		extractMax();
	}

	void buildMaxHeap() {
		for(int i = (size-1)/k;i>=0;i--)
			maxHeapify(i);
	}

	void printMaxHeap() {
		for(int i=0;i<size;i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}

class BuildKAryMaxHeap {
	static final int capacity = 100;

	static void printArray(int[] arr) {
		for(int i : arr)
			System.out.print(i + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr= new int[capacity];
		arr[0] = 4;
		arr[1] = 5;
		arr[2] = 6;
		arr[3] = 7;
		arr[4] = 8;
		arr[5] = 9;
		arr[6] = 10;
		arr[7] = 12;
		arr[8] = 15;
		arr[9] = 20;
		arr[10] = 22;
		int k = 3;
		int n = 11;

		System.out.println("Array");
		printArray(arr);

		KAryMaxHeap mh = new KAryMaxHeap(k,arr,n);

		System.out.println("\nMaxHeap");
		mh.printMaxHeap();

		System.out.println("\nInsert 3");
		mh.insert(3);
		System.out.println("MaxHeap");
		mh.printMaxHeap();

		System.out.println("\nExtracted max = " + mh.extractMax());
		System.out.println("MaxHeap");
		mh.printMaxHeap();

		System.out.println("\nInsert 10");
		mh.insert(10);
		System.out.println("MaxHeap");
		mh.printMaxHeap();

		System.out.println("\nDelete element at index 1");
		mh.delete(1);
		System.out.println("MaxHeap");
		mh.printMaxHeap();

		System.out.println("\nReplace key at index 4 by 11");
		mh.increaseKey(4,11);
		System.out.println("MaxHeap");
		mh.printMaxHeap();

		System.out.println("\nMax = " + mh.getMax());
		System.out.println("MaxHeap");
		mh.printMaxHeap();
	}
}