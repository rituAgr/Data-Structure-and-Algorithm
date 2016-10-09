package Sorting_geeksforgeeks.src;/*
 * http://www.geeksforgeeks.org/quicksort-tail-call-optimization-reducing-worst-case-space-log-n/
 * refer this pdf link for more explanation : http://www.cs.nthu.edu.tw/~wkhon/algo08-tutorials/tutorial2b.pdf
 */
import java.util.Arrays;

public class Quick_sort_Tail_call {
	public static void main(String args[])
	{
		int array[]={38,27,43,3,9,82,10};
		Tail_Quick_sorting(array,0,array.length-1);
		//System.out.println(array);
		System.out.println(Arrays.toString(array));//new thing to learn
	}
	public static void Tail_Quick_sorting(int[] array,int low, int high)
	{
		if(low>=high)
			return ;
		int p= partition(array,low,high);
		if(p-low<high-p)
		{
			partition(array,low,p-1);
			low=p+1;
		}
		else
		{
			partition(array,p+1,high);
			high=p-1;
		}
}
public static int partition(int[] array,int low,int high)
{
	int P_index=low;
	int index=low;
	int pivot=array[high];
	while(index<high)
	{
		if(array[index]<pivot)
		{
			swap(array,index,P_index);
			P_index++;
		}
		index++;	
	}
	swap(array,P_index,high);
	return P_index;
}
public static void swap(int[] a, int l, int h)
{
	int temp=a[l];
	a[l]=a[h];
	a[h]=temp;
}
}
