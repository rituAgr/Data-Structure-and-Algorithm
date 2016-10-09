package Divide_Conquer.src;

// For more details for question
//Refer : http://www.geeksforgeeks.org/find-missing-number-arithmetic-progression/
//Time complexity=O(log n)
public class Missing_num_AP {
	public static void main(String[] args)
	{
		int arr[]={1, 6, 11, 16, 21, 31};//{2, 4, 8, 10, 12, 14};
		int x=find(arr);
		System.out.println(x);
	}
	private static int find(int arr[])
	{
		int x=Integer.MAX_VALUE;
		if(arr.length==0||arr.length==1||arr.length==2||arr.length==3)
			return x;
		int d=0;
		int d1=arr[1]-arr[0];
		int d2 = arr[2]-arr[1];
		int d3=arr[3]-arr[2];
		if(d1==d2)
			d=d1;
		else if(d2==d3)
			d=d2;
		else
			d=d3;
		return binary_find(arr, 0, arr.length-1,d);
		/*for(int i=0;i<arr.length-2;i++)
			if((arr[i+1]-arr[i])!=(arr[i+2]-arr[i+1]))
			{
				if((arr[i+1]-arr[i])!=d)
					return arr[i]+d;
				else
					return arr[i+1]+d;
			}
		return x;	*/	
	}
	private static int binary_find(int arr[], int low, int high,int diff)
	{
		while(low<high)
		{
			int mid=low+(high-low)/2;
			if((arr[mid+1]-arr[mid])!=diff)
				return arr[mid]+diff;
			if(mid>0&&(arr[mid]-arr[mid-1])!=diff)
				return arr[mid-1]+diff;
			if(arr[mid]==arr[0]+diff*mid)//(arr[mid+1]-arr[mid])!=diff)
				low=mid+1;
			else
				high=mid-1;
		}
		return -1;
	}

}
