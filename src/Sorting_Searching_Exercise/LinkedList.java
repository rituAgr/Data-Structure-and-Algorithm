package Sorting_Searching_Exercise;

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
			return;
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
	
	// Traversing through the list
	public synchronized String traverse(ListNode head)
	{
		ListNode temp=head;
		String toString ="[ ";
		while(temp.getNext()!=null)
		{
			toString = toString+temp.getData()+" ";
			//System.out.print(temp.getData()+" ");
			temp=temp.getNext();
		}
		toString = toString +temp.getData()+" ]";
		return toString;
	}

		//To find the middle of linkedlist
	public ListNode getMiddle(ListNode start)
	{
		ListNode  pointer1=start;
		ListNode pointer2=start;
		while(pointer2.getNext()!=null&&pointer2.getNext().getNext()!=null)
		{
			pointer1=pointer1.getNext();
			pointer2=pointer2.getNext().getNext();
		}
		//pointer1.setNext(null);
		return pointer1;
	}
	//Merge sort
	public ListNode merge_sort(ListNode start)
	{
		if(start==null||start.getNext()==null)
			return start;
		ListNode middle=getMiddle(start);
		
		ListNode middleNext=middle.getNext();
		middle.setNext(null);
		ListNode left=merge_sort(start);
		ListNode right=merge_sort(middleNext);
		ListNode temp=merge(left,right);
		return temp;
	}
	//merging the two list
	public ListNode merge(ListNode left,ListNode right)
	{
		if(left==null)
			return right;
		if(right==null)
			return left;
		ListNode temp=null;
		if(left.getData()<right.getData())
			{
			temp=left;
			left=left.getNext();
			}
		else
			{
			temp=right;
			right=right.getNext();
			}
		temp.setNext(merge(left,right));
		return temp;
	}

}
