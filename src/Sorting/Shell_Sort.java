package Sorting;

import java.util.Arrays;

public class Shell_Sort {
	public static void main(String args[])
	{
		int array[]={66,32,14,65,43,67,99,80,77};
		Sort.Shell_sorting(array);
		System.out.println(Arrays.toString(array));
	}

}
class Sort
{
   public static void Shell_sorting(int array[])
   {
	   int k=array.length/2;
	   while(k>0)
	   {
		   for(int i=0;i<array.length-k;i++)
		   {
			   if(array[i]>array[k+i])
			   {
				   swap(array,i,k+i);
				   int back2=i-k;
				   int back1=i;
				   while(back2>-1&&array[back2]>array[back1])
				   {
					   swap(array,back1,back2);
					   back1=back2;
					   back2=back2-k;
				   }
			   }
		   }
		   k=k/2;
	   }
   }
   public static void swap(int array[],int pos1, int pos2)
   {
	   int temp=array[pos1];
	   array[pos1]=array[pos2];
	   array[pos2]=temp;
   }
}