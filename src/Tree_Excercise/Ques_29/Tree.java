package Tree_Excercise.Ques_29;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
	static int prestart=0;
	
// constructing tree from inorder and preorder
  /* public BinaryTreeNode contruct_Tree(char inorder[],int instart, int inend, char preorder[],int prestart,int preend)
   {
	   if(instart>inend||prestart>preend)
		   return null;
	   BinaryTreeNode temp = new BinaryTreeNode(preorder[prestart]);
	   int k=0;
	   for(int i=instart;i<=inend;i++)
	   {
		   if(temp.getData()==inorder[i])
		   { k=i;
			   break;}
	   }
	   BinaryTreeNode l=contruct_Tree(inorder,instart, k-1, preorder,prestart+1,prestart+(k-instart));
	   if(l!=null)
		      temp.setLeft(l);
	   BinaryTreeNode r=contruct_Tree(inorder,k+1, inend, preorder,prestart+(k-instart)+1,preend);
	   if(r!=null)
	      temp.setRight(r);
	   return temp;
   }*/
	
	// constructing tree from inorder and preorder
	public BinaryTreeNode contruct_Tree(char inorder[],int instart, int inend, char preorder[])
	   {
		   if(instart>inend)
			   return null;
		   char data = preorder[prestart++];
		   BinaryTreeNode node = new BinaryTreeNode(data);
			if(inend==instart)
				return node;
		   int pos=Integer.MIN_VALUE;
		   for(int i= instart; i<=inend;i++)
			   if(inorder[i]==data)
			   {
				   pos=i;
				   break;
			   }
		   node.setLeft(contruct_Tree(inorder,instart, pos-1,preorder));
		   node.setRight(contruct_Tree(inorder, pos+1, inend,preorder));
		   return node;
	   }
	
	
	
	static int postend=5;
// constructing tree from inorder and postorder
   public BinaryTreeNode contruct_Tree1(char inorder[],int instart, int inend, char postorder[])
   {
	   if(instart>inend||postend<0)
		   return null;
	   BinaryTreeNode temp = new BinaryTreeNode(postorder[postend]);
	   postend--;
	   int k=0;
	   for(int i=instart;i<=inend;i++)
	   {
		   if(temp.getData()==inorder[i])
		   { k=i;
			   break;}
	   }
// Here we assigning the right node to root; then left node because in postorder as we move from back;
// firstly, the right node come; and then comes the left node	   
	   temp.setRight(contruct_Tree1(inorder,k+1, inend, postorder));
	   temp.setLeft(contruct_Tree1(inorder,instart, k-1, postorder));
	   return temp;
   }
 //Proper Level-order traversal
	public void level_order_traversal(BinaryTreeNode root)
	{
		Queue<BinaryTreeNode> q= new LinkedList<BinaryTreeNode>();
		BinaryTreeNode curr = root;
		q.add(curr);
		do
		{	curr=q.remove();
		System.out.print(curr.getData()+" ");
			if(curr.getLeft()!=null)
			    q.add(curr.getLeft());
			if(curr.getRight()!=null)
			    q.add(curr.getRight());	
		}while(!q.isEmpty());
	}
	// postorder
	public void PostOrder(BinaryTreeNode root)
	{
		if(root!=null)
		{	
		PostOrder(root.getLeft());
		PostOrder(root.getRight());
		System.out.print(root.getData()+" ");
		}
		
	}
}
