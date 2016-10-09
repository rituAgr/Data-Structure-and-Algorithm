package DP;

/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-18-word-wrap/
 * Time complexity : O(n^2)
 * Space complexity : O(n^2)
 * https://www.youtube.com/watch?v=RORuwHiblPc
 */
public class WordWrap_Problem {

	public static void main(String[] args) {
		String sen="Tushar Roy likes to code";
		String words[]=sen.split(" ");
		WordWrap(words);
	}
	private static void WordWrap(String words[])
	{
		int n=words.length;
		int matrix[][]=new int[n][n];
		int width=10;
		for(int i=0;i<n;i++)
		{
			int l=0;
			for(int j=i;j<n;j++)
			{
				l=words[j].length()+1+l;
				if(l<=width+1)
					matrix[i][j]=(int) Math.pow(width-(l-1),2);
				else
					matrix[i][j]=Integer.MAX_VALUE;
			}
		}
		int values[]=new int[n];
		int pos[]=new int[n];
		for(int i=n-1;i>=0;i--)
		{
			int j=n-1;
			if(matrix[i][j]!=Integer.MAX_VALUE)
			{
				values[i]=matrix[i][j];
				pos[i]=j+1;
			}
			else
			{
				values[i]=Integer.MAX_VALUE;
				while(j>i)
				{
					j--;
					if(matrix[i][j]==Integer.MAX_VALUE)
						continue;
					int curr=matrix[i][j]+values[j+1];
					if(curr<values[i])
					{
						values[i]=curr;
						pos[i]=j+1;
					}
				}
			}
		}
		//This below comment codes is just to see the values in pos and values arrays
		/*for(int i=0;i<n;i++)
			System.out.print(values[i]+" ");
		System.out.println();
		for(int j=0;j<n;j++)
			System.out.print(pos[j]+" ");*/
		int start=0;
		int count=1,i=0;
		int cost=0;
		while(i<n)
		{
			int len=10;
			System.out.println();
			System.out.print("line "+count+" : ");
			for(int j=start;j<pos[i];j++)
				{
				System.out.print(words[j]+" ");
				len=len-words[j].length()-1;
				}
			cost=cost+(int)Math.pow((len+1),2);
			start=pos[i];
			i=pos[i];
			count++;
		}
		System.out.println("\nTotal cost is "+cost);
	}
}
