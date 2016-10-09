package Divide_Conquer.src;

//Refer http://www.geeksforgeeks.org/divide-and-conquer-set-2-karatsuba-algorithm-for-fast-multiplication/
//for more details and explaination
// for codes http://www.sanfoundry.com/java-program-karatsuba-multiplication-algorithm/
public class Karatsuba_Algo_Matrices_multiply
{
	public static void main(String args[])
	{
		int num1 = 212123;
		int num2 =1333;
		int ans= Karatsuba_multiply(num1, num2);
		System.out.println("The multiplication answer is " + ans);
	}
	public static int Karatsuba_multiply(int num1 , int num2)
	{
		//int l=getSize(num1);
		String x = Integer.toString(num1);
		String y = Integer.toString(num2);
		int n1 = x.length();
		int n2 = y.length();
		int n = Math.max(n1,n2);
		if(n<10)
			return num1*num2;
		n=n/2+n%2;
		int m=(int)Math.pow(10, n);
		int b=num1%m;
		int a=num1/m;
		int c=num2/m;
		int d=num2%m;

		int ac=Karatsuba_multiply(a,c);
		int bd=Karatsuba_multiply(b,d);
		int mid=Karatsuba_multiply(a+b,c+d)- ac-bd;

		int ans = ac*m+mid*(int)(Math.pow(10,2*n))+bd;
		return ans;
	}
}
