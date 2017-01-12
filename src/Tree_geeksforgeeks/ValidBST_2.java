package Tree_geeksforgeeks;

/**
 * Created by Ritu on 1/3/17.
 * http://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
 */
public class ValidBST_2 {
    public static void main(String args[])
    {
        // Node tree = new Node();
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        boolean status=Check_Validity(root);
        System.out.print(status);
    }
    static boolean  Check_Validity(Node root)
    {
        if(root==null)
            return false;
        return Check_ValidityUtil(root,Integer.MIN_VALUE,Integer.MAX_VALUE);

    }
    static boolean Check_ValidityUtil(Node root, int min, int max)
    {
        if(root==null)
            return true;
        if(!(root.data>=min&&root.data<=max))
            return false;

        boolean s1=Check_ValidityUtil(root.left,min,root.data);
        boolean s2=Check_ValidityUtil(root.right,root.data,max);
        return s1&&s2;
    }
}
