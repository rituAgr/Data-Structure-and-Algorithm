package String_geeksforgeeks;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Ritu on 2/1/17.
 * http://www.geeksforgeeks.org/find-first-non-repeating-character-stream-characters/
 * space and time complexity = O(n)
 */
public class First_NonRepeatingChar {
    public static void main(String args[])
    {
        String str="geeksforgeeksandgeeksquizfor";
        find(str);
    }
    private static void find(String str)
    {
        Queue<Character> q=new LinkedList<>();
        HashMap<Character, Integer> count=new HashMap<>();
        char nonreapeat=str.charAt(0);
        for(int i=0;i<str.length();i++)
        {
            char c=str.charAt(i);
            if(count.get(c)==null)
                count.put(c,1);
            else
            {
                int n=count.get(c);
                count.put(c,n+1);
            }
                q.add(c);
            System.out.println("Reading "+c);
            if(count.get(nonreapeat)!=1)
               while(!q.isEmpty()) {
                   nonreapeat = q.poll();
                if (count.get(nonreapeat)==1)
                    break;
            }
            System.out.println("First non repeating character till now is "+nonreapeat);
        }
    }
}
