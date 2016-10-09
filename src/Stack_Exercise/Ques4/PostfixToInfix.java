package Stack_Exercise.Ques4;

public class PostfixToInfix {
	int top;
    String stack[];
    public PostfixToInfix(int capacity)
    {
    	top=-1;
    	stack=new String[capacity];
    }
    public void push(String data)
    {
    	stack[++top]=data;	
    }
    public String pop()
    {
    	int length=top+1;
    	if(length==0)
    		return null;
    	String data=stack[top];
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
    public String peek()
    {
    	if(isEmpty())
    		return null;
    	return stack[top];
    }

    public String conversion(String exp)
    {
    	String value="";
    	char[] array=exp.toCharArray();
    	for(int i=0;i<array.length;i++)
    	{
    		//Check if character is digit or number
    		if(Character.isLetterOrDigit(array[i]))
    		{
    			push(Character.toString(array[i]));
    		}
    		else
    		{
    			String data=pop();
    			if(size()>1)
    			 value="("+value+pop()+array[i]+data+")";
    			else
    				value=value+pop()+array[i]+data;
    			push(value);
    		}
    			value="";
    	}
    		return pop();
         }
    public static void main(String[] args)
	{
    	PostfixToInfix balance=new PostfixToInfix(20);
    	String eq="ab*cd+-e+";
    	String check=balance.conversion(eq);
    	System.out.println("The equation braces is balanced : "+check);
	}

}
