package Tree_geeksforgeeks;

/*
 * http://www.geeksforgeeks.org/find-count-of-singly-subtrees/
 */
public class Count_SinglrValuedSubTree {
	static class Node 
	{
		int data;
		Node left, right;
		public Node(int item) 
		{
			data = item;
		}
	}
	static class Count 
	{
		int count;
		Count(int c)
		{
			count=c;
		}
	}
	public static void main(String[] args) {
		/* Let us construct the below tree
        5
      /   \
    4      5
  /  \      \
 4    4      5 */
		Node root = new Node(5);
		root.left = new Node(4);
		root.right = new Node(5);
		root.left.left = new Node(4);
		root.left.right = new Node(4);
		root.right.right = new Node(5);
		Count c= new Count(0);
		counting(root,c);
		System.out.println("The number is singly subtree is "+c.count);
	}
	static boolean counting(Node root, Count c)
	{
		if(root==null)
			return true;
		boolean l = counting(root.left,c);
		boolean r = counting(root.right,c);
		if(l==false||r==false)
			return false;
		if(root.left!=null&&root.data!=root.left.data)
			return false;
		if(root.right!=null&&root.data!=root.right.data)
			return false;
		c.count++;
		return true;
	}
}
