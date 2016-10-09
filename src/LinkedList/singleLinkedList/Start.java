package LinkedList.singleLinkedList;

public class Start {
	public static void main(String args[])
	{
		LinkedList list= new LinkedList();
		ListNode node1 = new ListNode(5);
		ListNode node2 = new ListNode(10);
		ListNode node3 = new ListNode(15);
		list.insertAtBegin(node1);
		list.insertAtBegin(node2);
		list.insertAtBegin(node3);
		list.insertAtPosition(100,1);
		
		list.insertAtPosition(200,2);
		
		list.insertAtPosition(300,3);
		String output = list.traverse();
		System.out.println(output);
		list.removeMatchedNode(node3);
		output=list.traverse();
		System.out.println(output);
		list.remove(3);
		output=list.traverse();
		System.out.println(output);
	}

}
