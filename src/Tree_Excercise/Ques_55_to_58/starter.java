package Tree_Excercise.Ques_55_to_58;

public class starter {
	public static void main(String[] args)
    {
        
		BSTNode root= new BSTNode(10);
		Tree t= new Tree();
        t.formTree(root);
        boolean check=t.check(root);
        System.out.print("\n Is the Tree BST :"+check);
         check=t.better_check(root);
        System.out.print("\n Is the Tree BST :"+check);
        check=t.best_check(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
        System.out.print("\n Is the Tree BST :"+check);
        check=t.bestOfbest_check(root);
        System.out.print("\n The best technique:\n \t Is the Tree BST :"+check);
    }

}
