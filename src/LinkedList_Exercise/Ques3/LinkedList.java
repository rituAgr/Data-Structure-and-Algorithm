package LinkedList_Exercise.Ques3;

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
	//To create the hash table from linkedList
	public void hashing()
	{
		table = new Hashtable<Integer,SLLNode>();
	    int position =1;
	    SLLNode curr = head;
	    while(curr!=null)
	    {
	    	table.put(position, curr);
	    	position++;
	    	curr=curr.getNext();
	    }
	    
	}
	
	// to find the data at that position
	public void find(int position)
	{
		int tableLength=table.size();
		if(position>tableLength)
		{
			System.out.println("Incorrect position : Out of range");
			return;
		}
		int tablePos= tableLength - (position-1);
		
		System.out.println("The value at the position "+position+" from end is "+(table.get(tablePos)).getData());
	}
	

}
