package Tree_Excercise.Ques_60;

public class starter {
	public static void main(String[] args)
    {
	DoubleLinkedList list = new DoubleLinkedList();
	list.insertHead(27);
	list.insertHead(24);
	list.insertHead(20);
	list.insertHead(15);
	list.insertHead(10);
	list.insertHead(5);
	DLLNode head=list.getHead();
	BSTNode root = list.convert(head,6);
	list.inorder(root);
    }

}
