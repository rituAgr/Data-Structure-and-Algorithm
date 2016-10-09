package LinkedList.singleLinkedList;

public class LinkedList {
	private int length;
	private ListNode head;
	public LinkedList()
	{
		length=0;
	}
	public synchronized ListNode getHead()
	{
		return head;
	}
	//Inserting a new node at the beginning of list
	public synchronized void insertAtBegin(ListNode node)
	{
		node.setNext(head);
		head=node;
		length++;
			
	}
	//Inserting a new node at the end of list
	public synchronized void insertAtEnd(ListNode node)
	{
		if(head==null)
		{
			head=node;
			length++;
		}
		if(head.getNext()==null)
			{
			head.setNext(node);
			length++;
			return;
			}    
		ListNode temp=head;
		while(temp.getNext()!=null)
			temp=temp.getNext();
		temp.setNext(node);
		length++;
	}
	//Inserting a new node at given position
	public synchronized void insertAtPosition(int data, int pos)
	{
		int temp=0;
		if(pos<0) pos=0;
		if(pos>length) pos=length;
		if(head==null)
		{
			head.setData(data);
			head.setNext(null);
			length++;
			return;
		}
		ListNode node = head;
		while(temp<(pos-1))
		{
			node=node.getNext();
			temp++;
		}
		ListNode newNode = new ListNode(data);
		newNode.setNext(node.getNext());
		node.setNext(newNode);
		length++;
		return;
	}
	// Traversing through the list
	public synchronized String traverse()
	{
		ListNode temp=head;
		String toString ="[";
		while(temp.getNext()!=null)
		{
			toString = toString+" "+temp.getData();
			//System.out.print(temp.getData()+" ");
			temp=temp.getNext();
		}
		toString = toString +" ]";
		return toString;
	}
	//removing the first node in list
	public synchronized ListNode removeFromBegin()
	{
		ListNode temp=head;
		if(head!=null)
		{
		head=temp.getNext();
		temp.setNext(null);
		length--;
		}
		return temp;
	}
	//removing the last node from list
	public synchronized ListNode removeFromEnd()
	{
		ListNode temp=head;
		if(head==null)
			return null;
		if(head.getNext()==null)
		{
			temp=head.getNext();
			head.setNext(null);
				
		}

		while((temp.getNext()).getNext()!=null)
		{
			temp=temp.getNext();
		}
		temp.setNext(null);
		length--;
		return temp;
	}
	//removing the  node from middle from list
	public synchronized void removeMatchedNode(ListNode node)
		{
		   ListNode temp=head;
			if(head==null) return;
			if(head.equals(node)) 
				{
				head=temp.getNext();
				temp.setNext(null);
				length--; 
				return;
				}
			while(temp.getNext()!=null)
			{
				if(temp.getNext().equals(node))
						{
					   temp.setNext((temp.getNext()).getNext());
					   (temp.getNext()).setNext(null);
					   length--;
					   return;
						}
						
			}
			
		}
	public synchronized void remove(int pos)
	{
		ListNode temp=head;
		int ListPosition=0;
		if(pos<=0)
		{
			head=temp.getNext();
			temp.setNext(null);
			length--;
		}
		if(pos>length) pos=length;
			pos=pos-1;
			while(temp.getNext()!=null)
			{
				temp=temp.getNext();
				ListPosition++;
				if(ListPosition==pos-1)
				{
				ListNode temp2=temp.getNext();
				 temp.setNext((temp2.getNext()));
				 temp2.setNext(null);
				length--;
				return;
			}
		}
	}
     //To clear everything
	public void clear()
	{
		head=null;
		length=0;
	}
	

}
