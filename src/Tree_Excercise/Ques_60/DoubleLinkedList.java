package Tree_Excercise.Ques_60;

public class DoubleLinkedList {
	DLLNode head;
	DLLNode tail;
	int length;
	public DoubleLinkedList()
	{
		head=new DLLNode(Integer.MIN_VALUE,null,null);
		tail=new DLLNode(Integer.MIN_VALUE,null,null);
		length=0;
		head.setNext(tail);
	}

	public void insertHead(int value)
	{
		if(head.getData()==Integer.MIN_VALUE)
		{
			head.setData(value);
			return;
		}
		DLLNode node=new DLLNode(value,null,head);
		node.setNext(head);
		DLLNode curr=head;
		curr.setPrevious(node);
		head=node;
		length++;
	}
	public DLLNode getHead()
	{
		return head;
	}
	public BSTNode convert(DLLNode head,int len)
	{
		if(head==null||len<1)
			return null;
		DLLNode curr=head;
		int count=1;
		while(count<=len/2)
		{
			++count;
			curr=curr.getNext();
		}
		BSTNode node=new BSTNode(curr.getData());
		node.setLeft(convert(head,count-1));
		node.setRight(convert(curr.getNext(),len-count));
		return node;
	}
	public void inorder(BSTNode root)
	{
		if(root==null)
			return;
		inorder(root.getLeft());
		System.out.print(root.getData()+" ");
		inorder(root.getRight());
	}
}

