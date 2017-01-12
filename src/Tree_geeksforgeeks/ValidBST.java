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
		//Generate Inorder traversal by just sorting.
		//try to construct tree
		//If there is any prolem, return false;
		return true;
	}
}
