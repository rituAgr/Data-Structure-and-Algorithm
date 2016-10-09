package Tree_geeksforgeeks;/*
 * http://www.geeksforgeeks.org/expression-tree/
 */
import java.util.Stack;

public class Construct_ExpressionTree {
	static class Node
	{
		char data;
		Node left,right;
		Node(char d)
		{
			data=d;
		}
	}
	public static void main(String[] args) {
		String postfix = "ab+ef*g*-";
		Node root=ExpressionTree(postfix.toCharArray());
		inorder(root);
	}
	public static Node ExpressionTree(char[] infix)
	{
		Stack<Character> st1= new Stack<Character>();
		Stack<Node> st2= new Stack<Node>();
		Node node=null,l,r;
		for(int i=0;i<infix.length;i++)
		{
			char c = infix[i];
			if(c=='+'||c=='-'||c=='*'||c=='/')
			{
				if(!st1.isEmpty())
					r=new Node(st1.pop());
				else
					r=st2.pop();
				if(!st1.isEmpty())
					l=new Node(st1.pop());
				else
					l=st2.pop();
				node=new Node(c);
				node.left=l;
				node.right=r;
				st2.push(node);
			}
			else
				st1.push(c);
		}
		return node;
	}
	public static void inorder(Node root)
	{
		if(root==null)
			return;
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
}
