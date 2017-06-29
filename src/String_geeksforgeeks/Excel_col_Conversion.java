package String_geeksforgeeks;

import java.util.*;
public class Excel_col_Conversion {

	public static void main(String[] args) {

		find_name(26);
		find_name(51);
		find_name(52);
		find_name(80);
		find_name(676);
		find_name(702);
		find_name(705);
	}
	static void find_name(int num)
	{
		int number=num;
		StringBuilder s = new StringBuilder();

		char c ='A';
		while(num>0)
		{
			int reminder=num%26;
			if(reminder==0)
			{
				s.append('Z');
				num=num/26-1;
			}
			else
			{
				s.append((char)((reminder-1)+c));
				num=num/26;
			}
		}
		s.reverse();
		System.out.print(number+" -> ");
		for(int k=0;k<s.length();k++)
			System.out.print(s.charAt(k));
		System.out.println();
	}

}
