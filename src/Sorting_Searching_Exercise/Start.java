package Sorting_Searching_Exercise;

public class Start {
	public static void main(String args[])
	{
		LinkedList list= new LinkedList();
		ListNode node1 = new ListNode(15);
		ListNode node2 = new ListNode(12);
		ListNode node3 = new ListNode(18);
		ListNode node4 = new ListNode(28);
		ListNode node5 = new ListNode(38);
		ListNode node6 = new ListNode(8);
		list.insertAtEnd(node1);
		list.insertAtEnd(node2);
		list.insertAtEnd(node3);
		list.insertAtEnd(node4);
		list.insertAtEnd(node5);
		list.insertAtEnd(node6);
		String output=list.traverse(node1);
		System.out.println(output);
		System.out.println("After Sorting the data, The data became as follows - ");
		ListNode start=list.merge_sort(node1);
		output=list.traverse(start);
		System.out.println(output);
	}

}
