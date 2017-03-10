package HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * COMPLETED
 * Created by Ritu on 3/1/17.
 https://www.hackerrank.com/challenges/sparse-arrays
 */
public class SparseArray {
    class TrieNode {
        HashMap<Character, TrieNode> hm;
        boolean isEnd;
        int count;

        TrieNode() {
            hm = new HashMap<Character, TrieNode>();
            isEnd = false;
            count = 0;
        }
    }

    TrieNode head;

    SparseArray() {
        head = null;
    }

    private void insert(String s) {
        if (head == null)
            head = new TrieNode();
        int l = s.length();
        TrieNode curr = head;
        for (int i = 0; i < l; i++) {
            char c = s.charAt(i);
            if (!curr.hm.containsKey(c)) {
                TrieNode node = new TrieNode();
                curr.hm.put(c, node);
            }
            curr = curr.hm.get(c);
        }
        curr.isEnd = true;
        curr.count++;
    }

    private int search(String s) {
        if (head == null || s.equals(""))
            return 0;

        int l = s.length();
        TrieNode curr = head;

        for (int i = 0; i < l; i++) {
            char c = s.charAt(i);
            if (!curr.hm.containsKey(c))
                return 0;
            curr = curr.hm.get(c);
        }
        if (curr.isEnd)
            return curr.count;
        return 0;

    }

    static String st;

    private static void nextLine(BufferedReader br) throws IOException {
        st = new String(br.readLine().trim());
    }

    private static int nexInt() {
        return Integer.parseInt(st);
    }

    private static String nextString() {
        return st;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nextLine(br);
        int count = nexInt();

        SparseArray trie = new SparseArray();
        for (int i = 0; i < count; i++) {
            nextLine(br);
            String s = nextString();
            trie.insert(s);
        }
        nextLine(br);
        count = nexInt();
        for (int i = 0; i < count; i++) {
            nextLine(br);
            String s = nextString();
            System.out.println(trie.search(s));
        }
    }
}
