package Searching_geeksforgeeks;

/*
 * http://www.geeksforgeeks.org/find-the-element-before-which-all-the-elements-are-smaller-than-it-and-after-which-all-are-greater-than-it/
 */
public class division_of_array {

	public static void main(String[] args) {
		int  arr[] = {5, 1, 4, 3, 6, 8, 10, 7, 9};
		System.out.print(find_pos(arr));
	}
	static int find_pos(int[] arr)
	{
		int n=arr.length;
		int leftMax[]=new int[n];
		int rightMin[] = new int[n];
		int max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
		for(int i=0;i<n;i++)
		{
			if(arr[i]>max)
			 max=arr[i];
			leftMax[i]=max;
		}
		for(int i=n-1;i>-1;i--)
		{
			if(arr[i]<min)
			 min=arr[i];
			rightMin[i]=min;
		}
		for(int i=1;i<n-1;i++)
			if(arr[i]>leftMax[i-1]&&arr[i]<rightMin[i+1])
				return i;
		return -1;
	}
}
