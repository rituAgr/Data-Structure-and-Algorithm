package LinkedList_Exercise.Ques2;

public class LinkedList {
	SLLNode head;
	int length=0;;
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
	// to find the data at that position
	public void find(int position)
	{
		SLLNode curr=head;
		int pos=length-(position-1);//position from front
		int count=1;
		while(count<pos)
		{
			curr=curr.getNext();
			count++;
		}
		System.out.println("The value at that position is "+ curr.getData());
	}
	

}
