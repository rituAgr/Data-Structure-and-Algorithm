package Stack_Queue.LinkedList_Stack;

public class ListNode {
	private int data;
	private ListNode next;
	public ListNode(int data)
	{
		this.data=data;
	}
	public void setData(int data)
	{
		this.data= data;
	}
	public int getData()
	{
		return data;
	}
	public void setNext(ListNode next)
	{
		this.next=next;
	}
	ListNode getNext()
	{
		return next;
	}

}
