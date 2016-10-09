package DP.Revision;

public class MinMatrixMultiplicationCost {

	public static void main(String[] args) {
		int[] arr={1,2,3,4};
		int min=minCost(arr);
		System.out.println(min);
	}
	private static int minCost(int[] arr)
	{
		int n=arr.length;
		int matrix[][] =new int[n][n];
		for(int i=0;i<n;i++)
			matrix[i][i]=0;
		for(int l=2;l<n;l++)
		{
			for(int i=1;i<n-l+1;i++)
			{
				int j=i+l-1;
				if(j==n)
					break;
				matrix[i][j]=Integer.MAX_VALUE;
				int temp;
				for(int k=i;k<j;k++)
				{
					temp=matrix[i][k]+matrix[k+1][j]+arr[i-1]*arr[k]*arr[j];
					if(temp<matrix[i][j])
						matrix[i][j]=temp;
				}
			}
		}
		return matrix[1][n-1];
	}
}
