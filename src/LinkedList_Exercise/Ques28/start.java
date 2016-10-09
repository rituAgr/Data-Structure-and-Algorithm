package LinkedList_Exercise.Ques28;
//To find middle element of list
public class start {
	public static void main(String[] args)
	{
		LinkedList list = new LinkedList();
		list.add(5);
		list.add(10);
		list.add(15);
		list.add(20);
		list.add(25);
		list.add(30);
		list.add(35);
		list.add(40);
		list.add(45);
		System.out.println("The list is ");
		list.display();
		int middle = list.findMiddle();
		System.out.println("Middle of list is : "+middle);
	}
}
