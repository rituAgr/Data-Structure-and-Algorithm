package Tree_geeksforgeeks;

public class RemoveNode {
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
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.left.left = new Node(7);
		root.right.right = new Node(6);
		root.right.right.left = new Node(8);
		remove(root,1,4);
		inorder(root);

	}
	static void inorder(Node root)
	{
		if(root==null)
			return;
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	public static boolean remove(Node root, int pos, int k)
	{
		if(root==null)
			return false;
		if(root.left==null&&root.right==null)
		{
			if(pos<k)
				return true;
			return false;
		}
		if(remove(root.left,pos+1,k))
			root.left=null;
		if(remove(root.right,pos+1,k))
			root.right=null;
		if(root.left==null&&root.right==null)
		{
			if((pos)<k)
				return true;
			return false;
		}
		return false;
	}
}
