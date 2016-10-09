package Heap.Ques_27;

public class Dynamic_median_finding {
	public static void main(String args[])
	{
		int[] array1={ 1, 1,3 ,3,4, 5,7,9};
		int[] array2={ 2,4,5,9,6,9,11,12,13,17};
		int len1=array1.length;
		int len2=array2.length;
		float result=median_finding(array1,0,len1-1,array2,0,len2-1);
		System.out.println("The median is "+result);
	}
	public static float median_finding(int[] array1,int start1, int end1,int[] array2,int start2, int end2)
	{
		int mid1=start1+(end1-start1)/2;
		int mid2=start2+(end2-start2)/2;
		if(array1[mid1]==array2[mid2])
			return array1[mid1];
		else if(array1[mid1]<array2[mid2])
			return median_finding(array1,mid1+1, end1,array2,start2,mid2-1);
		else
			return median_finding(array1,start1,mid1-1,array2,mid2+1,end2);
	}

}
