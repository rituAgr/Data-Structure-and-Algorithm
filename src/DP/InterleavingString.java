package DP;

/*
 * http://www.geeksforgeeks.org/check-whether-a-given-string-is-an-interleaving-of-two-other-given-strings-set-2/
 * https://www.youtube.com/watch?v=ih2OZ9-M3OM
 * Time complexity=O(len1*len2)
 * Space complexity=O(len1*len2)
 */
public class InterleavingString 
{
	public static void main(String[] args)
	{
		String str1="aab";
		String str2="axy";
		isInterleavingString(str1,str2,"aaxaby");
	}
	private static void isInterleavingString(String str1,String str2,String word)
	{
		int len1=str1.length();
		int len2=str2.length();
		boolean matrix[][]=new boolean[len2+1][len1+1];
		matrix[0][0]=true;
		int pos=0;
		for(int col=1;col<=len1;col++)
			if(word.charAt(pos++)==str1.charAt(col-1)&&matrix[0][col-1])
				matrix[0][col]=true;
		pos=0;
		for(int row=1;row<=len2;row++)
			if(word.charAt(pos++)==str2.charAt(row-1)&&matrix[row-1][0])
				matrix[row][0]=true;
		for(int row=1;row<=len2;row++)
		{
			pos=row;
			for(int col=1;col<=len1;col++)
			{
				char c= word.charAt(pos++);
				if(c!=str1.charAt(col-1)&&c!=str2.charAt(row-1))
					continue;
				if(c==str2.charAt(row-1))
				{
					if(matrix[row-1][col])
						matrix[row][col]=true;
				}
				else
				{
					if(matrix[row][col-1])
						matrix[row][col]=true;
				}
			}
		}
		//Below code is just to see matrix values
		/*for(int row=0;row<=len2;row++)
		{
			for(int col=0;col<=len1;col++)
				System.out.print(matrix[row][col]+" ");
			System.out.println();
		}*/
		System.out.println(matrix[len2][len1]);
	}
}
