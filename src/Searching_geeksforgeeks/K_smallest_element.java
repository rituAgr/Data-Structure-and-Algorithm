package Searching_geeksforgeeks;

/*
 * http://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
 * I did with method 4 in above link, 
 * Time complexity : O(n)
 */
public class K_smallest_element
{
	public static void main(String args[])
	{
		int arr[]={7, 10, 4, 3, 20, 15};
		int k=3;
		if(k>arr.length)
			System.out.println("Invalid value of k");
		int x=find(arr,0,arr.length-1,k);
		System.out.println("the value is "+x);
	}
	static int find(int[] arr, int l, int h,int k)
	{
		if(k-1<l||k-1>h)
			return Integer.MAX_VALUE;
		int pos=partition(arr,l,h);
		if(pos==k-1)
			return arr[pos];
		if(pos<k-1)
			return find(arr,pos+1,h,k);
		return find(arr,l,pos-1,k);

	}
	static int partition(int[] arr,int l, int h)
	{
		int pivot=h;
		int j=l,i;
		for(i=l;i<h;i++)
			if(arr[i]<arr[pivot])
			{
				swap(arr,i,j);
				j++;
			}
		swap(arr,pivot, j);
		return j;
	}
	static void swap(int arr[], int i, int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}
