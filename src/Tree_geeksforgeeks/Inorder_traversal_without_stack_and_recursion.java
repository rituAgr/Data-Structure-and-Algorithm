package Tree_geeksforgeeks;

/*
 * http://www.geeksforgeeks.org/inorder-non-threaded-binary-tree-traversal-without-recursion-or-stack/
 */
public class Inorder_traversal_without_stack_and_recursion
{
	static class Node
	{
		int data;
		Node left, right,parent;
		Node(Node node,int data)
		{
			parent=node;
			this.data=data;
		}
	}
	public static void main(String[] args)
	{
		Node root = new Node(null,10);
		root.left = new Node(root,5);
		root.right = new Node(root,100);
		root.left.right = new Node(root.left,15);
		root.right.left = new Node(root.right,80);
		root.right.right = new Node(root.right,120);
		root.right.left.left=new Node(root.right.left,200);
		root.right.left.right=new Node(root.right.left,300);
		inorder(root);
	}
	public static void inorder(Node root) 
	{
		boolean leftDone=false;
		Node node=root;
		while(node!=null)
		{
			if(!leftDone)
			{
				while(node.left!=null)
					node=node.left;
			}
			System.out.print(node.data+" ");
			leftDone=true;
			if(node.right!=null)
			{
				node=node.right;
				leftDone=false;
			}
			else if(node.parent!=null)
			{
				while(node.parent!=null&&node==node.parent.right)
					node=node.parent;
				node=node.parent;				
			}
			else
				break;
		}
	}
}
