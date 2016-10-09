package Divide_Conquer.src;

import java.util.Stack;

public class MaxAreaHistogram 
{
	public static void main(String args[])
	{
		int arr[]={2,2,2,6,1,5,4,2,2,2,2};
		int x=Largest_Area(arr);
		System.out.println(x);
	}
	public static int Largest_Area(int[] arr)
	{
		int l=arr.length;
		if(l==0)
			return -1;
		if(l==1)
			return arr[0];
		Stack<Integer> st = new Stack <Integer>();
		int maxArea=0;
		int i;
		for(i=0;i<l;)
		{
			if(st.isEmpty()||arr[st.peek()]<=arr[i])
			{
				st.push(i);
				i++;
			}
			else
			{
				int t=st.pop();
				int area=0;
				if(st.isEmpty())
					area=i*arr[t];
				else
					area=(i-1-st.peek())*arr[t];
				if(maxArea<area)
					maxArea=area;
			}
		}
		while(!st.isEmpty())
		{
			int t=st.pop();
			int area=0;
			if(st.isEmpty())
				area=i*arr[t];
			else
				area=(i-1-st.peek())*arr[t];
			if(maxArea<area)
				maxArea=area;	
		}
		return maxArea;
	}
}
