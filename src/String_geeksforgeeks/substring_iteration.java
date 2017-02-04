package String_geeksforgeeks;

/*
 * http://www.geeksforgeeks.org/find-given-string-can-represented-substring-iterating-substring-n-times/
 * Time complexity of the above solution is O(n) as it uses KMP preprocessing algorithm which is linear time algorithm.
 */
public class substring_iteration {

	public static void main(String[] args) {
		String word = "aabaabaabaab";//"abadabad";//
		boolean status = isTrue(word);
		System.out.println(status);
	}
	private static boolean isTrue(String word)
	{
		int[] array=KMP_Preprocess(word);
		int max=Integer.MIN_VALUE;
		int n=word.length();
		for(int i=0;i<n;i++)
			if(array[i]>max)
				max=array[i];
		if(n%(n-max)==0)
			return true;
		return false;
	}
	private static int[] KMP_Preprocess(String word)
	{
		int l=word.length();
		int[] len=new int[l];
		int i=0,j=1;
		while(j<l)
		{
			if(word.charAt(i)==word.charAt(j))
			{
				len[j]=len[i]+1;
				i++;
				j++;
			}
			else if(i>0)
				i=len[i-1];
			else
				j++;
		}
		return len;
	}
}