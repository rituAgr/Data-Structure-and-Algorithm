package Sorting_geeksforgeeks.src;/*
 * http://www.geeksforgeeks.org/3-way-quicksort/
 * refer this link pdf , the second option : http://algs4.cs.princeton.edu/lectures/23DemoPartitioning.pdf
 */
import java.util.Arrays;

public class three_way_quick_sort {
	public static void main(String args[])
	{
		char array[]={'P','A','B','X','W','P','V','P','D','P','C','Y','Z'};
		three_way_Quick_sorting(array,0,array.length-1);
		System.out.println(Arrays.toString(array));//new thing to learn
	}
	public static void three_way_Quick_sorting(char array[],int low,int high)
	{
		if(low>=high)
			return;
		int[] res=Partition(array,low,low,high,array[low]);
		int high1=res[0];
		int low1=res[1];
		three_way_Quick_sorting(array,low,high1);
		three_way_Quick_sorting(array,low1,high);
	}
	
	public static int[] Partition(char array[],int i, int lt,int ht, char pivot)
	{
		if(i>ht)
		{
			int res[]={lt-1,ht+1};
			return res;
		}			
		if(lt<ht)
		{
			if(array[i]<pivot)
			{
				swap(array,i,lt);
				i++;lt++;
			}
			else if(array[i]>pivot)
			{
				swap(array,i,ht);
				ht--;
			}
			else
				i++;			
		}
		return Partition(array,i,lt,ht,pivot);
	}
	public static void swap(char[] a, int l, int h)
	{
		char temp=a[l];
		a[l]=a[h];
		a[h]=temp;
	}
}
