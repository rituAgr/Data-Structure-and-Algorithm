package Advanced_DS;

import java.util.HashMap;

/**
 * Created by Ritu on 2/10/17.
 * http://www.geeksforgeeks.org/implement-forward-dns-look-cache/
 * Backwad dns lookup is very simple and similar to do
 */
public class Trie_ForwardDNS_LookUp
{
    TrieNode root;
    class TrieNode
    {
        HashMap<Character, TrieNode> hm;
        boolean isEnd;
        String dns;
        TrieNode()
        {
            hm=new HashMap<Character, TrieNode>();
            isEnd=false;
            dns=null;
        }
    }
    void insert(String s1,String s2)
    {
        if(root==null)
            root=new TrieNode();
        TrieNode curr=root;
        for(int i=0;i<s1.length();i++)
        {
            char c = s1.charAt(i);
            if(curr.hm.containsKey(c)==false)
                curr.hm.put(c,new TrieNode());
            curr=curr.hm.get(c);
        }
        curr.isEnd=true;
        curr.dns=s2;
    }
    String search(String s)
    {
        if(root==null||s.length()==0)
            return null;
        TrieNode curr=root;
        for(int i=0;i<s.length()&&curr!=null;i++)
        {
            char c = s.charAt(i);
            if(!curr.hm.containsKey(c))
                return null;
            curr=curr.hm.get(c);
        }
        if(curr.isEnd)
            return curr.dns;
        return null;
    }
    public static void main(String args[])
    {
        String[] dns={ "www.samsung.com", "www.samsung.net", "www.google.in"};
        String[] ip={"107.108.11.123", "107.109.123.255", "74.125.200.106"};
        Trie_ForwardDNS_LookUp trie=new Trie_ForwardDNS_LookUp();
        for(int i=0;i<dns.length;i++)
            trie.insert(dns[i],ip[i]);
        String wrd="www.samsung.net";
        System.out.println(trie.search(wrd));
        wrd="i like";
        System.out.println(trie.search(wrd));
    }
}
