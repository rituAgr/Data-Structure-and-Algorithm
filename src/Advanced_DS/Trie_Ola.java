package Advanced_DS;

import java.util.HashMap;

/**
 * Created by Ritu on 2/10/17.
 * Given the dictionary and list of english words, you need to return if the given input word can be broken into
 * list of words present in the dictionary -
 * Dictionary - { i , like, sam, sung, samsung , mobile, ice, cream, icecream, man , go , mango}
 * The string can be segmented as - "i like"
 * Input : ilikesamsung
 * Output : yes
 * The string can be segmented as "i like sam sung"or " i like samsung".
 */
public class Trie_Ola
{
    TrieNode root;
    class TrieNode
    {
        HashMap<Character, TrieNode> hm;
        boolean isEnd;
        TrieNode()
        {
            hm=new HashMap<Character, TrieNode>();
            isEnd=false;
        }
    }
    void insert(String s)
    {
        if(root==null)
            root=new TrieNode();
        TrieNode curr=root;
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(curr.hm.containsKey(c)==false)
                curr.hm.put(c,new TrieNode());
            curr=curr.hm.get(c);
        }
        curr.isEnd=true;
    }
    boolean search(String s)
    {
        if(root==null||s.length()==0)
            return false;
        TrieNode curr=root;
        for(int i=0;i<s.length();i++)
        {
            if(curr.isEnd)
                curr=root;
            char c = s.charAt(i);
            if(c==' ')
                continue;
            if(!curr.hm.containsKey(c))
                return false;
            curr=curr.hm.get(c);
        }
        return (curr.isEnd);
    }
    public static void main(String args[])
    {
        String[] dict={"i" , "like", "sam", "sung", "samsung" , "mobile", "ice", "cream", "icecream", "man" , "go" , "mango"};
        Trie_Ola trie=new Trie_Ola();
        for(String s : dict)
            trie.insert(s);
        String wrd="ilikesamsung";
        System.out.println(trie.search(wrd));
        wrd="i like";
        System.out.println(trie.search(wrd));
    }
}
