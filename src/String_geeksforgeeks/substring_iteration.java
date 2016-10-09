package String_geeksforgeeks;

/*
 * http://www.geeksforgeeks.org/find-given-string-can-represented-substring-iterating-substring-n-times/
 */
public class substring_iteration {

	public static void main(String[] args)
	{
		String word="abadabad";
		boolean status=isTrue(word);
		System.out.println(status);
	}
	public static boolean isTrue(String word)
	{
		char end=word.charAt(word.length()-1);
		for(int pos=0;pos<word.length()/2;pos++)
		{
			if(word.charAt(pos)!=end)
				continue;
			String subWord=word.substring(0,pos+1);
			if(isTrueUtil(word,subWord))
				return  true;
		}
		return false;
	}
	public static boolean isTrueUtil(String word,String subWord)
	{
		int jumps=subWord.length();
		int pos=jumps;
		int start=0;
		if(word.length()%jumps!=0)
			return false;
		while(pos<=word.length())
		{
			if(word.substring(start, pos).equals(subWord)==false)
				return false;
			start=pos;
			pos=start+jumps;
		}		
		return true;
	}
}
