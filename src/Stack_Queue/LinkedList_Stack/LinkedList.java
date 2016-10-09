package Stack_Queue.LinkedList_Stack;

import java.util.EmptyStackException;

public class LinkedList {
	private int length;
	private ListNode top;
	public LinkedList()
	{
		length=0;
		top=null;
	}

	//Pushing an element in stack
	public void push(int data)
	{
		ListNode node=new ListNode(data);
		if(top==null)
		  top=node;
		else
		{
			node.setNext(top);
			top=node;
		}
		length++;
	}
	//poping an element out of stack
		public int pop() throws EmptyStackException
		{
			if(isEmpty())
					throw new EmptyStackException();
			int data= top.getData();
			ListNode temp=top;
			top=top.getNext();
			temp=null;
			length--;
			return data;
		}
   //peeking the top element of stack
		public int peek() throws EmptyStackException
		{
			if(isEmpty())
				throw new EmptyStackException();
		return (top.getData());
		}
  //Checking if stack is empty
		public boolean isEmpty()
		{
			if(length==0)
				return true;
			else
				return false;
		}
  //Checking the size of stack		
		public int size()
		{
			return length;
		}
 //The string representation of stack
		public String toString()
		{
			String stack="[ ";
			ListNode temp=top;
			while(temp!=null)
			{
				stack=stack+temp.getData()+" ";
				temp=temp.getNext();
			}
			return (stack+"]");
		}

}
