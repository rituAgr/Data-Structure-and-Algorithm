package Tree_geeksforgeeks;

public class N_aryTree_Serialization {
	static int n=20;
	static class Node
	{
		char data;
		Node[] children=new Node[n];
		Node(char d)
		{
			data=d;
			for(int i=0;i<n;i++)
				children[i]=null;	
		}
		void setChildren(char data)
		{
			Node temp=children[0];
			int i=0;
			while(temp!=null&&i<n)
			{
				i++;
				temp=children[i];			
			}
			if(temp==null&&i<n)
				children[i]=new Node(data);
		}
		 Node getChildren(int index)
		{
			if(index<0||index>=n)
				return null;
			Node temp=children[index];
			return temp;
		}
	}
	public static void main(String[] args)
	{
		Node root=new Node('A');
		root.setChildren('B');
		root.setChildren('C');
		root.setChildren('D');
		root.getChildren(0).setChildren('E');
		root.getChildren(0).setChildren('F');
		root.getChildren(0).getChildren(1).setChildren('K');
		root.getChildren(2).setChildren('G');
		root.getChildren(2).setChildren('H');
		root.getChildren(2).setChildren('I');
		root.getChildren(2).setChildren('J');
		StringBuilder s=new StringBuilder();
		Serializaton(root,s);
		System.out.println(s);
	}
	static void Serializaton(Node root, StringBuilder s)
	{
		if(root==null)
			return;
		char d=root.data;
		s.append(d);
		int i=0;
		while(root.getChildren(i)!=null)
		{
			Serializaton(root.getChildren(i),s);
			i++;
		}
		s.append(')');
	}
}
