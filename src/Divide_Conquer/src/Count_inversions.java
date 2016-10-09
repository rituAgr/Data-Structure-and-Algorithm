package Divide_Conquer.src;

/*
 * Refer : http://www.geeksforgeeks.org/counting-inversions/
 * Time complexity : nlog n
 */
public class Count_inversions
{
	static int count=0;
	public static void main(String args[])
	{
		int arr[] = {1,3,5, 2 ,4 , 6};//{2, 4, 1, 3, 5};2 5 4 6 3 //2 4 5 6 3 //
		countInversionBreak(arr);
		System.out.println(count);
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
	}
	public static void countInversionBreak(int arr[])
	{
		int l=arr.length;
		if(l<=1)
			return ;
		int arr1[]=new int[l/2];
		int arr2[]=new int[l-l/2];
		System.arraycopy(arr, 0, arr1, 0, l/2);
		System.arraycopy(arr, l/2, arr2, 0,arr2.length);
		countInversionBreak(arr1);
		countInversionBreak(arr2);
		merge(arr,arr1,arr2);
	}
	static void merge(int[] array, int[] array1,int[] array2)
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
				count++;
			}
			pos++;//count++;
		}
		count=count+array2.length-pos2-pos1;
		System.arraycopy(array1, pos1, array, pos, array1.length-pos1);
		System.arraycopy(array2, pos2, array, pos, array2.length-pos2);
	}
}
