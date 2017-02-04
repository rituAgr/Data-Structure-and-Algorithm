package String_geeksforgeeks;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import static String_geeksforgeeks.anagram.form_anagram;

/**
 * Created by Ritu on 2/1/17.
 * http://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together/
 * Time complexity = O(MNlogN+MNlogM)
 * space complexity = O(MN)
 */
public class Anagrams
{

    public static void main(String[] args)
    {
        String words[]={"cat", "dog", "tac", "god", "act"};
        Anagrams obj=new Anagrams();
        obj.anagrams(words);
        //System.out.println(Arrays.toString(ans));
    }
    void anagrams(String words[])
    {
        int l=words.length;
        String Cwords[]=new String[l];
        int[] index=new int[l];
        for(int i=0;i<l;i++)
        {
            char[] c=words[i].toCharArray();
            Arrays.sort(c);
            Cwords[i]=new String(c);
            index[i]=i;
        }
        Arrays.sort(Cwords);
///=/int[] positio
//
//        for(int i=0;i<l;i++)
//            System.out.println(words[position[i]]);
    }
}

