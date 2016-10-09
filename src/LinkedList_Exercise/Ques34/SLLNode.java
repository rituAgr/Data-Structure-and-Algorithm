package LinkedList_Exercise.Ques34;

public class SLLNode {

		private int data;
		private SLLNode next;
		
		SLLNode(int data)
		{
			this.data=data;
		}
		public void setNext(SLLNode next)
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
		public SLLNode getNext()
		{
			return next;
		}
		

	}


