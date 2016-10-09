package Binary_tree.BST;

public class starter {
	public static void main(String[] args)
	{
		BSTNode root= new BSTNode(10);
		BST t= new BST();
        t.formTree(root);
        t.level_order_traversal(root);
        boolean check=t.recur_find(root, 14);
        System.out.println("\nRecursively: The element is found :"+check);
        check=t.iter_find(root, 14);
        System.out.println("Iterativelyly: The element is found :"+check);
        int max=t.max(root);
        System.out.println("Recursively: The max element is:"+max);
        max=t.iter_max(root);
        System.out.println("Iterativelyly: The max element is:"+max);
        int min=t.min(root);
        System.out.println("Recursively: The max element is:"+min);
        min=t.iter_min(root);
        System.out.println("Iterativelyly: The max element is:"+min);
       // t.insert(root, 8);
       // t.level_order_traversal(root);
        System.out.println("After deletion");
        t.delete(root,34);
        t.level_order_traversal(root);
	}

}
