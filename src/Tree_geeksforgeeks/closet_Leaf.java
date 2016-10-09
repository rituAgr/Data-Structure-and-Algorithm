package Tree_geeksforgeeks;

/*
 * http://www.geeksforgeeks.org/find-closest-leaf-binary-tree/
 * http://www.geeksforgeeks.org/closest-leaf-to-a-given-node-in-binary-tree/
 */
public class closet_Leaf {
	static boolean isPresent=false;
	static class Node
	{
		int data;
		Node left, right;
		Node(int data)
		{
			this.data=data;
		}
	}
	static class Info
	{
		Node leaf;
		boolean found;
		int dis;
	}
	public static Info closetLeaf(Node root,int data)
	{
		if(root==null)
			return new Info() ;
		if(root.data==data)
			isPresent=true;
		Info ob_left=closetLeaf(root.left,data);
		Info ob_right=closetLeaf(root.right,data);
		Info ob=new Info();
		if(isPresent||ob_left.found||ob_right.found)
			ob.found=true;
		int dis=(ob_left.dis<ob_right.dis)?ob_left.dis:ob_right.dis;
		ob.dis=dis+1;
		if(isPresent)
		{
			if(ob.dis==1)
				ob.leaf=root;
			else if(dis==ob_left.dis)
				ob.leaf=ob_left.leaf;
			else
				ob.leaf=ob_right.leaf;
		}
		else
		{
			if(ob_left.found)
			{
				if(ob.dis>ob_left.dis+1)
					ob.leaf=ob_left.leaf;
			}
			else
			{
				if(ob.dis<ob_right.dis+1)
					ob.leaf=ob_right.leaf;
			}
		}
		if(ob.leaf==null)
			ob.leaf=root;
		if(root.data==data)
			isPresent=false;
		return ob;
	}
	public static void main(String[] args)
	{
		Node root = new Node(10);
		root.left = new Node(12);
		root.right = new Node(13);

		root.right.left = new Node(14);
		root.right.right = new Node(15);

		root.right.left.left = new Node(21);
		root.right.left.right = new Node(22);
		root.right.right.left = new Node(23);
		//root.right.right.right = new Node(24);

		root.right.left.left.left = new Node(1);
		root.right.left.left.right = new Node(2);
		root.right.left.right.left = new Node(3);
		root.right.left.right.right = new Node(4);
		//root.right.right.left.left = new Node(5);
		//root.right.right.left.right = new Node(6);
		//root.right.right.right.left = new Node(7);
		//root.right.right.right.right = new Node(8);	
		//Node node=closet_LeafNode(root,13);
		Info ob=closetLeaf(root,13);
		if(ob==null)
			System.out.println("Not found");
		else
			System.out.println(ob.leaf.data+" "+ob.dis);
	}
}








