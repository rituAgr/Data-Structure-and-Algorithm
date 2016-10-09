package Tree_Excercise.Ques_27;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class Tree {
	public  void formTree(BinaryTreeNode root)
	{
		
		BinaryTreeNode L1 = new BinaryTreeNode(34);
		BinaryTreeNode R1 = new BinaryTreeNode(55);
		BinaryTreeNode L1L = new BinaryTreeNode(22);
		BinaryTreeNode L1R = new BinaryTreeNode(13);
		BinaryTreeNode R1L= new BinaryTreeNode(77);
		BinaryTreeNode R1R = new BinaryTreeNode(45);
		BinaryTreeNode R2R = new BinaryTreeNode(5);
		BinaryTreeNode R3R = new BinaryTreeNode(105);
		root.setLeft(L1);
		root.setRight(R1);
		L1.setLeft(L1L);
		L1.setRight(L1R);
		R1.setLeft(R1L);
		R1.setRight(R1R);
		R1R.setRight(R2R);
		R2R.setRight(R3R);
	}
	// Ques 27 Mirror image convertion
	public void mirror_image(BinaryTreeNode root)
	{
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.add(root);
		BinaryTreeNode curr = null;
		while(!q.isEmpty())
		{
			curr = q.poll();
			BinaryTreeNode temp = curr.getLeft();
			curr.setLeft(curr.getRight());
			curr.setRight(temp);
			if(curr.getLeft()!=null)
				q.add(curr.getLeft());
			if(curr.getRight()!=null)
				q.add(curr.getRight());
		}
	}
	//Ques 27 Mirror image converIIKtion through recursion
	public void mirror_recur(BinaryTreeNode root)
	{
	if(root==null)
		return;
	BinaryTreeNode l=root.getLeft();
	BinaryTreeNode r=root.getRight();
	root.setLeft(r);
	root.setRight(l);
	mirror_recur(root.getLeft());
	mirror_recur(root.getRight());
	}
	//level order traversal
	public void Level_order(BinaryTreeNode root)
	 {
		 if(root==null)
			 return;
		 Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		 q.add(root);
		 BinaryTreeNode curr=null;
		 while(!q.isEmpty())
		 {
			curr=q.poll();
			System.out.print(curr.getData()+" ");
			if(curr.getLeft()!=null)
				q.add(curr.getLeft());
			if(curr.getRight()!=null)
				q.add(curr.getRight());
		 }
	 }
	//preorder
	public void PreOrder(BinaryTreeNode root)
	{
		
		if(root==null)
			return;
		Stack<BinaryTreeNode> s= new Stack<BinaryTreeNode>();
		s.push(root);
		while(s.isEmpty()==false)
		{
		BinaryTreeNode temp = s.pop();
		System.out.print(temp.getData()+" ");
		if(temp.getRight()!=null)
			s.push(temp.getRight());
		if(temp.getLeft()!=null)
			s.push(temp.getLeft());		
		}		
	}	
}
