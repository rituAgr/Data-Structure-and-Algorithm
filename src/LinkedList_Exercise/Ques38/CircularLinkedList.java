package LinkedList_Exercise.Ques38;

public class CircularLinkedList {
	CLLNode start;
	int length;
	// In circular Linked List, head and tail creates confusion 
	// therefore, we have choosen the term 'start'
	CircularLinkedList()
	{
		start=null;
		length = 0;
	}
	// Add the data at the beginning
	public void add(int data)
	{
		addToHead(data);
	}
	// Add the data at the beginning
	public void addToHead(int data)
	{
		CLLNode temp = new CLLNode(data);
		temp.setNext(temp);
		if(start==null)
			{start=temp;	
		System.out.println(start.getData()+"is added");}
		else 
		{
			CLLNode curr= start;
			while(curr.getNext()!=start)
				curr=curr.getNext();
			temp.setNext(start);
	    	curr.setNext(temp);
	    	start=temp;
	    	System.out.println(start.getData()+"is added");
		}
		length++;
	}
	// Add the data at the end
	public void addToTail(int data)
	{
		CLLNode temp = new CLLNode(data);
		temp.setNext(temp);
		if(start==null)
			start=temp;
		else
		{
			CLLNode curr=start;
			while(curr.getNext()!=start)
				curr=curr.getNext();
			temp.setNext(start);
			curr.setNext(temp);
		}
		length++;
	}
	// Return data at the head
	public int peek()
	{
		return (start.getNext()).getData();
	}
	// Return data at the the tail
	public int startPeek()
	{
		return start.getData();
	}
	// Return and remove the head of circular linked list
	public void removeFromHead()
	{
		if(start==null)
			return;
		CLLNode curr = start;
		while(curr.getNext()!=start)
			curr=curr.getNext();
		curr.setNext(start.getNext());
		start.setNext(null);;
		start=curr.getNext();
		length--;
	}
	// Return and remove the tail element
	public void removeFromTail()
	{
			
	}
	//Return true if this data is present in list, else false
	public boolean contains(int data)
	{
		CLLNode temp = start;
		while(temp.getNext()!=start)
		{
			if(temp.getData()==data)
				return true;
			temp=temp.getNext();
		}
		return false;
	}
	// Remove and return the data if found in List
	public boolean remove(int data)
	{
		if(!contains(data))
			return false;
		CLLNode temp=start;
		if(start.getData()==data)
		{
				removeFromHead();	
				return true;
		}
		else
		 while(temp.getNext()!=start)
		{
			if((temp.getNext()).getData()==data)
			{
				CLLNode curr=temp.getNext();
				temp.setNext(curr.getNext());
				curr=null;
				length--;
				return true;
			}
			temp=temp.getNext();
		}
		return false;
	}
	// Return the length of list
	public int returnLength()
	{
		return length;
	}
	public void clearIt()
	{
		start=null;
		length=0;
	}
	//Returns the String representation of linkedList
	public String toString()
	{
		CLLNode temp=start;
		String value = "[ ";
		while(temp.getNext()!=start)
		{	
			value = value+temp.getData()+" ";
			temp=temp.getNext();
		}
		value = value+temp.getData()+"]";
		return value;
	}
	//Splitting the linkedList into two parts
	public void split(CircularLinkedList list)
	{
		CircularLinkedList list1 = new CircularLinkedList();
		CircularLinkedList list2 = new CircularLinkedList();
		CLLNode curr1=list.start;
		CLLNode curr2=list.start;
		list1.add(curr1.getData());
		while(curr2.getNext()!=list.start)
		{
			curr2=(curr2.getNext()).getNext();
			if(curr2==start)
				break;
			curr1=curr1.getNext();
			list1.add(curr1.getData());
			
		}
		while(curr1.getNext()!=start)
		{
			curr1=curr1.getNext();
			list2.add(curr1.getData());
		}
		//Display List1
		System.out.println("*******List1**********");
		String output=list1.toString();
		System.out.println(output);
		//Display List2
		System.out.println("*******List2**********");
	    output=list2.toString();
		System.out.println(output);
	}

}
