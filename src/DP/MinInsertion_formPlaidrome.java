package DP;

/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-28-minimum-insertions-to-form-a-palindrome/
 */
public class MinInsertion_formPlaidrome {

	public static void main(String[] args) {
		String word="geeks";
		int num=find(word);
		System.out.println(num);
	}
	private static int find(String str)
	{
		int n=str.length();
		int[][] matrix=new int[n][n];
		for(int l=1;l<=n;l++)
			for(int i=0;i<n-l+1;i++)
			{
				int j=i+l-1;
				String s=str.substring(i,j+1);
				if(isPalidrome(s))
				{
					matrix[i][j]=0;
					continue;
				}
				matrix[i][j]=Math.min(matrix[i][j-1], matrix[i+1][j])+1;
			}
		return matrix[0][n-1];
	}
	private static boolean isPalidrome(String s)
	{
		int start=0;
		int end=s.length()-1;
		while(start<end)
		{
			if(s.charAt(start)!=s.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}
}
