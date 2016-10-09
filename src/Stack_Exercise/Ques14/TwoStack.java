package Stack_Exercise.Ques14;

public class TwoStack {
	int top1;
	int top2;
    char stack1[];
    char stack2[];
    int total;
    public TwoStack(int capacity)
    {
    	if (capacity<2)
    		return;
    	total=capacity;
    	top1=-1;
    	stack1=new char[capacity];
    	top2=capacity;
    	stack2=new char[capacity];
    	
    }
    public void push(int stackID,char data)
    {
    	if(size(1)+size(2)>=total)
    	{
    		System.out.println("The total space is utilized; Can't enter : "+data);
    		return;
    	}
    	if(stackID==1)
    	   stack1[++top1]=data;	
    	if(stackID==2)
     	   stack2[--top2]=data;	
    }
    public char pop(int stackID)
    {
    	char data;
    	  if(stackID==1&&!isEmpty(stackID))
    	     {
    		  data=stack1[top1];
    		  top1--;
        	  return data;
    	     }
    	  else if(stackID==2&&!isEmpty(stackID))
 		  {
    		  data=stack2[top2];
 		      top2++;
     	      return data;
     	   }	  
    	  return '\u0000';
    }
    public int size(int stackID)
    {
    	if(stackID==1)
    	    return (top1+1);
    	else
    		return (total-top2);
    }
    public boolean isEmpty(int stackID)
    {
      if(stackID==1)
    	  {if(top1==-1)
    		  return true;
    	  else
    		  return false;}
      else
  	     {if(top2==total)
  		  return true;
  	  else
  		  return false;}
    }
    public String toString(int stackID)
	{
    	String val="[ ";
    	if(stackID==1)
    	{		
		for(int i=0;i<=top1;i++)
			val=val+stack1[i]+" ";		
    	}
    	else
    	{
    		for(int i=total-1;i>=top2;i--)
    			val=val+stack2[i]+" ";	
    	}
    	return(val+" ]");
	}
    public static void main(String[] args)
	{
    	TwoStack stack=new TwoStack(7);
		char[] array1 = {'a','b','c','d','e'};
		char[] array2 = {'A','B','C','D','E'};
		for(int i=0;i<5;i++)
			stack.push(1,array1[i]);
		for(int i=0;i<5;i++)
			stack.push(2,array2[i]);
		System.out.println("Th stack 1: "+stack.toString(1));
		System.out.println("*********");
		System.out.println("Th stack 2: "+stack.toString(2));
	}

}
