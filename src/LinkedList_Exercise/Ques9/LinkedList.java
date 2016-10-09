package LinkedList_Exercise.Ques9;

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
		if(length==7)
		{
			int count=0;
			LLNode curr=head;
			LLNode joint=null;
			while(curr.getNext()!=null)
			{	
				count++;
				curr=curr.getNext();
				if(count==3)
					 joint=curr;
			}
			curr.setNext(joint);
		}
	}
	
	//To create the hash table from linkedList
	public boolean isLoop()
	{
	 LLNode slow=head;
	 LLNode fastCheck=head;
	 LLNode fast=head;
	 while(fast!=null)
	 {
		 slow=slow.getNext();
		 fastCheck=fast.getNext();
		 if(fastCheck==null)
			 return false;
		 fast=fastCheck.getNext();
		 if(fast==null)
			 return false;
		 if(fast==slow)
			 return true;
	 }
	 return false;
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

