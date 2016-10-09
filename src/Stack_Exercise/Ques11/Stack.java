package Stack_Exercise.Ques11;

public class Stack {
	int top;
    char stack[];
    public Stack(int capacity)
    {
    	top=-1;
    	stack=new char[capacity];
    }
    public void push(char data)
    {
    	stack[++top]=data;	
    }
    public char pop()
    {
    	int length=top+1;
    	if(length==0)
    		return '\u0000';
    	char data=stack[top];
    	  top--;
    	  return data;
    }
    public int size()
    {
    	return (top+1);
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

}
