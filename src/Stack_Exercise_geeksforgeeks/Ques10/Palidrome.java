package Stack_Exercise_geeksforgeeks.Ques10;

public class Palidrome {
	int top;
    char stack[];
    public Palidrome(int capacity)
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
    public boolean palidromeChecker(String eq)
    {
    	int i= 0;
    	char letter[]=eq.toCharArray();
    	while(letter[i]!='X')
    	{
    		push(letter[i]);
    		i++;
    	}
    	for(i=i+1;i<letter.length;i++)
    	{
    		if(letter[i]!=pop())
    			return false;
    	}
    	return true;
    }
    public static void main(String[] args)
	{
    	Palidrome check=new Palidrome(20);
    	String eq="baabXbaab";
    	//boolean check=balance.ParanthesisChecker(eq.toCharArray());
    	System.out.println("The equation braces is balanced : "+check.palidromeChecker(eq));
	}

}
