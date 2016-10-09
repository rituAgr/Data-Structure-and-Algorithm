package Sorting;



/*
 * In this sorting algorithm, the array is considered to be divided into two parts-
 * sorted and unsorted part. in each iteration of outer loop one element from unsorted part is 
 * taken and inserted into unsorted part.
 */
public class Insertion_Sort {
	public static void main(String args[])
	{
		int array[]={66,32,14,65,43,67,99,80,77};
		Insertion_sorting(array);
		for(int i=0;i<array.length;i++)
			System.out.print(array[i]+" ");
	}
	public static void Insertion_sorting(int array[])
	{
		for(int i=1;i<array.length;i++)
		{
			int key=array[i];
			int j=i-1;
			while((j>=0)&&array[j]>key)
			{
				array[j+1]=array[j];
				j--;		
			}
			array[j+1]=key;
		}
	}
}
