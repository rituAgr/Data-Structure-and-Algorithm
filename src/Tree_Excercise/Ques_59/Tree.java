package Tree_Excercise.Ques_59;

import java.util.Stack;

public class Tree {
	public  void formTree(BSTNode root)
	{	
		BSTNode L1 = new BSTNode(6);
		BSTNode R1 = new BSTNode(16);
		BSTNode L1L = new BSTNode(4);
		BSTNode L1R = new BSTNode(89);
		BSTNode R1L= new BSTNode(13);
		BSTNode R1R = new BSTNode(7);
		//BSTNode max = new BSTNode(34);
		root.setLeft(L1);
		root.setRight(R1);
		L1.setLeft(L1L);
		L1.setRight(L1R);
		R1.setLeft(R1L);
		R1.setRight(R1R);
	}
	//Wrapper function over UtilTreetoList function
	public DLLNode TreetoList(BSTNode root)
	{
		DLLNode tail=UtilTreetoList(root);
		DLLNode head=tail;
		while(head.getPrevious()!=null)
			head=head.getPrevious();
		head.setPrevious(tail);
		tail.setNext(head);
		return head;
	}
	//The func which perform actual task
	//Performs inorder order traversal
	public DLLNode UtilTreetoList(BSTNode root)
	{
		if (root==null)
			return null;
		Stack<BSTNode> s = new Stack<BSTNode>();
		DLLNode current=null;
		DLLNode previous = null;
		BSTNode curr=root;
		while(!s.isEmpty()||curr!=null)
		{
			if(curr!=null)
				{
				s.push(curr);
				curr=curr.getLeft();
				}
			else
			{
				curr=s.pop();
				current=new DLLNode(curr.getData());
				join(previous,current);
				curr=curr.getRight();
				previous=current;
			}
		}
		return previous;
	}
	//The func which perform actual task
	//Performs th level order traversal
	/*public DLLNode UtilTreetoList(BSTNode root)
	{
		if (root==null)
			return null;
		Queue<BSTNode> q = new LinkedList<BSTNode>();
		BSTNode curr = root;
		q.add(curr);
		DLLNode previous=null;
		DLLNode current=null;
		while(!q.isEmpty())
		{
			curr=q.remove();
			current=new DLLNode(curr.getData());
			if(curr.getLeft()!=null)
				q.add(curr.getLeft());
			if(curr.getRight()!=null)
				q.add(curr.getRight());
			join(previous,current);
			previous=current;
		}
		return previous;
	}*/
	public void join(DLLNode first, DLLNode second)
	{
		if(first!=null)
			first.setNext(second);
		if(second!=null)
			second.setPrevious(first);
	}
}
