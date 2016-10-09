package Stack_Queue.LinkedList_Stack;

public class Start {
	public static void main(String args[])
	{
		String output;
		LinkedList list= new LinkedList();
		list.push(21);
		list.push(25);
		list.push(24);
		list.push(25);
		list.push(31);
		list.push(50);
		output=list.toString();
		System.out.println(output);
		list.pop();
		output=list.toString();
		System.out.println("After poping the last element"+output);
	}

}
