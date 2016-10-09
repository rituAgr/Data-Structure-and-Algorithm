package Sorting;



import java.util.Arrays;

public class Counting_sort {
	public static void main(String args[])
	{
		int array[]={66,32,14,65,43,67,99,80,77,34,44,21,0,54,2,11,32,3,4,3,1,4};
		Sort1.Counting_Sorting(array);
		System.out.println(Arrays.toString(array));

	}
}
class Sort1
{
	public static void Counting_Sorting(int array[])
	{
		int max=0;
		for(int i=0;i<array.length;i++)
			if(array[i]>max)
				max = array[i];
		int count[]=new int[max+1];
		for(int i:array)
			++count[i];
		int j=0;
		for(int i=0;i<=max;i++)
			while(count[i]>0)
			{
				count[i]--;
				array[j++]=i;
			}		
	}
}