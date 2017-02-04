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
        //generate(Inorder);

    }
    private static void generate(int[] array)
    {
        ArrayList<Node> trees=new ArrayList<>();
        for(int pos=0;pos<array.length;pos++) {
          Set<Integer> visited=new HashSet<>();
          //  generateUtil(pos,pos-1,array.length-1, array,visited, trees);
            for(Node r: trees)
            {PreOrder(r);
                System.out.println();}
        }
    }
    private static Node generateUtil(int start, int end, int[] array,Set<Integer> visited,ArrayList<Node> trees)
    {
        if(end==start) {
            //visited
            return new Node(array[end]);
        }
        if(end>start||start<0||end>=array.length)
            return null;

        for(int i=start;i<=end;i++)
        {
            int element=array[i];
            if(visited.contains(element))
                continue;
            visited.add(element);
            //generateUtil(i,end,)
        }
return null;
    }
//    private static void generateUtil(int pos,int start, int end, int[] array,Set<Integer> visited,ArrayList<Node> trees)
//    {
//        if(pos<0||pos>=array.length)
//            return ;
//
//        while(start>=0&&start<pos)
//        {
//            Node root=new Node(pos);
//            root.left=new Node(array[start]);
//            visited.add(array[start]);
//            if(visited.size()==1)
//                trees.add(root);
//            generateUtil(pos-1,start+1,pos, array,visited, trees);
//            visited.remove(array[start]);
//            start++;
//        }
//
//        while(end<array.length&&end>pos)
//        {
//            Node root=new Node(pos);
//            root.right=new Node(array[end]);
//            visited.add(array[end]);
//            if(visited.size()==1)
//                trees.add(root);
//            generateUtil(pos+1,pos+1,end, array,visited, trees);
//            visited.remove(array[end]);
//            end--;
//        }
//    }
    private static void PreOrder(Node node)
    {
        if(node==null)
            return;
        System.out.print(node.data+" ");
        PreOrder(node.left);
        PreOrder(node.right);
    }
}
