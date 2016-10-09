package Divide_Conquer.src;

/*
 * Refer : http://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/
 * Time complexity : log n
 */
public class Power_func
{
	public static void main(String args[])
	{
		int x= 8, y=-3;
		float res=power(x,y);
		System.out.println(res);
	}
	public static float power(int x, int y)
	{
		if(y==0)
			return 1;
		float temp=power(x,y/2);
		if(y%2==0)
			return temp*temp;
		else 
		{
			if(y>0)
				return x*temp*temp;
			else 
				return temp*temp/x;
		}
	}
}
