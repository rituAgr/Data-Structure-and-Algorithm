package LinkedList_Exercise.Ques47;

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
		list.display();
		System.out.println("The Last matched n%K number is "+list.findLastModule(2));
		
	}
}
