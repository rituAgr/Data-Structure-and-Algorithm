package String_geeksforgeeks;/*
 * http://www.geeksforgeeks.org/print-possible-strings-can-made-placing-spaces/
 */
import java.util.ArrayList;
public class generate_wordsBySpace {

	public static void main(String[] args) {
		String word="ABCD";
		ArrayList<String> res= new ArrayList<String>();
		formWords(word,res);
		//for(int i=0;i<res.size();i++)
		//System.out.println(res.get(i));

	}
	public static void formWords(String word,ArrayList<String> res)
	{
		//int num_spaces;
		for(int i=1;i<word.length();i++)
		{
			formWordsUtil(word,res,i);
			System.out.println("word with"+i+" spaces are: ");
			for (String s: res)
				System.out.println(s);
			res.clear();
		}
	}
	public static void formWordsUtil(String word,ArrayList<String> res,int num_spaces)
	{	
		//int space_pos=1;ABCD
		//A B CD,       A BC D,         AB C D
		for(int i=1;i<word.length();i++)
		{
			int start=0;
			StringBuilder str=new StringBuilder();
			int end=i;
			str.append(word.substring(start,end));
			StringBuilder s=new StringBuilder();

			while(s.length()==0||(s.charAt(s.length()-1)!='D'&&s.charAt(s.length()-1)!=' '))
			{
				s.append(str);
				for(int space=1;space<=num_spaces;space++)
				{
					s.append(" ");
					start=end;
					end=start+space;
					end=end>word.length()?word.length():end;				
					s.append(word.substring(start,end));
					if(space==num_spaces)
					{
						s.append(word.substring(end, word.length()));
						//s.append('*');
						res.add(s.toString());
					}
				}
			}
		}
	}
}