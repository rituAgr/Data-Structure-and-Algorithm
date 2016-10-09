package LinkedList_Exercise.Ques56;

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
	
	public  SLLNode insertionSortList() {
 		if (head == null || head.getNext() == null)
			return null;
 
		SLLNode newHead = head;
		SLLNode temp = head.getNext();//temp=pointer
 
		// loop through each element in the list
		while (temp != null) {
			// insert this element to the new list
 
			SLLNode curr = newHead;//innerPointer=curr
			//SLLNode next = pointer.next;
			temp.setNext(temp.getNext());
			if (temp.getData() <= newHead.getData()) {
				SLLNode oldHead = newHead;
				newHead = temp;
				//newHead.next = oldHead;
				newHead.setNext(oldHead);
			} else {
				while (curr.getNext() != null) {
 
					if (temp.getData() > curr.getData() && temp.getData() <= (curr.getNext()).getData())
					{
						SLLNode temp2 = curr.getNext();//oldnext=temp2
						curr.setNext(temp);
						temp.setNext(temp2);
					}
 
					curr = curr.getNext();
				}
 
				if (curr.getNext() == null && temp.getData() > curr.getData()) {
					temp=curr.getNext();
					temp.setNext(null);;
				}
			}
 
			// finally
			temp = temp.getNext();
		}
 
		return newHead;
	}

}
