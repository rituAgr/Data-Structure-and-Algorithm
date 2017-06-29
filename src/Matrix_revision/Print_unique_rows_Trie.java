package Matrix_revision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Created by Ritu on 2/10/17.
 * http://www.geeksforgeeks.org/print-unique-rows/
 * Time complexity : O(m*n)
 * Space(Auxillary) complexity : O(m*n)
 */
public class Print_unique_rows_Trie {
    TrieNode root;
    class TrieNode
    {
        HashMap<Integer, TrieNode> hm;
        boolean isEnd;
        TrieNode()
        {
            hm=new HashMap<Integer, TrieNode>();
            isEnd=false;
        }
    }
    void insert(int[] array)
    {
        if(root==null)
            root=new TrieNode();
        TrieNode curr=root;
        for(int c: array)
        {
            if(curr.hm.containsKey(c)==false)
                curr.hm.put(c,new TrieNode());
            curr=curr.hm.get(c);
        }
        curr.isEnd=true;
    }
    void traverse(TrieNode node, ArrayList<Integer> row)
    {
        if(node==null)
            return ;
        if(node.isEnd)
        {
            System.out.println(row.toString());
            return;
        }
        Set<Entry<Integer, TrieNode>> entries=node.hm.entrySet();
        for(Entry<Integer, TrieNode> entry: entries)
        {
            row.add(entry.getKey());
            traverse(entry.getValue(), row);
            row.remove(row.size()-1);
        }

    }
    public static void main(String args[])
    {
        int matrix[][] = {{0, 1, 0, 0, 1},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 1, 0, 0}};
        Print_unique_rows_Trie trie=new Print_unique_rows_Trie();
    for(int i=0;i<matrix.length;i++)
        //for(int j=0;j<matrix[0].length;j++)
        trie.insert(matrix[i]);

        trie.traverse(trie.root,new ArrayList<>());
    }
}
