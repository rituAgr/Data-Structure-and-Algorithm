package LinkedList_Exercise.Ques28;

public class LLNode {

		private int data;
		private LLNode next;
		
		LLNode(int data)
		{
			this.data=data;
		}
		public void setNext(LLNode next)
		{
			this.next=next;
		}
		public void setData(int data)
		{
			this.data=data;
		}
		public int getData()
		{
			return data;
		}
		public LLNode getNext()
		{
			return next;
		}
		

	}


