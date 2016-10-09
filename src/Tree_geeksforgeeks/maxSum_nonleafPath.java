package Tree_geeksforgeeks;

/*
 * http://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
 */
public class maxSum_nonleafPath {
	static int res=0;
	static class Node
	{
		int data;
		Node left,right;
		Node(int d)
		{
			data=d;
		}
	}
	public static void main(String[] args) 
	{
		Node root= new Node(10);
		root.left        = new Node(2);
		root.right       = new Node(10);
		root.left.left  = new Node(20);
		root.left.right = new Node(1);
		root.right.right = new Node(-25);
		root.right.right.left   = new Node(3);
		root.right.right.right  = new Node(4);
		getSum(root);
		System.out.println(res);
	}
	public static int getSum(Node root)
	{
		if(root==null)
			return 0;
		int l=getSum(root.left);
		int r= getSum(root.right);
		int val=root.data;
		int num_max= Math.max(val,Math.max(l+val, r+val));
		if(num_max==val&&res<num_max)
			res=val;
		if(num_max==val+r&&l>=0&&res<num_max)
			res=num_max+l;
		if(num_max==val+l&&r>=0&&res<num_max)
			res=num_max+r;
		return num_max;
	}

}
