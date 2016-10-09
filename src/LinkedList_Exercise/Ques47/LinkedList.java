package LinkedList_Exercise.Ques47;

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
	//To find last n%k==0 element in th list
	public int findLastModule(int n)
	{
		SLLNode curr=head;
		int count=0;
		SLLNode temp=null;
		while(curr!=null)
		{
			count++;
			if(count%n==0)
				{
				temp=curr;
				count=0;
				}
			curr=curr.getNext();
		}
		return temp.getData();
	}
	

}
