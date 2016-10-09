package DP.Revision;
/*
 * http://www.geeksforgeeks.org/ugly-numbers/
 * Time complexity : O(n)
 * Space complexity : O(n)
 */
public class Ugly_Number
{
	public static void main(String[] args)
	{
		find_UglyNumber(150);
	}
	private static void find_UglyNumber(int num)
	{
		int lastIndex=1;
		int arr[] =new int[num];
		arr[0]=1;
		int i2,i3,i5;
		i2=i3=i5=0;
		while(lastIndex<num)
		{
			int n=Math.min(2*arr[i2],Math.min(3*arr[i3], 5*arr[i5]));
			arr[lastIndex++]=n;
			if(n==2*arr[i2])
				i2++;
			if(n==3*arr[i3])
				i3++;
			if(n==5*arr[i5])
				i5++;
		}
		/* below commneted is just to see the array formed
		for(int i=0;i<num;i++)
			System.out.println(arr[i]);*/
		System.out.println("Number is "+arr[lastIndex-1]);
	}
}
