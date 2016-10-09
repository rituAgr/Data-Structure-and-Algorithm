package LinkedList_Exercise.Ques32;

public class Merging {
	public LinkedList sortedAndMerge(LinkedList list1,LinkedList list2)
	{
		LinkedList list=new LinkedList();
		SLLNode temp1=list1.head;
		SLLNode temp2=list2.head;
		while(temp1!=null&&temp2!=null)
		{
		if(temp1.getData()>temp2.getData())
		{
			list.add(temp1.getData());
			temp1=temp1.getNext();
		}
		else
		{
			list.add(temp2.getData());
			temp2=temp2.getNext();
		}
		}
		if(temp1!=null)
			list.add(temp1.getData());
		if(temp2!=null)
			list.add(temp2.getData());
		return list;
		
	}

}
