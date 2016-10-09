package Stack_Queue.DynamicArrayQueue;

public class DynamicArrayQueue {
	private int[] queue;
	private int size,front,rear;
	private static int CAPACITY=8;
	private static int MINCAPACITY=4;
	// default constructor
	public DynamicArrayQueue()
	{
		queue= new int[CAPACITY];
		size=0;rear=-1;front=0;
	}
	//constructor
	public DynamicArrayQueue(int cap)
	{
		queue= new int[cap];
		size=0;rear=-1;front=0;
	}
    //Enqueue process
	public void enQueue(int data) throws NullPointerException, IllegalStateException
	{
		if(size==CAPACITY)
			expand();
			//throw new IllegalStateException("Queue is full : Overflow");
		else
		{
			size++;
			rear=(rear+1)%CAPACITY;
			queue[rear]=data;
			
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
	//expand the queue size
	public void expand()
	{
		int length=size;
		int[] newQueue=new int[length*2];
		for(int i=front;i<=rear;i++)
			newQueue[i-front]=queue[i%CAPACITY];
		queue=newQueue;
		front=0;
		rear=size-1;
		CAPACITY=CAPACITY*2;
	}
	//Shrinking the stack
	public void shrink()
	{
		int length=size;
		if(length>=3/4*CAPACITY||length<MINCAPACITY)
			return;
		length=length/2;
		if(length<MINCAPACITY)
			length=MINCAPACITY;
		int[] newQueue=new int[length];
		for(int i=front;i<=rear;i++)
			newQueue[i-front]=queue[i%CAPACITY];
		queue=newQueue;
		front=0;
		rear=size-1;
		CAPACITY=CAPACITY/2;
	}
	// returns string representation of queue
	public String toString()
	{
		String q="[";
		for(int i=front;i<=rear;i++)
			//{System.out.println("The queue is :**** "+queue[front]);
			q=q+" "+queue[i];
		q=q+" ]";
		return q;	
	}
	public static void main(String[] args)
	{
		DynamicArrayQueue q=new DynamicArrayQueue();
		for(int i=14;i<=50;i=i+2)
			q.enQueue(i);
		System.out.println("The queue is : "+q.toString());
	}

}
