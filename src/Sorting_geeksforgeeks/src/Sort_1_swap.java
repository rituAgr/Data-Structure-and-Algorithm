package Sorting_geeksforgeeks.src;

/*
 * http://www.geeksforgeeks.org/sort-an-almost-sorted-array-where-only-two-elements-are-swapped/
 */
public class Sort_1_swap 
{
	public static void main(String args[])
	{
		int arr[] = {1, 5, 3};//{10, 20, 60, 40, 50, 30};
		int[]array=sort(arr);
		for(int x:array)
		System.out.println(x+" ");
	}
	public static int[] sort(int []arr)
	{
		int l=arr.length;
		int first=-1;
		int sec=-1;
		if(arr[0]>arr[1])
			first=0;
		if(arr[l-1]<arr[l-2])
			sec=l-1;
		for(int i=1;i<l;i++)
		{
			if(arr[i-1]>arr[i])
			{
				if(first==-1)
					first=i-1;
				else if(sec==-1)
					sec=i-1;
			}
		}
		if(first==-1&&sec==-1)
			return arr;
		if(first==-1)
			first=sec-1;
		if(sec==-1)
			sec=first+1;
		int temp=arr[first];
		arr[first]=arr[sec];
		arr[sec]=temp;
		return arr;
	}
}
