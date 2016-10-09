package LinkedList_Exercise.Ques39;

public class Palidrome {
			//checking if palidrome
		public void checkPalidrome(LinkedList list)
		{
			LinkedList List1=new LinkedList();
			SLLNode slow=list.head;
			SLLNode fast=list.head;
			while(fast.getNext()!=null)
			{
				int data=slow.getData();
				List1.add(data);
				//System.out.println("********"+data);
				slow=slow.getNext();
				fast=(fast.getNext()).getNext();
				if(fast==null)
					break;
				if(fast.getNext()==null&&fast!=null)
					slow=slow.getNext();
			}
			boolean check=true;
			System.out.println("slow pointer value is"+slow.getData());
			System.out.println("***List1 Before reverse*****");
			List1.display();
			//List1.reverseList();
			//System.out.println("***List1 After reverse*****");
		  //  List1.display();
			SLLNode curr=List1.head;
			while(slow!=null)
			{
				if(curr==null)
					break;
				if(curr.getData()!=slow.getData())
					check= false;
				slow=slow.getNext();
				curr=curr.getNext();
			}
			System.out.println("Is the list palidrome : "+check);
		}

}
