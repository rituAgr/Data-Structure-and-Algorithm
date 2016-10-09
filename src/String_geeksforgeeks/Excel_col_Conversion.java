package String_geeksforgeeks;

import java.util.*;
public class Excel_col_Conversion {

	public static void main(String[] args) {
		int col_num=705;
		String col_name=find_name(col_num);
		System.out.println(col_name);
	}
	static String find_name(int num)
	{
		StringBuilder s = new StringBuilder();
		HashMap <Integer,Character> hm = new HashMap<Integer,Character>();
		char c ='A';
		for(int i=1;i<=26;i++)
		{
			hm.put(i,c);
			c++;
		}
		while(num>0)
		{
			int n=num%26;
			num=num/26;
			if(n==0)
			{
				s.append('Z');
				num--;
				continue;
			}
			c=hm.get(n);
			s.append(c);
		}
		s.reverse();
		return s.toString();
	}

}
