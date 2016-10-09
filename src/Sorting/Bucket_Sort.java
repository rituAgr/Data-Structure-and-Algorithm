package Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class Bucket_Sort {
	public static void main(String args[])
	{
		int array[]={66,32,14,65,3,1,43,67,99,80,77,34,44,21,54,2,11,32,4};
		Do_Sort.Counting_Sorting(array);
		System.out.println(Arrays.toString(array));

	}

}
class Do_Sort
{
	final static int size=10;
	public static void Counting_Sorting(int array[])
	{
		int min=Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int element : array)
		{
			if(element>max)
				max=element;
			if(element<min)
				min=element;
		}
		ArrayList<ArrayList<Integer>> buckets= new ArrayList<ArrayList<Integer>>(10);
		for(int i=0;i<10;i++)
			buckets.add(new ArrayList<Integer>());
		for(int i=0;i<array.length;i++)
		{
			int bucket=(array[i]-min)/size;
			(buckets.get(bucket)).add(array[i]);
		}
		for(int i=0;i<buckets.size();i++)
		{
			for(int j=1;j<buckets.get(i).size();j++)
			{
				while(((buckets.get(i)).get(j))<((buckets.get(i)).get(j-1)))
				{
					int temp=(buckets.get(i)).get(j);
					(buckets.get(i)).set(j,(buckets.get(i)).get(j-1));//)=(buckets.get(i)).get(j-1);
					(buckets.get(i)).set(j-1,temp);
				}

			}
		}
		int bucket_num=0;
		int pos=0;
		int count=0;
		while(bucket_num<buckets.size())
		{
			while(pos<((buckets.get(bucket_num)).size()))
				{
				array[count]=(buckets.get(bucket_num)).get(pos);
				count++;
				pos++;
				}
			pos=0;
			bucket_num++;
		}

	}
}
