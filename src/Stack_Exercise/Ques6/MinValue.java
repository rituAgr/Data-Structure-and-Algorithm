package Stack_Exercise.Ques6;

public class MinValue {
	int top;
    int stack[];
    int minTop;
    int minStack[];
    public MinValue(int capacity)
    {
    	top=-1;
    	minTop=-1;
    	stack=new int[capacity];
    	minStack=new int[capacity];
    }
    public void push(int data)
    {
    	stack[++top]=data;	
    }
    public void minPush(int minData)
    {	
    	minStack[++minTop]=minData;
    }
    public int pop()
    {
    	int length=top+1;
    	if(length==0)
    		return Integer.MIN_VALUE;
    	int data=stack[top];
    	  top--;
    	  return data;
    }
    public int minPop()
    {
    	int length=minTop+1;
    	if(length==0)
    		return Integer.MIN_VALUE;
    	int data=minStack[minTop];
    	minTop--;
    	  return data;
    }
    public int size()
    {
    	return (top+1);
    }
    public boolean isEmpty()
    {
    	if(top+1==0)
    		return true;
    	else 
    		return false;
    }
    public boolean minIsEmpty()
    {
    	if(minTop+1==0)
    		return true;
    	else 
    		return false;
    }
    public int peek()
    {
    	if(isEmpty())
    		return Integer.MIN_VALUE;
    	return stack[top];
    }
    public int minPeek()
    {
    	if(minIsEmpty())
    		return Integer.MIN_VALUE;
    	return minStack[minTop];
    }
   public int minimumCal(int array[])
   {
	   for(int i=0;i<array.length;i++)
	   {
		   push(array[i]);
		   if(minPeek()>array[i]||minIsEmpty())
			   minPush(array[i]);
		  /* else
			   minPush(minPeek());*/
	   }
	   return minPeek();
   }
   public static void main(String[] args)
  	{
     	MinValue balance=new MinValue(20);
      	int[] array={12,4,9,24,54,22,223,32};
      	System.out.println("The minimum value is : "+balance.minimumCal(array));
     }
}