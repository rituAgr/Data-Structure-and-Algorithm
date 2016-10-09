package Tree_Excercise.Ques_52;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Tree {
	public  void formTree(BSTNode root)
	{	
		BSTNode L1 = new BSTNode(6);
		BSTNode R1 = new BSTNode(16);
		BSTNode L1L = new BSTNode(4);
		BSTNode L1R = new BSTNode(91);
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
	// LCA Route
	public ArrayList<Integer> route(BSTNode root,int first,int second)
	{
		if(root==null)
			return null;
		if(first<root.getData()&&second>root.getData())
			return find(root, first, second);
		else
		{
			if(root.getData()>first&&root.getData()>second)
				return route(root.getLeft(), first, second);
			else if(root.getData()<first&&root.getData()<first)
				return route(root.getRight(), first, second);
		}
		return null;
		
	}
	public ArrayList<Integer> find(BSTNode root,int first,int second)
	{
		ArrayList<Integer> array = new ArrayList<Integer>();
		BSTNode curr=root;
		while(curr.getData()!=first)
		    {
			array.add(0,curr.getData());
			if(curr.getData()>first)
			    curr=curr.getLeft();
			else
				curr=curr.getRight();
		    }
		array.add(0,curr.getData());
		curr=root.getRight();
		while(curr.getData()!=second)
	    {
		array.add(curr.getData());
		if(second<curr.getData())
		    curr=curr.getLeft();
		else
			curr=curr.getRight();
	    }
		array.add(curr.getData());
		return array;
	}
	//Least common Ancestor
	public int LCA(BSTNode root,int a, int b)
	{
		if(root==null)
			return Integer.MIN_VALUE;
		if(a<root.getData()&&b>root.getData())
			return root.getData();
		else
		{
			int data=Integer.MIN_VALUE;
			if(root.getData()<a&&root.getData()<b&&root.getRight()!=null)
				 data=LCA(root.getRight(),a,b);
			else if(root.getData()>a&&root.getData()>b&&root.getLeft()!=null)
				data=LCA(root.getLeft(),a,b);
			return data;
		}		
	}
//check weather a tree is BST or not
	public boolean check(BSTNode root)
	{
		if(root==null)
			return true;
		if((root.getLeft()!=null)&&(root.getLeft().getData()>root.getData()))
			return false;
		else 
			if((root.getRight()!=null)&&(root.getRight().getData()<root.getData()))
				return false;
			else 
		return (check(root.getLeft())&&(check(root.getRight())));
		
	}
}
