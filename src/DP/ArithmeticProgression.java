package DP;

import java.util.ArrayList;

/*
 * http://www.geeksforgeeks.org/length-of-the-longest-arithmatic-progression-in-a-sorted-array/
 */
public class ArithmeticProgression {

	public static void main(String[] args) 
	{
		int[] arr={5, 10, 15, 20, 25, 30};
		find(arr);
	}
	static class block
	{
		int d,len;
		block(int d, int l)
		{
			this.d=d;
			len=l;
		}
	}
	private static void find(int[] arr)
	{
		int n=arr.length;
		block[][] matrix=new block[n][n];
		for(int i=0;i<n-1;i++)
			matrix[i][i+1]=new block(arr[i+1]-arr[i],2);
		for(int l=3;l<=n;l++)
		{
			for(int row=0;row<n-l+1;row++)
			{
				int col=row+l-1;
				int k=col-1;
				int maxlen=0,maxDis=0;
				while(matrix[row][k]!=null&&k<n)
				{
					if((arr[col]-arr[k])==matrix[row][k].d&&matrix[row][k].len+1>maxlen)
					{
						maxlen=matrix[row][k].len+1;
						maxDis=matrix[row][k].d;
					}
					k--;
				}
				k=col-1;
				while(matrix[row][k]!=null&&k<n)
				{
					if(matrix[row][k].len>maxlen)
					{
						maxlen=matrix[row][k].len;
						maxDis=matrix[row][k].d;
					}
					k--;
				}
				if(maxlen>0)
					matrix[row][col]=new block(maxlen,maxDis);
				else
					matrix[row][col]=new block(arr[col]-arr[col-1],2);
			}
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
				if(matrix[i][j]==null)
					System.out.print(null+"  ");
				else
					System.out.print("("+matrix[i][j].d+","+matrix[i][j].len+")");
			System.out.println();
		}
		int maxLen=0,row=-1,dis=-1;
		for(int i=0;i<n-1;i++)
			if(matrix[i][n-1].len>maxLen)
			{
				maxLen=matrix[i][n-1].len;
				row=i;
				dis=matrix[i][n-1].d;
			}
		int k=n-1;
		ArrayList<Integer> res= new ArrayList<Integer>();
		while(k>=0&&matrix[row][k]!=null)
		{
			if(matrix[row][k].d==dis)
				res.add(0,arr[k]);
			k--;
		}
		System.out.println("Len of longest AP is "+maxLen);
		System.out.println(res);
	}
}
