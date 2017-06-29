package String_geeksforgeeks;

import java.util.Arrays;

/**
 * Created by Ritu on 2/26/17.
 * http://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together/
 */
public class Sorting_Anagram implements Comparable<Sorting_Anagram>{
    String s;
    Sorting_Anagram(String str)
    {
        s=str;
    }
    @Override
    public int compareTo(Sorting_Anagram o) {
        char[] arr = o.s.toCharArray();
        Arrays.sort(arr);
        String word2 = new String(arr);

        arr=this.s.toCharArray();
        Arrays.sort(arr);
        String word1=new String(arr);

        if(word1.equals(word2))
        {
            for(int i=0;i<word1.length();i++) {
                if (o.s.charAt(i) == this.s.charAt(i))
                    continue;
                return (this.s.charAt(i) - o.s.charAt(i));
            }
        }

        int l=Math.min(word1.length(),word2.length());
        for(int i=0;i<l;i++)
        {
            if(word1.charAt(i)==word2.charAt(i))
                continue;
            return (word1.charAt(i) - word2.charAt(i));
        }
        return (word1.length()-word2.length());
    }
    public static void main(String[] args)
    {
        String wordArr[] = {"cat", "dog", "tac", "god", "act"};
        int l=wordArr.length;

        Sorting_Anagram[] allwords=new Sorting_Anagram[l];
        for(int i=0;i<l;i++)
            allwords[i]=new Sorting_Anagram(wordArr[i]);

        Arrays.sort(allwords);

        for(int i=0;i<allwords.length;i++)
            System.out.print(allwords[i].s+"  ");
    }
}

