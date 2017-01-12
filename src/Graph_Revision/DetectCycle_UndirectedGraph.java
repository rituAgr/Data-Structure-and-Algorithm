package Graph_Revision;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Ritu on 1/11/17.
 * http://www.geeksforgeeks.org/detect-cycle-undirected-graph/
 * There are two ways of of detetcted cycle in undirected graph -
 *  -DFS
 *  - Disjoint Set
 * time complexity is O(V+E)
 */
public class DetectCycle_UndirectedGraph {
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
            hm.get(v2).addLast(v1);
        }
    }
    public static void main(String args[]) {
        graph g = new graph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);

        System.out.println(isCycle(g));
    }
    private static boolean isCycle(graph g)
    {
        for (int i=0;i<g.v;i++)
        {
            boolean[] visited=new boolean[g.v];
            if(isCycleUtil(g,visited,i,-1))
                return true;
        }
        return false;
    }
    private static boolean isCycleUtil(graph g, boolean[] visited,int start, int prev)
    {
        if(visited[start])
            return true;
        visited[start]=true;
        LinkedList<Integer> list=g.hm.get(start);
        for(int i=1;i<list.size();i++)
        {
            int element=list.get(i);
            if(element==prev)
                continue;
            if(isCycleUtil(g,visited,element,start))
                return true;
            visited[element]=false;
        }
        return false;
    }
}
