package Divide_Conquer.src;

//Refer this link http://www.geeksforgeeks.org/divide-and-conquer-maximum-sum-subarray/
public class maxSubArraySum
{
	public static void main(String args[])
	{
		int arr[]={-2, -5, 6, -2, -3, 1, 5, -6};
		int num= find_maxSubArraySum(arr , 0 , arr.length-1);
		System.out.println(num);
		//6, -2, -3, 1, 5 sums upto 7, that is max sum.
	}
	public static int find_maxSubArraySum(int[] arr, int l, int h)
	{
		if(l==h)
			return arr[l];
		int m=(l+h)/2;
		
		int leftSum=find_maxSubArraySum(arr,l,m);
		int RightSum=find_maxSubArraySum(arr,m+1,h);
		int midSum=maxCrossSum(arr,l,m,h);
		return Math.max(midSum, Math.max(leftSum, RightSum));
	}

	public static int maxCrossSum(int[] arr,int l,int m,int h)
	{
		int leftSum=Integer.MIN_VALUE, rightSum=Integer.MIN_VALUE, sum=0;
		for(int i=m;i>=l;i--)
		{
			sum+=arr[i];
			if(sum>leftSum)
				leftSum=sum;
		}
		sum=0;
		for(int i=m+1;i<=h;i++)
		{
			sum+=arr[i];
			if(sum>rightSum)
				rightSum=sum;
		}
		return rightSum+leftSum;
	}
}
