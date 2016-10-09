package Hashing;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class Ques_2_to_4 {
	public static void main(String[] args)
	{
		int array[]={1,1,2,3,3,4,4,5,5,8,9,11};
		System.out.print("The original array with suplicate is :\n");
		for(int value : array)
			System.out.print(value+"  ");
		/*array=remove_duplicate(array);
		System.out.print("\nThe original array with suplicate is :\n");
		for(int value : array)
			   System.out.print(value+" ");*/
		remove_dups(array);
		remove_dups_set(array);
	}
	//Ques 2
	public static int[] remove_duplicate(int[] array)
	{
		int len=array.length;
		for(int i=0;i<len;i++)
		{
			for(int j=i+1;j<len;j++)
			{
				if(array[i]==array[j])
				{
					array[j]=array[len-1];
					array[len-1]='\0';
					len--;
				}
			}
		}
		return array;
	}
	//Ques 4
	public static void remove_dups(int []array)
	{
		System.out.println("\n Removing duplicates using HahTable");
		Hashtable<Integer,Integer> h = new Hashtable<Integer,Integer>();
		for(int i=0;i<array.length;i++)
			if(!h.containsKey(array[i]))
				h.put(array[i], 1);
		Set<Integer> keys = h.keySet();
		for(Integer key: keys)
			System.out.print(key+"  ");

	}
	//Doing same using set : the best way
	public static void remove_dups_set(int []array)
	{
		System.out.println("\n Removing duplicates using HashSet");
		int d=0;
		HashSet<Integer> s = new HashSet<Integer>();
		for(int i : array)
		{
			if(!s.add(i))
			    d++;
		}
		for(int j : s)
			System.out.print(j+" ");;
			System.out.println("\n Total no. of duplicates "+d);

	}
}





