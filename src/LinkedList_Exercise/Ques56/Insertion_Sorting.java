package LinkedList_Exercise.Ques56;

public class Insertion_Sorting {
	public static void main(String[] args)
	{
		int array[]={12,45,11,9,76,23,67};
		for(int count=1;count<array.length;count++)
		{
			for(int compare=count;compare>0;compare--)
			{
				if(array[compare]<array[compare-1])
				{
					int temp=array[compare];
					array[compare]=array[compare-1];
					array[compare-1]=temp;
				}
			}
		}
		for(int count=0;count<array.length;count++)
		   System.out.println(array[count]);
	}

}
