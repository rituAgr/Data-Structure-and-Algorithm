package LinkedList_Exercise.Ques28;

import java.util.Hashtable;


public class LinkedList {
	LLNode head;
	int length=0;
	Hashtable<LLNode,Integer> table;
	//To add the data at the front of list
	public void add(int data)
	{
		
		LLNode node= new LLNode(data);
		if(head==null)
		{ 
		 head=node;
		 length++;
		 return;
		}	
		node.setNext(head);
		head=node;
		length++;
		
	}
	// To display the list
	public void display()
	{
		String value ="[ ";
		LLNode curr=head;
		while(curr!=null)
		{
			value=value+curr.getData()+" ";
			curr=curr.getNext();
		}
		value= value+" ]";
		System.out.println(value);
	}
	//To find middle element of linkedList
	public int findMiddle()
	{
	 LLNode slow=head;
	 LLNode fast=head;
	 while(fast.getNext()!=null)
	 {
		 slow=slow.getNext();
		 fast=(fast.getNext()).getNext();
		 
		 if(fast.getNext()==null)
			 return slow.getData();
	 }
	 return Integer.MAX_VALUE;
	}

		/*table = new Hashtable<LLNode,Integer>();
	    int position =0;
	    LLNode curr = head;
	    while(curr!=null)
	    {
	    	position++;
	    	if(table.containsKey(curr)==false)
	    	     table.put(curr,position);
	    	else
	    		return true;
	    	curr=curr.getNext();
	    }
	    return false;*/
	    
	}

