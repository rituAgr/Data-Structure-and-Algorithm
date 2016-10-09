package Tree_Excercise.Ques_60;

public class DLLNode {
	private int data;
	private DLLNode next;
	private DLLNode previous;
	public DLLNode(int data)
	{
		this.data=data;
		next=null;
		previous=null;
	}
	public DLLNode(int data,DLLNode previous,DLLNode next)
	{
		this.data = data;
		this.previous=previous;
		this.next=next;
	}
	public void setData(int data)
	{
		this.data=data;
	}
	public void setNext(DLLNode next)
	{
		this.next=next;
	}
	public void setPrevious(DLLNode previous)
	{
		this.previous=previous;
	}
	public int getData()
	{
		return data;
	}
	public DLLNode getNext()
	{
		return next;
	}
	public DLLNode getPrevious()
	{
		return previous;
	}

}
