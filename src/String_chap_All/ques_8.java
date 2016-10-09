package String_chap_All;

public class ques_8 {
	public static void main(String[] args)
	{
		String sen="This is a career monk string";
		String newSen = reverseWord(sen);
		System.out.println("The original String is : "+sen);
		System.out.println("\nThe Reversed words String is : "+newSen);
		String rev_sen=reverseLetter(sen);
		System.out.println("\nThe Reversed String with reversed letters and words is : "+rev_sen);
	}
	//To reverse the words in string
	public static String reverseWord(String sen)
	{
		String[] words=sen.split(" ");
		StringBuffer newSen=new StringBuffer();
		for(int i=words.length-1;i>=0;i--)
			newSen.append(words[i]+" ");
		return newSen.toString();
	}
	//to reverse the letter in the string
	public static String reverseLetter(String sen)
	{
		String[] words=sen.split(" ");
		StringBuffer newSen=new StringBuffer();
		for(int i=words.length-1;i>=0;i--)
		{
			String word=words[i];
		   for(int j=words[i].length()-1;j>=0;j--)
			newSen.append(word.charAt(j));
		newSen.append(" ");
		}
		return newSen.toString();
	}
}
