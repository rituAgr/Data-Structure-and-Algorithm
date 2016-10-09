package LinkedList.doubleLinkedList;

public class DoubleLinkedList {
	DLLNode head;
	DLLNode tail;
	int length;
   public DoubleLinkedList()
   {
	   head=new DLLNode(Integer.MIN_VALUE,null,null);
	   tail=new DLLNode(Integer.MIN_VALUE,null,null);
	   length=0;
	  head.setNext(tail);
   }
   // To get the position of the given data in linkedList
   public int getPosition(int data)
   {
	   DLLNode curr=head;
	   int position=0;
	   while(curr.getNext()!=null)
	   {
		   position++;
		   if(curr.getData()==data)
			   return position;
		   curr=curr.getNext();
	   }
	   return Integer.MIN_VALUE;
   }
   // To get the length of linkedlist
   public int getLength()
   {
	   return length;
   }
   // To insert at head of linkedlist
  public void insertHead(int value)
   {
	  if(head.getData()==Integer.MIN_VALUE)
		  {
		  head.setData(value);
	       return;
		  }
	   DLLNode node=new DLLNode(value,null,head);
	   node.setNext(head);
	   DLLNode curr=head;
	   curr.setPrevious(node);
	   head=node;
	   length++;
   }
   // Insert the node at specified position.
   public void insert(int data, int position)
   {
	   DLLNode node=new DLLNode(data);
	   int count=1;
	   if(position<0)
		   position = 0;
	   if(position>length)
		   position = length;
	   if(head==null)
	   { 
		   head=new DLLNode(data);
	       return;
	   }
	   DLLNode curr=head;
	   while(curr.getNext()!=null)
	   {  
		   if(count==(position-1))
		   {
			   node.setNext(curr.getNext());
			   node.setPrevious((curr.getNext()).getPrevious());
			   curr.setNext(node);
			   curr.getNext().setPrevious(node);
			   length++;
			   return;
		   }
		   curr=curr.getNext();
		   count++;
	   }
   }
   //Insert value at the tail of List
   public void insertTail(int value)
   {
	   DLLNode curr=head;
	   DLLNode node = new DLLNode(value,null,null);
	   while(curr.getNext()!=null)
	      curr=curr.getNext();
	   curr.setNext(node);
	   node.setPrevious(curr);
	   tail=node;
	   length++;
   }
   // To remove a node at specified position
   public void remove(int position)
   {
	   DLLNode curr=head;
	   int count=1;
	   position--;
	   if(position<0)
		   position = 0;
	   if(position>length)
		   position = length;
	   while(count<position)
	   {
		   curr=curr.getNext();
	       count++;
        }
	   DLLNode temp = curr.getNext();
	   curr.setNext(temp.getNext());
	   (temp.getNext()).setPrevious(temp.getPrevious());
	   temp=null;
	   length--;
   }
   // TO remove the matched node from List
   public void removeMatchedNode(DLLNode node)
   {
	   if(head==null) return;
	   if(node.getData()==(head.getData()))
		   {
		   DLLNode temp=head;
		   head=head.getNext();
		   temp=null;
		   length--;
		   if(head==null)
			   tail=null;
		   }
	  // if(node.equals(tail))
	   
	   DLLNode curr=head;
	   while(curr.getNext()!= null)
	   {
		   if(node.getData()==(curr.getNext()).getData())
				   {
			       DLLNode temp = curr.getNext();
				   curr.setNext(temp.getNext());
				   temp.getNext().setPrevious(curr);
				   temp=null;
				   length--;
				   if(curr.getNext()==null)
					   curr = tail;
				   return;
	               }
		   curr=curr.getNext();
       }
   } 
   //To remove the head node
   public int removeHead()
   {
	   int toReturn;
	   if(head==null) 
		   return Integer.MIN_VALUE;
	   if(head.getNext()==null)
	   {
		   toReturn=head.getData();
		   head = null;
		   tail =null;
		   length--;
		   return toReturn; 
	   }
	   toReturn=head.getData();
	   DLLNode curr = head.getNext();
	   curr.setPrevious(null);
	   head.setNext(null);
	   head=curr;
	   length--;
	   return toReturn;
   }
 //To remove the tail node
   public int removeTail()
   {
	   int value;
	   if(tail==null)
		   return Integer.MIN_VALUE;
	   if(tail.getPrevious()==null)
	   {
		  value=tail.getData();
		  tail=head=null;
		  length--;
		  return value;
	   }
	   value=tail.getData();
	   DLLNode node=tail.getPrevious();
	   node.setNext(null);
	   tail.setPrevious(null);
	   tail=node;
	   length--;
	   return value;
   }
   
   // Clear the list
   public void clearIt()
   {
	   head=tail=null;
	   length=0;
   }
  // To return the list 
   public String stringList()
   {
	   String list="[ ";
	   DLLNode curr=head;
	   while(curr.getNext()!=null)
	   {
		   list=list+curr.getData()+" ";
		   curr=curr.getNext();
	   }
	   return (list +"]");
   } 

}
