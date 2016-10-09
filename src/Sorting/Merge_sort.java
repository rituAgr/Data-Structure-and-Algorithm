package Sorting;



import java.util.Arrays;

public class Merge_sort {
	public static void main(String args[])
	{
		int array[]={38,27,43,3,9,82,10};
		array=Merge_sorting(array);
		System.out.println(Arrays.toString(array));//new thing to learn
	}
	public static int[] Merge_sorting(int array[])
	{
		int end=array.length-1;
		if(end<=0)
			return array;
		int array1[]=new int[array.length/2];
		int array2[]=new int[array.length-array1.length];
		System.arraycopy(array, 0, array1, 0, array1.length);
		System.arraycopy(array, array.length/2, array2, 0, array2.length);
		Merge_sorting(array1);
		Merge_sorting(array2);
		return Merge(array1,array2, array);
	}
	public static int[] Merge(int array1[],int array2[], int array[])
	{
		int pos1=0,pos2=0,pos=0;
		while(pos1<array1.length&&pos2<array2.length)
		{
			if(array1[pos1]<array2[pos2])
			{
				array[pos]=array1[pos1];
				pos1++;
			}
			else
			{
				array[pos]=array2[pos2];
				pos2++;
			}
			pos++;
		}
		System.arraycopy(array1, pos1, array, pos, array1.length-pos1);
		System.arraycopy(array2, pos2, array, pos, array2.length-pos2);
		return array;
	}

}
