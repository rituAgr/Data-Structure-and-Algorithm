package Advanced_DS;

import java.util.ArrayList;

/**
 * Created by Ritu on 2/19/17.
 * http://www.geeksforgeeks.org/check-two-strings-k-anagrams-not/
 */
public class k_anagram {
    public static void main(String args[]) {
        String str1="anagram";
        String str2="grammar";
        int k=3;
        check(str1,str2,k);
        str1 = "geeks"; str2 = "eggkf"; k = 1;
        System.out.println("\nAnother input ");
        check(str1,str2,k);
    }
    private static void check(String str1,String str2, int k)
    {
       int[] arr1=new int[26];
        int[] arr2=new int[26];

        int start='a';

        for(int i=0;i<str1.length();i++)
        {
            int pos=str1.charAt(i)-start;
            arr1[pos]++;
        }

        for(int i=0;i<str2.length();i++)
        {
            int pos=str2.charAt(i)-start;
            arr2[pos]++;
        }
        ArrayList<Character> s1=new ArrayList<>();
        ArrayList<Character> s2=new ArrayList<>();
        int count=0;
        for(int i=0;i<26;i++)
        {
            if(arr1[i]==arr2[i])
                continue;
            if(arr1[i]>arr2[i])
            {
                int diff=arr1[i]-arr2[i];
                char c=(char)(i+start);
                while(diff!=0)
                {
                    s1.add(c);
                    diff--;
                    count++;
                }
            }
            else
            {
                int diff=arr2[i]-arr1[i];
                char c=(char)(i+start);
                while(diff!=0)
                {
                    s2.add(c);
                    diff--;
                    count++;
                }
            }
            if(count>2*k)
            {
                System.out.println("Not a anagram with "+k+" modifications");
                return;
            }
        }

        System.out.println("Anagram is possible by following modifications ");
        int l=Math.max(s1.size(),s2.size());
        int i=0;
        for(;i<l;i++)
            System.out.println("replace "+s1.get(i)+" from string1 with "+s2.get(i)+" of string 2");
        while(i<s1.size())
        {
            System.out.println("remove "+s1.get(i)+" from string 1");
            i++;
        }
        while(i<s2.size())
        {
            System.out.println("Add "+s2.get(i)+" to string 2");
            i++;
        }
    }
}
