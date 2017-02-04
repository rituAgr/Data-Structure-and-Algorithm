package Graph_Revision;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Ritu on 1/18/17.
 * http://www.geeksforgeeks.org/connectivity-in-a-directed-graph/
 */
public class isStronglyConnected_UndirectedGraph {
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
            hm.get(v2).addLast(v1);
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

        isStronglyConnected_UndirectedGraph ob=new isStronglyConnected_UndirectedGraph();
        System.out.println(ob.isStronglyConnected(g1));
    }
    private boolean isStronglyConnected(graph g)
    {
      int n=g.v;
        for(int i=0;i<n;i++)
        {
            Set<Integer> visited=new HashSet<>();
            DFS(g,i, visited);
            if(visited.size()<n)
                return false;
        }
        return true;
    }
    private void DFS(graph g, int start, Set<Integer> visited)
    {

        visited.add(start);
        LinkedList list=g.hm.get(start);
        for(int i=0;i<list.size();i++)
        {
            int element=(Integer)list.get(i);
            if(visited.contains(element))
            continue;
            DFS(g,element,visited);
        }
    }
}
