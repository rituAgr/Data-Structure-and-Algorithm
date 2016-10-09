/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
 * Time complexity :O(mn)
 * Space complexity :O(mn)
 */
package DP.Revision;
public class Edit_Distance {

	public static void main(String[] args) {
		String str1="sunday";
		String str2="saturday";
		System.out.println("The minimum number of edits required is "+CalculateMinEdits(str1,str2));
	}
	private static int CalculateMinEdits(String str1,String str2)
	{
		int len1=str1.length();
		int len2=str2.length();
		if(len1==0&&len2==0)
			return 0;
		if(len1==0)
			return len2;
		if(len2==0)
			return len1;
		int matrix[][]=new int[len1+1][len2+1];
		for(int i=0;i<=len1;i++)
			for(int j=0;j<=len2;j++)
			{
				if(i==0)
					matrix[i][j]=j;
				else if(j==0)
					matrix[i][j]=i;
				else if(str1.charAt(i-1)==str2.charAt(j-1))
					matrix[i][j]=matrix[i-1][j-1];
				else
					matrix[i][j]=1+Math.min(matrix[i-1][j-1],Math.min(matrix[i-1][j], matrix[i][j-1]));
			}
		printPath(matrix,str1,str2);
		return matrix[len1][len2];
	}
	private static void printPath(int[][] matrix,String str1,String str2)
	{
		int row=matrix.length-1;
		int col=matrix[0].length-1;
		while(row>0&&col>0)
		{	
			if(matrix[row][col]==1+matrix[row-1][col-1])
			{
				System.out.println("Replace "+str1.charAt(row-1)+" with "+str2.charAt(col-1));
				row--;col--;
			}
			else if(matrix[row][col]==1+matrix[row-1][col])
			{
				System.out.println("Remove "+str2.charAt(row-1));
				row--;
			}
			else if(matrix[row][col]==1+matrix[row][col-1])
			{
				System.out.println("Add "+str2.charAt(col-1));
				col--;
			}
			else
			{
				row--;col--;
				continue;
			}
		}
	}
}
