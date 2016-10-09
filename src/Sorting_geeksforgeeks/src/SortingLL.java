package Sorting_geeksforgeeks.src;/*
 * http://www.geeksforgeeks.org/how-to-sort-a-linked-list-that-is-sorted-alternating-ascending-and-descending-orders/
 */
import java.util.LinkedList;
public class SortingLL 
{
	public static void main(String args[])
	{
		LinkedList<Integer> LL=new LinkedList<Integer>();
		// 10->40->53->30->67->12->89->NULL
		int a[]={10,40,53,30,67,12,89};
		for(int i=0;i<a.length;i++)
			LL.add(a[i]);
		sorting s = new sorting();
		LinkedList<Integer> result=s.sort(LL);
		System.out.println(result.toString());
	}
}
class sorting
{
	LinkedList<Integer> sort(LinkedList<Integer> LL)
	{
		if(LL.size()==0)
			return null;
		if(LL.size()==1)
			return LL;
		int mid=LL.size()/2;
		LinkedList<Integer> LL1 = BreakLL(LL,0,mid-1);
		LinkedList<Integer> LL2 = BreakLL(LL,mid,LL.size()-1);
		LinkedList<Integer> L1=sort(LL1);
		LinkedList<Integer> L2=sort(LL2);
		return merge(L1,L2);
	}
	LinkedList<Integer> merge(LinkedList<Integer> L1,LinkedList<Integer> L2)
	{
		LinkedList<Integer> result= new LinkedList<Integer>();
		int i=0,j=0;
		while(i<L1.size()&&j<L2.size())
		{
			if(L1.get(i)<L2.get(j))
				result.add(L1.get(i++));
			else
				result.add(L2.get(j++));
		}
		while(i<L1.size())
			result.add(L1.get(i++));
		while(j<L2.size())
			result.add(L2.get(j++));
		return result;
	}
	LinkedList<Integer> BreakLL(LinkedList<Integer> LL, int start, int pos)
	{
		LinkedList<Integer> L1=new LinkedList<Integer>();
		for(int i=start;i<=pos;i++)
			L1.add(LL.get(i));
		return L1;
	}
}
