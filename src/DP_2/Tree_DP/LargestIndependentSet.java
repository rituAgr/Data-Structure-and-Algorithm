package DP_2.Tree_DP;

/**
 * Created by Ritu on 3/5/17.
 * http://www.geeksforgeeks.org/largest-independent-set-problem/
 * This recursion calculates the LLIS of each node just one time;
 * Other time it just looks up so;
 * Time complexity : O(n)
 */
public class LargestIndependentSet
{
    static class Node
    {
        int data;
        Node left,right;
        int llis;
        Node(int data)
        {
            this.data=data;
            left=null;
            right=null;
            llis=0;
        }
    }
    public static void main(String[] args)
    {
        Node root                 = new Node(20);
        root.left                 = new Node(8);
        root.left.left          = new Node(4);
        root.left.right         = new Node(12);
        root.left.right.left   = new Node(10);
        root.left.right.right  = new Node(14);
        root.right               = new Node(22);
        root.right.right        = new Node(25);
        System.out.println(getLLIS(root));
    }
    private static int getLLIS(Node root)
    {
        if(root==null)
            return 0;
        if(root.llis!=0)
            return root.llis;
        int inclusive_LLIS=1;
        if(root.left!=null)
            inclusive_LLIS+=getLLIS(root.left.left)+getLLIS(root.left.right);
        if(root.right!=null)
            inclusive_LLIS+=getLLIS(root.right.left)+getLLIS(root.right.right);
        int exclusive_LLIS=getLLIS(root.left)+getLLIS(root.right);
        int val= Math.max(inclusive_LLIS,exclusive_LLIS);
        root.llis=val;
        return val;
    }
}
