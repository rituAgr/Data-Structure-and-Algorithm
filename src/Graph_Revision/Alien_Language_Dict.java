package Graph_Revision;

import java.util.*;

/**
 * Created by Ritu on 2/16/17.
 * http://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/
 * Time Complexity = O(V+E)+(n*m)
 * where, n=number of words; m = avg. length of each word
 * V=Number of characters+ E=No of edges formed
 */
public class Alien_Language_Dict
{
    public static void main(String args[])
    {
        String words[] =  {"caa", "aaa", "aab"};//{"baa", "abcd", "abca", "cab", "cad"};
        ArrayList<Character> result=SortedChars(words);
        System.out.println(result.toString());
    }
    private static ArrayList<Character> SortedChars(String[] words)
    {
        HashSet<Character> set=find_DistinctChars(words);
        DAG_Generics<Character> g=new DAG_Generics<Character>(set);
        for(int i=0;i<words.length-1;i++)
        {
            String word1=words[i];
            String word2=words[i+1];
            int len=Math.min(word1.length(),word2.length());
            for(int pos=0;pos<len;pos++)
            {
                if(word1.charAt(pos)==word2.charAt(pos))
                    continue;
                g.addEdge(word1.charAt(pos),word2.charAt(pos));
                break;
            }
        }
        int l=set.size();
        HashSet<Character> visited=new HashSet<Character>();
        ArrayList<Character> result=new ArrayList<Character>();
        for(char c: set)
        {
            if(!visited.contains(c))
                topological_Sort(g,visited,result,c);
        }
        return result;
    }
    private static void topological_Sort(DAG_Generics<Character> g, HashSet visited,ArrayList st, char c)
    {
        visited.add(c);
        LinkedList<Character> list=g.hm.get(c);
        for(int i=0;i<list.size();i++)
        {
            char element=list.get(i);
            if(!visited.contains(element))
                topological_Sort(g,visited,st,element);
        }
        st.add(0,c);
    }
    private static HashSet<Character> find_DistinctChars(String[] words)
    {
        HashSet<Character> set=new HashSet();
        for(String word : words)
            for(int i=0;i<word.length();i++)
                set.add(word.charAt(i));
        return set;
    }
}
class DAG_Generics<E>
{
    int v;
    HashMap<E,LinkedList<E>> hm;
    DAG_Generics(HashSet<E> set)
    {
        this.v=set.size();
        hm=new HashMap<>();
        for(E element : set)
        {
            LinkedList<E> list=new LinkedList<E>();
            hm.put(element,list);
        }
    }
    void addEdge(E v1, E v2)
    {
        hm.get(v1).addLast(v2);
    }
}
