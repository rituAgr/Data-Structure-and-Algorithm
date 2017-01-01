package Revision;

/**
 * Created by Ritu on 12/23/16.
 */
public class Morris_InOrder_Traversal
{
    public static void main(String args[])
    {
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(5);
        root.right=new TreeNode(30);
        root.right.right=new TreeNode(40);
        root.left.left=new TreeNode(-2);
        root.left.right=new TreeNode(6);
        root.left.right.right=new TreeNode(8);
        root.left.left.right=new TreeNode(2);
        root.left.left.right.left=new TreeNode(-1);
        System.out.print("The Inorder traversal recursively is \n");
        InOrder_Recursion(root);

        System.out.println("\nThe InOrder traversal by Morris way is ");
        InOrder_Morris(root);

        System.out.println("\nThe PreOrder traversal is ");
        PreOrder_Morris(root);
    }
    private static void InOrder_Recursion(TreeNode curr)
    {
        if(curr==null)
            return;
        InOrder_Recursion(curr.left);
        System.out.print(curr.data+" ");
        InOrder_Recursion(curr.right);
    }
    private static void InOrder_Morris(TreeNode curr)
    {
        while(curr!=null)
        {
           intloop: if(curr.left==null)
            {
                System.out.print(curr.data+" ");
                curr=curr.right;
            }
            else
            {
               TreeNode start=curr;
                curr=curr.left;
                while(curr.right!=null)
                {
                    if(curr.right==start)
                    {
                        curr.right=null;
                        curr=start;
                        System.out.print(curr.data+" ");
                        curr=curr.right;
                        break intloop;
                    }
                    curr=curr.right;
                }
                curr.right=start;
                curr=start.left;
            }
        }
    }

    private static void PreOrder_Morris(TreeNode curr)
    {
        while(curr!=null)
        {
            System.out.print(curr.data+" ");
            intloop: if(curr.left==null)
                curr=curr.right;
            else
            {
                TreeNode start=curr.right;
                while(curr.left!=null) {
                    if(curr.right!=null)
                        start=curr.right;
                    curr = curr.left;
                    System.out.print(curr.data + " ");
                }
                //TreeNode start=curr;
                curr=curr.left;
                while(curr.right!=null)
                {
                    if(curr.right==start)
                    {
                        curr.right=null;
                        curr=start;
                        System.out.print(curr.data+" ");
                        curr=curr.right;
                        break intloop;
                    }
                    curr=curr.right;
                }
                curr.right=start;
                curr=start.left;
            }
        }
    }
}
