package LinkedList_Exercise.Ques44;

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
	public void add(String data)
	{
		addToHead(data);
	}
	// Add the data at the beginning
	public void addToHead(String data)
	{
		CLLNode temp = new CLLNode(data);
		temp.setNext(temp);
		if(start==null)
			{start=temp;	
		System.out.println(start.getData()+" is added");}
		else 
		{
			CLLNode curr= start;
			while(curr.getNext()!=start)
				curr=curr.getNext();
			temp.setNext(start);
	    	curr.setNext(temp);
	    	start=temp;
	    	System.out.println(start.getData()+" is added");
		}
		length++;
	}
	// Add the data at the end
	public void addToTail(String data)
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
	public String peek()
	{
		return (start.getNext()).getData();
	}
	// Return data at the the tail
	public String startPeek()
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
	public boolean contains(String data)
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
	public boolean remove(String data)
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
	//Josephus Circle
	public String ChooseLeader(int remove)
	{
		String output;
		int count=1;
		CLLNode curr=null;
		CLLNode temp;
		while(length!=1)
		{
			curr=start;
         while(count!=(remove-1))
         {
        	 curr=curr.getNext();
        	 count++;
         }
         temp=curr.getNext();
         curr.setNext(temp.getNext());
         temp.setNext(null);
         length--;
         count=1;
         start=curr.getNext();
        output = toString();
        System.out.println(temp.getData()+" is removed");
 		System.out.println("********After one removal*********");
 		System.out.println(output);
 		System.out.println("\n");
		}
		return curr.getData();
	}
	

}
