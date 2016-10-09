package Tree_Excercise.Ques_63;

public class LinkedList {
	private int length;
	private ListNode head;
	public LinkedList()
	{
		length=0;
	}
	public synchronized ListNode getHead()
	{
		return head;
	}
	//Inserting a new node at the beginning of list
	public synchronized void insertHead(int data)
	{
		ListNode node = new ListNode(data);
		if(head==null)
			head=node;
		else
		{
			node.setNext(head);
			head = node;
		}
		length++;
	}

	// Traversing through the list
	public synchronized String traverse()
	{
		ListNode temp=head;
		String toString ="[";
		while(temp.getNext()!=null)
		{
			toString = toString+" "+temp.getData();
			System.out.print(temp.getData()+" ");
			temp=temp.getNext();
		}
		System.out.println(temp.getData());
		toString = toString +temp.getData()+" ]";
		return toString;
	}
	//removing the first node in list
	public synchronized ListNode removeFromBegin()
	{
		ListNode temp=head;
		if(head!=null)
		{
			head=temp.getNext();
			temp.setNext(null);
			length--;
		}
		return temp;
	}
	//To clear everything
	public void clear()
	{
		head=null;
		length=0;
	}
	//Convert Singly LinkedList into balanced binary tree
	public BSTNode convert(int start, int end)
	{
		if(end<start)
			return null;
		int mid=start+(end-start)/2;
		BSTNode left=convert(start,mid-1);
		BSTNode parent=new BSTNode(head.getData());
		head=head.getNext();
		parent.setRight(convert(mid+1,end));
		parent.setLeft(left);
		return parent;
	}
	
	public void inOrder(BSTNode root)
	{
		if(root==null)
			return;
		inOrder(root.getLeft());
		System.out.print(root.getData()+" ");
		inOrder(root.getRight());
	}

}
