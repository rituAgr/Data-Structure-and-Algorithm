package LinkedList.doubleLinkedList;

public class Start {
	public static void main(String args[])
	{
		DoubleLinkedList list= new DoubleLinkedList();
		DLLNode node1 = new DLLNode(5);
	//	DLLNode node2 = new DLLNode(10);
		//DLLNode node3 = new DLLNode(15);
		list.insertHead(5);
		list.insertHead(10);
		list.insertHead(15);
		
		list.insert(100,2);		
		list.insert(200,3);
		list.insert(300,3);
		
		String output = list.stringList();
		System.out.println(output);
		
		list.removeMatchedNode(node1);
		output = list.stringList();
		System.out.println(output);
		
		list.remove(3);
		output = list.stringList();
		System.out.println(output);
	}

}
