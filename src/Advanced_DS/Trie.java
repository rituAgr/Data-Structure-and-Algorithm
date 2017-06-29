package Advanced_DS;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Ritu on 1/18/17.
 * Insert/delete/search into trie data structure
 */
public class Trie
{
    public static void main(String[] arg)
    {
        Trie t=new Trie();
        t.insert("abc");
        t.insert("abgl");
        t.insert("cdf");
        t.insert("abcd");
        t.insert("lmn");

        System.out.println(t.search("lmn"));
        System.out.println(t.search("ab"));

        System.out.println("before deletion abc "+t.search("abc"));
        t.delete("abc");
        System.out.println("After deletion abc "+t.search("abc"));

        System.out.println("before deletion abgl "+t.search("abgl"));
        t.delete("abgl");
        System.out.println("After deletion abgl "+t.search("abgl"));

        System.out.println("before deletion abcd "+t.search("abcd"));
        t.delete("abcd");
        System.out.println("After deletion abcd "+t.search("abcd"));
    }
    class TrieNode
    {
        Map<Character, TrieNode> children;
        boolean isEnd;
        TrieNode()
        {
            children =new HashMap<Character, TrieNode>();
            isEnd=false;
        }
    }
    TrieNode root;
    Trie()
    {
        root=new TrieNode();
    }
    void insert (String word)
    {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++)
        {
            char c = word.charAt(i);
            Map<Character, TrieNode> children=curr.children;
            if(!children.containsKey(c))
                children.put(c,new TrieNode());
            curr=children.get(c);
        }
        curr.isEnd=true;
    }
    boolean search(String word)
    {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++)
        {
            char c = word.charAt(i);
            Map<Character, TrieNode> children=curr.children;
            if(!children.containsKey(c))
                return false;
            curr=children.get(c);
        }
        return curr.isEnd;
    }
    void delete(String word)
    {
        if(!search(word))
            return ;
        TrieNode curr=root;
        Stack<TrieNode> st=new Stack();
        st.push(curr);
        for(int i=0;i<word.length();i++)
        {
            char c = word.charAt(i);
            Map<Character, TrieNode> children=curr.children;
            curr=children.get(c);
            st.push(curr);
        }
        curr.isEnd=false;
        if(curr.children.size()>0)
            return;
        int pos=word.length()-1;
        while(!st.isEmpty()&&pos>=0)
        {
            curr=st.pop();
            curr.children.remove(word.charAt(pos));
            if(curr.isEnd)
                break;
            pos--;
        }
    }
}
