package DP;

import java.util.ArrayList;
import java.util.Collections;

/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-32-word-break-problem/
 * https://www.youtube.com/watch?v=WepWFGxiwRs
 * Space complexity = O(n*n)
 * Time complexity = O(n*n*no of word in dictionary)
 */
public class WordBreak {

	public static void main(String[] args) {
		String elements[] = {"mobile","samsung","sam","sung","man","mango",
				"icecream","and","go","i","like","ice","cream"};
		ArrayList<String> dictionary = new ArrayList<String>();
		Collections.addAll(dictionary, elements);
		String word="igo";
		SplitWord(word,dictionary);
	}
	static class block
	{
		boolean value;
		int splitPos;
		block(boolean v, int pos)
		{
			value=v;
			splitPos=pos;
		}
	}
	private static void SplitWord(String word,ArrayList<String> dictionary)
	{
		int n=word.length();
		block[][] matrix=new block[n][n];
		for(int l=1;l<=n;l++)
		{
			for(int row=0;row<n-l+1;row++)
			{
				int col=l+row-1;
				String s=word.substring(row,col+1);
				if(row==col)
				{					
					if(dictionary.contains(s))
						matrix[row][col]=new block(true,row);
					continue;
				}
				if(dictionary.contains(s))
				{
					matrix[row][col]=new block(true,col);
					continue;
				}
				for(int split=0;split<s.length();split++)
				{
					if(matrix[row][split]==null||matrix[split+1][col]==null)
						continue;
					else
					{
						matrix[row][col]=new block(true,split);
						break;
					}
				}
			}
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
				if(matrix[i][j]!=null)
					System.out.print(matrix[i][j].value+" ");
				else
					System.out.print(null+" ");
			System.out.println();
		}
		if(matrix[0][n-1]==null)
		{
			System.out.println(false);
			return;
		}
		boolean status=matrix[0][n-1].value;
		System.out.println(status);
		if(!status)
			return;
		int row=0,col=n-1;
		ArrayList<String> result = new ArrayList<String>();
		while(matrix[row][col].splitPos!=col)
		{
			int split=matrix[row][col].splitPos;
			result.add(0,word.substring(split+1,col+1));
			col=split;
		}
		result.add(0,word.substring(0,matrix[row][col].splitPos+1));
		System.out.println(result);
	}
}

