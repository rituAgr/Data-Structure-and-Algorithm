//package Trie_LongestPrefix;
//
//import java.util.HashMap;
//import java.util.Stack;
//
//// This class consist of insert string function and searching largest Prefix
//public class Trie {
//	TrieNode root;
//	Trie()
//	{
//		root=new TrieNode('\0');
//	}
//	//Inserting the string into tree
//	public void insert(String word)
//	{
//		int length=word.length();
//		if(length==0)
//			return;
//		TrieNode crawl = root;
//		char ch;
//		for(int level=0;level<length;level++)
//		{
//			HashMap<Character,TrieNode> child=crawl.getChildren();
//			ch=word.charAt(level);
//			if(child.containsKey(ch))
//			{
//				crawl=child.get(ch);
//			}
//			else
//			{
//				TrieNode temp = new TrieNode(ch);
//				child.put(ch, temp);
//				crawl=child.get(ch);//or crawl=temp
//			}
//		}
//		crawl.setIsEnd(true);
//	}
//	//Inserting the string into tree
//	public boolean delete(String word)
//	{
//		Stack<TrieNode> s=new Stack<TrieNode>();
//		TrieNode crawl = root;
//		char ch;
//		for(int level=0;level<word.length();level++)
//		{
//			HashMap<Character,TrieNode> children=crawl.getChildren();
//			ch=word.charAt(level);
//			if(children.containsKey(ch))
//			{
//				crawl=children.get(ch);
//				s.push(crawl);
//			}
//			else
//				return false;
//		}
//		crawl.setIsEnd(false);
//		if(crawl.getChildren()==null)
//		{
//			TrieNode temp;
//			while(!s.isEmpty())
//			{
//				temp=s.pop();
//				if(temp.getChildren()==null&&temp.getIsEnd()==false)
//					temp=null;
//			}
//			return true;
//		}
//		else
//		{
//			return true;
//		}
//	}
//	//Searching the Longest prefix
//	public String searchLongestPrefix(String word)
//	{
//		String result="";
//		char ch;
//		int prevMatch=0;
//		TrieNode crawl = root;
//		HashMap<Character,TrieNode> child;
//		for(int level=0;level<word.length();level++)
//		{
//			ch=word.charAt(level);
//			child=crawl.getChildren();
//			if(child.containsKey(ch))
//			{
//				result=result+ch;
//				crawl=child.get(ch);
//				if(crawl.getIsEnd())
//					prevMatch=level+1;
//			}
//			else
//				break;
//
//		}
//		if(!crawl.getIsEnd())
//			return word.substring(0,prevMatch);
//		else
//			return result;
//	}
//	//Searching the Shortest prefix
//	public String searchSortestPrefix(String word)
//	{
//		char ch;
//		TrieNode crawl = root;
//		HashMap<Character,TrieNode> child;
//		for(int level=0;level<word.length();level++)
//		{
//			ch=word.charAt(level);
//			child=crawl.getChildren();
//			if(child.containsKey(ch))
//			{
//				crawl=child.get(ch);
//				if(crawl.getIsEnd())
//					return (word.substring(0,level+1));
//			}
//			else
//				break;
//
//		}
//		return null;
//	}
//	//Display all the words in the trie
//	/*public ArrayList<String> display()
//	{
//		ArrayList<String> result=new ArrayList<String>();
//		String word="";
//		TrieNode crawl;
//		HashMap<Character,TrieNode> children=root.getChildren();
//		Stack<TrieNode> s = new Stack<TrieNode>();
//		s.addAll(children.values());
//		while(!s.isEmpty())
//		{
//			crawl=s.pop();
//			word=word+crawl.getValue();
//			Stack<TrieNode> s2 = new Stack<TrieNode>();
//			if(crawl.getChildren()!=null)
//				s2.addAll(crawl.getChildren().values());
//			crawl=s2.pop();
//			crawl=crawl.getChildren().get;
//		}
//
//
//
//		else
//		{
//			ArrayList<Character> letters=(ArrayList)children.keySet();
//			for(Character letter : letters)
//			{   int level=0;
//			crawl=children.get(letter);
//			while(crawl.getChildren()!=null)
//			{
//				word=word+crawl.getValue();
//				if(crawl.getIsEnd()==true)
//					result.add(word);
//				crawl=children.get(letter);
//				level++;
//			}
//			}
//		}
//	}*/
//}
