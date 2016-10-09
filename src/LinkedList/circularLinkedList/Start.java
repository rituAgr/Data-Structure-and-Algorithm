package LinkedList.circularLinkedList;

public class Start {
	public static void main(String args[])
	{
		String output;
		CircularLinkedList list= new CircularLinkedList();
		
		list.add(5);
		list.add(10);
		list.add(15);
		System.out.println("The lengthof list is "+list.returnLength());
		output = list.toString();
		System.out.println("*****************");
		System.out.println(output);
		list.addToTail(100);
		output = list.toString();
		System.out.println(output);
		list.addToTail(200);
		output = list.toString();
		System.out.println(output);
		System.out.println("*****************");
		list.removeFromHead();
		output=list.toString();
		System.out.println(output);
		list.removeFromTail();
		output=list.toString();
		System.out.println(output);
		System.out.println("The lengthof list is "+list.returnLength());
	}

}
