package Tree_geeksforgeeks;/*
 * http://www.geeksforgeeks.org/check-if-a-given-array-can-represent-preorder-traversal-of-binary-search-tree/
 */
import java.util.Stack;
public class ValidBST {
	public static void main(String[] args) {
		int pre[] =  {40, 30, 35, 20, 80, 100};
		System.out.println(isValid(pre));
	}
	public static boolean isValid(int[] pre)
	{
		int root=Integer.MIN_VALUE;
		Stack<Integer> st = new Stack<Integer>();
		
		for(int i=0;i<pre.length;i++)
		{
			if(pre[i]<root)
				return false;
			while(!st.isEmpty()&&st.peek()<pre[i])
				root=st.pop();
			st.push(pre[i]);
		}
		return true;
	}
}
