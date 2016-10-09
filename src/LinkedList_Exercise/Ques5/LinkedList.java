package LinkedList_Exercise.Ques5;

import java.util.Hashtable;

public class LinkedList {
	SLLNode head;
	int length=0;
	Hashtable<Integer,SLLNode> table;
	//To add the data at the front of list
	public void add(int data)
	{
		SLLNode node= new SLLNode(data);
		if(head==null)
		{ 
		 head=node;
		 length++;
		 return;
		}
		node.setNext(head);
		head=node;
		length++;
		return;
	}
	// To display the list
	public void display()
	{
		String value ="[ ";
		SLLNode curr=head;
		while(curr.getNext()!=null)
		{
			value=value+curr.getData()+" ";
			curr=curr.getNext();
		}
		value= value + curr.getData()+" ]";
		System.out.println(value);
	}
	
	
	
	// to find the data at that position from end : Most efficient way
	public void find(int position)
	{
		if(position>length)
		{
			System.out.println("The value at the position is incorrect : out of range");
			return;
		}
		int count;
		SLLNode temp=head;
		SLLNode result=head;
		for(count=1;count<position;count++)
			temp=temp.getNext();
		while(temp.getNext()!=null)
		{
		 result=result.getNext();
		 temp=temp.getNext();
		}	
		System.out.println("The value at the position "+position+" from end is "+result.getData());
	}
	

}
