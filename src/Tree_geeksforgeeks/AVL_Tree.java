package Tree_geeksforgeeks;

/**
 * Created by Ritu on 1/10/17.
 * http://www.geeksforgeeks.org/avl-tree-set-1-insertion/
 * https://www.youtube.com/watch?v=rbg7Qf8GkQ4
 *  Runtime complexity to insert into AVL tree is O(logn).
 *
 *  There are four different use cases to insert into AVL tree
 * left left - needs ones right rotation
 * left right - needs one left and one right rotation
 * right left - needs one right and one left rotation
 * right right - needs one left rotation
 */
public class AVL_Tree
{
    static class Node
    {
        int data;
        Node left,right;
        int height;
        Node(int data)
        {
            this.data=data;
            height=1;
        }
    }
    public static void main(String args[])
    {
        Node root=new Node(12);
        int[] array={8,5,4,11,18,17};
        for(int i:array)
            root=insert(root,i);
        Inorder(root);
//        root.left=new Node(8);
//        root.left.left=new Node(5);
//        root.left.left.left=new Node(4);
//        root.left.right=new Node(11);
//        root.right=new Node(18);
//        root.right.left=new Node(17);
    }
    private static void Inorder(Node root)
    {
        if(root==null)
            return;
        Inorder(root.left);
        System.out.println(root.data+" ("+root.height+") ");
        Inorder(root.right);
    }
    private static Node insert(Node node, int data)
    {
        if(node==null)
            return new Node(data);

        if(node.data==data)
            return node;
        if(data<node.data)
            node.left=insert(node.left,data);
        else
            node.right=insert(node.right,data);
        int l_height=0,r_height=0;
        if(node.left==null)
            node.height=node.right.height+1;
        else if(node.right==null)
            node.height=node.left.height+1;
        else if(node.right.height>node.left.height)
            node.height=node.right.height+1;
        else
            node.height=node.left.height+1;

        if(Math.abs(getHeight(node.left)-getHeight(node.right))>2)
            node=check_balance(node);
//        if((node.left==null||node.right==null)&&node.height==2)
//            node= check_balance(node);
//        else if((Math.abs(node.left.height-node.right.height))>=2)
//            node=check_balance(node);
        return node;
    }
    private static Node check_balance(Node node)
    {
        int left_height=getHeight(node.left);
        int right_height=getHeight(node.right);
        if(Math.abs(left_height-right_height)<2)
            return node;
        if(left_height>right_height)
        {
            int  left_left_height=getHeight(node.left.left);
            int  left_right_height=getHeight(node.left.right);
            if(left_right_height>left_left_height)
            {
                Node temp1=node.left;

                Node temp2=node.left.right;
                temp1.right=null;
                node.left=temp2;
                temp2.left=temp1;
                temp2.height++;
                temp1.height--;
            }
            node=rotate_Clockwise(node);

        }
        else
        {
            int  right_left_height=getHeight(node.right.left);
            int  right_right_height=getHeight(node.right.right);
            if(right_left_height>right_right_height)
            {
                Node temp1=node.right;

                Node temp2=node.left.right;
                temp1.left=null;
                node.right=temp2;
                temp2.right=temp1;
                temp2.height++;
                temp1.height--;
            }
            node=rotate_AntiClockwise(node);
        }
        return node;
    }
    private static int getHeight(Node node)
    {
        if(node==null)
            return 0;
        if(node.left==null&&node.right==null)
            return 1;
        int l=getHeight(node.left);
        int r=getHeight(node.right);
        return l-r;
    }
    private static Node rotate_Clockwise(Node node)
    {
        Node new_Root=node.left;
        Node l=new_Root.right;
        new_Root.right=node;
        node.left=l;
        node.height=Math.abs(getHeight(node));
        return new_Root;
    }
    private static Node rotate_AntiClockwise(Node node)
    {
        Node new_Root=node.right;
        Node r=new_Root.left;
        new_Root.left=node;
        node.right=r;
        node.height=Math.abs(getHeight(node));
        return new_Root;
    }
}
