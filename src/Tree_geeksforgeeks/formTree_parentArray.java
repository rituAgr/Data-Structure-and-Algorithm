package Tree_geeksforgeeks;

/**
 * Created by Ritu on 4/23/17.
 * http://www.geeksforgeeks.org/construct-a-binary-tree-from-parent-array-representation/
 * Time complexity = O(n)
 Space complexity = O(n)
 */
public class formTree_parentArray
{
    static class Node
    {
        int data;
        Node left;
        Node right;
        Node(int d)
        {
            data=d;
            left=null;
            right=null;
        }
    }
    public static void main(String[] args)
    {
        int parent[] = new int[]{1, 5, 5, 2, 2, -1, 3};//{-1, 0, 0, 1, 1, 3, 5};
        Node root=formTree(parent);
        inorder(root);

    }
    private static void inorder(Node curr)
    {
        if(curr==null)
            return ;
        inorder(curr.left);
        System.out.print("  "+curr.data);
        inorder(curr.right);
    }
    private static Node formTree(int[] parent)
    {
        Node root=null;
        int n=parent.length;
        Node arr[]=new Node[n];

        for(int i=0;i<n;i++)
            arr[i]=new Node(i);

        for(int k=0;k<n;k++)
        {
            int p=parent[k];
            if(p==-1)
            {
                root=arr[k];
                continue;
            }
            if(arr[p].left==null)
                arr[p].left=arr[k];
            else if(arr[p].right==null)
                arr[p].right=arr[k];
        }
        return root;
    }
}
