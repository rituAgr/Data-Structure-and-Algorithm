package String_geeksforgeeks;

public class wildcard_Match {

	public static void main(String[] args) 
	{
		System.out.println("Matching g*ks and geeks : "+match("g*ks", "geeks",0,0));	
		boolean x=match("ge?ks*s", "geeksforgeeks",0,0);
		System.out.println("Matching ge?ks*s and geeksforgeeks : " +x);
		x=match("g*k", "gee",0,0);
		System.out.println("Matching g*k and gee : " +x);
		System.out.println("Matching *pqrs , pqrst : "+match("*pqrs", "pqrst",0,0));
		System.out.println("Matching abc*bcd, abcdhghgbcd : "+match("abc*bcd", "abcdhghgbcd",0,0));
		System.out.println("Matching abc*c?d , abcd : "+match("abc*c?d", "abcd",0,0));
		System.out.println("Matching *c*d , abcd : "+match("*c*d", "abcd",0,0));
		System.out.println("Matching *?c*d* , abcd : "+match("*?c*d*", "abcd",0,0));
	}
	static boolean match(String s, String sen,int i, int j)
	{
		if(i>=s.length()&&j>=sen.length())
			return true;
		if(i==s.length()-1&&s.charAt(i)=='*'&&j>=sen.length())
			return true;
		if(i>=s.length()||j>=sen.length())
			return false;		
		if(s.charAt(i)=='*'&&s.charAt(i+1)!='\0'&&sen.charAt(j)=='\0')
			return false;
		if(s.charAt(i)=='?'||s.charAt(i)==sen.charAt(j))
			return match(s,sen,i+1,j+1);
		if(s.charAt(i)=='*')
			return(match(s,sen,i+1,j)||match(s,sen,i,j+1));
		return false;
	}

}
