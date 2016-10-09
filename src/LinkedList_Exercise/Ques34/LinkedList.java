package LinkedList_Exercise.Ques34;

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
		while(curr!=null)
		{
			value=value+curr.getData()+" ";
			curr=curr.getNext();
		}
		value= value + " ]";
		System.out.println(value);
	}
	//To reverse the list node in pairs
	
	public void reversePairs()
	{
		SLLNode curr=head;
		SLLNode temp;
		while(curr.getNext()!=null&&curr!=null)
		{
			temp=(curr.getNext()).getNext();
			(curr.getNext()).setNext(curr);
			if(curr==head)
				head=curr.getNext();
			if(temp.getNext()!=null)
			   curr.setNext(temp.getNext());
			else
				curr.setNext(temp);
			curr=temp;
		}
		
	}

}
