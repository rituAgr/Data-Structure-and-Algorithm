package LinkedList_Exercise.Ques44;

public class Start {
	public static void main(String args[])
	{
		String output;
		CircularLinkedList list= new CircularLinkedList();
		
		list.add("Ritu");
		list.add("Nikhil");
		list.add("Shailendra");
		list.add("Meenakshi");
		list.add("Ram");
		list.add("Vaibhav");
		//list.add("Vikas");
		//list.add("Golu");
		//list.add("Lokesh");
		list.add("pardeep");
		System.out.println("The length of list is "+list.returnLength());
		output = list.toString();
		System.out.println("*********orginal********");
		System.out.println(output);
		
		int count=5;
		System.out.println("*****************");
		System.out.println("The count of removing candidate is "+ count+"\n");
		System.out.println("Leader is "+list.ChooseLeader(count));
	}

}
