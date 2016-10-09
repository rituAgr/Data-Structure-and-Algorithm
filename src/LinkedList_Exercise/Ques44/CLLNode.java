package LinkedList_Exercise.Ques44;

public class CLLNode {
	private CLLNode next;
	private String data;
	CLLNode(String data)
	{
		this.data=data;
	}
	CLLNode(String data, CLLNode next)
	{
		this.data=data;
		this.next=next;
	}
	public void setData(String data)
	{
		this.data=data;
	}
	public void setNext(CLLNode node)
	{
		next=node;
	}
	public String getData()
	{
		return data;
	}
	public CLLNode getNext()
	{
		return next;
	}
	

}
