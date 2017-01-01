package Revision;

/**
 * Created by Ritu on 12/22/16.
 */
public class Serialization_BinaryTree
{
    public static void main(String args[])
    {
        Node root= new Node ('A');
        root.left=new Node('B');
        root.right=new Node('C');
        root.right.right=new Node('F');
        root.left.left=new Node('D');
        root.left.right=new Node('E');
        root.left.right.left=new Node('G');
        StringBuilder str=new StringBuilder();

        System.out.print("\n The inorder traversal is ");
        Inorder(root);

        serialize_Tree(root,str);
        System.out.print("\n"+str.toString());

        Node node=deserialize_Tree(str.toString());
        System.out.print("\n The inorder traversal is ");
        Inorder(node);
    }
    private static void Inorder(Node root)
    {
        if(root==null)
            return;
        Inorder(root.left);
        System.out.print(root.data+" ");
        Inorder(root.right);
    }
    private static void serialize_Tree(Node root,StringBuilder str)
    {
        if(root==null)
            return ;
        str.append(root.data);
        if(root.left==null&&root.right==null)
            return;
        str.append('^');

        if(root.left==null)
            str.append('/');
        else
            serialize_Tree(root.left,str);

        if(root.right==null)
            str.append('/');
        else
            serialize_Tree(root.right,str);
    }
    static int pos=0;
    private static Node deserialize_Tree(String str)
    {
        if(pos>=str.length()||str.charAt(pos)=='/')
            return null;
        char c=str.charAt(pos);
        Node curr=new Node(c);
        if((pos+1)<str.length()&&str.charAt(pos+1)=='^') {
            pos=pos+2;
            curr.left = deserialize_Tree(str);
            ++pos;
            curr.right = deserialize_Tree(str);
        }

        return curr;
    }


}
