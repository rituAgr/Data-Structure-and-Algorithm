package LinkedList_Exercise.Ques56;

public class start {
	public static void main(String[] args)
	{
		LinkedList list = new LinkedList();
		list.add(5);
		list.add(25);
		list.add(15);
		list.add(20);
		list.add(35);
		list.add(30);
		list.add(10);
		list.display();
	    SLLNode node=list.insertionSortList();
	  //  list.display();
	    String value ="[ ";
		SLLNode curr=node;
		while(curr!=null)
		{
			value=value+curr.getData()+" ";
			curr=curr.getNext();
		}
		value= value + " ]";
		System.out.println(value);
	}
}
