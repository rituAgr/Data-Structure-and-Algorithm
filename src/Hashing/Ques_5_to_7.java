package Hashing;

import java.util.ArrayList;
import java.util.Hashtable;

public class Ques_5_to_7 {
	public static void main(String[] args)
	{
	 int A[]={2,5,6,8,10,5,5};
	 int B[]={2,5,5,8,10,5,6};
	 boolean check=check(A,B);
	 System.out.print(" Is the two arrays have set of number : "+check);
	}
	public static boolean check(int[] A, int[] B)
	{
	  Hashtable<Integer,Integer> hash1=new Hashtable<Integer,Integer>();
	//  Hashtable hash2<Integer,Integer> = new Hashtable<Integer,Integer>();
	  for(int i : A)
		  if(hash1.containsKey(i))
			  {
			  int count=hash1.get(i);
			  hash1.replace(i, count, ++count);
			  }
		  else
			  hash1.put(i, 1);
	  for(int i: B)
		  if(hash1.containsKey(i))
		  {
			  int count=hash1.get(i);
			  hash1.replace(i, count, --count);
		  }
		  else
			  return false;
	  ArrayList<Integer> val= new ArrayList<Integer>(hash1.values());
	  for(int i:val)
		  if(i>0)
			  return false;
	  return true;
	  
		    
	}

}
