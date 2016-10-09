package LinkedList_Exercise.Ques39;

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
		value= value +" ]";
		System.out.println(value);
	}
	//Reversing the list
	/* Here the code for reversing is written as per instruction for palidrome
	 * implementation in the book, however, it is not required practically 
	 * because as the smaller list which is formed by breaking out from bigger 
	 * list, head the list gets automatically reversed.
	 */
			public void reverseList()
			{
				SLLNode curr=head;
				SLLNode prev=null;
				SLLNode next=null;
				while(curr!=null)
				{
					
					next=curr.getNext();
					curr.setNext(prev);
					prev=curr;
					curr=next;
				}
			}
	

}
