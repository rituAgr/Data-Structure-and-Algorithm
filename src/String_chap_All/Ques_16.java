package String_chap_All;

public class Ques_16 {
	public static void main(String args[])
	{
		boolean b = wildCardMAtch("aab","aab");
		System.out.println("The pattern is matched :"+b);
	}
	public static boolean wildCardMAtch(String text,String pattern)
	{
		int lenText=text.length();
		int lenPattern=pattern.length();
		if(lenText==0&&lenPattern==0)
			return true;
		int i=0,j=0;
		int startText=-1,startPattern=-1;
		while(i<lenText)
		{
			if(j<lenPattern&&(text.charAt(i)==pattern.charAt(j)||pattern.charAt(j)=='?'))
			{
				i++;
				j++;
			}
			else if(j<lenPattern&&pattern.charAt(j)=='*')
			{
				while(j<lenPattern&&pattern.charAt(j)=='*')
					j++;
				if(j==lenPattern)
					return true;
				startPattern=j;
				startText=i;  
			}
			else if((j>=lenPattern||text.charAt(i)!=pattern.charAt(j))&&startPattern>-1)
			{
				startText++;
				j=startPattern;
				i=startText;
			}
			else 
				return false;
	}

		while(j<lenPattern)
		{
			if(pattern.charAt(j)!='*')
				return false;
			j++;
		}
		return false;
	}

}
