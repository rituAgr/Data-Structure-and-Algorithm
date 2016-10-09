package Stack_Queue.FixedSizeArrayQueue;

public class FixedSizeArrayQueue {
	private int[] queue;
	int capacity;
	private int size,front,rear;
	private static final int CAPACITY=16;
	// default constructor
	public FixedSizeArrayQueue()
	{
		queue= new int[CAPACITY];
		size=0;rear=0;front=0;
	}
	//constructor
	public FixedSizeArrayQueue(int cap)
	{
		queue= new int[cap];
		size=0;rear=0;front=0;
		capacity=cap;
	}
    //Enqueue process
	public void enQueue(int data) throws NullPointerException, IllegalStateException
	{
		if(size==CAPACITY)
			throw new IllegalStateException("Queue is full : Overflow");
		else
		{
			size++;
			queue[rear]=data;
			rear=(rear+1)%CAPACITY;
		}
	}
	// dequeue process
	public int deQueue() throws IllegalStateException
	{
		int data;
		if(size==0)
			throw new IllegalStateException("Queue is Empty : Underflow");
		else
		{
			data= queue[front];
			front= (front-1)%CAPACITY;
			size--;
		}
		return data;
	}
	//check if queue is empty
	public boolean isEmpty()
	{
		return (size==0);
	}
	//Check if queue is full
	public boolean isFull()
	{
		return (size==CAPACITY);
	}
	// returns string representation of queue
	public String toString()
	{
		String q="[";
		for(int i=0;i<size;i++)
			q=q+" "+queue[i];
		q=q+" ]";
		return q;	
	}
	public static void main(String[] args)
	{
		FixedSizeArrayQueue q=new FixedSizeArrayQueue();
		for(int i=14;i<=23;i=i+2)
			q.enQueue(i);
		System.out.println("The queue is : "+q.toString());
	}
}
