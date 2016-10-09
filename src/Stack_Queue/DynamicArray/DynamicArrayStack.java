package Stack_Queue.DynamicArray;

public class DynamicArrayStack {
	int[] stackRep;
	int top;
	public static final int CAPACITY=5;
	int capacity;
	DynamicArrayStack()
	{
		top=-1;
		stackRep = new int[CAPACITY];
		capacity=CAPACITY;
	}
	DynamicArrayStack(int cap)
	{
		top=-1;
		stackRep = new int[cap];
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
	public void push(int data)
	{
		if(size()==capacity)
			expand();// expanding the the size of stack
		stackRep[++top]=data;
	}
	public void expand()
	{
		int length=size();
		int newStack[]=new int[length<<1];
		System.arraycopy(stackRep, 0, newStack, 0, length);
		stackRep=newStack;
	}
   public void shrink()
   {
	   int length=top+1;
	   if(length<=CAPACITY)
		   return;
	   if(length>=(3/4*capacity))
		   return;
	   int newStack[]=new int[capacity/2];
		System.arraycopy(stackRep, 0, newStack, 0, length);
		stackRep=newStack;
   }
   public int top() throws Exception
   {
	   if(isEmpty())
		   throw new Exception("Stack is empty");
	   return stackRep[top];
   }
   public int pop() throws Exception
   {
	   if(isEmpty())
		   throw new Exception("Stack is empty");
	   int data = stackRep[top];
	   top--;
	   return data;
   }
   public String toString()
   {
	   String data="[ ";
	   for(int i=0;i<=top;i++)
		   data=data+stackRep[i]+" ";
	   return (data +"]");
   }
}
