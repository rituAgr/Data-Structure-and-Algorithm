package Revision;

/**
 * Created by Ritu on 12/20/16.
 * Revision
 * http://www.geeksforgeeks.org/diameter-of-a-binary-tree/
 */
public class DiameterOfTree {
    static int MaxDia=0;
    public static void main(String args[]) {
        /*
                1
               / \
              2   3
             / \
            4  5
           /    \
         16      6
        /         \
      17           7
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.left.right.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(16);
        root.left.left.left.left = new TreeNode(17);
        diameterOfTree(root);
        System.out.println(MaxDia);
    }
    private static int diameterOfTree(TreeNode curr)
    {
        if(curr==null)
            return 0;
        if(curr.left==null&&curr.right==null)
            return 1;
        int left_height=diameterOfTree(curr.left);
        int right_height=diameterOfTree(curr.right);
        int combined_dia=left_height+right_height+1;
        if(MaxDia<combined_dia)
            MaxDia=combined_dia;
        if(right_height>left_height)
            return right_height+1;
        else
            return left_height+1;
    }
}

class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int item) {
        data = item;
        left = right = null;
    }
}


