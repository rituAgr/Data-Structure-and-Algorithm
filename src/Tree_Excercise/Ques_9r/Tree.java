package Tree_Excercise.Ques_9r;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {
	//Forming the tree
		public  void formTree(BinaryTreeNode root)
		{
			
			BinaryTreeNode L1 = new BinaryTreeNode(34);
			BinaryTreeNode R1 = new BinaryTreeNode(55);
			BinaryTreeNode L1L = new BinaryTreeNode(22);
			BinaryTreeNode L1R = new BinaryTreeNode(13);
			BinaryTreeNode R1L= new BinaryTreeNode(77);
			BinaryTreeNode R1R = new BinaryTreeNode(45);
			BinaryTreeNode R2R = new BinaryTreeNode(5);
			root.setLeft(L1);
			root.setRight(R1);
			L1.setLeft(L1L);
			L1.setRight(L1R);
			R1.setLeft(R1L);
			R1.setRight(R1R);
			R1R.setRight(R2R);
		}
		//Proper Level-order traversal
			public ArrayList<Integer> level_order_traversal(BinaryTreeNode root)
			{
				ArrayList<Integer> result = new ArrayList<Integer>();
				Queue<BinaryTreeNode> q= new LinkedList<BinaryTreeNode>();
				BinaryTreeNode curr = root;
				q.add(curr);
				do
				{	curr=q.remove();
					result.add((curr.getData()));
					if(curr.getLeft()!=null)
					    q.add(curr.getLeft());
					if(curr.getRight()!=null)
					    q.add(curr.getRight());	
				}while(!q.isEmpty());
				return result;
			}
	// Reverse Level order Traversing
	   public ArrayList<Integer> reverse_traversal(BinaryTreeNode root)
	   {
		   ArrayList<Integer> array = new ArrayList<Integer>();
		   Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		   Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		   q.add(root);
		   BinaryTreeNode temp;
		   while(!q.isEmpty())
		   {
			   temp=q.remove();
			   s.push(temp);
			   if(temp.getRight()!=null)
				   q.add(temp.getRight());
			   if(temp.getLeft()!=null)
				   q.add(temp.getLeft());
		   }
		   while(!s.isEmpty())
			   array.add(s.pop().getData());
		   return array;
	   }

}
