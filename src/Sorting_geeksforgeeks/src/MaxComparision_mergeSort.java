package Sorting_geeksforgeeks.src;/*
 * http://www.geeksforgeeks.org/find-a-permutation-that-causes-worst-case-of-merge-sort/
 * for explaination see the link : http://stackoverflow.com/questions/24594112/when-will-the-worst-case-of-merge-sort-occur/24594419#24594419
 */
import java.util.ArrayList;

public class MaxComparision_mergeSort {

	public static void main(String[] args)
	{
		int[] array ={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		int[] result=Max_Compare(array);
		for(int x: result)
		System.out.print(x+" ");
	}
	public static int[] Max_Compare(int[] array)
	{
		int l=array.length;
		if(l==0||l==1)
			return array;
		if(l==2)
		{
			int temp=array[0];
			array[0]=array[1];
			array[1]=temp;
			return array;
		}
		ArrayList<int[]> res = separate(array);
		int array1[]=res.get(0);
		int array2[]=res.get(1);
		array1=Max_Compare(array1);
		array2=Max_Compare(array2);
		return merge(array1,array2);
	}
	static ArrayList<int[]> separate (int[]array)
	{
		int l=array.length;
		int array1[]=new int[l/2];
		int array2[]=new int[l-l/2];
		int pos=0;
		for(int i=0;i<l&&i%2==0;)
		{
			array1[pos]=array[i++];
			array2[pos++]=array[i++];
		}
		if(pos*2!=l)
			array2[pos]=array[l-1];
		ArrayList<int[]> res=new ArrayList<int[]>();
		res.add(array1);
		res.add(array2);
		return res;
	}
	static int[] merge(int[] arr1, int[] arr2)
	{
		int l1=arr1.length;
		int l2=arr2.length;
		int array[]=new int[l1+l2];
		int pos=0,i;
		for(i=0;i<l1;i++)
			array[pos++]=arr1[i];
		for(i=0;i<l2;i++)
			array[pos++]=arr2[i];
		return array;
	}
}
