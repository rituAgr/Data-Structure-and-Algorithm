package Sorting_geeksforgeeks.src;

import java.util.Arrays;

/*
 * Refer this link for explanation : http://www.geeksforgeeks.org/sort-array-wave-form-2/
 * Time complexity : O(n)
 */
public class wave_form_sorting
{
	public static void main(String args[])
	{
		int array[]={10, 5, 6, 3, 2, 20, 100, 80};
		Wave_sorting(array);
		//System.out.println(array);
		System.out.println(Arrays.toString(array));//new thing to learn
	}
	public static void Wave_sorting(int[] array)
	{
		int end=array.length-1;
		int Next=1, prev=1;
		//checking if all previous odd position element are less than current
		for(int i=2;i<=end;i++)
		{
			if(array[i]<array[prev])
				swap(array, i, prev);
			if(i%2!=0)
				prev=i;
		}
		//checking if all next odd position element are less than current
		for(int i=0;i<=end;i++)
		{
			if(array[i]<array[Next])
				swap(array, i, Next);
			if((i+2)%2!=0)
				Next=i+2;
			if(Next>end)
				break;
		}
	}
	public static void swap(int[] array, int x, int y)
	{
		int t=array[x];
		array[x]=array[y];
		array[y]=t;
	}
}
