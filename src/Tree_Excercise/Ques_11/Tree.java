package Tree_Excercise.Ques_11;
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
	//Calculate the max height of binary tree iteratively using stack
	 public int maxHeight(BinaryTreeNode root)
	{
		 if(root==null)
			 return 0;
		 int max=0;
		 BinaryTreeNode prev,curr;
		 prev=null;
		 Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		 s.push(root);
		 while(!s.isEmpty())
		 {
			curr=s.peek(); 
			if(prev==null||prev.getLeft()==curr||prev.getRight()==curr)
			{
				if(curr.getLeft()!=null)
					s.push(curr.getLeft());
				else if(curr.getRight()!=null)
					s.push(curr.getRight());
			}
			else if(curr.getLeft()==prev)
			{
				if(curr.getRight()!=null)
					s.push(curr.getRight());	
			}
			else
				s.pop();
			prev=curr;
			if(max<s.size())
				max=s.size();
		 }
		return max;
	}
	//Calculate the min height of binary tree iteratively using stack
		 public int minHeight(BinaryTreeNode root)
		{
			 if(root==null)
				 return 0;
			 int min=Integer.MAX_VALUE;
			 BinaryTreeNode prev,curr;
			 prev=null;
			 Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
			 s.push(root);
			 while(!s.isEmpty())
			 {
				curr=s.peek(); 
				if(prev==null||prev.getLeft()==curr||prev.getRight()==curr)
				{
					if(curr.getLeft()!=null)
						s.push(curr.getLeft());
					else if(curr.getRight()!=null)
						s.push(curr.getRight());
					if(min>s.size()&&curr.getLeft()==null&&curr.getRight()==null)
						min=s.size();
				}
				else if(curr.getLeft()==prev)
				{
					if(curr.getRight()!=null)
						s.push(curr.getRight());	
					if(min>s.size()&&curr.getLeft()==null&&curr.getRight()==null)
						min=s.size();
				}
				else
					s.pop();
				prev=curr;	
			 }
			return min;
		}
}
