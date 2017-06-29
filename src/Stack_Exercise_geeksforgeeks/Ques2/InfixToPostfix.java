package Stack_Exercise_geeksforgeeks.Ques2;


public class InfixToPostfix {
	int top;
	char stack[];
	public InfixToPostfix(int capacity)
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
	public char peek()
	{
		if(isEmpty())
			return '\u0000';
		return stack[top];
	}

	public boolean hasHigherPrecedence(char first, char second)
	{
		int order1=0,order2=0,order=0;
		char check=first;
		for(int count=1;count<=2;count++)
		{
			if(check=='('||check==')')
				return true;
			if(check=='^')
				order=2;
			if(check=='*'||check=='/')
				order=3;
			if(check=='+'||check=='-')
				order=4;
			if(count==1)
			{
				order1=order;
				check=second;
			}
			else
				order2=order;
		}
		if(order1<order2)
			return true;
		else
			return false;
	}
	public String conversion(String exp)
	{
		String output="";
		char[] array=exp.toCharArray();
		for(int i=0;i<array.length;i++)
		{
			//Check if character is digit or number77777
			if(Character.isLetterOrDigit(array[i]))
				output=output+array[i];

				//Check if character is opening braces
			else
			{
				switch(array[i])
				{
					case '(' :
						push(array[i]);
						break;
					case ')' :
						while(peek()!='(')
							output=output+pop();
						pop();
						break;
					default :
					{
						if((hasHigherPrecedence(array[i],peek()))||isEmpty())
							push(array[i]);
						else
						{while(hasHigherPrecedence(array[i],peek())!=true&&(!isEmpty()))
						{
							char data=pop();
							if(data!='(')
								output=output+data;
						}
							push(array[i]);
						}
					}
				}
			}
		}
		while(!isEmpty())
		{
			char data=pop();
			if(data!='(')
				output=output+data;
		}
		return output;
	}
	public static void main(String[] args)
	{
		InfixToPostfix balance=new InfixToPostfix(20);
		String eq="a*b-(c+d)+e";
		String check=balance.conversion(eq);
		System.out.println("The equation braces is balanced : "+check);
	}

}
