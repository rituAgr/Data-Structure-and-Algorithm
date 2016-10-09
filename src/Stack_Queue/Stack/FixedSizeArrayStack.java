package Stack_Queue.Stack;

public class FixedSizeArrayStack {
	private int capacity;
	public static final int CAPACITY=10;
	int[] stackRep;
	int top=-1;
	public FixedSizeArrayStack()
	{
		capacity=CAPACITY;
		stackRep=new int[CAPACITY];
	}
	public FixedSizeArrayStack(int cap)
	{
		stackRep=new int[cap];
		capacity=cap;
	}
	public int size()
	{
		return (top+1);
	}
	public boolean isEmpty()
	{
		if(size()==0)
			return true;
		else 
			return false;
	}
	public void push(int data) throws Exception
	{
		if(size()==capacity)
			throw new Exception("Stack is full");
		stackRep[++top]=data;
	}
	public int pop() throws Exception
	{
		if(size()==0)
			throw new Exception("Stack is Empty");
		int remove=stackRep[top];
		top--;
		return remove;
	}
	public String toString()
	{
		String val="[ ";
		for(int i=0;i<=top;i++)
		{
			val=val+stackRep[i]+" ";
		}
		return(val+" ]");
	}
	
}














