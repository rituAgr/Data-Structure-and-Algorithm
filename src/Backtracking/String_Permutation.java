package Backtracking;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class String_Permutation
{
	public static void main(String args[])
	{
		String str ="AABC";		
		ArrayList<String> output=permute(str.toCharArray());	
		for(int i=0;i<output.size();i++)
			System.out.println(output.get(i)+" ");
	}
	public static ArrayList<String> permute(char[] str)
	{
		TreeMap<Character, Integer> countMap = new TreeMap<Character, Integer>();
		for(char c : str)
		{
			countMap.compute(c, (key, val)->
			{
				if(val==null)
					return 1;
				else
					return val+1;
			});
		}
		int count[]= new int[str.length];
		char letter[]= new char[str.length];
		int index =0;
		for(Map.Entry<Character, Integer> entry : countMap.entrySet())
		{
			letter[index]=entry.getKey();
			count[index]=entry.getValue();
			index++;
		}
		ArrayList<String> resultList = new ArrayList<String>();
		char[] result = new char[str.length];
		permuteUtil(letter, count, 0, result, resultList );
		return resultList;
	}
	public static void permuteUtil(char[] letter, int[] count , int level , char[] result, ArrayList<String> resultList)
	{
		if(level==result.length)// Here the length of result string is constant 4
		{
			resultList.add(new String(result));
			return;
		}
		for(int i=0;i<letter.length;i++)
		{
			if(count[i]==0)
				continue;
			result[level]= letter[i];
			count[i]--;
			permuteUtil(letter, count,level+1, result, resultList);
			count[i]++;
		}
	}
}
