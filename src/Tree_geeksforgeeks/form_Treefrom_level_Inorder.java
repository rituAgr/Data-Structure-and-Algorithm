package Tree_geeksforgeeks;

public class form_Treefrom_level_Inorder {
	static class Node
	{
		int data;
		Node left,right;
		Node(int d)
		{
			data=d;
		}
	}
	public static void main(String[] args) {
		int in[] = {4, 8, 10, 12, 14, 20, 22};
		int level[] = {20, 8, 22, 4, 12, 10, 14};
		Node root=form_tree(in,level,0);
		print_PostOrder(root);
	}
	static Node form_tree(int[] in,int[] level, int pos)
	{
		if(pos>=level.length)
			return null;
		int number=level[pos];
		Node node=new Node(number);
		int index=find_index(in,number);
		if(index==-1)
			return null;
		int[] inorder1=new int[index];
		System.arraycopy(in, 0, inorder1, 0, index);
		node.left=form_tree(inorder1,level,pos+1);
		if(index==in.length-1)
			return node;
		int[] inorder2=new int[level.length-index];
		System.arraycopy(in, index+1, inorder2, 0, level.length-index-1);
	
		node.right=form_tree(inorder2,level,pos+2);
		return node;
	}
	static int find_index(int[] inorder, int num)
	{
		for(int i=0;i<inorder.length;i++)
			if(inorder[i]==num)
				return i;
		return -1;
	}
	static void print_PostOrder(Node root)
	{
		if(root==null)
			return;
		print_PostOrder(root.left);
		print_PostOrder(root.right);
		System.out.println(root.data);
	}
}
