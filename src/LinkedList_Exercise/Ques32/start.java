package LinkedList_Exercise.Ques32;

public class start {
	public static void main(String[] args)
	{
		//Creating and adding List 1 of 6 elements 
		LinkedList list1 = new LinkedList();
		list1.add(5);
		list1.add(10);
		list1.add(15);
		list1.add(20);
		list1.add(25);
		list1.add(30);
		list1.display();
		//Creating and adding List 2 of 7 elements
		LinkedList list2 = new LinkedList();
		list2.add(3);
		list2.add(6);
		list2.add(9);
		list2.add(12);
		list2.add(15);
		list2.add(18);
		list2.add(21);
		list2.display();
		//creating the third linked list for storing the merged Lists
		Merging ob=new Merging();
		LinkedList list3 = ob.sortedAndMerge(list1, list2);
		list3.display();
		
	}
}
