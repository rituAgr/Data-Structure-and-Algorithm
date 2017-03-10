package Stack_Exercise.Ques25;

public class Stack {
	int top;
    int stack[];
    public Stack(int capacity)
    {
    	top=-1;
    	stack=new int[capacity];
    }
    public void push(int data)
    {
    	stack[++top]=data;	
    }
    public int pop()
    {
    	int length=top+1;
    	if(length==0)
    		return Integer.MIN_VALUE;
    	int data=stack[top];
    	  top--;
    	  return data;
    }
    public int size()
    {
    	return (top+1);
    }
    public int peek()
    {
    	return stack[top];
    }
    public boolean isEmpty()
    {
    	if(top+1==0)
    		return true;
    	else 
    		return false;
    }
    public String toString()
	{
		String val="[ ";
		for(int i=0;i<=top;i++)
		{
			val=val+stack[i]+" ";
		}
		return(val+" ]");
	}
    public Stack sorting(Stack stack)
    {
    	Stack sorted=new Stack(top+1);
    	while(stack.isEmpty()==false)
    	{
    		int temp=stack.pop();
    		while(sorted.isEmpty()==false&&sorted.peek()>temp)
    		{
    		     stack.push(sorted.pop());	
    		}
    		sorted.push(temp);
    	}
    	return sorted;
    }
    public static void main(String[] args)
    {
    	Stack stack=new Stack(10);
    	int array[]={3,2,5,1,2,3,4,4,9};
    	for(int i=0;i<array.length;i++)
    		stack.push(array[i]);
    	System.out.println("The original stack is : "+stack.toString());
    	stack=stack.sorting(stack);
    	System.out.println("The sorted stack is : "+stack.toString());
    	
    }

}
