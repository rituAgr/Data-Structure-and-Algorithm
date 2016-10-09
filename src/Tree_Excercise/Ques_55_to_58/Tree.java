package Tree_Excercise.Ques_55_to_58;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class Tree {
	public  void formTree(BSTNode root)
	{	
		BSTNode L1 = new BSTNode(6);
		BSTNode R1 = new BSTNode(16);
		BSTNode L1L = new BSTNode(4);
		BSTNode L1R = new BSTNode(89);
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
	//check weather a tree is BST or not
	//Ques 55
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
	//helper function of finding max in tree used in ques 56
	public int max(BSTNode root)
	{
		BSTNode curr;
		int max=Integer.MIN_VALUE;
		Queue<BSTNode> q = new LinkedList<BSTNode>();
		q.add(root);
		while(!q.isEmpty())
		{
			curr=q.poll();
			if(curr.getData()>max)
				max=curr.getData();
			if(curr.getLeft()!=null)
				q.add(curr.getLeft());
			if(curr.getRight()!=null)
				q.add(curr.getRight());
		}
		return max;
	}
	//helper function of finding min in tree used in ques 56
	public int min(BSTNode root)
	{
		BSTNode curr;
		int min=Integer.MAX_VALUE;
		Queue<BSTNode> q = new LinkedList<BSTNode>();
		q.add(root);
		while(!q.isEmpty())
		{
			curr=q.poll();
			if(curr.getData()<min)
				min=curr.getData();
			if(curr.getLeft()!=null)
				q.add(curr.getLeft());
			if(curr.getRight()!=null)
				q.add(curr.getRight());
		}
		return min;
	}
	//check if BST Ques 56
	public boolean better_check(BSTNode root)
	{
		if(root==null)
			return true;
		if(root.getLeft()!=null&&max(root.getLeft())>root.getData())
			return false;
		if(root.getRight()!=null&&min(root.getRight())<root.getData())
			return false;
		return (check(root.getLeft())&&(check(root.getRight())));          
	}
	//check if BST Ques 57
	public boolean best_check(BSTNode root,int min, int max)
	{
		if (root==null)
			return true;
		boolean check1=(root.getData()>min&&root.getData()<max);
		boolean check2=best_check(root.getLeft(),min,root.getData());
		boolean check3=best_check(root.getRight(),root.getData(),max);
		return (check1&&check2&&check3);
	}
	//check if BST Ques 58
	public boolean bestOfbest_check(BSTNode root)
	{
		BSTNode curr=root;
		int prev=Integer.MIN_VALUE;
		Stack<BSTNode> s = new Stack<BSTNode>();
		while(true)
		{
			if(curr!=null)
			{
				s.push(curr);
				curr=curr.getLeft();
			}
			else
			{
				if(s.isEmpty())
					return true;
				curr=s.pop();
				int data=curr.getData();
				if(prev>data)
					return false;
				prev=data;
				curr=curr.getRight();
				if(curr!=null)
					s.push(curr);
				
			}
		}
	}
}










