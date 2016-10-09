package Tree_Excercise.Ques_63;

public class starter {
	public static void main(String[] args)
    {
	LinkedList list = new LinkedList();
	list.insertHead(27);
	list.insertHead(24);
	list.insertHead(20);
	list.insertHead(15);
	list.insertHead(10);
	list.insertHead(5);
	list.traverse();
	BSTNode root = list.convert(0,5);
	list.inOrder(root);
    }

}
