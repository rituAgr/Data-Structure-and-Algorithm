package HackerRank;

import Advanced_DS.Trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by Ritu on 3/3/17.
 * https://www.hackerrank.com/challenges/contacts
 * 4
 add hack
 add hackerrank
 find hac
 find hak
 */
public class Contact_System
{
    static StringTokenizer st;
        TrieNode head;

    static void nextLine(BufferedReader br) throws IOException {
        st=new StringTokenizer(br.readLine());
    }
    static String nextString()  {

        String s=st.nextToken();
        return s;
    }
    static int nextInt()  {

        int s= Integer.parseInt(st.nextToken());
        return s;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        nextLine(br);
        int count=nextInt();

        Contact_System ob=new Contact_System();
        for(int i=0;i<count;i++)
        {
            nextLine(br);
            String operaion = nextString();
            String name=nextString().trim();
            if(operaion.equals("add"))
                ob.insert(name);
            else
                System.out.println(ob.find(name));
        }
    }

    class TrieNode
    {
        HashMap<Character,TrieNode> hm;
        boolean isEnd;
        int prefixCount;

        TrieNode()
        {
            hm=new HashMap<>();
            isEnd=false;
            prefixCount=0;
        }
    }
    void insert(String name)
    {
        int l=name.length();
        if(head==null)
            head=new TrieNode();
        TrieNode curr=head;
        for(int i=0;i<l;i++)
        {
            char c = name.charAt(i);
            if(!curr.hm.containsKey(c))
                curr.hm.put(c,new TrieNode());
            curr.prefixCount++;
            curr=curr.hm.get(c);
        }
        curr.isEnd=true;
    }
    int find(String name)
    {
        TrieNode curr=head;
        if(head==null||name.length()==0)
            return 0;
        for(int i=0;i<name.length();i++)
        {
            char c = name.charAt(i);
            if(!curr.hm.containsKey(c))
                return 0;
            if(i==name.length()-1)
                return curr.prefixCount;
            curr=curr.hm.get(c);
        }
        return 0;
    }

}






















