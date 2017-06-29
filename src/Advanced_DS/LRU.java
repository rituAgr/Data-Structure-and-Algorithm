package Advanced_DS;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Ritu on 2/7/17.
 * http://www.geeksforgeeks.org/implement-lru-cache/
 * http://mcicpc.cs.atu.edu/archives/2012/mcpc2012/lru/lru.html
 * Time complexity : O(Number of input ellements)
 * Space Complexity : O(size of frame)
 */
public class LRU<E>
{
    int size;
    Queue<Node> q;
    HashMap<E,Node> hm;
    LRU(int size)
    {
        this.size=size;
        q=new LinkedList<Node>();
        hm=new HashMap<E, Node>();
    }
    static class Node<E>
    {
        E data;
        Node(E data)
        {
            this.data=data;
        }
    }
    private void insertINlru(E c)
    {
        if(hm.containsKey(c))
        {
            Node N=hm.get(c);
            q.remove(N);
            q.add(N);
        }
        else {
            if (q.size() >= size)
            {
                Node last=q.poll();
                hm.remove(last.data);
            }
            Node N=new Node(c);
            q.add(N);
            hm.put(c,N);
        }
    }
    private void printLRU()
    {
        Iterator<Node> iter=q.iterator();
        while(iter.hasNext())
            System.out.print(iter.next().data+" ");
        System.out.println();
    }
    public static void main(String[] arg)
    {
        //Creating LRU of Characters

        //Simulation1
        String cStr="ABC!DEAF!B!";
        System.out.println("\nSimulation 1 :");
        LRU<Character> lru=new LRU<Character>(5);
        for(int i=0;i<cStr.length();i++)
        {
            char c=cStr.charAt(i);
            if(c=='!')
                lru.printLRU();
            else
                lru.insertINlru(c);
        }

        //Simulation2
         cStr="WXWYZ!YZWYX!XYXY!";
        System.out.println("\nSimulation 2 :");
       lru=new LRU<Character>(3);
        for(int i=0;i<cStr.length();i++) {
            char c = cStr.charAt(i);
            if (c == '!')
                lru.printLRU();
            else
                lru.insertINlru(c);
        }


        //Simulation3
        cStr="EIEIO!";
        System.out.println("\nSimulation 3 :");
        lru=new LRU<Character>(5);
        for(int i=0;i<cStr.length();i++) {
            char c = cStr.charAt(i);
            if (c == '!')
                lru.printLRU();
            else
                lru.insertINlru(c);
        }


        //Simulation4
        cStr="1234!5312!11!";
        System.out.println("\nSimulation 4 :");
        LRU<Integer> lru1=new LRU<Integer>(5);
        for(int i=0;i<cStr.length();i++) {
            String c = cStr.substring(i,i+1);
            if (c.equals("!"))
                lru1.printLRU();
            else {
                Integer num = Integer.parseInt(c);
                lru1.insertINlru(num);
            }
        }
    }

}
