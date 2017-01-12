package Binary_tree;

/**
 * Created by Ritu on 1/5/17.
 * http://www.geeksforgeeks.org/add-greater-values-every-node-given-bst/
 */
public class Amazon_BST
{
    public static void main(String args[])
    {
        Node root=new Node(50);
        root.left=new Node(30);
        root.right=new Node(70);
        root.left.left=new Node(20);
        root.left.right=new Node(40);
        root.right.left=new Node(60);
        root.right.right=new Node(80);
        Inorder(root);
        System.out.println("\n After change");
        makeChange(root,0);
        Inorder(root);
    }
    private static int makeChange(Node node,int s)
    {
        if(node==null)
            return s;
        int sum=makeChange(node.right,s);
        sum=sum+node.data;
        node.data=sum;
        sum=makeChange(node.left,sum);
        return sum;
    }
    private static void Inorder(Node node)
    {
       if(node==null)
           return;
        Inorder(node.left);
        System.out.print(node.data+" ");
        Inorder(node.right);
    }
}
class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
    }
}
