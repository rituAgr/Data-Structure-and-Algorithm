package Sorting;

//

//bubbling smallest number to top (start of array) . In each loop just one swap if needed.
public class Selection_Sort {
	public static void main(String args[])
	{
		int array[]={66,32,14,65,43,67,99,80,77};
		array=Selection_Sorting(array);
		for(int i=0;i<array.length;i++)
			System.out.print(array[i]+" ");
	}
	public static int[] Selection_Sorting(int[] array)
	{

		for(int i=0;i<array.length-1;i++)
		{
			int min=i;
			for(int j=i+1;j<array.length;j++)
			{
                if(array[min]>array[j])
                	min=j;
			}
			if(min!=i)
			{
				int temp=array[i];
				array[i]=array[min];
				array[min]=temp;
			}
		}
		return array;
	}

}
