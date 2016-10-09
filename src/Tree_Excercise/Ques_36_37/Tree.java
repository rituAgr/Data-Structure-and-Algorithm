package Tree_Excercise.Ques_36_37;

import java.util.*;

public class Tree {
	static boolean v1=false;
	static boolean v2=false;
	public  void formTree(BinaryTreeNode root)
	{
		BinaryTreeNode L1 = new BinaryTreeNode(34);
		BinaryTreeNode R1 = new BinaryTreeNode(55);
		BinaryTreeNode L1L = new BinaryTreeNode(22);
		BinaryTreeNode L1R = new BinaryTreeNode(13);
		BinaryTreeNode R1L= new BinaryTreeNode(77);
		BinaryTreeNode R1R = new BinaryTreeNode(45);
		BinaryTreeNode R2R = new BinaryTreeNode(5);
		BinaryTreeNode R3R = new BinaryTreeNode(105);
		root.setLeft(L1);
		root.setRight(R1);
		L1.setLeft(L1L);
		L1.setRight(L1R);
		R1.setLeft(R1L);
		R1.setRight(R1R);
		R1R.setRight(R2R);
		R1L.setRight(R3R);
	}

	public void VerticalSum(BinaryTreeNode root)
	{
		if(root==null)
			return;
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		VerticalSumUtil(root, hm,0);
		for(int set : hm.keySet())
			System.out.print(set + " : "+hm.get(set)+"\n");
	}
	public HashMap<Integer,Integer> VerticalSumUtil(BinaryTreeNode root, HashMap<Integer,Integer> hm, int pos)
	{
		if(root==null)
			return null;
		int prevSum = (hm.get(pos)==null)?0:hm.get(pos);
		hm.put(pos, prevSum+root.getData());
		/*if(hm.get(pos)==null)
			prevSum=root.getData();
		else
			prevSum=hm.get(pos)+root.getData();
		hm.put(pos, prevSum);*/
		VerticalSumUtil(root.getLeft(),hm,pos-1);
		VerticalSumUtil(root.getRight(),hm, pos+1);
		return hm;
	}
}
