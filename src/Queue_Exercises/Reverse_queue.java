package Queue_Exercises;

/**
 * Created by Ritu on 12/18/16.
 */
public class Reverse_queue {
    private int[] queue;
    int capacity;
    private int size,front,rear;
    private static final int CAPACITY=16;
    // default constructor
    public Reverse_queue()
    {
        queue= new int[CAPACITY];
        size=0;rear=-1;front=0;
    }
    //constructor
    public Reverse_queue(int cap)
    {
        queue= new int[cap];
        size=0;rear=-1;front=0;
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
            front= (front+1)%CAPACITY;
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
        for(int i=front;i<=rear;i++)
            q=q+" "+queue[i];
        q=q+" ]";
        return q;
    }
    public void reverse()
    {
        if(isEmpty())
            return;
        int temp=deQueue();
        reverse();
        enQueue(temp);
    }
    public static void main(String[] args)
    {
        Reverse_queue q=new Reverse_queue();
        for(int i=14;i<=23;i=i+2)
            q.enQueue(i);
        System.out.println("The queue is : "+q.toString());
        q.reverse();
        System.out.println("After reversing. The queue is : "+q.toString());
    }

}
