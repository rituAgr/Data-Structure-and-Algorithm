package LinkedList_Exercise.Ques38;

public class CLLNode {
	private CLLNode next;
	private int data;
	CLLNode(int data)
	{
		this.data=data;
	}
	CLLNode(int data, CLLNode next)
	{
		this.data=data;
		this.next=next;
	}
	public void setData(int data)
	{
		this.data=data;
	}
	public void setNext(CLLNode node)
	{
		next=node;
	}
	public int getData()
	{
		return data;
	}
	public CLLNode getNext()
	{
		return next;
	}
	

}
