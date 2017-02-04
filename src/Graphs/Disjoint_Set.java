package Graphs;

import java.util.*;

public class Disjoint_Set {
	ArrayList<HashMap<Integer, Set<Integer>>> set;
	Disjoint_Set()
	{
		set=new ArrayList<HashMap<Integer, Set<Integer>>>();
	}
	int size_disjointSet()
	{
		return set.size();
	}
	void create_set(int element)
	{
		HashMap<Integer,Set<Integer>> hm=new HashMap<Integer,Set<Integer>>();
		HashSet<Integer> s = new HashSet<Integer>();
		s.add(element);
		hm.put(element, s);
		set.add(hm);
	}
	boolean union(int element1, int element2)
	{
		Integer key1=find_Set(element1);
		Integer key2=find_Set(element2);
		if(key1==key2)
			return true;
		Set<Integer> set1=null;
		Set<Integer> set2=null;
		for(int i=0;i<set.size();i++)
		{
			HashMap<Integer, Set<Integer>> hm= set.get(i);
			if(hm.containsKey(key1))
				set1=hm.get(key1);
			else if(hm.containsKey(key2))
				set2=hm.get(key2);
		}
		if(set1!=null&&set2!=null)
			set1.addAll(set2);
		for(int i=0;i<set.size();i++)
		{
			HashMap<Integer, Set<Integer>> hm= set.get(i);
			if(hm.containsKey(key1))
				set1=hm.put(key1,set1);
			else if(hm.containsKey(key2))
				set.remove(i);
		}
return false;
	}
	Integer find_Set(int element)
	{
		HashMap<Integer, Set<Integer>> e ;//= set.e
		for(int i=0;i<set.size();i++)
		{
			e=set.get(i);
			Set<Integer> keyset=e.keySet();
			for(Integer k: keyset)
			{
				Set<Integer> col=e.get(k);
				if(col.contains(element))
					return k;
			}
		}
		return -1;
	}
	public static void main(String[] args) 
	{
		System.out.println("The element enetered are from 1-5");
		Disjoint_Set ss =new Disjoint_Set();
		for(int i=1;i<=5;i++)
			ss.create_set(i);
		System.out.println("The size of element is "+ss.size_disjointSet());
		ss.union(1, 2);
		ss.union(2, 3);
		System.out.println("The size of element is "+ss.size_disjointSet());
		for (int i = 1; i <= 5; i++)
        {
           int x= ss.find_Set(i);
           System.out.println("The mapping is key -> "+x+"\t value -> "+i);
        }
	}

}
