package LinkedList_Exercise.Ques41;

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
	public void two_Exchange()
	{
		SLLNode curr=head;
		SLLNode temp;
		SLLNode next;
		head=head.getNext();
		while (curr!=null&&curr.getNext()!=null)
		{
			next=curr.getNext();
		    temp=next.getNext();
		    next.setNext(curr);
		    if(temp==null)
		    {
		    	curr.setNext(null);
		    	break;
	    	}
		    	
		    if(temp.getNext()!=null)
		      curr.setNext(temp.getNext());
		   else
		      curr.setNext(temp);
		    curr=temp;
		   
		}	
		
	}
	public void three_Exchange()
	{
		SLLNode curr=head;
		SLLNode temp;
		SLLNode next;
		SLLNode nextToNext;
		head=(head.getNext()).getNext();
		while (curr!=null&&curr.getNext()!=null&&(curr.getNext()).getNext()!=null)
		{
			next=curr.getNext();
			nextToNext=next.getNext();
		    temp=nextToNext.getNext();
		    nextToNext.setNext(next);
		    next.setNext(curr);
		    if(temp==null)
		    {
		    	curr.setNext(null);
		    	break;
	    	}
		    if(temp.getNext()==null||(temp.getNext()).getNext()==null)
		    {
		    	curr.setNext(temp);
		    	break;
		    }
		   	
		    if((temp.getNext()).getNext()!=null)
		      curr.setNext((temp.getNext()).getNext());
		   else if(temp.getNext()!=null)
			   curr.setNext(temp.getNext());
		   else if(temp!=null)
			   curr.setNext(temp);
		   
		    curr=temp;
		   
		}
		
		
	}
	
	public void four_Exchange()
	{
		SLLNode curr=head;
		SLLNode temp;
		SLLNode next;
		SLLNode nextToNext;
		SLLNode last;
		head=((head.getNext()).getNext()).getNext();
		while (curr!=null&&curr.getNext()!=null&&(curr.getNext()).getNext()!=null&&((curr.getNext()).getNext()).getNext()!=null)
		{
			next=curr.getNext();
			nextToNext=next.getNext();
			last=nextToNext.getNext();
		    temp=last.getNext();
		    last.setNext(nextToNext);
		    nextToNext.setNext(next);
		    next.setNext(curr);
		    if(temp==null)
		    {
		    	curr.setNext(null);
		    	break;
	    	}
		    if(temp.getNext()==null||(temp.getNext()).getNext()==null)
		    {
		    	curr.setNext(temp.getNext().getNext());
		    	break;
		    }
		   	if(((temp.getNext()).getNext()).getNext()!=null)
		   		curr.setNext(((temp.getNext()).getNext()).getNext());
		    if((temp.getNext()).getNext()!=null)
		      curr.setNext((temp.getNext()).getNext());
		   else if(temp.getNext()!=null)
			   curr.setNext(temp.getNext());
		   else if(temp!=null)
			   curr.setNext(temp);
		   
		    curr=temp;
		   
		}
		
		
	}
}
