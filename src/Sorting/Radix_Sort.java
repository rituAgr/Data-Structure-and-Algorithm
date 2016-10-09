package Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class Radix_Sort {
	public static void main(String args[])
	{
		int array[]={1234,3455,2104,5394,4284,1098,1048,3387};
		Sorting.radix_Sorting(array);
		System.out.println(Arrays.toString(array));

	}

}
class Sorting
{
	public static void radix_Sorting(int array[])
	{
		int num=array[0];
		for(int i=1;num/i>0;i=i*10)
		{
			sortByDigit(array,i);
		}		
	}
	private static void sortByDigit(int array[], int digit)
	{
		ArrayList<ArrayList<Integer>> buckets=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<10;i++)
			buckets.add(new ArrayList<Integer>());
		for(int i=0;i<array.length;i++)
		{
			int j=(array[i]/digit)%10;
			//System.out.println(j);
			(buckets.get(j)).add(array[i]);
		}
		int pos=0,i=0;
		int count=0;
		while(count<10)
		{
			while(pos<buckets.get(count).size())
			{
				array[i++]=(buckets.get(count)).get(pos);
				pos++;
			}
			pos=0;
			count++;
		}
	}
	
}
