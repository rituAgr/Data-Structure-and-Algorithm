package Tree_Excercise.Ques_52;

public class starter {
    public static void main(String[] args)
    {
        
		BSTNode root= new BSTNode(10);
		Tree t= new Tree();
        t.formTree(root);
       /*t.level_order_traversal(root);
     //   ArrayList<Integer> array=t.route(root,4, 7);
        System.out.print("The route is :\n");
        for(int i : array)
        	System.out.print(i+" -> ");
        int node=t.LCA(root, 4, 9);
        System.out.print("\n The LCA is"+node);*/
        boolean check=t.check(root);
        System.out.print("\n Is the Tree BST :"+check);
    }

}
