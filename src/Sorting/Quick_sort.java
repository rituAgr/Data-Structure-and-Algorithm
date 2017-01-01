package Sorting;



import java.util.Arrays;

public class Quick_sort {
	public static void main(String args[])
	{
		int array[]={38,27,43,3,9,82,10};
		Quick_sorting(array,0,array.length-1);
		//System.out.println(array);
		System.out.println(Arrays.toString(array));//new thing to learn
	}
	public static void Quick_sorting(int array[],int start, int end)
	{
		if(start<end)
		{
			int mid=Randomized_Partition(array,start,end);
			Quick_sorting(array,start,mid-1);
			Quick_sorting(array,mid+1,end);
		}
	}
	public static int Randomized_Partition(int array[],int start, int end)
	{
		int range=end-start+1;
		int pivotIndex=start + (int)(Math.random()*range);
		//This 1 is added to Math.random func because range is [0-1) that is exclude exact one
		swap(array,pivotIndex,end);
		int pivot=array[end];
		int startIndex=start;
		int i=start;
		while(i<end)
		{
			if(array[i]<=pivot)
			{
				swap(array,i,startIndex);
				startIndex++;
			}
			i++;
		}
		swap(array,end,startIndex);
		return startIndex;
	}
	public static void swap(int array[],int i,int j)
	{
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}

}
