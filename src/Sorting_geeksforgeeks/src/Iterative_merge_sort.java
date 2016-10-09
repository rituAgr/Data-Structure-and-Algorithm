package Sorting_geeksforgeeks.src;

import java.util.Arrays;

public class Iterative_merge_sort {
	public static void main(String args[])
	{
		int array[]={38,27,43,3,9,82,10};
		Merge_sorting(array);
		//System.out.println(array);
		System.out.println(Arrays.toString(array));//new thing to learn
	}
	public static void Merge_sorting(int array[])
	{
		//int start=0;
		int len=array.length;
		int end=len-1;
		//int res[]=new int[len];
		for(int i=0;i<=end;i=i+2)
		{
			if(i+1>end)
				break;
			if(array[i]>array[i+1])
				swap(array,i,i+1);
		}
		int jump=2,pos=0;
		boolean flag=false;
		while(jump<=len/2)
		{
			while(pos+2*jump-1<=end)
				pos=merge(array,pos,pos+jump-1,pos+jump,pos+2*jump-1);
			if(pos+2*jump-1>end)
			{
				flag =true;
				break;
			}
			pos=0;
			jump=2*jump;
		}
		if(flag)
		{
			merge(array,0,pos,pos+1,end);	
		}
		/*for(int i=1;i<end/2;i=i*2)
		{
			for(int j=1;(4*j-1)<=end;j=2*j)
				merge(array,0,2*j-1,2*j,4*j-1);
		}*/
	}
	public static int merge(int array[],int start1,int end1, int start2, int end2)
	{
		int x=start1, y=end2;
		int res[]= new int[end1-start1+end2-start2+2];
		int k=0;
		while(start1<=end1&&start2<=end2)
		{
			if(array[start2]<array[start1])
				res[k++]=array[start2++];
			else
				res[k++]=array[start1++];
		}
		if(start1<=end1)
			System.arraycopy(array,start1,res,k,end1-start1+1);
		if(start2<=end2)
			System.arraycopy(array,start2,res,k,end2-start2+1);
		System.arraycopy(res,0,array,x,y-x+1);
		return ++k;
	}
	public static void swap(int array[],int i,int j)
	{
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
}
