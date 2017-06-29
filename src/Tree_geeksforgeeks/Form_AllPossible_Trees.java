package Tree_geeksforgeeks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ritu on 2/3/17.
 */
public class Form_AllPossible_Trees {
    public static void main(String[] args)
    {
        int[] Inorder={4, 5, 7};
        generate(Inorder);

    }
    private static void generate(int[] array)
    {
        int l=array.length;
        ArrayList<Node> trees=new ArrayList<Node>();
        for(int i=0;i<l;i++)
        {
            generateUtil(0,i-1,i+1,l,i,array,trees,true);
                for(Node node: trees)
                {
                    preOrder(node);
                    System.out.println();
                }
                trees.clear();

        }

    }
    private static void preOrder(Node root)
    {
        if(root==null)
            return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    private static Node generateUtil(int start1, int end1,int start2, int end2,int pos, int[] array,ArrayList<Node> trees, boolean isroot)
    {
        if(start1>end1&&start2>end2)
            return null;
        int l=array.length;
        //if(start1<0||start2<0||end1>=array.length||end2>=array.length)
        if(pos<0||pos>=l)
            return null;
        if(end2==start2&&end1>start1&&end2<l&&start2>=0)
            return new Node(array[end2]);
        if(end1==start1&&end2>start2&&end1<l&&start1>=0)
            return new Node(array[end1]);

          for(int k1=start1;k1<=end1;k1++) {
              for (int k2 = start2; k2 <= end2; k2++) {
                  Node root = new Node(array[pos]);
                  root.left = generateUtil(start1,k1-1, start2, k1-1, k1, array, trees, false);
                  root.right = generateUtil(k2+1, end1, k2+1, end2, k2, array, trees, false);
                  if (isroot)
                      trees.add(root);
              }
          }
          return null;
    }
}
