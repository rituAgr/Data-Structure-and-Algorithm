package Tree_Excercise.Ques_15;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Tree {
	// Forming the tree
	public  BinaryTreeNode formTree(BinaryTreeNode root)
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
		return R1L;
	}
	
	//Getting the last node
	public int lastNode(BinaryTreeNode root)
	 {
 
		 Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		 HashMap<BinaryTreeNode,BinaryTreeNode> map = new HashMap<BinaryTreeNode,BinaryTreeNode>();
		 map.put(root,null);
		 q.add(root);
		 BinaryTreeNode curr=null;
		 while(!q.isEmpty())
		 {
			curr=q.remove();
			if(curr.getLeft()!=null)
				{
				q.add(curr.getLeft());
				map.put(curr.getLeft(),curr);
				}
			if(curr.getRight()!=null)
				{
				q.add(curr.getRight());
				map.put(curr.getRight(),curr);
				}
		 }
		 int data = curr.getData();
		 BinaryTreeNode temp = map.get(curr);
		 if(temp.getLeft()==curr)
			 temp.setLeft(null);
		 else
			 temp.setRight(null);
		 return data;
	 }
		
	//Finding and repalcing the node and replacing 
	public boolean replace(BinaryTreeNode root, BinaryTreeNode node)
	{
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.add(root);
		BinaryTreeNode curr;
		while(!q.isEmpty())
		{
			curr=q.remove();
			if(curr.getData()==node.getData())
			{
				int temp = lastNode(root);
				curr.setData(temp);
				return true;
			}
			if(curr.getLeft()!=null)
				q.add(curr.getLeft());
			if(curr.getRight()!=null)
				q.add(curr.getRight());
			
		}
		return false;
	}
	// Level order traversal
	public void level_order(BinaryTreeNode root)
	 {
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

}
