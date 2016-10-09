/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-14-variations-of-lis/
 */
package DP.Longest_Increasing_Subsequence;

import java.util.Arrays;

public class BoxStacking {
	static class Dimension
	{
		int dim1,dim2,dim3;
		Dimension(int dim1,int dim2,int dim3)
		{
			this.dim1=dim1;
			this.dim2=dim2;
			this.dim3=dim3;
		}
	}
	static class Box implements Comparable<Box>//<Integer>
	{
		int l,w,h;
		Box(int l, int w,int h)
		{
			this.l=l;
			this.w=w;
			this.h=h;
		}
		public int compareTo(Box ob2) {
			int area1=this.l*this.w;
			int area2=ob2.l*ob2.w;
			if(area1==area2)
				return 0;
			if(area1<area2)
				return 1;
			else 
				return -1;
		}
	}
	public static void main(String[] args) 
	{
		Dimension[] dims={new Dimension(3, 2, 5),new Dimension(1, 2, 4)};
		doBoxStacking(dims);
	}
	public static void doBoxStacking(Dimension[] dims)
	{
		int n=dims.length;
		Box[] boxes=new Box[3*n];
		int count=0;
		for(int i=0;i<n;i++)
		{
			boxes[count++]=new Box(dims[i].dim2,dims[i].dim3,dims[i].dim1);
			boxes[count++]=new Box(dims[i].dim1,dims[i].dim3,dims[i].dim2);
			boxes[count++]=new Box(dims[i].dim2,dims[i].dim1,dims[i].dim3);
		}
		Arrays.sort(boxes);
		int[] parent=new int[3*n];
		Arrays.fill(parent,-1);
		int[] maxHeight=new int[3*n];
		maxHeight[0]=boxes[0].h;
		int max=Integer.MIN_VALUE, maxIndex=-1;
		for(int i=1;i<3*n;i++)
			maxHeight[i]=boxes[i].h;
		for(int i=1;i<3*n;i++)
			for(int j=0;j<i;j++)
				if(((boxes[j].l>boxes[i].l&&boxes[j].w>boxes[i].w)||(boxes[j].w>boxes[i].l&&boxes[j].l>boxes[i].w))&&(maxHeight[j]+boxes[i].h>maxHeight[i]))
				{		

					maxHeight[i]=maxHeight[j]+boxes[i].h;
					parent[i]=j;
				}
		for(int i=1;i<3*n;i++)
			if(maxHeight[i]>max)
			{
				max=maxHeight[i];
				maxIndex=i;
			}

		System.out.println("The max height is "+max);
		System.out.println("length width height");
		while(parent[maxIndex]!=-1)
		{
			System.out.println(boxes[maxIndex].l+"    "+boxes[maxIndex].w+"    "+boxes[maxIndex].h);
			maxIndex=parent[maxIndex];
		}
		System.out.println(boxes[maxIndex].l+"    "+boxes[maxIndex].w+"    "+boxes[maxIndex].h);
	}
}
