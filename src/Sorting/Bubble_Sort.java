package Sorting;

//bubbling down the largest number to bottom (to end of array)
public class Bubble_Sort {
	public static void main(String args[])
	{
		int array[]={66,32,14,65,43,67,99,80,77};
		array=Bubble_Sorting(array);
		for(int i=0;i<array.length;i++)
			System.out.print(array[i]+" ");
	}
	public static int[] Bubble_Sorting(int array[])
	{
		for(int i=array.length-1;i>0;i--)
		{
			int count=0;
			for(int j=0;j<i;j++)
			{
				if(array[j]>array[j+1])
				{
					count++;
					int temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
				
			}
			if(count==0)
				return array;
		}
		return array;
	}

}
