package Graph_Revision;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Ritu on 1/12/17.
 */
public class Detect_Cycle_DAG_Color {
    static class graph
    {
        int v;
        HashMap<Integer,LinkedList<Integer>> hm;
        graph(int v)
        {
            this.v=v;
            hm=new HashMap<>();
            for(int i=0;i<v;i++)
            {
                LinkedList<Integer> list=new LinkedList<Integer>();
                list.add(i);
                hm.put(i,list);
            }
        }
        void addEdge(int v1, int v2)
        {
            hm.get(v1).addLast(v2);
           // hm.get(v2).addLast(v1);
        }
    }
    public static void main(String args[]) {

        graph g = new graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(isCycle(g));
    }
    private static boolean isCycle(graph g)
    {
        Set<Integer> white=new HashSet<>();
        Set<Integer> black=new HashSet<>();

        for(int i=0;i<g.v;i++)
            white.add(i);
        int element=-1;
        while(!white.isEmpty())
        {
            element++;
            Set<Integer> gray=new HashSet<>();
            if(!white.contains(element))
                continue;
            white.remove(element);
            if(isCycleUtil(g,white,gray,black,element))
                return true;
        }
        return false;
    }
    private static boolean isCycleUtil(graph g,Set<Integer> white,Set<Integer> gray,Set<Integer> black, int start)
    {
        gray.add(start);
        LinkedList<Integer> list=g.hm.get(start);
        for(int i=1;i<list.size();i++)
        {
            int element=list.get(i);
            if(gray.contains(element))
                return true;
            if(black.contains(element))
                continue;
            white.remove(element);
            if(isCycleUtil(g,white,gray,black,element))
                return true;

        }
        gray.remove(start);
        black.add(start);
        return false;
    }

}
