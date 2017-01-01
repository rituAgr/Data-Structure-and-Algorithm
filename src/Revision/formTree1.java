package Revision;

/**
 * Created by Ritu on 12/21/16.
 * http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
 */
public class formTree1
{
    public static void main(String args[])
    {
        char InOrder[]={'D','B','E','A','F','C'};// D B E A F C
        char PreOrder[]={'A','B','D','E','C','F'};// A B D E C F
        Node root=MakeTree(InOrder,PreOrder);
        PostOrder(root);
    }
    private static Node MakeTree(char InOrder[],char PreOrder[])
    {
        if(InOrder.length==0||PreOrder.length==0)
            return null;
        Node curr=new Node(PreOrder[0]);
        int pos=-1;
        //getting the position of Inorder array
        for(int i=0;i<InOrder.length;i++)
            if(InOrder[i]==PreOrder[0])
            {
                pos=i;
                break;
            }
        char[] leftPreorder=new char[pos];
        System.arraycopy(PreOrder,1,leftPreorder,0,pos);
        int posright=PreOrder.length-1-pos;
        char[] rightPreorder=new char[posright];
        System.arraycopy(PreOrder,pos+1,rightPreorder,0,posright);

        char[] leftInorder=new char[pos];
        System.arraycopy(InOrder,0,leftInorder,0,pos);
        posright=InOrder.length-1-pos;
        char[] rightInorder=new char[posright];
        System.arraycopy(InOrder,pos+1,rightInorder,0,posright);

        //System.arraycopy(PreOrder,pos+1,rightPreorder,0,posright);
        curr.left=MakeTree(leftInorder,leftPreorder);
        curr.right=MakeTree(rightInorder,rightPreorder);
        return curr;
    }
    private static void PostOrder(Node curr)
    {
        if(curr==null)
            return;
        PostOrder(curr.left);
        PostOrder(curr.right);
        System.out.print(curr.data+"  ");
    }
}
class Node {
    char data;
    Node left, right;

    public Node(char item) {
        data = item;
        left = right = null;
    }
}
