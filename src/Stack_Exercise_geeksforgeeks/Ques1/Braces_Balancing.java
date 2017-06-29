package Stack_Exercise_geeksforgeeks.Ques1;

public class Braces_Balancing {
	int top;
    char stack[];
    public Braces_Balancing(int capacity)
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
    public boolean ParanthesisChecker(char[] equation)
    {
    	int len=equation.length;
    	if(len==0)
    		return false;
    	for(int i=0;i<len;i++)
    	{
    		if(equation[i]=='{'||equation[i]=='['||equation[i]=='(')
    			push(equation[i]);
    		if(equation[i]=='}'||equation[i]==']'||equation[i]==')')
    		{
    			char brace=pop();
    			if(brace=='(')
    			{    
    				if(equation[i]!=')')
                     return false;
    			}
    			if(brace=='{')
    			{    
    				if(equation[i]!='}')
                     return false;
    			}
    			if(brace=='[')
    			{    
    				if(equation[i]!=']')
                     return false;
    			}
    		}
    	}
    	
    	return true;
    }
    public static void main(String[] args)
	{
    	Braces_Balancing balance=new Braces_Balancing(20);
    	String eq="[A+(d-e)*42-{s+d}]";
    	boolean check=balance.ParanthesisChecker(eq.toCharArray());
    	System.out.println("The equation braces is balanced : "+check);
	}
}
