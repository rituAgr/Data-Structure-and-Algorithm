package Stack_Queue.LinkedQueue;

public class LinkedQueue {
	private int length;
	private ListNode front, rear; 
	//Constructor
	public LinkedQueue()
	{
		length=0;
		front=rear=null;
	}
	//enQueue
	public void enQueue(int data)
	{
		ListNode node = new ListNode(data);
		if(front==null)
			{
			front = node;
			rear = node;
			length++;
			return;
			}
		rear.setNext(node);	
		rear=node;
		length++;
	}
	//deQueue
	public int deQueue() throws Exception
	{
		if(isEmpty())
			throw new Exception("Queue is empty : Can't dequeue");
		int data=front.getData();
		ListNode temp=front;
		front=front.getNext();
		temp=null;
		length--;
		return data;
	}
	//Check if empty
	public boolean isEmpty()
	{
		return (length==0);
	}
	public String toString()
	{
		String s="[ ";
		ListNode temp=front;
		while(temp!=null)
		{
			s=s+temp.getData()+" ";
			temp=temp.getNext();
		}
		s=s+"]";
		return s;
	}
  public static void main(String[] args) throws Exception
  {
	  LinkedQueue q= new LinkedQueue();
	  q.enQueue(45);
	  q.enQueue(34);
	  q.enQueue(22);
	  q.enQueue(55);q.enQueue(65);q.enQueue(3);
	  System.out.println("the queue is : "+q.toString());
	  int data=q.deQueue();
	  System.out.println("After removing from queue : "+data+"\n The queue is "+q.toString());
	   data=q.deQueue();
	  System.out.println("After removing from queue : "+data+"\n The queue is "+q.toString());
  }
}
