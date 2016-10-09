package Binary_tree.BST;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
	public  void formTree(BSTNode root)
	{	
		BSTNode L1 = new BSTNode(6);
		BSTNode R1 = new BSTNode(16);
		BSTNode L1L = new BSTNode(4);
		BSTNode L1R = new BSTNode(9);
		BSTNode R1L= new BSTNode(13);
		BSTNode L1RL = new BSTNode(7);
		BSTNode max = new BSTNode(34);
		root.setLeft(L1);
		root.setRight(R1);
		L1.setLeft(L1L);
		L1.setRight(L1R);
		L1R.setLeft(L1RL);
		R1.setLeft(R1L);
		R1.setRight(max);
	}

	//Proper Level-order traversal
	public void level_order_traversal(BSTNode root)
	{
		System.out.print("The level order traversal is: \n");
		Queue<BSTNode> q= new LinkedList<BSTNode>();
		BSTNode curr = root;
		q.add(curr);
		do
		{	curr=q.remove();
		System.out.print(curr.getData()+" ");
		if(curr.getLeft()!=null)
			q.add(curr.getLeft());
		if(curr.getRight()!=null)
			q.add(curr.getRight());	
		}while(!q.isEmpty());
	}
	//Finding the element in tree recursively
	public boolean recur_find(BSTNode root, int data)
	{
		if(root==null)
			return false;
		if(root.getData()==data)
			return true;
		if(data<root.getData())
			return(recur_find(root.getLeft(),data));
		else
			return(recur_find(root.getRight(),data));

	}
	//	Finding the element in tree iteratively
	public boolean iter_find(BSTNode root, int data)
	{
		if(root==null)
			return false;
		BSTNode curr=root;
		while(curr!=null)
		{
			if(curr.getData()==data)
				return true;
			else
			{
				if(data<root.getData())
					curr=curr.getLeft();
				else
					curr=curr.getRight();
			}
		}
		return false;
	}
	//Finding the max value in BST recursively
	public int max(BSTNode root)
	{
		if(root==null)
			return Integer.MIN_VALUE;
		if(root.getRight()!=null)
			return max(root.getRight());
		else
			return root.getData();
	}
	//Finding the max value in BST iteratively
	public int iter_max(BSTNode root)
	{
		if(root==null)
			return Integer.MIN_VALUE;
		BSTNode curr = root;
		while(curr.getRight()!=null)
			curr=curr.getRight();
		return curr.getData();
	}	
	//Finding the min value in BST recursively
	public int min(BSTNode root)
	{
		if(root==null)
			return Integer.MIN_VALUE;
		if(root.getLeft()!=null)
			return min(root.getLeft());
		else
			return root.getData();
	}
	//Finding the min value in BST iteratively
	public int iter_min(BSTNode root)
	{
		if(root==null)
			return Integer.MIN_VALUE;
		BSTNode curr = root;
		while(curr.getLeft()!=null)
			curr=curr.getLeft();
		return curr.getData();
	}	
	//Inserting a node
	public BSTNode insert(BSTNode root, int data)
	{
		if(root==null)
		{
			root=new BSTNode(data);
			return root;
		}
		else
		{
			if(data<root.getData())
				root.setLeft(insert(root.getLeft(),data));
			else if(data>root.getData())
				root.setRight(insert(root.getRight(),data));
		}
		return root;
	}
	//Deleting a node
	public void delete(BSTNode root,int data)
	{
		if(root==null)
			return;
		BSTNode curr = root;
		BSTNode prev = null;
		while(curr!=null)
		{

			if(curr.getData()==data)
			{
				if(curr.getLeft()==null&&curr.getRight()==null)
				{
					if(prev.getLeft()!=null&&prev.getLeft().equals(curr))
						prev.setLeft(null);
					if(prev.getRight()!=null&&prev.getRight().equals(curr))
						prev.setRight(null);
					return;
				}
				else
				{
					if(curr.getLeft()==null)
					{
						prev.setRight(curr.getRight());
						curr.setRight(null);
						return;
					}	
					else if(curr.getRight()==null)
					{
						BSTNode max=max_n_parent(curr.getLeft());
						prev.setRight(max);
						curr=null;
						return;
					}
				}
			}
			if(data<curr.getData())
			{
				prev=curr;
				curr=curr.getLeft();
			}
			else if(data>curr.getData())
			{
				prev=curr;
				curr=curr.getRight();
			}
		}
	}
	// Finding max with the parent node
	public BSTNode max_n_parent(BSTNode root)
	{
		BSTNode curr = root;
		while(curr.getRight()!=null)
			curr=curr.getRight();
		return curr;
	}

}












