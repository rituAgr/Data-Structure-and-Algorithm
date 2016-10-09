package Tree_geeksforgeeks;/*
 * http://www.geeksforgeeks.org/diagonal-sum-binary-tree/
 */
import java.util.TreeMap;
public class Diagonal_Sum {

	static class Node
	{
		int data;
		Node left, right;
		Node(int data)
		{
			this.data=data;
		}
	}
	public static void main(String[] args) 
	{
		Node root = new Node(1);	
		root.right = new Node(3);
		root.right.right = new Node(5);
		
		root.left = new Node(2);
		root.left.right = new Node(6);
		root.right.left = new Node(4);
		root.right.left.right=new Node(7);
		
		root.left.left=new Node(9);
		root.left.left.right = new Node(10);
		root.left.right.left = new Node(11);
		root.right.left.left=new Node(12);
		TreeMap<Integer,Integer> tm=new TreeMap<Integer,Integer>();
		DiagonalSum(tm,root,1);
		for(Integer key: tm.keySet())
			System.out.println("The sum at diagonal "+key+" is "+tm.get(key));
	}
	static void DiagonalSum(TreeMap<Integer,Integer> tm,Node root, int pos)
	{
		if(root==null)
			return;
		if(tm.containsKey(pos))
		{
			int val=tm.get(pos);
			tm.put(pos, val+root.data);
		}
		else
			tm.put(pos, root.data);
		DiagonalSum(tm,root.right,pos);
		DiagonalSum(tm,root.left,pos+1);
	}
}
