package Graph_Revision;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Ritu on 1/18/17.
 * http://www.geeksforgeeks.org/connectivity-in-a-directed-graph/
 * This solution is one which is given in geeksforgeeks. The time complexity is least and it is easiest conceptually
 * time complexity : O(V+E)
 */
public class isStronglyConnected_DirectedGraph
{
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
                hm.put(i,list);
            }
        }
        void addEdge(int v1, int v2)
        {
            hm.get(v1).addLast(v2);
        }
        HashMap<Integer,LinkedList<Integer>> getTranspose()
        {
            HashMap<Integer,LinkedList<Integer>> transpose=new  HashMap<Integer,LinkedList<Integer>>();
            for(int i=0;i<v;i++)
            {
                LinkedList<Integer> list=new LinkedList<Integer>();
                transpose.put(i,list);
            }
            for(int i=0;i<v;i++)
            {
                LinkedList<Integer> list=hm.get(i);
                for(int j=0;j<list.size();j++)
                {
                    int element=list.get(j);
                    transpose.get(element).addLast(i);
                }
            }
            return transpose;
        }
    }
    public static void main(String args[])
    {
        graph g1=new graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(3, 0);
        g1.addEdge(2, 4);
        g1.addEdge(4, 2);

        isStronglyConnected_DirectedGraph ob=new isStronglyConnected_DirectedGraph();
        System.out.println(ob.isStronglyConnected(g1));
    }
    private boolean isStronglyConnected(graph g)
    {
        int n=g.v;
        int start=0;
        Set<Integer> visited=new HashSet<>();
        HashMap<Integer,LinkedList<Integer>> hm=g.hm;
        DFS(hm,start, visited);
        if(visited.size()<n)
            return false;
        hm=g.getTranspose();
        visited.clear();
        DFS(hm,start, visited);
        if(visited.size()<n)
            return false;
        return true;
}
    private void DFS(HashMap<Integer,LinkedList<Integer>> hm, int start, Set<Integer> visited)
    {

        visited.add(start);
        LinkedList list=hm.get(start);
        for(int i=0;i<list.size();i++)
        {
            int element=(Integer)list.get(i);
            if(visited.contains(element))
                continue;
            DFS(hm,element,visited);
        }
    }
}
