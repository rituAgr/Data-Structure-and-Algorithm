package Tree_geeksforgeeks;

import java.util.*;
public class get_height {
	static class Node
	{
		Node left,right;
		int data;
		Node(int d)
		{
			data=d;
		}
	}

	public static void main(String[] args) {
		int[] parents={1, 5, 5, 2, 2, -1, 3};//{-1,0,0,1,1,3,5};//
		Node root=formTree(parents);
		int h=find_Height(root);
		System.out.println("Method 1: \n The height of tree is "+h);
		h=directly_getHeight(parents);
		System.out.println("Method 2: \n The height of tree is "+h);
	}
	//Method1:
	static Node formTree(int[] parents)
	{
		Node root=null;
		HashMap<Integer,Node> hm= new HashMap<Integer,Node>();
		for(int i=0;i<parents.length;i++)
		{
			Node parent,child;
			if(hm.containsKey(parents[i]))
				parent=hm.get(parents[i]);
			else
			{
				parent=new Node(parents[i]);
				hm.put(parents[i], parent);
			}
			if(hm.containsKey(i))
				child=hm.get(i);
			else
			{
				child=new Node(i);
				hm.put(i, child);
			}
			if(parents[i]==-1)
				root=child;
			if(parent.left==null)
				parent.left=child;
			else
				parent.right=child;
		}
		return root;
	}
	static int find_Height(Node root)
	{
		if(root==null)
			return 0;
		if(root.left==null&&root.right==null)
			return 1;
		int l=find_Height(root.left);
		int r=find_Height(root.right);
		if(l>r)
			return l+1;
		return r+1;
	}
	//Method 2:
	static int directly_getHeight(int[] parents)
	{
		int l=parents.length;
		int heights[]=new int[l];
		Arrays.fill(heights, 0);
		int start=getIndex(-1, parents);
		int max_height=0;
		int count=0;
		int i=start;
		while(count<l)
		{		 
			int parent_pos=i;
			int child_pos=parents[i];
			if(parent_pos==-1)
				{
				heights[child_pos]=1;	
				count++;
				i=getIndex(child_pos,parents);
				continue;
				}
			else if(heights[child_pos]==0&&heights[parent_pos]==0)
			{
				heights[child_pos]=1;
				heights[parent_pos]=heights[child_pos]+1;
			}
			else
			{if(heights[child_pos]>heights[parent_pos])
				heights[parent_pos]=heights[child_pos]+1;
			else
				heights[child_pos]=heights[parent_pos]-1;}
			if(max_height<heights[parent_pos])
				max_height=heights[parent_pos];
			count++;
			i=getIndex(child_pos,parents);
		}
		return max_height;
	}
	static int getIndex(int n, int[] parents)
	{
		for(int i=0;i<parents.length;i++)
			if(parents[i]==n)
				return i;
		return -1;
	}
}
