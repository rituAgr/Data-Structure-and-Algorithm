package Tree_geeksforgeeks;

/*
 * http://www.geeksforgeeks.org/given-a-binary-tree-how-do-you-remove-all-the-half-nodes/
 */
public class Remove_HalfNodes {
	static class Node
	{
		int data;
		Node left, right;
		Node(int data)
		{
			this.data=data;
		}
	}
	public static void main(String[] args) {
		Node root = new Node(2);
		root.left = new Node(7);
		root.right = new Node(5);
		root.left.right = new Node(6);
		root.left.right.left = new Node(1);
		root.left.right.right = new Node(11);
		root.right.right = new Node(9);
		root.right.right.left = new Node(4);
		RemoveHalfNodes(root);
		inorder(root);		
	}
	public static void inorder(Node root)
	{
		if(root==null)
			return;
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	public static Node RemoveHalfNodes(Node root)
	{
		if(root==null)
			return null;
		if(root.left==null&&root.right==null)
			return root;
		root.left=RemoveHalfNodes(root.left);
		root.right=RemoveHalfNodes(root.right);
		if(root.left!=null&&root.right!=null)
			return root;
		if(root.left==null&&root.right==null)
			return root;
		if(root.left==null)
			return root.right;
		return root.left;
	}

}
