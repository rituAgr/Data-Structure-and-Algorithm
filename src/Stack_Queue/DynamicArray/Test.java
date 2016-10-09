package Stack_Queue.DynamicArray;

public class Test {
	public static void main(String args[]) throws Exception
	{
		DynamicArrayStack ob= new DynamicArrayStack(6);
		ob.push(4);
		ob.push(6);
		ob.push(9);
		ob.push(3);
		ob.push(0);
		ob.push(5);
		ob.push(0);
		ob.push(9);
		ob.push(3);
		ob.push(0);
		System.out.println("The output is "+ob.toString());
		System.out.println("After popping : "+ob.pop()+"\nThe output is "+ob.toString());
	}

}
