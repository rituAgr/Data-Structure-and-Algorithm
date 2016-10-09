package Tree_Excercise.Ques_59;

public class starter {
	public static void main(String[] args)
    {
        
		BSTNode root= new BSTNode(10);
		Tree t= new Tree();
        t.formTree(root);
        DLLNode head=t.TreetoList(root);
        DLLNode curr=head;
        while(curr.getNext()!=head)
        {
        	System.out.print(curr.getData()+"  ");
        	curr=curr.getNext();
        }
        System.out.print(curr.getData()+"  ");
    }

}
