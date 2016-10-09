package LinkedList_Exercise.Ques9;
//To check if th given Linked List has a loop or not?
public class start {
	public static void main(String[] args)
	{
		LinkedList list = new LinkedList();
		list.add(5);
		list.add(10);
		list.add(15);
		list.add(20);
		list.add(25);
		System.out.println("Is the LinkedList a loop "+list.isLoop());
		list.add(30);
		System.out.println("Is the LinkedList a loop "+list.isLoop());
		list.add(35);
		System.out.println("Is the LinkedList a loop "+list.isLoop());
		list.add(40);
		list.add(45);
		list.add(50);
		System.out.println("Is the LinkedList a loop "+list.isLoop());
	}
}
