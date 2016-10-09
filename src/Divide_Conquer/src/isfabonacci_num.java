package Divide_Conquer.src;

/*
 * Refer the link for explination http://www.geeksforgeeks.org/check-number-fibonacci-number/
 * See the special property to check this condition
 * Cond : n is fibonacci number if (5n2+4) or (5n2-4) is perfect square
 */
public class isfabonacci_num
{
	static boolean isPerfectSqr(int n)
	{
		double x=(int)Math.sqrt((double)n);
		if(x*x==n)
			return true;
		return false;
	}
	public static void main(String args[])
	{
		int n=5;//89;
		if(isPerfectSqr(5*n*n+4)||isPerfectSqr(5*n*n-4))
			System.out.println("true");
		else
			System.out.println("false");
	}
}
