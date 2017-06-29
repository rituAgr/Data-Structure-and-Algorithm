package Stack_Exercise_geeksforgeeks.Ques11;

public class StackReversal {

	public static void reverseStack(Stack stack)
	{
		if(stack.isEmpty())
			return;
		char temp = stack.pop();
		reverseStack(stack);
		insertAtBottom(stack,temp);
	}
	private static void insertAtBottom(Stack stack,char data)
	{
		if(stack.isEmpty())
		{
			stack.push(data);
			return;
		}
		char temp=stack.pop();
		insertAtBottom(stack, data);
		stack.push(temp);
	}
	public static void main(String[] args)
	{
		Stack stack=new Stack(20);
		char[] array = {'a','b','c','d','e'};
		for(int i=0;i<5;i++)
		{
			stack.push(array[i]);
		}
		System.out.println("Th stack before is "+stack.toString());
		reverseStack(stack);
		System.out.println("Th stack after reversal is "+stack.toString());
	}
}
