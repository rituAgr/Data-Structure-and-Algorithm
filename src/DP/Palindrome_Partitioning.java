package DP;

/*
 * 
 */
public class Palindrome_Partitioning {

	public static void main(String[] args) {
		String word="ababbbabbababa";
		int num=find_Max_Palindrome_Partitioning(word);
		System.out.println("The maximum number of partiion is "+num);
	}
	private static int find_Max_Palindrome_Partitioning(String word)
	{
		int n=word.length();
		int[][] matrix=new int[n][n];
		for(int l=2;l<=n;l++)
		{
			for(int i=0;i<n-l+1;i++)
			{
				int j=i+l-1;
				if(j>=n)
					break;
				String str=word.substring(i,j+1);
				if(isPalidrome(str))
					matrix[i][j]=0;
				else
				{
					matrix[i][j]=Integer.MAX_VALUE;
					for(int k=0;k<str.length()-1;k++)
					{
						int min=1+matrix[i][k+i]+matrix[k+i+1][j];
						if(min<matrix[i][j])
							matrix[i][j]=min;
					}
				}				
			}
		}
		return matrix[0][n-1];
	}
	private static boolean isPalidrome(String s)
	{
		int n=s.length();
		if(n==0)
			return false;
		if(n==1)
			return true;
		int start=0;
		int end=n-1;
		while(start<=end)
		{
			if(s.charAt(start)==s.charAt(end))
			{
				start++;
				end--;
				continue;
			}
			return false;
		}
		return true;
	}
}
