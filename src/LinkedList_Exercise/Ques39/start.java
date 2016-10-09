package LinkedList_Exercise.Ques39;

public class start {
	public static void main(String[] args)
	{
		LinkedList list = new LinkedList();
		//LinkedList list1;
		Palidrome pal=new Palidrome();
		list.add(5);
		list.add(10);
		list.add(15);
		list.add(25);
		list.add(15);
		list.add(10);
		list.add(5);
		list.display();
		pal.checkPalidrome(list);
		
	}
}
