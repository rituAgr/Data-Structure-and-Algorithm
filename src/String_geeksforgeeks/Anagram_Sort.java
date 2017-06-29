package String_geeksforgeeks;

import java.util.Arrays;

/**
 * Created by Ritu on 4/25/17.
 * http://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together/
 */
public class Anagram_Sort {
    public static void main(String[] args)
    {
        String wordsArray[] = {"cat", "dog", "tac", "god", "act"};
        find(wordsArray);
    }
    private static void find(String[] wordsArray)
    {
        int n=wordsArray.length;
        Word[] words=new Word[n];
        for(int i=0;i<n;i++)
            words[i]=new Word(wordsArray[i]);
        Arrays.sort(words);
        for(int i=0;i<words.length;i++)
            System.out.print(words[i].word+" ");
    }
}
class Word implements Comparable<Word>
{

    String word;
    Word(String s)
    {
        word=s;
    }
    @Override
    public int compareTo(Word second) {
        char[] c=this.word.toCharArray();
        Arrays.sort(c);
        String word1=new String(c);

        c=second.word.toCharArray();
        Arrays.sort(c);
        String word2=new String(c);

        if(word1.equals(word2))
        {
            for(int i=0;i<second.word.length();i++)
            {
                if(word.charAt(i)==second.word.charAt(i))
                    continue;
             return word.charAt(i)-second.word.charAt(i);
            }
        }

        int l=Math.min(word1.length(),word2.length());

        for(int i=0;i<l;i++)
        {
            if(word1.charAt(i)==word2.charAt(i))
                continue;
            return word1.charAt(i)-word2.charAt(i);
        }
        return word1.length()-word2.length();
    }
}
